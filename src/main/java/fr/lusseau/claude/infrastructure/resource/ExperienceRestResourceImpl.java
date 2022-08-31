package fr.lusseau.claude.infrastructure.resource;

import fr.lusseau.claude.domain.model.Experience;
import fr.lusseau.claude.domain.validator.ExperienceValidator;
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
@Path("/experiences")
public class ExperienceRestResourceImpl {

    private final FactoryService factoryService;

    @ConfigProperty(name = "article.response.error.msg.articleNotFound")
    String articleNotFound;

    @ConfigProperty(name = "experience.response.error.msg.invalidExperienceArticle")
    String invalidExperienceArticle;

    @ConfigProperty(name = "article.response.error.msg.emptyArticleList")
    String emptyArticleList;

    @ConfigProperty(name = "article.response.error.msg.titleExist")
    String titleExist;

    @ConfigProperty(name = "article.response.error.msg.urlExist")
    String urlExist;

    @Inject
    public ExperienceRestResourceImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Experience> getAllExperience() {
        List<Experience> experiences = this.factoryService.getUseCaseFactory().getCrudExperienceUseCase().getAll();
        if (experiences.isEmpty()) {
            throw new ResourceException(emptyArticleList);
        }
        return experiences;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Experience getOneExperience(@PathParam("id") Long id) {
        Experience experience = this.factoryService.getUseCaseFactory().getCrudExperienceUseCase().getOne(id);
        if (experience == null) {
            throw new ResourceException(articleNotFound);
        }
        return experience;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response removeExperience(@PathParam("id") Long id) {
        Experience experience = this.factoryService.getUseCaseFactory().getCrudExperienceUseCase().getOne(id);
        try {
            this.factoryService.getUseCaseFactory().getCrudExperienceUseCase().remove(experience);
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
    public Response createNewExperience(Experience experience) {
        Experience newExperience = Experience.builder()
                .withTitle(experience.getTitle())
                .withAuthor(experience.getAuthor())
                .withCompany(experience.getCompany())
                .withDateIn(experience.getDateIn())
                .withDateOut(experience.getDateOut())
                .withCreatedAt(experience.getCreatedAt())
                .witJobName(experience.getJobName())
                .withBody(experience.getBody())
                .withUrl(experience.getUrl())
                .withCover(experience.getCover())
                .withMiniature(experience.getMiniature())
                .withActive(experience.isActive())
                .build();
        boolean isTitleExist = this.factoryService.getUseCaseFactory().getCheckUseCase().checkIfTitleExperienceExist(experience.getTitle());
        boolean isUrlExist = this.factoryService.getUseCaseFactory().getCheckUseCase().checkIfUrlEducationExist(experience.getUrl());
        try {
            ExperienceValidator.validateExperienceArticle(newExperience);
        } catch (RuntimeException e) {
            throw new ResourceException(invalidExperienceArticle);
        }
        if (isTitleExist) {
            throw new ResourceException(titleExist);
        }
        if (isUrlExist) {
            throw new ResourceException(urlExist);
        }
        this.factoryService.getUseCaseFactory().getCrudExperienceUseCase().create(experience);
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    @Transactional
    public Response updateExperience(Experience experience) {
        if (getOneExperience(experience.getId()) == null) {
            throw new ResourceException(articleNotFound);
        }
        try {
            this.factoryService.getUseCaseFactory().getCrudExperienceUseCase().update(experience);
         }catch (RuntimeException e) {
            throw new ResourceException(invalidExperienceArticle);
        }
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }
}