package face_it_test.dto;

public class StatisticDto {

    private String location;
    private long vacancyCount;

    public StatisticDto() {
    }

    public StatisticDto(String location, long vacancyCount) {
        this.location = location;
        this.vacancyCount = vacancyCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getVacancyCount() {
        return vacancyCount;
    }

    public void setVacancyCount(long vacancyCount) {
        this.vacancyCount = vacancyCount;
    }
}
