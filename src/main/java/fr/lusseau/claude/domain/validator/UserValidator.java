package fr.lusseau.claude.domain.validator;

import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.domain.exception.ValidatorException;

import java.io.Serializable;

import static java.util.Objects.isNull;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator
 * @date 16/08/2022
 */
public class UserValidator implements Serializable {

    static String emailRequired = "emailRequired";

    static String firstnameRequired = "firstnameRequired";

    static String lastnameRequired = "lastnameRequired";

    static String roleRequired = "roleRequired";

    static String passwordRequired = "passwordRequired";

    protected UserValidator() {
    }

    public static void validateUser(final User user) {

        if (isNull(user.getEmail())) throw new ValidatorException(emailRequired);
        if ((user.getEmail().isBlank())) throw new ValidatorException(emailRequired);
        if (isNull(user.getFirstName())) throw new ValidatorException(firstnameRequired);
        if ((user.getFirstName().isBlank())) throw new ValidatorException(firstnameRequired);
        if (isNull(user.getLastName())) throw new ValidatorException(lastnameRequired);
        if ((user.getLastName().isBlank()))throw new ValidatorException(lastnameRequired);
        if (isNull(user.getRole())) throw new ValidatorException(roleRequired);
        if (isNull(user.getPassword())) throw new ValidatorException(passwordRequired);
        if ((user.getPassword().isBlank())) throw new ValidatorException(passwordRequired);
    }
}
