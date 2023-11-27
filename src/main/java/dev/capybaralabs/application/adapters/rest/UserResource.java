package dev.capybaralabs.application.adapters.rest;

import dev.capybaralabs.domain.adapters.services.UserService;
import dev.capybaralabs.domain.dtos.UserDTO;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.Duration;
import java.util.List;

@WithTransaction
@Path("/user")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<UserDTO>> allUser() {
        return userService.listAllUsers()
                .ifNoItem().after(Duration.ofSeconds(5)).fail()
                .onFailure().recoverWithItem(List.of());
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<UserDTO> findByName(
            @PathParam("name") String name
    ) {
        return userService.findByName(name)
                .ifNoItem().after(Duration.ofSeconds(5)).fail()
                .onFailure().recoverWithItem(new UserDTO());
    }
}
