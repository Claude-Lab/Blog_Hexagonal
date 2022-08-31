package fr.lusseau.claude.domain.validator;

import fr.lusseau.claude.domain.model.Company;
import fr.lusseau.claude.domain.exception.ValidatorException;

import java.io.Serializable;

import static java.util.Objects.isNull;


/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator
 * @date 16/08/2022
 */
public class CompanyValidator implements Serializable {

    static String companyNameRequired = "companyNameRequired";

    static String companyPlaceRequired = "companyPlaceRequired";


    public static void validateCompany(final Company company) {

        if ((company.getName().isBlank())) throw new ValidatorException(companyNameRequired);
        if (isNull(company.getName())) throw new ValidatorException(companyNameRequired);
        if ((company.getPlace().isBlank())) throw new ValidatorException(companyPlaceRequired);
        if (isNull(company.getPlace())) throw new ValidatorException(companyPlaceRequired);
    }
}
