package fr.lusseau.claude.domain.model;

import io.smallrye.common.constraint.NotNull;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.entity
 * @date 06/08/2022
 */
public class Role implements Serializable {

    @NotNull
    private final long id;
    @NotNull
    @NotBlank
    private final String name;

    public Role(RoleBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;

    }

    public static RoleBuilder builder(){
        return new RoleBuilder();
    }

    public static class RoleBuilder {
        private long id;
        private String name;

        public RoleBuilder withId(long id){
            this.id = id;
            return this;
        }

        public RoleBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
