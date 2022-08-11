package fr.lusseau.claude.domain.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.model
 * @date 10/08/2022
 */
public class Company implements Serializable {

    private final Long id;
    private final String name;
    private final String place;
    private final String type;
    private final String url;

    public Company(CompanyBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.url = builder.url;
        this.place = builder.place;
    }

    public CompanyBuilder builder() {
        return new CompanyBuilder();
    }

    public static class CompanyBuilder {
        private Long id;
        private String name;
        private String type;
        private String url;
        private String place;

        public CompanyBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CompanyBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CompanyBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public CompanyBuilder withUrl( String url) {
            this.url = url;
            return this;
        }

        public CompanyBuilder withPlace(String place) {
            this.place = place;
            return this;
        }

        public Company build() {
            return new Company(this);
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
        Company company = (Company) o;
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
