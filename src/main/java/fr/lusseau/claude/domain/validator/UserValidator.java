package fr.lusseau.claude.domain.validator;

import fr.lusseau.claude.domain.exception.ValidationException;
import fr.lusseau.claude.domain.model.User;

import static java.util.Objects.isNull;
import static org.apache.maven.shared.utils.StringUtils.isBlank;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator
 * @date 16/08/2022
 */
public class UserValidator {

    protected UserValidator() {
    }

    public static void validateUser(final User user) {

        if (isNull(user)) throw new ValidationException("User should not be null");
        if (isNull(user.getEmail())) throw new ValidationException("User email should not be null");
        if (isBlank(user.getEmail())) throw new ValidationException("User email should not be blank");
        if (isNull(user.getFirstName())) throw new ValidationException("User firstname in should not be null");
        if (isBlank(user.getFirstName())) throw new ValidationException("User firstname should not be blank");
        if (isNull(user.getLastName())) throw new ValidationException("User lastname should not be null");
        if (isBlank(user.getLastName())) throw new ValidationException("User lastname should not be null");
        if (isNull(user.getRole())) throw new ValidationException("User role should not be null");
        if (isNull(user.getPassword())) throw new ValidationException("User password date should not be null");
        if (isBlank(user.getPassword())) throw new ValidationException("User password should not be blank");
    }
}
