package fr.lusseau.claude.infrastructure.resource;


import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

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
@Path("/users")
public class UserRestResourceImpl {

    private final FactoryService factoryService;

    @Inject
    public UserRestResourceImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return this.factoryService.createUseCaseFactory().getUserUseCase().getAllUsers();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User getOneUser(@PathParam("id") Long id) {
        return this.factoryService.createUseCaseFactory().getUserUseCase().getOne(id);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void removeUser(@PathParam("id") Long id) {
        this.factoryService.createUseCaseFactory().deleteUserUseCase().removeUser(id);
    }

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createNewUser(User user) {
        User newUser = User.builder()
                .withEmail(user.getEmail())
                .withPassword(user.getPassword())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withRole(user.getRole())
                .build();
        boolean result = this.factoryService.createUseCaseFactory().createUserUseCase().createUser(newUser);
        if(!result) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void updateUser(User user) {
        this.factoryService.createUseCaseFactory().updateUserUseCase().updateUser(user);
    }

}
