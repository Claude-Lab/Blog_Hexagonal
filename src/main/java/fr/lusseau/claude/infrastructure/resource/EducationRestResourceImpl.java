package fr.lusseau.claude.infrastructure.resource;

import fr.lusseau.claude.domain.model.Education;
import fr.lusseau.claude.domain.validator.EducationValidator;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.resource.exception.ResourceException;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.controller
 * @date 13/08/2022
 */
@LogAudited
@Path("/educations")
public class EducationRestResourceImpl {

    private final FactoryService factoryService;

    @ConfigProperty(name = "education.response.error.msg.invalidEducationArticle")
    String invalidEducationArticle;

    @ConfigProperty(name = "article.response.error.msg.articleNotFound")
    String articleNotFound;

    @ConfigProperty(name = "article.response.error.msg.titleExist")
    String titleExist;

    @ConfigProperty(name = "article.response.error.msg.emptyArticleList")
    String emptyArticleList;

    @ConfigProperty(name = "article.response.error.msg.urlExist")
    String urlExist;


    @Inject
    public EducationRestResourceImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Education> getAll() {
        List<Education> educations = factoryService.getUseCaseFactory().getCrudEducationUseCase().getAll();
        if (educations.isEmpty()) {
            throw new ResourceException(emptyArticleList);
        }
        return educations;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Education getOne(@PathParam("id") Long id) {
        Education education = factoryService.getUseCaseFactory().getCrudEducationUseCase().getOne(id);
        if (education == null) {
            throw new ResourceException(articleNotFound);
        }
        return education;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response remove(@PathParam("id") Long id) {
        Education education  = factoryService.getUseCaseFactory().getCrudEducationUseCase().getOne(id);
        try {
            factoryService.getUseCaseFactory().getCrudEducationUseCase().remove(education);
        } catch (IllegalArgumentException e) {
            throw new ResourceException(articleNotFound);
        }
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Education education) {
        Long id = null;
        Education newEducation = Education.builder()
                .withTitle(education.getTitle())
                .withAuthor(education.getAuthor())
                .withCompany(education.getCompany())
                .withDateIn(education.getDateIn())
                .withDateOut(education.getDateOut())
                .withCreatedAt(education.getCreatedAt())
                .withUpdatedAt(education.getUpdatedAt())
                .withLevel(education.getLevel())
                .withBody(education.getBody())
                .withUrl(education.getUrl())
                .withCover(education.getCover())
                .withMiniature(education.getMiniature())
                .withActive(education.isActive())
                .build();
        boolean isTitleExist = factoryService.getUseCaseFactory().getCheckUseCase().checkIfTitleEducationExist(newEducation.getTitle(), id);
        boolean isUrlExist = factoryService.getUseCaseFactory().getCheckUseCase().checkIfUrlEducationExist(newEducation.getUrl(), id);
        try {
            EducationValidator.validateEducationArticle(newEducation);
        } catch (RuntimeException e) {
            throw new ResourceException(invalidEducationArticle);
        }
        if (isTitleExist) {
            throw new ResourceException(titleExist);
        }
        if (isUrlExist) {
            throw new ResourceException(urlExist);
        }
        factoryService.getUseCaseFactory().getCrudEducationUseCase().create(newEducation);
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Transactional
    public Education update(@PathParam("id")Long id) {
        Education education = getOne(id);
        factoryService.getUseCaseFactory().getCrudEducationUseCase().update(education);
        if (education == null) {
            throw new ResourceException(articleNotFound);
        }
        return education;
    }
}