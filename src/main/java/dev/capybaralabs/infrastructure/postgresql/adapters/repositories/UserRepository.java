package dev.capybaralabs.infrastructure.postgresql.adapters.repositories;

import dev.capybaralabs.domain.User;
import dev.capybaralabs.domain.dtos.UserDTO;
import dev.capybaralabs.domain.repositories.UserRepositoryPort;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class UserRepository implements UserRepositoryPort, PostgresRepositoryPort {

    private static PostgresRepositoryPort postgresRepositoryPort;

    public UserRepository(PostgresRepositoryPort postgresRepositoryPort) {
        UserRepository.postgresRepositoryPort = postgresRepositoryPort;
    }


    @Override
    public Uni<List<User>> all() {
        Uni<List<User>> releaseDate = postgresRepositoryPort
                .listAll(Sort.by("id"))
                .ifNoItem()
                .after(Duration.ofMillis(10000))
                .fail()
                .onFailure()
                .recoverWithUni(Uni.createFrom().<List<PanacheEntityBase>>item(Collections.EMPTY_LIST));
        return releaseDate;
    }

    @Override
    public Uni<User> findByName(String name) {
        return null;
    }

    @Override
    public Uni<User> findByEmail(String email) {
        return null;
    }

    @Override
    public Uni<User> save(UserDTO userDTO) {
        return null;
    }
}
