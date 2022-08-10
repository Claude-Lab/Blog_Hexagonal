package fr.lusseau.claude.domain.model;

import fr.lusseau.claude.domain.exception.DomainModelException;

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

    private final long id;
    private final String title;
    private final String body;
    private final String url;
    private final String cover;
    private final String miniature;
    private final boolean isActive;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final User author;

    public Education(EducationBuilder builder) {
        if (builder.id < 0) {
            throw new DomainModelException("Id cannot be null");
        }
        if (builder.title == null) {
            throw new DomainModelException("Title cannot be null");
        }
        if (builder.url == null) {
            throw new DomainModelException("Url cannot be null");
        }
        if (builder.createdAt == null) {
            throw new DomainModelException("Created date cannot be null");
        }
        if (builder.author == null) {
            throw new DomainModelException("Author date cannot be null");
        }
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
    }

    public static EducationBuilder builder() {
        return new EducationBuilder();
    }

    public static class EducationBuilder {
        private long id;
        private String title;
        private String body;
        private String url;
        private String cover;
        private String miniature;
        private boolean isActive;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private User author;

        public EducationBuilder withId(long id) {
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

        public EducationBuilder withMiniature(String miniature) {
            this.miniature = miniature;
            return this;
        }

        public EducationBuilder withIsActive(boolean isActive) {
            this.isActive = isActive;
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

        public EducationBuilder withAuthor(User author) {
            this.author = author;
            return this;
        }

        public Education build() {
            return new Education(this);
        }
    }

    public long getId() {
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

    public User getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return id == education.id && isActive == education.isActive && Objects.equals(title, education.title) && Objects.equals(body, education.body) && Objects.equals(url, education.url) && Objects.equals(cover, education.cover) && Objects.equals(miniature, education.miniature) && Objects.equals(createdAt, education.createdAt) && Objects.equals(updatedAt, education.updatedAt) && Objects.equals(author, education.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, url, cover, miniature, isActive, createdAt, updatedAt, author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Education{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
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
