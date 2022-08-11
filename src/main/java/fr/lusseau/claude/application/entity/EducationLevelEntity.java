package fr.lusseau.claude.application.entity;

import fr.lusseau.claude.application.exception.EntityException;

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
public class EducationLevelEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name is required.")
    @NotBlank(message = "Name is required.")
    @Column(name = "education_level_name")
    private String name;

    public EducationLevelEntity(EducationLevelEntityBuilder builder) {
        if (builder.id == null) {
            throw new EntityException("Id is required.");
        }
        if (builder.name == null) {
            throw new EntityException("Name is required.");
        }
        if (!builder.name.contains(" ")) {
            throw new EntityException("Name is required.");
        }
        id = builder.id;
        name = builder.name;
    }

    protected EducationLevelEntity() {
    }

    private EducationLevelEntity(Long id, String name) {
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

        public EducationLevelEntityBuilder withTitle(String name) {
            this.name = name;
            return this;
        }
        public EducationLevelEntity build() {
            return new EducationLevelEntity(this);
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
        EducationLevelEntity that = (EducationLevelEntity) o;
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