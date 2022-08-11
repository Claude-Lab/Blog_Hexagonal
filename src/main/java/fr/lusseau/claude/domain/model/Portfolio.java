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
public class Portfolio implements Serializable {

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

    public Portfolio(PortfolioBuilder builder) {
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

    public static PortfolioBuilder builder() {
        return new PortfolioBuilder();
    }

    public static class PortfolioBuilder {
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

        public PortfolioBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public PortfolioBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public PortfolioBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public PortfolioBuilder withUrl(String url) {

            this.url = url;
            return this;
        }

        public PortfolioBuilder withCover(String cover) {
            this.cover = cover;
            return this;
        }

        public PortfolioBuilder withMiniature(String miniature) {
            this.miniature = miniature;
            return this;
        }

        public PortfolioBuilder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public PortfolioBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PortfolioBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public PortfolioBuilder withAuthor(User author) {
            this.author = author;
            return this;
        }

        public Portfolio build() {
            return new Portfolio(this);
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
        Portfolio portfolio = (Portfolio) o;
        return id == portfolio.id && isActive == portfolio.isActive && Objects.equals(title, portfolio.title) && Objects.equals(body, portfolio.body) && Objects.equals(url, portfolio.url) && Objects.equals(cover, portfolio.cover) && Objects.equals(miniature, portfolio.miniature) && Objects.equals(createdAt, portfolio.createdAt) && Objects.equals(updatedAt, portfolio.updatedAt) && Objects.equals(author, portfolio.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, url, cover, miniature, isActive, createdAt, updatedAt, author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Portfolio{");
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
