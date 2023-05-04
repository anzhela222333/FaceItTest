package controller;

import face_it_test.controller.VacancyController;
import face_it_test.dto.StatisticDto;
import face_it_test.dto.VacancyResponseDto;
import face_it_test.service.VacancyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class VacancyControllerTest {

    private static final String COMPANY_NAME = "Test";
    private static final String TEST_SLUG = "Test slug";
    private static final String TEST_DESC = "Test Desc";
    private static final int PAGE = 1;
    private static final int SIZE = 5;

    @InjectMocks
    private VacancyController vacancyController;
    @Mock
    private VacancyService vacancyService;

    @Test
    public void getAllVacanciesTest() {
        when(vacancyService.getVacancies(PAGE, SIZE)).thenReturn(List.of(createVacancyResponseDto()));

        ResponseEntity<List<VacancyResponseDto>> responseEntity = vacancyController.getAllVacancies(PAGE, SIZE);
        List<VacancyResponseDto> responseList = responseEntity.getBody();
        Assertions.assertNotNull(responseList);
        Assertions.assertEquals(1, responseList.size());
        Assertions.assertEquals(responseList.get(0).getCompanyName(), COMPANY_NAME);
    }

    @Test
    public void getCountByLocation() {
        when(vacancyService.getStatisticByLocation()).thenReturn(List.of(createStatisticDto()));

        ResponseEntity<List<StatisticDto>> response = vacancyController.getCountByLocation();
        List<StatisticDto> responseDtos = response.getBody();

        Assertions.assertNotNull(responseDtos);
        Assertions.assertEquals(1, responseDtos.size());
        Assertions.assertEquals(15, responseDtos.get(0).getVacancyCount());
        Assertions.assertEquals(COMPANY_NAME, responseDtos.get(0).getLocation());
    }

    @Test
    public void getTopTen() {
        when(vacancyService.getTop10Vacancies()).thenReturn(List.of(createVacancyResponseDto()));

        ResponseEntity<List<VacancyResponseDto>> response = vacancyController.getTopTen();
        List<VacancyResponseDto> responseDtos = response.getBody();

        Assertions.assertNotNull(responseDtos);
        Assertions.assertEquals(1, responseDtos.size());
        Assertions.assertEquals(COMPANY_NAME, responseDtos.get(0).getCompanyName());
    }

    private VacancyResponseDto createVacancyResponseDto() {
        VacancyResponseDto dto = new VacancyResponseDto();
        dto.setCompanyName(COMPANY_NAME);
        dto.setSlug(TEST_SLUG);
        dto.setDescription(TEST_DESC);
        dto.setRemote(true);
        return dto;
    }

    private StatisticDto createStatisticDto() {
        StatisticDto dto = new StatisticDto();
        dto.setLocation(COMPANY_NAME);
        dto.setVacancyCount(15);
        return dto;
    }
}
