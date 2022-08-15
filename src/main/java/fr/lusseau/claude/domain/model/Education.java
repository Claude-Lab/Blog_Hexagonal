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
public class Education extends Article implements Serializable {

    private final Company company;
    private final LocalDateTime dateIn;
    private final LocalDateTime dateOut;
    private final EducationLevel level;

    public Education(EducationBuilder builder) {
        super(builder);
        company = builder.company;
        dateIn = builder.dateIn;
        dateOut = builder.dateOut;
        level = builder.level;
    }

    public static EducationBuilder builder() {
        return new EducationBuilder();
    }

    public static class EducationBuilder extends Article.ArticleBuilder<EducationBuilder> {

        private Company company;
        private LocalDateTime dateIn;
        private LocalDateTime dateOut;
        private EducationLevel level;

        @Override
        public EducationBuilder getThis() {
            return this;
        }

        public EducationBuilder withCompany(Company company) {
            this.company = company;
            return this;
        }

        public EducationBuilder withDateIn(LocalDateTime dateIn) {
            this.dateIn = dateIn;
            return this;
        }

        public EducationBuilder withDateOut(LocalDateTime dateOut) {
            this.dateOut = dateOut;
            return this;
        }

        public EducationBuilder withLevel(EducationLevel level) {
            this.level = level;
            return this;
        }

        @Override
        public Education build() {
            return new Education(this);
        }
    }

    public Company getCompany() {
        return company;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public LocalDateTime getDateOut() {
        return dateOut;
    }


    public EducationLevel getLevel() {
        return level;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Education education = (Education) o;
        return Objects.equals(company, education.company) && Objects.equals(dateIn, education.dateIn) && Objects.equals(dateOut, education.dateOut) && Objects.equals(level, education.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, dateIn, dateOut, level);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Education{");
        sb.append(super.toString());
        sb.append("company=").append(company);
        sb.append(", dateIn=").append(dateIn);
        sb.append(", dateOut=").append(dateOut);
        sb.append(", level=").append(level);
        sb.append('}');
        return sb.toString();
    }
}
