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
public class Article implements Serializable {

    private final Long id;
    private final String title;
    private final String body;
    private final String url;
    private final String cover;
    private final String miniature;
    private final boolean isActive;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final User author;

    public Article(ArticleBuilder<?> builder) {
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


    public static ArticleBuilder builder() {
        return new ArticleBuilder() {
            @Override
            public ArticleBuilder getThis() {
                return this;
            }
        };
    }

    public abstract  static class ArticleBuilder <T extends ArticleBuilder<T>> {
        private Long id;
        private String title;
        private String body;
        private String url;
        private String cover;
        private String miniature;
        private boolean isActive;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private User author;

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

        public T withIsActive(boolean isActive) {
            this.isActive = isActive;
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

        public T withAuthor(User author) {
            this.author = author;
            return this.getThis();
        }

        public Article build() {
            return new Article(this);
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

    public User getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return isActive == article.isActive && Objects.equals(id, article.id) && Objects.equals(title, article.title) && Objects.equals(body, article.body) && Objects.equals(url, article.url) && Objects.equals(cover, article.cover) && Objects.equals(miniature, article.miniature) && Objects.equals(createdAt, article.createdAt) && Objects.equals(updatedAt, article.updatedAt) && Objects.equals(author, article.author);
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
