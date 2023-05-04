package face_it_test.service;

import face_it_test.dto.StatisticDto;
import face_it_test.dto.VacancyResponseDto;
import face_it_test.entity.Vacancy;
import face_it_test.mapper.VacancyDtoMapper;
import face_it_test.mapper.VacancyEntityMapper;
import face_it_test.model.VacancyModel;
import face_it_test.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    private static final String CREATED_AT_FIELD = "createdAt";
    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private GateWayService gateWayService;
    @Autowired
    private VacancyEntityMapper entityMapper;
    @Autowired
    private VacancyDtoMapper dtoMapper;

    public void loadVacanciesData() {
        List <VacancyModel> models = gateWayService.readData();
        vacancyRepository.saveAll(entityMapper.toVacancyEntity(models));
    }

    @Override
    public List<StatisticDto> getStatisticByLocation() {
        return vacancyRepository.getStatisticByLocations();
    }

    @Override
    public List<VacancyResponseDto> getVacancies(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(CREATED_AT_FIELD).descending());
        List<Vacancy> vacancyEntities = vacancyRepository.findAll(pageable).getContent();
        return dtoMapper.toVacancyDto(vacancyEntities);
    }

    @Override
    public List<VacancyResponseDto> getTop10Vacancies() {
        Pageable pageable = PageRequest.ofSize(10);
        List<Vacancy> vacancies = vacancyRepository.findAll(pageable).getContent();
        return dtoMapper.toVacancyDto(vacancies);
    }
}
