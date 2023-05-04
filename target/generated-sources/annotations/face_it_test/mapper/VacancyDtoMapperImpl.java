package face_it_test.mapper;

import face_it_test.dto.VacancyResponseDto;
import face_it_test.entity.Vacancy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-03T21:52:35+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Azul Systems, Inc.)"
)
@Component
public class VacancyDtoMapperImpl implements VacancyDtoMapper {

    @Override
    public VacancyResponseDto toVacancyDto(Vacancy entity) {
        if ( entity == null ) {
            return null;
        }

        VacancyResponseDto vacancyResponseDto = new VacancyResponseDto();

        vacancyResponseDto.setSlug( entity.getSlug() );
        vacancyResponseDto.setCompanyName( entity.getCompanyName() );
        vacancyResponseDto.setTitle( entity.getTitle() );
        vacancyResponseDto.setDescription( entity.getDescription() );
        vacancyResponseDto.setRemote( entity.getRemote() );
        vacancyResponseDto.setUrl( entity.getUrl() );
        List<String> list = entity.getTags();
        if ( list != null ) {
            vacancyResponseDto.setTags( new ArrayList<String>( list ) );
        }
        List<String> list1 = entity.getJobTypes();
        if ( list1 != null ) {
            vacancyResponseDto.setJobTypes( new ArrayList<String>( list1 ) );
        }
        vacancyResponseDto.setLocation( entity.getLocation() );
        vacancyResponseDto.setCreatedAt( entity.getCreatedAt() );

        return vacancyResponseDto;
    }

    @Override
    public List<VacancyResponseDto> toVacancyDto(List<Vacancy> entitys) {
        if ( entitys == null ) {
            return null;
        }

        List<VacancyResponseDto> list = new ArrayList<VacancyResponseDto>( entitys.size() );
        for ( Vacancy vacancy : entitys ) {
            list.add( toVacancyDto( vacancy ) );
        }

        return list;
    }
}
