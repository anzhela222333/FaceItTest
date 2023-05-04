package face_it_test.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    private int id;
    @Column(name = "slug", columnDefinition = "varchar(500)")
    private String slug;
    @Column(name = "company_name", columnDefinition = "varchar(500)")
    private String companyName;
    @Column(name = "title", columnDefinition = "varchar(500)")
    private String title;
    @Column(name = "description", columnDefinition = "varchar(500)")
    private String description;
    @Column(name = "remote", columnDefinition = "varchar(500)")
    private Boolean remote;
    @Column(name = "url", columnDefinition = "varchar(500)")
    private String url;
    @ElementCollection(targetClass = String.class)
    @Column(name = "tags", columnDefinition = "varchar(500)")
    private List<String> tags;
    @ElementCollection(targetClass = String.class)
    @Column(name = "jobTypes", columnDefinition = "varchar(500)")
    private List<String> jobTypes;
    @Column(name = "location", columnDefinition = "varchar(500)")
    private String location;
    @Column(name = "created_at", columnDefinition = "varchar(30)")
    private String createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy that = (Vacancy) o;
        return id == that.id &&
                Objects.equals(slug, that.slug) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(remote, that.remote) &&
                Objects.equals(url, that.url) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(jobTypes, that.jobTypes) &&
                Objects.equals(location, that.location) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, slug, companyName, title, description, remote, url, tags, jobTypes, location, createdAt);
    }
}
