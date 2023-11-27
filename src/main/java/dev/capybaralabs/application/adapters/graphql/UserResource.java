package dev.capybaralabs.application.adapters.graphql;

import dev.capybaralabs.domain.adapters.services.UserService;
import dev.capybaralabs.domain.dtos.UserDTO;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
@WithTransaction
public class UserResource {

    @Inject
    UserService userService;

    @Query
    @Description("All User")
    public Uni<List<UserDTO>> allUser() {
        return userService.listAllUsers();
    }

}
