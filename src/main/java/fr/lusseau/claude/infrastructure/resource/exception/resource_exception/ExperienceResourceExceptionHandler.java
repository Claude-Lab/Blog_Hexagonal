package fr.lusseau.claude.infrastructure.resource.exception.resource_exception;

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
public class ExperienceResourceExceptionHandler extends ArticleResourceExceptionHandler implements ExceptionMapper<ResourceException> {

    @ConfigProperty(name = "experience.response.error.msg.invalidExperienceArticle")
    String invalidExperienceArticle;

    @ConfigProperty(name = "experience.response.error.msg.nameExist")
    String nameExist;


    @Override
    public Response toResponse(ResourceException e) {
        if (e.getMessage().equalsIgnoreCase(invalidExperienceArticle)) {
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity(new ErrorMessage(e.getMessage(), false)).build();
        }
        if (e.getMessage().equalsIgnoreCase(nameExist)) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorMessage(e.getMessage(), false)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorMessage(e.getMessage(), false)).build();

    }
}
