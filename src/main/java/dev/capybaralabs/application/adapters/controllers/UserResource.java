package dev.capybaralabs.application.adapters.controllers;

import dev.capybaralabs.domain.services.UserService;
import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@WithTransaction
@ApplicationScoped
@Path("/user")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<UserEntity>> hello() {
        return userService.findAll();
    }
}
