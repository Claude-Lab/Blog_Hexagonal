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

    private Long id;
    private String name;
    private String place;
    private String type;

    public Company(CompanyBuilder builder) {
        id = builder.id;
        name = builder.name;
        place = builder.place;
        type = builder.type;
    }

    protected Company() {
    }

    public static CompanyBuilder builder() {
        return new CompanyBuilder();
    }

    public static class CompanyBuilder {
        private Long id;
        private String name;
        private String place;
        private String type;

        public CompanyBuilder withId(Long id) {
            this.id = id;
            return this;
        }
        public CompanyBuilder withName(String name) {
            this.name = name;
            return this;
        }
        public CompanyBuilder withPlace(String place) {
            this.place = place;
            return this;
        }
        public CompanyBuilder withType(String type) {
            this.type = type;
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

    public String getPlace() {
        return place;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) && Objects.equals(name, company.name) && Objects.equals(place, company.place) && Objects.equals(type, company.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, place, type);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("fr.lusseau.claude.domain.model.Company{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", place='").append(place).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}