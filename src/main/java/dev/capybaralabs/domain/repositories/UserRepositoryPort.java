package dev.capybaralabs.domain.repositories;

import dev.capybaralabs.domain.User;
import dev.capybaralabs.domain.dtos.UserDTO;
import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface UserRepositoryPort {
    Uni<List<User>> all();

    Uni<User> findByName(String name);

    Uni<User> findByEmail(String email);

    Uni<User> save(UserDTO userDTO);
}
