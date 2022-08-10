package fr.lusseau.claude.application.entity;

import fr.lusseau.claude.domain.exception.DomainModelException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.entity
 * @date 06/08/2022
 */
@Entity
@Table(name = "user_blog")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    @Column(name = "user_email")
    private final String email;
    @Column(name = "user_password")
    private final String password;
    @Column(name = "user_firstName")
    private final String firstName;
    @Column(name = "user_lastName")
    private final String lastName;
    @Column(name = "user_role")
    private final RoleEntity role;
    @OneToMany(targetEntity = ArticleEntity.class, mappedBy = "author")
    private final List<ArticleEntity> articles;
    @OneToMany(targetEntity = PortfolioEntity.class, mappedBy = "author")
    private final List<PortfolioEntity> portfolios;
    @OneToMany(targetEntity = EducationEntity.class, mappedBy = "author")
    private final List<EducationEntity> educations;
    @OneToMany(targetEntity = ExperienceEntity.class, mappedBy = "author")
    private final List<ExperienceEntity> experiences;

    public UserEntity(UserBuilder builder) {
        if (builder.id < 0) {
            throw new DomainModelException("Id cannot be null");
        }
        if (builder.email == null) {
            throw new DomainModelException("Email cannot be null");
        }
        if (builder.password == null) {
            throw new DomainModelException("Password cannot be null");
        }
        if (builder.role == null) {
            throw new DomainModelException("Role cannot be null");
        }
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.role = builder.role;
        this.articles = builder.articles;
        this.portfolios = builder.portfolios;
        this.educations = builder.educations;
        this.experiences = builder.experiences;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private long id;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private RoleEntity role;
        private List<ArticleEntity> articles;
        private List<PortfolioEntity> portfolios;
        private List<EducationEntity> educations;
        private List<ExperienceEntity> experiences;

        public UserBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withRole(RoleEntity role) {
            this.role = role;
            return this;
        }

        public UserBuilder withArticles(List<ArticleEntity> articles) {
            this.articles = articles;
            return this;
        }

        public UserBuilder withPortfolios(List<PortfolioEntity> portfolios) {
            this.portfolios = portfolios;
            return this;
        }

        public UserBuilder withEducations(List<EducationEntity> educations) {
            this.educations = educations;
            return this;
        }

        public UserBuilder withExperiences(List<ExperienceEntity> experiences) {
            this.experiences = experiences;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }

    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public RoleEntity getRole() {
        return role;
    }

    public List<ArticleEntity> getArticles() {
        return articles;
    }

    public List<PortfolioEntity> getPortfolios() {
        return portfolios;
    }

    public List<EducationEntity> getEducations() {
        return educations;
    }

    public List<ExperienceEntity> getExperiences() {
        return experiences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity user = (UserEntity) o;
        return id == user.id && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(role, user.role) && Objects.equals(articles, user.articles) && Objects.equals(portfolios, user.portfolios) && Objects.equals(educations, user.educations) && Objects.equals(experiences, user.experiences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, lastName, role, articles, portfolios, educations, experiences);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserEntity{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", role=").append(role);
        sb.append(", articles=").append(articles);
        sb.append(", portfolios=").append(portfolios);
        sb.append(", educations=").append(educations);
        sb.append(", experiences=").append(experiences);
        sb.append('}');
        return sb.toString();
    }
}
