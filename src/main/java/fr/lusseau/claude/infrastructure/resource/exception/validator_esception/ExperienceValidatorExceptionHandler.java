package fr.lusseau.claude.infrastructure.resource.exception.validator_esception;

import fr.lusseau.claude.domain.exception.ValidatorException;
import fr.lusseau.claude.infrastructure.resource.exception.ValidatorErrorMessage;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator.esception
 * @date 26/08/2022
 */
public class ExperienceValidatorExceptionHandler extends ArticleValidatorExceptionHandler implements ExceptionMapper<ValidatorException>  {


    @ConfigProperty(name = "education.validator.error.msg.companyRequired")
    String companyRequired;

    @ConfigProperty(name = "education.validator.error.msg.dateInRequired")
    String dateInRequired;

    @ConfigProperty(name = "experience.validator.error.msg.jobName")
    String jobName;

    @Override
    public Response toResponse(ValidatorException e) {
        if (e.getMessage().equalsIgnoreCase(createdAtRequired)) {
            return getResponseExperience(e);
        }
        if (e.getMessage().equalsIgnoreCase(authorRequired)) {
            return getResponseExperience(e);
        }
        if (e.getMessage().equalsIgnoreCase(titleRequired)) {
            return getResponseExperience(e);
        }
        if (e.getMessage().equalsIgnoreCase(urlRequired)) {
            return getResponseExperience(e);
        }
        if (e.getMessage().equalsIgnoreCase(companyRequired)) {
            return getResponseExperience(e);
        }
        if (e.getMessage().equalsIgnoreCase(dateInRequired)) {
            return getResponseExperience(e);
        }
        if (e.getMessage().equalsIgnoreCase(jobName)) {
            return getResponseExperience(e);
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ValidatorErrorMessage(e.getMessage(), false)).build();
    }

    private Response getResponseExperience(ValidatorException e) {
        return Response.status(Response.Status.NOT_ACCEPTABLE)
                .entity(new ValidatorErrorMessage(e.getMessage(), false)).build();
    }

}
