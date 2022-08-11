package fr.lusseau.claude.application.entity;

import fr.lusseau.claude.application.exception.EntityException;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.entity
 * @date 06/08/2022
 */
@Entity
@Table(name = "experience_blog")
@Cacheable
public class ExperienceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "experience_title")
    private String title;
    @Column(name = "experience_job_name")
    private String jobName;
    @Column(name = "experience_company")
    private CompanyEntity company;
    @Column(name = "experience_dateIn")
    private LocalDateTime dateIn;
    @Column(name = "experience_dateOut")
    private LocalDateTime dateOut;
    @Lob
    @Column(name = "experience_body")
    private String body;
    @Column(name = "experience_url")
    private String url;
    @Column(name = "experience_cover")
    private String cover;
    @Column(name = "experience_miniature")
    private String miniature;
    @Column(name = "experience_isActive")
    private boolean isActive;
    @Column(name = "experience_createdAt")
    private LocalDateTime createdAt;
    @Column(name = "experience_updatedAt")
    private LocalDateTime updatedAt;
    @ManyToOne()
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity author;

    protected ExperienceEntity() {
    }

    private  ExperienceEntity(Long id, String title, String jobName, CompanyEntity company, LocalDateTime dateIn, LocalDateTime dateOut, String body, String url, String cover, String miniature, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, UserEntity author) {
        this.id = id;
        this.title = title;
        this.jobName = jobName;
        this.company = company;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.body = body;
        this.url = url;
        this.cover = cover;
        this.miniature = miniature;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.author = author;
    }

    public ExperienceEntity(ExperienceEntityBuilder builder) {
        if (builder.id == null) {
            throw new EntityException("Id is required.");
        }
        if (builder.title == null) {
            throw new EntityException("Title is required.");
        }
        if (builder.body == null) {
            throw new EntityException("Body is required.");
        }
        if (builder.url == null) {
            throw new EntityException("Url is required.");
        }
        if (builder.dateIn == null) {
            throw new EntityException("Date In is required.");
        }
        if (builder.createdAt == null) {
            throw new EntityException("CreatedAt is required.");
        }
        if (builder.author == null) {
            throw new EntityException("Author is required.");
        }
        id = builder.id;
        title = builder.title;
        jobName = builder.jobName;
        body = builder.body;
        url = builder.url;
        cover = builder.cover;
        miniature = builder.miniature;
        company = builder.company;
        isActive = builder.isActive;
        dateIn = builder.dateIn;
        dateOut = builder.dateOut;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        author = builder.author;
    }

    public static ExperienceEntityBuilder builder() {
        return new ExperienceEntityBuilder();
    }

    public static class ExperienceEntityBuilder {
        private Long id;
        private String title;
        private CompanyEntity company;
        private String jobName;
        private String body;
        private String url;
        private String cover;
        private String miniature;
        private boolean isActive;
        private LocalDateTime dateIn;
        private LocalDateTime dateOut;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private UserEntity author;

        public ExperienceEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ExperienceEntityBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ExperienceEntityBuilder withCompany(CompanyEntity company) {
            this.company = company;
            return this;
        }

        public ExperienceEntityBuilder witJobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public ExperienceEntityBuilder withBody(String body) {
            this.body = body;
            return this;
        }
        public ExperienceEntityBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public ExperienceEntityBuilder withCover(String cover) {
            this.cover = cover;
            return this;
        }

        public ExperienceEntityBuilder withMiniature(String miniature) {
            this.miniature = miniature;
            return this;
        }

        public ExperienceEntityBuilder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }
        public ExperienceEntityBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ExperienceEntityBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        public ExperienceEntityBuilder withDateIn(LocalDateTime dateIn) {
            this.dateIn = dateIn;
            return this;
        }

        public ExperienceEntityBuilder withDateOut(LocalDateTime dateOut) {
            this.dateOut = dateOut;
            return this;
        }

        public ExperienceEntityBuilder withAuthor(UserEntity author) {
            this.author = author;
            return this;
        }

        public ExperienceEntity build() {
            return new ExperienceEntity(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getJobName() {
        return jobName;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public LocalDateTime getDateOut() {
        return dateOut;
    }

    public String getBody() {
        return body;
    }

    public String getUrl() {
        return url;
    }

    public String getCover() {
        return cover;
    }

    public String getMiniature() {
        return miniature;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UserEntity getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceEntity that = (ExperienceEntity) o;
        return isActive == that.isActive && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(jobName, that.jobName) && Objects.equals(company, that.company) && Objects.equals(dateIn, that.dateIn) && Objects.equals(dateOut, that.dateOut) && Objects.equals(body, that.body) && Objects.equals(url, that.url) && Objects.equals(cover, that.cover) && Objects.equals(miniature, that.miniature) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, jobName, company, dateIn, dateOut, body, url, cover, miniature, isActive, createdAt, updatedAt, author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExperienceEntity{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", jobName='").append(jobName).append('\'');
        sb.append(", company=").append(company);
        sb.append(", dateIn=").append(dateIn);
        sb.append(", dateOut=").append(dateOut);
        sb.append(", body='").append(body).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", cover='").append(cover).append('\'');
        sb.append(", miniature='").append(miniature).append('\'');
        sb.append(", isActive=").append(isActive);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", author=").append(author);
        sb.append('}');
        return sb.toString();
    }
}