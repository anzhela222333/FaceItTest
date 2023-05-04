package scheduler;

import face_it_test.config.ScheduledConfig;
import face_it_test.scheduler.LoadInfoScheduler;
import face_it_test.service.VacancyService;
import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringJUnitConfig(ScheduledConfig.class)
public class LoadInfoSchedulerTest {

    @SpyBean
    private LoadInfoScheduler loadInfoScheduler;
    @MockBean
    private VacancyService vacancyService;

    @Test
    public void loadWebSiteData() {
        await()
                .atMost(Duration.ONE_MINUTE)
                .untilAsserted(() -> verify(loadInfoScheduler, atLeast(1)).loadWebSiteData());
    }
}
