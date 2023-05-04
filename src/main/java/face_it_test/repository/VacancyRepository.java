package face_it_test.repository;

import face_it_test.dto.StatisticDto;
import face_it_test.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {

    @Query(value = "SELECT new face_it_test.dto.StatisticDto(v.location, COUNT(v.location)) "
            + "FROM Vacancy v "
            + "GROUP BY v.location")
    List<StatisticDto> getStatisticByLocations();
}
