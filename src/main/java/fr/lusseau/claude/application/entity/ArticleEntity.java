package fr.lusseau.claude.application.entity;

import fr.lusseau.claude.application.exception.EntityException;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@Table(name = "article_blog")
@Cacheable
public class ArticleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Title is required.")
    @NotBlank(message = "Title is required.")
    @Column(name = "article_title")
    private String title;
    @Lob
    @NotNull(message = "Body is required.")
    @NotBlank(message = "Body is required.")
    @Column(name = "article_body")
    private String body;
    @NotNull(message = "Url is required.")
    @NotBlank(message = "Url is required.")
    @Column(name = "article_url")
    private String url;
    @Column(name = "article_cover")
    private String cover;
    @Column(name = "article_miniature")
    private String miniature;
    @Column(name = "article_isActive")
    private boolean isActive;
    @NotNull(message = "CreatedAt is required.")
    @Column(name = "article_createdAt")
    private LocalDateTime createdAt;
    @Column(name = "article_updatedAt")
    private LocalDateTime updatedAt;
    @NotNull(message = "Author is required.")
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity author;

    protected ArticleEntity() {
    }

    private ArticleEntity(Long id, String title, String body, String url, String cover, String miniature, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, UserEntity author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.url = url;
        this.cover = cover;
        this.miniature = miniature;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.author = author;
    }

    private ArticleEntity(ArticleEntityBuilder builder) {
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
        if (builder.createdAt == null) {
            throw new EntityException("CreatedAt is required.");
        }
        if (builder.author == null) {
            throw new EntityException("Author is required.");
        }
        id = builder.id;
        title = builder.title;
        body = builder.body;
        url = builder.url;
        cover = builder.cover;
        miniature = builder.miniature;
        isActive = builder.isActive;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        author = builder.author;

    }

    public static ArticleEntityBuilder builder() {
        return new ArticleEntityBuilder();
    }

    public static class ArticleEntityBuilder {
        private Long id;
        private String title;
        private String body;
        private String url;
        private String cover;
        private String miniature;
        private boolean isActive;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private UserEntity author;

        public ArticleEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ArticleEntityBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ArticleEntityBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public ArticleEntityBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public ArticleEntityBuilder withCover(String cover) {
            this.cover = cover;
            return this;
        }

        public ArticleEntityBuilder withMiniature(String miniature) {
            this.miniature = miniature;
            return this;
        }

        public ArticleEntityBuilder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public ArticleEntityBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ArticleEntityBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ArticleEntityBuilder withAuthor(UserEntity author) {
            this.author = author;
            return this;
        }

        public ArticleEntity build() {
            return new ArticleEntity(this);
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

    public UserEntity getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleEntity article = (ArticleEntity) o;
        return isActive == article.isActive && Objects.equals(id, article.id) && Objects.equals(title, article.title) && Objects.equals(body, article.body) && Objects.equals(url, article.url) && Objects.equals(cover, article.cover) && Objects.equals(miniature, article.miniature) && Objects.equals(createdAt, article.createdAt) && Objects.equals(updatedAt, article.updatedAt) && Objects.equals(author, article.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, url, cover, miniature, isActive, createdAt, updatedAt, author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArticleEntity{");
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
