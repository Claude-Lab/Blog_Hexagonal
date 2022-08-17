package fr.lusseau.claude.infrastructure.dto;

import fr.lusseau.claude.domain.model.Role;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.entity
 * @date 06/08/2022
 */
@Entity
@Table(name = "user_blog")
@Cacheable
@NamedQuery(name = "User.findAll", query = "SELECT u FROM UserDTO u")
@NamedQuery(name = "User.delete", query = "DELETE FROM UserDTO u WHERE u.id = :id")
public class UserDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Email is required.")
    @NotBlank(message = "Email is required.")
    @Column(name = "user_email", unique = true, nullable = false)
    private String email;
    @NotNull(message = "Password is required.")
    @NotBlank(message = "Password is required.")
    @Column(name = "user_password", nullable = false)
    private String password;
    @NotNull(message = "Firstname is required.")
    @NotBlank(message = "Firstname is required.")
    @Column(name = "user_firstName", nullable = false)
    private String firstName;
    @NotNull(message = "Lastname is required.")
    @NotBlank(message = "Lastname is required.")
    @Column(name = "user_lastName", nullable = false)
    private String lastName;
    @NotNull(message = "Role is required.")
    @Column(name = "user_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    protected UserDTO() {
    }

    private UserDTO(Long id, String email, String password, String firstName, String lastName, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public UserDTO(UserEntityBuilder builder) {
        id = builder.id;
        email = builder.email;
        password = builder.password;
        firstName = builder.firstName;
        lastName = builder.lastName;
        role = builder.role;
    }

    public static UserEntityBuilder builder() {
        return new UserEntityBuilder();
    }

    public static class UserEntityBuilder {
        private Long id;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private Role role;

        public UserEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserEntityBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserEntityBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserEntityBuilder withFirstname(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserEntityBuilder withLastname(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserEntityBuilder withRole(Role role) {
            this.role = role;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO that = (UserDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, lastName, role);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserEntity{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}