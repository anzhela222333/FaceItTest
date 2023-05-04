package face_it_test.mapper;

import face_it_test.dto.VacancyResponseDto;
import face_it_test.entity.Vacancy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VacancyDtoMapper {

    VacancyResponseDto toVacancyDto(Vacancy entity);

    List<VacancyResponseDto> toVacancyDto(List<Vacancy> entitys);

}
