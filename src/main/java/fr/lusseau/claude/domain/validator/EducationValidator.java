package fr.lusseau.claude.domain.validator;

import fr.lusseau.claude.domain.exception.ValidationException;
import fr.lusseau.claude.domain.model.Education;

import static java.util.Objects.isNull;
import static org.apache.maven.shared.utils.StringUtils.isBlank;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator
 * @date 16/08/2022
 */
public class EducationValidator {

    public static void validateEducationArticle(final Education education) {

        if (isNull(education)) throw new ValidationException("Education article should not be null");
        if (isNull(education.getLevel())) throw new ValidationException("Education level should not be null");
        if (isNull(education.getDateIn())) throw new ValidationException("Education date in should not be null");
        if (isBlank(education.getUrl())) throw new ValidationException("Education url should not be blank");
        if (isNull(education.getUrl())) throw new ValidationException("Education url should not be null");
        if (isNull(education.getCompany())) throw new ValidationException("Education company should not be null");
        if (isNull(education.getAuthor())) throw new ValidationException("Education author (user) should not be null");
        if (isNull(education.getCreatedAt())) throw new ValidationException("Education creation date should not be null");
        if (isBlank(education.getTitle())) throw new ValidationException("Education title should not be blank");
        if (isNull(education.getTitle())) throw new ValidationException("Education title should not be null");
    }
}
