package face_it_test.controller;

import face_it_test.dto.StatisticDto;
import face_it_test.dto.VacancyResponseDto;
import face_it_test.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, params = {"page", "size"})
    public ResponseEntity<List<VacancyResponseDto>> getAllVacancies(@RequestParam("page") int page,
                                                                    @RequestParam("size") int size) {
        List<VacancyResponseDto> vacancies = vacancyService.getVacancies(page, size);
        return new ResponseEntity<List<VacancyResponseDto>>(vacancies, HttpStatus.OK);
    }

    @RequestMapping(value = "/count-by-location", method = RequestMethod.GET)
    public ResponseEntity<List<StatisticDto>> getCountByLocation() {
        List<StatisticDto> statisticDtos = vacancyService.getStatisticByLocation();
        return new ResponseEntity<List<StatisticDto>>(statisticDtos, HttpStatus.OK);
    }

    //STUB
    @RequestMapping(value = "/top-ten", method = RequestMethod.GET)
    public ResponseEntity<List<VacancyResponseDto>> getTopTen(){
        List<VacancyResponseDto> dtos = vacancyService.getTop10Vacancies();
        return new ResponseEntity<List<VacancyResponseDto>>(dtos, HttpStatus.OK);
    }
}
