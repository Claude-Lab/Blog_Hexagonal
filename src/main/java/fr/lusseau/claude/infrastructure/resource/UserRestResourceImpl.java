package fr.lusseau.claude.infrastructure.resource;


import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.domain.validator.UserValidator;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.resource.exception.ResourceException;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
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
@Path("/users")
public class UserRestResourceImpl {

    private final FactoryService factoryService;

    @ConfigProperty(name = "user.custom.error.msg.userNotFound")
    String userNotFound;
    @ConfigProperty(name = "user.custom.error.msg.invalidUser")
    String invalidUser;
    @ConfigProperty(name = "user.custom.error.msg.emailExist")
    String emailExist;
    @ConfigProperty(name = "user.custom.error.msg.emptyUserList")
    String emptyUserList;

    @Inject
    public UserRestResourceImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() throws ResourceException {
        List<User> users = this.factoryService.createUseCaseFactory().getUserUseCase().getAllUsers();
        if (users.isEmpty()) {
            throw new ResourceException(emptyUserList);
        }
        return users;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User getOneUser(@PathParam("id") Long id) {
        User user = this.factoryService.createUseCaseFactory().getUserUseCase().getOne(id);
        if (user == null) {
            throw new ResourceException(userNotFound);
        }
        return user;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response removeUser(@PathParam("id") Long id) {
        try {
            this.factoryService.createUseCaseFactory().deleteUserUseCase().removeUser(id);
        } catch (IllegalArgumentException e) {
            throw new ResourceException(userNotFound);
        }
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createNewUser(User user) throws ResourceException {
        User newUser = User.builder()
                .withEmail(user.getEmail())
                .withPassword(user.getPassword())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withRole(user.getRole())
                .build();
        boolean checkEmail = this.factoryService.createUseCaseFactory().emailCheckUseCase().isEmailExist(newUser.getEmail());
        try {
            UserValidator.validateUser(newUser);
        } catch (RuntimeException e) {
            throw new ResourceException(invalidUser);
        }
        if (checkEmail) {
            throw new ResourceException(emailExist);
        }
        this.factoryService.createUseCaseFactory().createUserUseCase().createUser(newUser);
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    @Transactional
    public User updateUser(User user) {
        User updatedUser = this.factoryService.createUseCaseFactory().updateUserUseCase().updateUser(user);
        if (updatedUser == null) {
            throw new ResourceException(userNotFound);
        }
        return updatedUser;
    }
}