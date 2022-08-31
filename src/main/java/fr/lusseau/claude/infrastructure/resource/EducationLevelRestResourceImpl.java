package fr.lusseau.claude.infrastructure.resource;

import fr.lusseau.claude.domain.model.EducationLevel;
import fr.lusseau.claude.domain.validator.EducationLevelValidator;
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
@Path("/levels")
public class EducationLevelRestResourceImpl {

    private final FactoryService factoryService;

    @ConfigProperty(name = "educationLevel.response.error.msg.invalidEducationLevel")
    String invalidEducationLevel;

    @ConfigProperty(name = "educationLevel.response.error.msg.nameExist")
    String nameExist;

    @ConfigProperty(name = "educationLevel.response.error.msg.educationLevelNotFound")
    String educationLevelNotFound;

    @ConfigProperty(name = "educationLevel.response.error.msg.emptyEducationLevelList")
    String emptyEducationLevelList;


    @Inject
    public EducationLevelRestResourceImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EducationLevel> getAllEducationLevel() {
        List<EducationLevel> educationLevels = this.factoryService.getUseCaseFactory().getCrudEducationLevelUseCase().getAll();
        if (educationLevels.isEmpty()) {
            throw new ResourceException(emptyEducationLevelList);
        }
        return educationLevels;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public EducationLevel getOneEducationLevel(@PathParam("id") Long id) {
        EducationLevel educationLevel = this.factoryService.getUseCaseFactory().getCrudEducationLevelUseCase().getOne(id);
        if (educationLevel == null) {
            throw new ResourceException(emptyEducationLevelList);
        }
        return educationLevel;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response removeEducationLevel(@PathParam("id") Long id) {
        EducationLevel educationLevel = factoryService.getUseCaseFactory().getCrudEducationLevelUseCase().getOne(id);
        try {
            this.factoryService.getUseCaseFactory().getCrudEducationLevelUseCase().remove(educationLevel);
        } catch (IllegalArgumentException e) {
            throw new ResourceException(educationLevelNotFound);
        }
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createNewEducationLevel(EducationLevel educationLevel) {
        EducationLevel newEducationLevel = EducationLevel.builder()
                .withName(educationLevel.getName())
                .build();
        boolean isNameExist = this.factoryService.getUseCaseFactory().getCheckUseCase().checkIfEducationLevelNameExist(newEducationLevel.getName());
        try {
            EducationLevelValidator.validateEducationLevel(newEducationLevel);
        } catch (RuntimeException e) {
            throw new ResourceException(invalidEducationLevel);
        }
        if (isNameExist) {
            throw new ResourceException(nameExist);
        }
        this.factoryService.getUseCaseFactory().getCrudEducationLevelUseCase().create(newEducationLevel);
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Transactional
    public EducationLevel updateEducationLevel(@PathParam("id")Long id) {
        EducationLevel updatedEducationLevel = this.getOneEducationLevel(id);
        if (updatedEducationLevel == null) {
            throw new ResourceException(educationLevelNotFound);
        }
        return updatedEducationLevel;
    }
}