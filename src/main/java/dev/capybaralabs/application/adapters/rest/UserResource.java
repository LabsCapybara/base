package dev.capybaralabs.application.adapters.rest;

import dev.capybaralabs.domain.adapters.services.UserService;
import dev.capybaralabs.domain.dtos.UserDTO;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@WithTransaction
@Path("/user")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<UserDTO>> allUser() {
        return userService.findAll();
    }
}
