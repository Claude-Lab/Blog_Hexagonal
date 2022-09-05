package fr.lusseau.claude.infrastructure.resource;

import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.domain.validator.UserValidator;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.resource.exception.ResourceException;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.inject.Named;
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
@Named
@Path("/users")
public class UserRestResourceImpl {

    private final FactoryService factoryService;

    @ConfigProperty(name = "user.response.error.msg.userNotFound")
    String userNotFound;

    @ConfigProperty(name = "user.response.error.msg.invalidUser")
    String invalidUser;

    @ConfigProperty(name = "user.response.error.msg.emailExist")
    String emailExist;

    @ConfigProperty(name = "user.response.error.msg.emptyUserList")
    String emptyUserList;

    @Inject
    public UserRestResourceImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        List<User> users = this.factoryService.getUseCaseFactory().getCrudUserUseCase().getAll();
        if (users.isEmpty()) {
            throw new ResourceException(emptyUserList);
        }
        return users;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User getOne(@PathParam("id") Long id) {
        User user = this.factoryService.getUseCaseFactory().getCrudUserUseCase().getOne(id);
        if (user == null) {
            throw new ResourceException(userNotFound);
        }
        return user;
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(User user) {
        User newUser = User.builder()
                .withEmail(user.getEmail())
                .withPassword(user.getPassword())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withRole(user.getRole())
                .build();
        try {
            UserValidator.validateUser(newUser);
        } catch (RuntimeException e) {
            throw new ResourceException(invalidUser);
        }
        if (factoryService.getUseCaseFactory().getCheckUseCase().isEmailExist(user.getEmail())) {
            throw new ResourceException(emailExist);
        }
        user = this.factoryService.getUseCaseFactory().getCrudUserUseCase().create(newUser);

        if (user == null) {
            return Response.notModified().status(Response.Status.NOT_IMPLEMENTED).build();
        }
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    @Transactional
    public Response update(User user) {
        if (getOne(user.getId()) == null) {
            throw new ResourceException(userNotFound);
        }
        if (!factoryService.getUseCaseFactory().getCheckUseCase().isEmailExist(user.getEmail())) {
            throw new ResourceException(emailExist);
        }
        try {
            this.factoryService.getUseCaseFactory().getCrudUserUseCase().update(user);
        } catch (RuntimeException e) {
            throw new ResourceException(invalidUser);
        }
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response remove(@PathParam("id") Long id) {
        User user = this.factoryService.getUseCaseFactory().getCrudUserUseCase().getOne(id);
        if (user == null) {
            throw new ResourceException(userNotFound);
        }
        this.factoryService.getUseCaseFactory().getCrudUserUseCase().remove(user);
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }
}