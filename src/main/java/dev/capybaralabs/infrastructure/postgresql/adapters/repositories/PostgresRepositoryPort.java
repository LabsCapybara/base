package dev.capybaralabs.infrastructure.postgresql.adapters.repositories;

import dev.capybaralabs.domain.User;
import dev.capybaralabs.domain.dtos.UserDTO;
import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface PostgresRepositoryPort extends PanacheRepository<UserEntity> {

    Uni<List<User>> all();

    Uni<User> findByName(String name);

    Uni<User> findByEmail(String email);

    Uni<User> save(UserDTO userDTO);

}
