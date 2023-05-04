package service;

import face_it_test.dto.StatisticDto;
import face_it_test.dto.VacancyResponseDto;
import face_it_test.entity.Vacancy;
import face_it_test.mapper.VacancyDtoMapper;
import face_it_test.mapper.VacancyEntityMapper;
import face_it_test.model.VacancyModel;
import face_it_test.repository.VacancyRepository;
import face_it_test.service.GateWayService;
import face_it_test.service.VacancyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.isA;

@ExtendWith(MockitoExtension.class)
public class VacancyServiceTest {

    private static final String SLUG = "Test slug";
    private static final String DESC = "Test Desc";
    private static final String LOCATION = "London";
    private static final String CREATED_AT_FIELD = "createdAt";
    private static final int PAGE_NUMBER = 1;
    private static final int PAGE_SIZE = 5;

    @InjectMocks
    private VacancyServiceImpl vacancyService;
    @Mock
    private GateWayService gateWayService;
    @Mock
    private VacancyEntityMapper entityMapper;
    @Mock
    private VacancyRepository repository;
    @Mock
    private VacancyDtoMapper dtoMapper;

    @Test
    public void loadVacanciesData() {
        List<VacancyModel> vacancyModels = List.of(createVacancyModel());
        List<Vacancy> vacancies = List.of(createVacancy());

        when(gateWayService.readData()).thenReturn(vacancyModels);
        when(entityMapper.toVacancyEntity(vacancyModels)).thenReturn(vacancies);

        vacancyService.loadVacanciesData();
        verify(repository, times(1)).saveAll(vacancies);
    }

    @Test
    public void getStatisticByLocation() {
        List<StatisticDto> statisticDtos = List.of(createStatisticDto());
        when(repository.getStatisticByLocations()).thenReturn(statisticDtos);

        List<StatisticDto> response = vacancyService.getStatisticByLocation();
        verify(repository, times(1)).getStatisticByLocations();
        Assertions.assertEquals(response.get(0).getLocation(), LOCATION);
        Assertions.assertEquals(response.get(0).getVacancyCount(), 15);
    }

    @Test
    public void getVacancies() {
        Page<Vacancy> vacancies = mock(Page.class);
        when(repository.findAll(isA(Pageable.class))).thenReturn(vacancies);
        when(dtoMapper.toVacancyDto(vacancies.getContent())).thenReturn(List.of(createVacancyResponseDto()));

        List<VacancyResponseDto> response = vacancyService.getVacancies(PAGE_NUMBER, PAGE_SIZE);
        Assertions.assertEquals(response.get(0).getDescription(), DESC);
        Assertions.assertEquals(response.get(0).getSlug(), SLUG);
    }

    @Test
    public void getTop10Vacancies() {
        Page<Vacancy> vacancies = mock(Page.class);
        when(repository.findAll(isA(Pageable.class))).thenReturn(vacancies);
        when(dtoMapper.toVacancyDto(vacancies.getContent())).thenReturn(List.of(createVacancyResponseDto()));

        List<VacancyResponseDto> response = vacancyService.getTop10Vacancies();
        Assertions.assertEquals(response.get(0).getDescription(), DESC);
        Assertions.assertEquals(response.get(0).getSlug(), SLUG);
    }

    private VacancyModel createVacancyModel() {
        VacancyModel vacancyModel = new VacancyModel();
        vacancyModel.setSlug(SLUG);
        vacancyModel.setDescription(DESC);
        return vacancyModel;
    }

    private Vacancy createVacancy() {
        Vacancy vacancy = new Vacancy();
        vacancy.setSlug(SLUG);
        vacancy.setDescription(DESC);
        return vacancy;
    }

    private StatisticDto createStatisticDto() {
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setLocation(LOCATION);
        statisticDto.setVacancyCount(15);
        return statisticDto;
    }

    private VacancyResponseDto createVacancyResponseDto() {
        VacancyResponseDto dto = new VacancyResponseDto();
        dto.setSlug(SLUG);
        dto.setDescription(DESC);
        return dto;
    }
}
