package fr.lusseau.claude.infrastructure.resource.exception.validator_esception;

import fr.lusseau.claude.domain.exception.ValidatorException;
import fr.lusseau.claude.infrastructure.resource.exception.ErrorMessage;
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
 * @date 25/08/2022
 */
@Provider
@LogAudited
public class EducationLevelValidatorExceptionHandler implements ExceptionMapper<ValidatorException> {

    @ConfigProperty(name = "educationLevel.response.error.msg.invalidEducationLevel")
    String invalidEducationLevel;

    @ConfigProperty(name = "educationLevel.response.error.msg.nameExist")
    String nameExist;

    @ConfigProperty(name = "educationLevel.response.error.msg.educationLevelNotFound")
    String educationLevelNotFound;

    @ConfigProperty(name = "educationLevel.response.error.msg.emptyEducationLevelList")
    String emptyEducationLevelList;


    @Override
    public Response toResponse(ValidatorException e) {
        if (e.getMessage().equalsIgnoreCase(educationLevelNotFound)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessage(e.getMessage(), false)).build();
        }
        if (e.getMessage().equalsIgnoreCase(invalidEducationLevel)) {
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity(new ErrorMessage(e.getMessage(), false)).build();
        }
        if (e.getMessage().equalsIgnoreCase(nameExist)) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorMessage(e.getMessage(), false)).build();
        }
        if (e.getMessage().equalsIgnoreCase(emptyEducationLevelList)) {
            return Response.status(Response.Status.NO_CONTENT)
                    .entity(new ErrorMessage(e.getMessage(), false)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ValidatorErrorMessage(e.getMessage(), false)).build();

    }

    private Response getResponse(ValidatorException e) {
        return Response.status(Response.Status.NOT_ACCEPTABLE)
                .entity(new ValidatorErrorMessage(e.getMessage(), false)).build();
    }
}
