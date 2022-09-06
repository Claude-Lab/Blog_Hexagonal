package fr.lusseau.claude.infrastructure.entity;

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
@NamedQuery(name = "EducationLevel.findByName", query = "SELECT e FROM EducationLevelEntity e WHERE e.name = :name")
public class EducationLevelEntity extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name is required.")
    @NotBlank(message = "Name is required.")
    @Column(name = "education_level_name")
    private String name;

    protected EducationLevelEntity() {
    }

    public EducationLevelEntity(EducationLevelEntityBuilder builder) {
        id = builder.id;
        name = builder.name;
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
        final StringBuilder sb = new StringBuilder("EducationLevelEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}