package fr.lusseau.claude.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.entity
 * @date 06/08/2022
 */
public class Experience implements Serializable {

    private final Long id;
    private final String title;
    private final String jobName;
    private final String body;
    private final String url;
    private final String cover;
    private final String miniature;
    private final Company company;
    private final boolean isActive;
    private final LocalDateTime dateIn;
    private final LocalDateTime dateOut;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final User author;

    public Experience(ExperienceBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.body = builder.body;
        this.url = builder.url;
        this.cover = builder.cover;
        this.miniature = builder.miniature;
        this.isActive = builder.isActive;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.author = builder.author;
        this.company = builder.company;
        this.dateIn = builder.dateIn;
        this.dateOut = builder.dateOut;
        this.jobName = builder.jobName;
    }

    public static ExperienceBuilder builder() {
        return new ExperienceBuilder();
    }

    public static class ExperienceBuilder {
        private Long id;
        private String title;
        private String body;
        private String url;
        private String cover;
        private Company company;
        private String miniature;
        private boolean isActive;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private User author;
        private LocalDateTime dateIn;
        private LocalDateTime dateOut;

        private String jobName;

        public ExperienceBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ExperienceBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ExperienceBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public ExperienceBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public ExperienceBuilder withCover(String cover) {
            this.cover = cover;
            return this;
        }

        public ExperienceBuilder withMiniature(String miniature) {
            this.miniature = miniature;
            return this;
        }

        public ExperienceBuilder withCompany(Company company) {
            this.company = company;
            return this;
        }

        public ExperienceBuilder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public ExperienceBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ExperienceBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ExperienceBuilder withAuthor(User author) {
            this.author = author;
            return this;
        }

        public ExperienceBuilder withDateIn(LocalDateTime dateIn) {
            this.dateIn = dateIn;
            return this;
        }

        public ExperienceBuilder withDateOut(LocalDateTime dateOut) {
            this.dateOut = dateOut;
            return this;
        }

        public ExperienceBuilder withJobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public Experience build() {
            return new Experience(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public Company getCompany() {
        return company;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public LocalDateTime getDateOut() {
        return dateOut;
    }

    public String getJobName() {
        return jobName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return isActive == that.isActive && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(jobName, that.jobName) && Objects.equals(body, that.body) && Objects.equals(url, that.url) && Objects.equals(cover, that.cover) && Objects.equals(miniature, that.miniature) && Objects.equals(company, that.company) && Objects.equals(dateIn, that.dateIn) && Objects.equals(dateOut, that.dateOut) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, jobName, body, url, cover, miniature, company, isActive, dateIn, dateOut, createdAt, updatedAt, author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Experience{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", jobName='").append(jobName).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", cover='").append(cover).append('\'');
        sb.append(", miniature='").append(miniature).append('\'');
        sb.append(", company=").append(company);
        sb.append(", isActive=").append(isActive);
        sb.append(", dateIn=").append(dateIn);
        sb.append(", dateOut=").append(dateOut);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", author=").append(author);
        sb.append('}');
        return sb.toString();
    }
}
