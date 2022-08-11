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
@Table(name = "education_blog")
@Cacheable
public class EducationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Title is required.")
    @NotBlank(message = "Title is required.")
    @Column(name = "education_title")
    private String title;
    @NotNull(message = "Body is required.")
    @NotBlank(message = "Body is required.")
    @Lob
    @Column(name = "education_body")
    private String body;
    @NotNull(message = "Url is required.")
    @NotBlank(message = "Url is required.")
    @Column(name = "education_url")
    private String url;
    @Column(name = "education_cover")
    private String cover;
    @Column(name = "education_miniature")
    private String miniature;
    @Column(name = "education_company")
    private CompanyEntity company;
    @Column(name = "education_isActive")
    private boolean isActive;
    @NotNull(message = "Date in is required.")
    @Column(name = "education_dateIn")
    private LocalDateTime dateIn;
    @Column(name = "education_dateOut")
    private LocalDateTime dateOut;
    @Column(name = "education_level")
    private EducationLevelEntity level;
    @NotNull(message = "CreatedAt is required.")
    @Column(name = "education_createdAt")
    private LocalDateTime createdAt;
    @Column(name = "education_updatedAt")
    private LocalDateTime updatedAt;
    @NotNull(message = "Author is required.")
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity author;

    protected EducationEntity() {
    }

    private EducationEntity(Long id, String title, String body, String url, String cover, String miniature, CompanyEntity company, boolean isActive, LocalDateTime dateIn, LocalDateTime dateOut, EducationLevelEntity level, LocalDateTime createdAt, LocalDateTime updatedAt, UserEntity author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.url = url;
        this.cover = cover;
        this.miniature = miniature;
        this.company = company;
        this.isActive = isActive;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.level = level;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.author = author;
    }

    public EducationEntity(EducationEntityBuilder builder) {
        if (builder.id == null) {
            throw new EntityException("Id is required.");
        }
        if (builder.title == null) {
            throw new EntityException("Title is required.");
        }
        if (!builder.title.contains(" ")) {
            throw new EntityException("Title is required.");
        }
        if (builder.body == null) {
            throw new EntityException("Body is required.");
        }
        if (!builder.body.contains(" ")) {
            throw new EntityException("Body is required.");
        }
        if (builder.url == null) {
            throw new EntityException("Url is required.");
        }
        if (builder.createdAt == null) {
            throw new EntityException("CreatedAt is required.");
        }
        if (builder.dateIn == null) {
            throw new EntityException("Date in is required.");
        }
        if (builder.author == null) {
            throw new EntityException("Author is required.");
        }
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

    public static EducationEntityBuilder builder() {
        return new EducationEntityBuilder();
    }

    public static class EducationEntityBuilder {
        private Long id;
        private String title;
        private String body;
        private String url;
        private String cover;
        private CompanyEntity company;
        private LocalDateTime dateIn;
        private LocalDateTime dateOut;
        private String miniature;
        private boolean isActive;
        private EducationLevelEntity level;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private UserEntity author;

        public EducationEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EducationEntityBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public EducationEntityBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public EducationEntityBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public EducationEntityBuilder withCover(String cover) {
            this.cover = cover;
            return this;
        }

        public EducationEntityBuilder withCompany(CompanyEntity company) {
            this.company = company;
            return this;
        }

        public EducationEntityBuilder withDateIn(LocalDateTime dateIn) {
            this.dateIn = dateIn;
            return this;
        }

        public EducationEntityBuilder withDateOut(LocalDateTime dateOut) {
            this.dateOut = dateOut;
            return this;
        }

        public EducationEntityBuilder withMiniature(String miniature) {
            this.miniature = miniature;
            return this;
        }

        public EducationEntityBuilder withLevel(EducationLevelEntity level) {
            this.level = level;
            return this;
        }

        public EducationEntityBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public EducationEntityBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public EducationEntityBuilder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public EducationEntityBuilder withAuthor(UserEntity author) {
            this.author = author;
            return this;
        }

        public EducationEntity build() {
            return new EducationEntity(this);
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

    public CompanyEntity getCompany() {
        return company;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public LocalDateTime getDateOut() {
        return dateOut;
    }

    public EducationLevelEntity getLevel() {
        return level;
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
        EducationEntity that = (EducationEntity) o;
        return isActive == that.isActive && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(body, that.body) && Objects.equals(url, that.url) && Objects.equals(cover, that.cover) && Objects.equals(miniature, that.miniature) && Objects.equals(company, that.company) && Objects.equals(dateIn, that.dateIn) && Objects.equals(dateOut, that.dateOut) && Objects.equals(level, that.level) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, url, cover, miniature, company, isActive, dateIn, dateOut, level, createdAt, updatedAt, author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EducationEntity{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", cover='").append(cover).append('\'');
        sb.append(", miniature='").append(miniature).append('\'');
        sb.append(", company=").append(company);
        sb.append(", isActive=").append(isActive);
        sb.append(", dateIn=").append(dateIn);
        sb.append(", dateOut=").append(dateOut);
        sb.append(", level=").append(level);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", author=").append(author);
        sb.append('}');
        return sb.toString();
    }
}