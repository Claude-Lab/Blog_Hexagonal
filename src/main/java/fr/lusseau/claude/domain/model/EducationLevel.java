package fr.lusseau.claude.domain.model;

import java.util.Objects;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.model
 * @date 10/08/2022
 */
public class EducationLevel {

    private final Long id;
    private final String name;

    public EducationLevel(EducationLevelBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
    }

    public static EducationLevelBuilder builder() {
        return new EducationLevelBuilder();
    }

    public static class EducationLevelBuilder {
        private Long id;
        private String name;

        public EducationLevelBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EducationLevelBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public EducationLevel build() {
            return new EducationLevel(this);
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
        EducationLevel that = (EducationLevel) o;
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
