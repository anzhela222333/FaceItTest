package face_it_test.scheduler;

import face_it_test.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LoadInfoScheduler {

    @Autowired
    private VacancyService vacancyService;

    @Scheduled(cron = "0 * * * * *")
    public void loadWebSiteData() {
        System.out.println("It's a cron JOB");
        vacancyService.loadVacanciesData();
    }

}
