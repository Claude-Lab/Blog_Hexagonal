package fr.lusseau.claude.domain.validator;

import fr.lusseau.claude.domain.exception.ValidationException;
import fr.lusseau.claude.domain.model.Experience;

import static java.util.Objects.isNull;
import static org.apache.maven.shared.utils.StringUtils.isBlank;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator
 * @date 16/08/2022
 */
public class ExperienceValidator {

    public static void validateExperienceArticle(final Experience experience) {

        if (isNull(experience)) throw new ValidationException("Experience article should not be null");
        if (isNull(experience.getJobName())) throw new ValidationException("Experience JobName should not be null");
        if (isBlank(experience.getJobName())) throw new ValidationException("Experience JobName should not be blank");
        if (isNull(experience.getDateIn())) throw new ValidationException("Experience date in should not be null");
        if (isBlank(experience.getUrl())) throw new ValidationException("Experience url should not be blank");
        if (isNull(experience.getUrl())) throw new ValidationException("Experience url should not be null");
        if (isNull(experience.getCompany())) throw new ValidationException("Experience company should not be null");
        if (isNull(experience.getAuthor())) throw new ValidationException("Experience author (user) should not be null");
        if (isNull(experience.getCreatedAt())) throw new ValidationException("Experience creation date should not be null");
        if (isBlank(experience.getTitle())) throw new ValidationException("Experience title should not be blank");
        if (isNull(experience.getTitle())) throw new ValidationException("Experience title should not be null");
    }
}
