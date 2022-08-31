package fr.lusseau.claude.domain.validator;

import fr.lusseau.claude.domain.model.Experience;
import fr.lusseau.claude.domain.exception.ValidatorException;

import java.io.Serializable;

import static java.util.Objects.isNull;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator
 * @date 16/08/2022
 */
public class ExperienceValidator extends ArticleValidator implements Serializable {

    static String companyRequired = "companyRequired";

    static String dateInRequired = "dateInRequired";

    static String jobName = "jobName";

    public static void validateExperienceArticle(final Experience experience) {

        if (isNull(experience.getJobName())) throw new ValidatorException(companyRequired);
        if (isNull(experience.getDateIn())) throw new ValidatorException(dateInRequired);
        if ((experience.getUrl().isBlank())) throw new ValidatorException(dateInRequired);
        if (isNull(experience.getUrl())) throw new ValidatorException(dateInRequired);
        if ((experience.getJobName().isBlank())) throw new ValidatorException(jobName);
        if (isNull(experience.getJobName())) throw new ValidatorException(jobName);
    }
}
