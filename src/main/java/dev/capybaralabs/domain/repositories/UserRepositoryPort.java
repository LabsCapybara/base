package dev.capybaralabs.domain.repositories;

import dev.capybaralabs.domain.User;
import dev.capybaralabs.domain.dtos.UserDTO;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface UserRepositoryPort {
    Uni<List<User>> listAllUser();

    Uni<User> findByName(String name);

    Uni<User> findByEmail(String email);

    Uni<User> save(UserDTO userDTO);

    Uni<Void> delete(UserDTO userDTO);
}
