package fr.lusseau.claude.domain.validator;

import fr.lusseau.claude.domain.exception.ValidationException;
import fr.lusseau.claude.domain.model.Company;

import static org.apache.maven.shared.utils.StringUtils.isBlank;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator
 * @date 16/08/2022
 */
public class CompanyValidator {

    public static void validateCompany(final Company company) {
        if (company == null) throw new ValidationException("Company should not be null");
        if (isBlank(company.getName())) throw new ValidationException("Name should not be null");
        if (isBlank(company.getPlace())) throw new ValidationException("Place should not be null");
        if (isBlank(company.getName())) throw new ValidationException("Name should not be null");
    }
}
