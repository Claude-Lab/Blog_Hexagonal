package fr.lusseau.claude.infrastructure.controller;


import fr.lusseau.claude.domain.model.Role;
import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("users")
public class UserRestControllerImpl {

    private final FactoryService factoryService;

    @Inject
    public UserRestControllerImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GET
    public List<User> getAllUsers() {
        return this.factoryService.createUseCaseFactory().getUserUseCase().getAllUsers();
    }

    @GET
    @Path("/{id}")
    public User getOne(Long id) {
        return this.factoryService.createUseCaseFactory().getUserUseCase().getOne(id);
    }

    @DELETE
    @Path("/{id}")
    public Integer removeUser(Long id) {
        return this.factoryService.createUseCaseFactory().deleteUserUseCase().removeUser(id);
    }

    @POST
    public Response createNewUser(@QueryParam("email") String email, @QueryParam("password") String password, @QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname, @QueryParam("role") Role role ) {
        User user = User.builder()
                .withEmail(email)
                .withPassword(password)
                .withFirstname(firstname)
                .withLastname(lastname)
                .withRole(role)
                .build();
        boolean result = this.factoryService.createUseCaseFactory().createUserUseCase().createUser(user);
        if (!result) {
            return Response.notModified().build();

        }
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Long updateUser(User user) {
        return this.factoryService.createUseCaseFactory().updateUserUseCase().updateUser(user);
    }

}
