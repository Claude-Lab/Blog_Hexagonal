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
public class ArticleValidatorExceptionHandler implements ExceptionMapper<ValidatorException>  {


    @ConfigProperty(name = "article.validator.error.msg.authorRequired")
    String authorRequired;

    @ConfigProperty(name = "article.validator.error.msg.urlRequired")
    String urlRequired;

    @ConfigProperty(name = "article.validator.error.msg.titleRequired")
    String titleRequired;

    @ConfigProperty(name = "article.validator.error.msg.createdAtRequired")
    String createdAtRequired;

    @Override
    public Response toResponse(ValidatorException e) {
        if (e.getMessage().equalsIgnoreCase(createdAtRequired)) {
            return getResponse(e);
        }
        if (e.getMessage().equalsIgnoreCase(authorRequired)) {
            return getResponse(e);
        }
        if (e.getMessage().equalsIgnoreCase(titleRequired)) {
            return getResponse(e);
        }
        if (e.getMessage().equalsIgnoreCase(urlRequired)) {
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
