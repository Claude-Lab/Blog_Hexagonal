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
@Table(name = "article_blog")
public class ArticleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    @Column(name = "article_title")
    private final String title;
    @Lob
    @Column(name = "article_body")
    private final String body;
    @Column(name = "article_url")
    private final String url;
    @Column(name = "article_cover")
    private final String cover;
    @Column(name = "article_miniature")
    private final String miniature;
    @Column(name = "article_isActive")
    private final boolean isActive;
    @Column(name = "article_createdAt")
    private final LocalDateTime createdAt;
    @Column(name = "article_updatedAt")
    private final LocalDateTime updatedAt;

    @ManyToOne()
    @JoinColumn(name = "id_user", nullable = false)
    private final UserEntity author;

    public ArticleEntity(ArticleBuilder builder) {
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

    public static ArticleBuilder builder() {
        return new ArticleBuilder();
    }

    public static class ArticleBuilder {
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

        public ArticleBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public ArticleBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ArticleBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public ArticleBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public ArticleBuilder withCover(String cover) {
            this.cover = cover;
            return this;
        }

        public ArticleBuilder withMiniature(String miniature) {
            this.miniature = miniature;
            return this;
        }

        public ArticleBuilder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public ArticleBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ArticleBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ArticleBuilder withAuthor(UserEntity author) {
            this.author = author;
            return this;
        }

        public ArticleEntity build() {
            return new ArticleEntity(this);
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
        ArticleEntity article = (ArticleEntity) o;
        return id == article.id && isActive == article.isActive && Objects.equals(title, article.title) && Objects.equals(body, article.body) && Objects.equals(url, article.url) && Objects.equals(cover, article.cover) && Objects.equals(miniature, article.miniature) && Objects.equals(createdAt, article.createdAt) && Objects.equals(updatedAt, article.updatedAt) && Objects.equals(author, article.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, url, cover, miniature, isActive, createdAt, updatedAt, author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Article{");
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
