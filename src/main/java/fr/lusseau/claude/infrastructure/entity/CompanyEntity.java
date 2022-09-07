package fr.lusseau.claude.infrastructure.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@Cacheable
@NamedQuery(name = "Company.isNameExist", query = "SELECT c FROM CompanyEntity c WHERE name = :name")
public class CompanyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_name")
    @NotNull(message = "Name is required.")
    @NotBlank(message = "Name is required.")
    private String name;
    @Column(name = "company_place")
    private String place;
    @Column(name = "company_type")
    private String type;

    protected CompanyEntity() {
    }

    public CompanyEntity(CompanyEntityBuilder builder) {
        id = builder.id;
        name = builder.name;
        place = builder.place;
        type = builder.type;
    }

    public static CompanyEntityBuilder builder() {
        return new CompanyEntityBuilder();
    }

    public static class CompanyEntityBuilder {
        private Long id;
        private String name;
        private String place;
        private String type;

        public CompanyEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CompanyEntityBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CompanyEntityBuilder withPlace(String place) {
            this.place = place;
            return this;
        }

        public CompanyEntityBuilder withType(String type) {
            this.type = type;
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
        CompanyEntity that = (CompanyEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(place, that.place) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, place, type);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("fr.lusseau.claude.infrastructure.dto.CompanyDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", place='").append(place).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}