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
public class Experience extends Article implements Serializable {

    private final String jobName;
    private final Company company;
    private final LocalDateTime dateIn;
    private final LocalDateTime dateOut;

    public Experience(ExperienceBuilder builder) {
        super(builder);
        jobName = builder.jobName;
        company = builder.company;
        dateIn = builder.dateIn;
        dateOut = builder.dateOut;
    }

    public static ExperienceBuilder builder() {
        return new ExperienceBuilder();
    }

    public static class ExperienceBuilder extends Article.ArticleBuilder<ExperienceBuilder>{
        private Company company;
        private String jobName;
        private LocalDateTime dateIn;
        private LocalDateTime dateOut;

        @Override
        public ExperienceBuilder getThis() {
            return this;
        }

        public ExperienceBuilder withCompany(Company company) {
            this.company = company;
            return this;
        }

        public ExperienceBuilder witJobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public ExperienceBuilder withDateIn(LocalDateTime dateIn) {
            this.dateIn = dateIn;
            return this;
        }

        public ExperienceBuilder withDateOut(LocalDateTime dateOut) {
            this.dateOut = dateOut;
            return this;
        }
        @Override
        public Experience build() {
            return new Experience(this);
        }
    }


    public String getJobName() {
        return jobName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Experience that = (Experience) o;
        return Objects.equals(jobName, that.jobName) && Objects.equals(company, that.company) && Objects.equals(dateIn, that.dateIn) && Objects.equals(dateOut, that.dateOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), jobName, company, dateIn, dateOut);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Experience{");
        sb.append(super.toString());
        sb.append("jobName='").append(jobName).append('\'');
        sb.append(", company=").append(company);
        sb.append(", dateIn=").append(dateIn);
        sb.append(", dateOut=").append(dateOut);
        sb.append('}');
        return sb.toString();
    }
}
