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
public class Education implements Serializable {

    private final Long id;
    private final String title;
    private final String body;
    private final String url;
    private final String cover;
    private final Company company;
    private final LocalDateTime dateIn;
    private final LocalDateTime dateOut;
    private final String miniature;
    private final boolean isActive;
    private final EducationLevel level;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final User author;

    public Education(EducationBuilder builder) {
        id = builder.id;
        title = builder.title;
        body = builder.body;
        url = builder.url;
        cover = builder.cover;
        company = builder.company;
        dateIn = builder.dateIn;
        dateOut = builder.dateOut;
        miniature = builder.miniature;
        isActive = builder.isActive;
        level = builder.level;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        author = builder.author;
    }

    public static EducationBuilder builder() {
        return new EducationBuilder();
    }

    public static class EducationBuilder {
        private Long id;
        private String title;
        private String body;
        private String url;
        private String cover;
        private Company company;
        private LocalDateTime dateIn;
        private LocalDateTime dateOut;
        private String miniature;
        private boolean isActive;
        private EducationLevel level;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private User author;

        public EducationBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EducationBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public EducationBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public EducationBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public EducationBuilder withCover(String cover) {
            this.cover = cover;
            return this;
        }

        public EducationBuilder withCompany(Company company) {
            this.company = company;
            return this;
        }

        public EducationBuilder withDateIn(LocalDateTime dateIn) {
            this.dateIn = dateIn;
            return this;
        }

        public EducationBuilder withDateOut(LocalDateTime dateOut) {
            this.dateOut = dateOut;
            return this;
        }

        public EducationBuilder withMiniature(String miniature) {
            this.miniature = miniature;
            return this;
        }

        public EducationBuilder withLevel(EducationLevel level) {
            this.level = level;
            return this;
        }

        public EducationBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public EducationBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public EducationBuilder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public EducationBuilder withAuthor(User author) {
            this.author = author;
            return this;
        }

        public Education build() {
            return new Education(this);
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

    public Company getCompany() {
        return company;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public LocalDateTime getDateOut() {
        return dateOut;
    }

    public String getMiniature() {
        return miniature;
    }

    public boolean isActive() {
        return isActive;
    }

    public EducationLevel getLevel() {
        return level;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public User getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return isActive == education.isActive && Objects.equals(id, education.id) && Objects.equals(title, education.title) && Objects.equals(body, education.body) && Objects.equals(url, education.url) && Objects.equals(cover, education.cover) && Objects.equals(company, education.company) && Objects.equals(dateIn, education.dateIn) && Objects.equals(dateOut, education.dateOut) && Objects.equals(miniature, education.miniature) && Objects.equals(level, education.level) && Objects.equals(createdAt, education.createdAt) && Objects.equals(updatedAt, education.updatedAt) && Objects.equals(author, education.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, url, cover, company, dateIn, dateOut, miniature, isActive, level, createdAt, updatedAt, author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Education{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", cover='").append(cover).append('\'');
        sb.append(", company=").append(company);
        sb.append(", dateIn=").append(dateIn);
        sb.append(", dateOut=").append(dateOut);
        sb.append(", miniature='").append(miniature).append('\'');
        sb.append(", isActive=").append(isActive);
        sb.append(", level=").append(level);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", author=").append(author);
        sb.append('}');
        return sb.toString();
    }
}
