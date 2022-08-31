package fr.lusseau.claude.infrastructure.resource.exception.validator_esception;

import fr.lusseau.claude.domain.exception.ValidatorException;
import fr.lusseau.claude.infrastructure.resource.exception.ValidatorErrorMessage;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator.esception
 * @date 26/08/2022
 */
@Provider
@LogAudited
public class CompanyValidatorExceptionHandler implements ExceptionMapper<ValidatorException>  {


    @ConfigProperty(name = "company.validator.error.msg.companyNameRequired")
    String companyNameRequired;

    @ConfigProperty(name = "company.validator.error.msg.companyPlaceRequired")
    String companyPlaceRequired;


    @Override
    public Response toResponse(ValidatorException e) {
        if (e.getMessage().equalsIgnoreCase(companyNameRequired)) {
            return getResponse(e);
        }
        if (e.getMessage().equalsIgnoreCase(companyPlaceRequired)) {
            return getResponse(e);
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ValidatorErrorMessage(e.getMessage(), false)).build();
    }

    private Response getResponse(ValidatorException e) {
        return Response.status(Response.Status.NOT_ACCEPTABLE)
                .entity(new ValidatorErrorMessage(e.getMessage(), false)).build();
    }
}
