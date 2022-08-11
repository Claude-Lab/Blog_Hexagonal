package fr.lusseau.claude.application.entity;

import fr.lusseau.claude.application.exception.EntityException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.model
 * @date 10/08/2022
 */
@Entity
@Table(name = "company_blog")
public class CompanyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    @Column(name = "company_name")
    private final String name;
    @Column(name = "company_place")
    private final String place;
    @Column(name = "company_type")
    private final String type;
    @Column(name = "company_url")
    private final String url;

    public CompanyEntity(CompanyEntityBuilder builder) {
        if (builder.id == null) {
            throw new EntityException("Id cannot be null");
        }
        if (builder.name == null) {
            throw new EntityException("Name cannot be null");
        }
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.url = builder.url;
        this.place = builder.place;
    }

    public CompanyEntityBuilder builder() {
        return new CompanyEntityBuilder();
    }

    public static class CompanyEntityBuilder {
        private Long id;
        private String name;
        private String type;
        private String url;
        private String place;

        public CompanyEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CompanyEntityBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CompanyEntityBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public CompanyEntityBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public CompanyEntityBuilder withPlace(String place) {
            this.place = place;
            return this;
        }

        public CompanyEntity build() {
            return new CompanyEntity(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getPlace() {
        return place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity company = (CompanyEntity) o;
        return Objects.equals(id, company.id) && Objects.equals(name, company.name) && Objects.equals(place, company.place) && Objects.equals(type, company.type) && Objects.equals(url, company.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, place, type, url);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", place='").append(place).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
