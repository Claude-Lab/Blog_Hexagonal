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
 * @date 25/08/2022
 */
@Provider
@LogAudited
public class UserValidatorExceptionHandler implements ExceptionMapper<ValidatorException> {

    @ConfigProperty(name = "user.validator.error.msg.emailRequired")
    String emailRequired;

    @ConfigProperty(name = "user.validator.error.msg.firstnameRequired")
    String firstnameRequired;

    @ConfigProperty(name = "user.validator.error.msg.lastnameRequired")
    String lastnameRequired;

    @ConfigProperty(name = "user.validator.error.msg.roleRequired")
    String roleRequired;

    @ConfigProperty(name = "user.validator.error.msg.passwordRequired")
    String passwordRequired;

    @Override
    public Response toResponse(ValidatorException e) {
        if (e.getMessage().equalsIgnoreCase(emailRequired)) {
            return getResponse(e);
        }
        if (e.getMessage().equalsIgnoreCase(firstnameRequired)) {
            return getResponse(e);
        }
        if (e.getMessage().equalsIgnoreCase(lastnameRequired)) {
            return getResponse(e);
        }
        if (e.getMessage().equalsIgnoreCase(roleRequired)) {
            return getResponse(e);
        }
        if (e.getMessage().equalsIgnoreCase(passwordRequired)) {
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
