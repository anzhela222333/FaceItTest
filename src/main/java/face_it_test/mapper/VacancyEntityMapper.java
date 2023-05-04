package face_it_test.mapper;

import face_it_test.entity.Vacancy;
import face_it_test.model.VacancyModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.regex.Pattern;

@Mapper(componentModel = "spring")
public interface VacancyEntityMapper {

    static final String INT_REGEX = "-?[0-9]+";
    static final String SPLIT_PATTER = "-";

    Vacancy toVacancyEntity(VacancyModel model);

    List<Vacancy> toVacancyEntity(List<VacancyModel> models);

    @AfterMapping
    default void cutDescriptionAndSetId(@MappingTarget List<Vacancy> entities) {
        entities.forEach(el -> {
            el.setId(getId(el.getSlug()));
            if (el.getDescription().length() > 500) {
                el.setDescription(el.getDescription().substring(0, 500));
            }
        });
    }

    private int getId(String slug) {
        String[] mass = slug.split(SPLIT_PATTER);
        return Pattern.matches(INT_REGEX, mass[mass.length - 1]) ?
                Integer.parseInt(mass[mass.length - 1]) : slug.hashCode();
    }
}
