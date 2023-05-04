package face_it_test.service;

import face_it_test.dto.StatisticDto;
import face_it_test.dto.VacancyResponseDto;

import java.util.List;

public interface VacancyService {

    void loadVacanciesData();
    List<StatisticDto> getStatisticByLocation();
    List<VacancyResponseDto> getVacancies(int pageNumber, int pageSize);
    List<VacancyResponseDto> getTop10Vacancies();

}
