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
@Table(name = "education_level_blog")
public class EducationLevelEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    @Column(name = "education_level_name")
    private final String name;

    public EducationLevelEntity(EducationLevelEntityBuilder builder) {
        if (builder.id == null) {
            throw new EntityException("Id cannot be null");
        }
        if (builder.name == null) {
            throw new EntityException("Name cannot be null");
        }
        this.id = builder.id;
        this.name = builder.name;
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
        final StringBuilder sb = new StringBuilder("EducationLevel{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
