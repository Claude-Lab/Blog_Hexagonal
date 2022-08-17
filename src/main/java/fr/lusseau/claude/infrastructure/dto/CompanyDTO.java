package fr.lusseau.claude.infrastructure.dto;

import fr.lusseau.claude.infrastructure.dto.exception.EntityException;

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
public class CompanyDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required.")
    @NotNull(message = "Name is required.")
    @Column(name = "company_name")
    private String name;
    @Column(name = "company_place")
    private String place;
    @Column(name = "company_type")
    private String type;
    @NotBlank(message = "Url is required.")
    @NotNull(message = "Url is required.")
    @Column(name = "company_url")
    private String url;

    protected CompanyDTO() {
    }

    private CompanyDTO(Long id, String name, String place, String type, String url) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.type = type;
        this.url = url;
    }

    public CompanyDTO(CompanyEntityBuilder builder) {
        if (builder.id == null) {
            throw new EntityException("Id is required.");
        }
        if (builder.name == null) {
            throw new EntityException("Name is required.");
        }
        if (!builder.name.contains(" ")) {
            throw new EntityException("Name is required.");
        }
        if (builder.url == null) {
            throw new EntityException("Url is required.");
        }
        id = builder.id;
        name =  builder.name;
        place =  builder.place;
        type =  builder.type;
        url =  builder.url;
    }

    public static CompanyEntityBuilder builder() {
        return new CompanyEntityBuilder();
    }

    public static class CompanyEntityBuilder {
        private Long id;
        private String name;
        private String place;
        private String type;
        private String url;

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
        public CompanyEntityBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public CompanyDTO build() {
            return new CompanyDTO(this);
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

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDTO that = (CompanyDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(place, that.place) && Objects.equals(type, that.type) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, place, type, url);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CompanyEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", place='").append(place).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}