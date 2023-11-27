package dev.capybaralabs.domain.ports.interfaces;

import dev.capybaralabs.domain.dtos.UserDTO;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface UserServicePort {
    Uni<List<UserDTO>> listAllUsers();

    Uni<UserDTO> findByName(String name);

    Uni<UserDTO> findByEmail(String email);

    Uni<UserDTO> save(UserDTO userDTO);

    Uni<Void> delete(UserDTO userDTO);
}
