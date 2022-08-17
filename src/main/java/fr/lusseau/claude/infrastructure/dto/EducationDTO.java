package fr.lusseau.claude.infrastructure.dto;

import fr.lusseau.claude.infrastructure.dto.exception.EntityException;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
public class EducationDTO extends ArticleDTO implements Serializable {

    @Column(name = "education_company")
    private CompanyDTO company;
    @NotNull(message = "Date in is required.")
    @Column(name = "education_dateIn")
    private LocalDateTime dateIn;
    @Column(name = "education_dateOut")
    private LocalDateTime dateOut;
    @Column(name = "education_level")
    private EducationLevelDTO level;

    private EducationDTO(Long id, String title, String body, String url, String cover, String miniature, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, UserDTO author, CompanyDTO company, LocalDateTime dateIn, LocalDateTime dateOut, EducationLevelDTO level) {
        super(id, title, body, url, cover, miniature, isActive, createdAt, updatedAt, author);
        this.company = company;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.level = level;
    }

    public EducationDTO() {
    }

    public EducationDTO(EducationEntityBuilder builder) {
        super(builder);
        company = builder.company;
        dateIn = builder.dateIn;
        dateOut = builder.dateOut;
        level = builder.level;
    }

    public static EducationEntityBuilder builder() {
        return new EducationEntityBuilder();
    }

    public static class EducationEntityBuilder extends ArticleEntityBuilder<EducationEntityBuilder> {
        private CompanyDTO company;
        private LocalDateTime dateIn;
        private LocalDateTime dateOut;
        private EducationLevelDTO level;

        @Override
        public EducationEntityBuilder getThis() {
            return this;
        }

        public EducationEntityBuilder withCompany(CompanyDTO company) {
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

        public EducationEntityBuilder withLevel(EducationLevelDTO level) {
            this.level = level;
            return this;
        }

        public EducationDTO build() {
            return new EducationDTO(this);
        }
    }


    public CompanyDTO getCompany() {
        return company;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public LocalDateTime getDateOut() {
        return dateOut;
    }

    public EducationLevelDTO getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EducationDTO that = (EducationDTO) o;
        return Objects.equals(company, that.company) && Objects.equals(dateIn, that.dateIn) && Objects.equals(dateOut, that.dateOut) && Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, dateIn, dateOut, level);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EducationEntity{");
        sb.append(super.toString());
        sb.append("company=").append(company);
        sb.append(", dateIn=").append(dateIn);
        sb.append(", dateOut=").append(dateOut);
        sb.append(", level=").append(level);
        sb.append('}');
        return sb.toString();
    }
}