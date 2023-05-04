package face_it_test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VacancyModel {

    @JsonProperty("slug")
    private String slug;
    @JsonProperty("company_name")
    private String companyName;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("remote")
    private Boolean remote;
    @JsonProperty("url")
    private String url;
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("job_types")
    private List<String> jobTypes;
    @JsonProperty("location")
    private String location;
    @JsonProperty("created_at")
    private String createdAt;

    public VacancyModel() {
    }

    public VacancyModel(String slug, String companyName, String title, String description, Boolean remote,
                        String url, List<String> tags, List<String> jobTypes, String location, String createdAt) {
        this.slug = slug;
        this.companyName = companyName;
        this.title = title;
        this.description = description;
        this.remote = remote;
        this.url = url;
        this.tags = tags;
        this.jobTypes = jobTypes;
        this.location = location;
        this.createdAt = createdAt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRemote() {
        return remote;
    }

    public void setRemote(Boolean remote) {
        this.remote = remote;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getJobTypes() {
        return jobTypes;
    }

    public void setJobTypes(List<String> jobTypes) {
        this.jobTypes = jobTypes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
