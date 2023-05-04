package face_it_test.mapper;

import face_it_test.entity.Vacancy;
import face_it_test.model.VacancyModel;
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
public class VacancyEntityMapperImpl implements VacancyEntityMapper {

    @Override
    public Vacancy toVacancyEntity(VacancyModel model) {
        if ( model == null ) {
            return null;
        }

        Vacancy vacancy = new Vacancy();

        vacancy.setSlug( model.getSlug() );
        vacancy.setCompanyName( model.getCompanyName() );
        vacancy.setTitle( model.getTitle() );
        vacancy.setDescription( model.getDescription() );
        vacancy.setRemote( model.getRemote() );
        vacancy.setUrl( model.getUrl() );
        List<String> list = model.getTags();
        if ( list != null ) {
            vacancy.setTags( new ArrayList<String>( list ) );
        }
        List<String> list1 = model.getJobTypes();
        if ( list1 != null ) {
            vacancy.setJobTypes( new ArrayList<String>( list1 ) );
        }
        vacancy.setLocation( model.getLocation() );
        vacancy.setCreatedAt( model.getCreatedAt() );

        return vacancy;
    }

    @Override
    public List<Vacancy> toVacancyEntity(List<VacancyModel> models) {
        if ( models == null ) {
            return null;
        }

        List<Vacancy> list = new ArrayList<Vacancy>( models.size() );
        for ( VacancyModel vacancyModel : models ) {
            list.add( toVacancyEntity( vacancyModel ) );
        }

        cutDescriptionAndSetId( list );

        return list;
    }
}
