package fr.lusseau.claude.domain.validator;

import fr.lusseau.claude.domain.model.EducationLevel;
import fr.lusseau.claude.domain.exception.ValidatorException;

import java.io.Serializable;

import static java.util.Objects.isNull;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator
 * @date 16/08/2022
 */
public class EducationLevelValidator implements Serializable {

    static String nameRequired = "nameRequired";

    public static void validateEducationLevel(final EducationLevel educationLevel) {

        if (isNull(educationLevel.getName())) throw new ValidatorException(nameRequired);
        if ((educationLevel.getName().isBlank())) throw new ValidatorException(nameRequired);

    }
}
