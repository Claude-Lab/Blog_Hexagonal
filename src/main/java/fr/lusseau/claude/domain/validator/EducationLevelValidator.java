package fr.lusseau.claude.domain.validator;

import fr.lusseau.claude.domain.exception.ValidationException;
import fr.lusseau.claude.domain.model.EducationLevel;

import static java.util.Objects.isNull;
import static org.apache.maven.shared.utils.StringUtils.isBlank;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator
 * @date 16/08/2022
 */
public class EducationLevelValidator {

    public static void validateEducationLevel(final EducationLevel educationLevel) {

        if (isNull(educationLevel)) throw new ValidationException("Education article should not be null");
        if (isNull(educationLevel.getName())) throw new ValidationException("Education level name should not be null");
        if (isBlank(educationLevel.getName())) throw new ValidationException("Education level name should not be blank");

    }
}
