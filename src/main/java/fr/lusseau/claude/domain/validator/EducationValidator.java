package fr.lusseau.claude.domain.validator;

import fr.lusseau.claude.domain.model.Education;
import fr.lusseau.claude.domain.exception.ValidatorException;

import java.io.Serializable;

import static java.util.Objects.isNull;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator
 * @date 16/08/2022
 */
public class EducationValidator extends ArticleValidator implements Serializable {

    static String companyRequired = "companyRequired";

    static String dateInRequired = "dateInRequired";

    public static void validateEducationArticle(final Education education) {

        if (isNull(education.getDateIn())) throw new ValidatorException(dateInRequired);
        if (isNull(education.getCompany())) throw new ValidatorException(companyRequired);
    }
}
