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
@Table(name = "education_blog")
public class EducationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    @Column(name = "education_title")
    private final String title;
    @Lob
    @Column(name = "education_body")
    private final String body;
    @Column(name = "education_url")
    private final String url;
    @Column(name = "education_cover")
    private final String cover;
    @Column(name = "education_miniature")
    private final String miniature;
    @Column(name = "education_isActive")
    private final boolean isActive;
    @Column(name = "education_createdAt")
    private final LocalDateTime createdAt;
    @Column(name = "education_updatedAt")
    private final LocalDateTime updatedAt;
    @ManyToOne()
    @JoinColumn( name="id_user", nullable=false  )
    private final UserEntity author;

    public EducationEntity(EducationBuilder builder) {
        if (builder.id < 0) {
            throw new EntityException("Id cannot be null");
        }
        if (builder.title == null) {
            throw new EntityException("Title cannot be null");
        }
        if (builder.url == null) {
            throw new EntityException("Url cannot be null");
        }
        if (builder.createdAt == null) {
            throw new EntityException("Created date cannot be null");
        }
        if (builder.author == null) {
            throw new EntityException("Author date cannot be null");
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
        private UserEntity author;

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

        public EducationBuilder withAuthor(UserEntity author) {
            this.author = author;
            return this;
        }

        public EducationEntity build() {
            return new EducationEntity(this);
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

    public UserEntity getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationEntity education = (EducationEntity) o;
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
