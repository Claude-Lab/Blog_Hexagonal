package fr.lusseau.claude.infrastructure.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Cacheable
public abstract class ArticleEntity extends PanacheEntityBase implements Serializable  {

    @Id
    @TableGenerator(
            name = "artGen",
            table = "ID_GEN",
            pkColumnName = "GEN_KEY",
            valueColumnName = "GEN_VALUE",
            pkColumnValue = "ART_ID",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "artGen")
    private Long id;
    @NotNull(message = "Title is required.")
    @NotBlank(message = "Title is required.")
    @Column(name = "article_title", unique = true, nullable = false)
    private String title;
    @Lob
    @NotNull(message = "Body is required.")
    @NotBlank(message = "Body is required.")
    @Column(name = "article_body")
    private String body;
    @NotNull(message = "Url is required.")
    @NotBlank(message = "Url is required.")
    @Column(name = "article_url", unique = true, nullable = false)
    private String url;
    @Column(name = "article_cover")
    private String cover;
    @Column(name = "article_miniature")
    private String miniature;
    @Column(name = "article_active")
    private boolean active;
    @NotNull(message = "CreatedAt is required.")
    @Column(name = "article_createdAt")
    private LocalDateTime createdAt;
    @Column(name = "article_updatedAt")
    private LocalDateTime updatedAt;
    @NotNull(message = "Author is required.")
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity author;

    protected ArticleEntity(Long id, String title, String body, String url, String cover, String miniature, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt, UserEntity author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.url = url;
        this.cover = cover;
        this.miniature = miniature;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.author = author;
    }

    protected ArticleEntity() {
    }

    protected ArticleEntity(ArticleEntityBuilder<?> builder) {
        id = builder.id;
        title = builder.title;
        body = builder.body;
        url = builder.url;
        cover = builder.cover;
        miniature = builder.miniature;
        active = builder.active;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        author = builder.author;

    }


    public abstract static class ArticleEntityBuilder<T extends ArticleEntityBuilder<T>> {
        private Long id;
        private String title;
        private String body;
        private String url;
        private String cover;
        private String miniature;
        private boolean active;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private UserEntity author;

        public abstract T getThis();

        public T withId(Long id) {
            this.id = id;
            return this.getThis();
        }

        public T withTitle(String title) {
            this.title = title;
            return this.getThis();
        }

        public T withBody(String body) {
            this.body = body;
            return this.getThis();
        }

        public T withUrl(String url) {
            this.url = url;
            return this.getThis();
        }

        public T withCover(String cover) {
            this.cover = cover;
            return this.getThis();
        }

        public T withMiniature(String miniature) {
            this.miniature = miniature;
            return this.getThis();
        }

        public T withActive(boolean active) {
            this.active = active;
            return this.getThis();
        }

        public T withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this.getThis();
        }

        public T withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this.getThis();
        }

        public T withAuthor(UserEntity author) {
            this.author = author;
            return this.getThis();
        }

        public abstract ArticleEntity build();
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
        return active;
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
        return active == article.active && Objects.equals(id, article.id) && Objects.equals(title, article.title) && Objects.equals(body, article.body) && Objects.equals(url, article.url) && Objects.equals(cover, article.cover) && Objects.equals(miniature, article.miniature) && Objects.equals(createdAt, article.createdAt) && Objects.equals(updatedAt, article.updatedAt) && Objects.equals(author, article.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, url, cover, miniature, active, createdAt, updatedAt, author);
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
        sb.append(", active=").append(active);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", author=").append(author);
        sb.append('}');
        return sb.toString();
    }
}
