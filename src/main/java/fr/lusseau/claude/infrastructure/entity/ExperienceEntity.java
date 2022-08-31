package fr.lusseau.claude.infrastructure.entity;

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
@Table(name = "experience_blog")
@Cacheable
public class ExperienceEntity extends ArticleEntity implements Serializable {

    @Column(name = "experience_job_name")
    private String jobName;
    @Column(name = "experience_company")
    private CompanyEntity company;
    @Column(name = "experience_dateIn")
    private LocalDateTime dateIn;
    @Column(name = "experience_dateOut")
    private LocalDateTime dateOut;

    private ExperienceEntity(Long id, String title, String body, String url, String cover, String miniature, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, UserEntity author, String jobName, CompanyEntity company, LocalDateTime dateIn, LocalDateTime dateOut) {
        super(id, title, body, url, cover, miniature, isActive, createdAt, updatedAt, author);
        this.jobName = jobName;
        this.company = company;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public ExperienceEntity() {
    }

    public ExperienceEntity(ExperienceEntityBuilder builder) {
        super(builder);
        jobName = builder.jobName;
        company = builder.company;
        dateIn = builder.dateIn;
        dateOut = builder.dateOut;
    }

    public static ExperienceEntityBuilder builder() {
        return new ExperienceEntityBuilder();
    }

    public static class ExperienceEntityBuilder extends ArticleEntityBuilder<ExperienceEntityBuilder> {
        private CompanyEntity company;
        private String jobName;
        private LocalDateTime dateIn;
        private LocalDateTime dateOut;

        @Override
        public ExperienceEntityBuilder getThis() {
            return this;
        }

        public ExperienceEntityBuilder withCompany(CompanyEntity company) {
            this.company = company;
            return this;
        }

        public ExperienceEntityBuilder witJobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public ExperienceEntityBuilder withDateIn(LocalDateTime dateIn) {
            this.dateIn = dateIn;
            return this;
        }

        public ExperienceEntityBuilder withDateOut(LocalDateTime dateOut) {
            this.dateOut = dateOut;
            return this;
        }

        public ExperienceEntity build() {
            return new ExperienceEntity(this);
        }
    }


    public String getJobName() {
        return jobName;
    }

    public CompanyEntity getCompany() {
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
        ExperienceEntity that = (ExperienceEntity) o;
        return Objects.equals(jobName, that.jobName) && Objects.equals(company, that.company) && Objects.equals(dateIn, that.dateIn) && Objects.equals(dateOut, that.dateOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), jobName, company, dateIn, dateOut);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExperienceEntity{");
        sb.append(super.toString());
        sb.append("jobName='").append(jobName).append('\'');
        sb.append(", company=").append(company);
        sb.append(", dateIn=").append(dateIn);
        sb.append(", dateOut=").append(dateOut);
        sb.append('}');
        return sb.toString();
    }
}