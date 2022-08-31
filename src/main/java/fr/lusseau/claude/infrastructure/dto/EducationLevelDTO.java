package fr.lusseau.claude.infrastructure.dto;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

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
@Table(name = "education_level_blog")
@Cacheable
public class EducationLevelDTO extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name is required.")
    @NotBlank(message = "Name is required.")
    @Column(name = "education_level_name")
    private String name;

    public EducationLevelDTO(EducationLevelEntityBuilder builder) {
        id = builder.id;
        name = builder.name;
    }

    protected EducationLevelDTO() {
    }

    private EducationLevelDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static EducationLevelEntityBuilder builder() {
        return new EducationLevelEntityBuilder();
    }

    public static class EducationLevelEntityBuilder {
        private Long id;
        private String name;

        public EducationLevelEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EducationLevelEntityBuilder withName(String name) {
            this.name = name;
            return this;
        }
        public EducationLevelDTO build() {
            return new EducationLevelDTO(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationLevelDTO that = (EducationLevelDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EducationLevelEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}