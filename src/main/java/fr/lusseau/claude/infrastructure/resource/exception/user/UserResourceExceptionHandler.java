package fr.lusseau.claude.infrastructure.resource.exception.user;

import fr.lusseau.claude.infrastructure.resource.exception.ErrorMessage;
import fr.lusseau.claude.infrastructure.resource.exception.ResourceException;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.resource.exception
 * @date 24/08/2022
 */
@Provider
@LogAudited
public class UserResourceExceptionHandler implements ExceptionMapper<ResourceException> {

    @ConfigProperty(name = "user.custom.error.msg.userNotFound")
    String userNotFound;

    @ConfigProperty(name = "user.custom.error.msg.invalidUser")
    String invalidUser;

    @ConfigProperty(name = "user.custom.error.msg.emailExist")
    String emailExist;

    @ConfigProperty(name = "user.custom.error.msg.emptyUserList")
    String emptyUserList;

    @Override
    public Response toResponse(ResourceException e) {
        if (e.getMessage().equalsIgnoreCase(userNotFound)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessage(e.getMessage(), false)).build();
        }
        if (e.getMessage().equalsIgnoreCase(invalidUser)) {
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity(new ErrorMessage(e.getMessage(), false)).build();
        }
        if (e.getMessage().equalsIgnoreCase(emailExist)) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorMessage(e.getMessage(), false)).build();
        }
        if (e.getMessage().equalsIgnoreCase(emptyUserList)) {
            return Response.status(Response.Status.NO_CONTENT)
                    .entity(new ErrorMessage(e.getMessage(), false)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorMessage(e.getMessage(), false)).build();

    }
}
