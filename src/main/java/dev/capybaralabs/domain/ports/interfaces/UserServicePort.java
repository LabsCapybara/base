package dev.capybaralabs.domain.ports.interfaces;

import dev.capybaralabs.domain.dtos.UserDTO;
import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface UserServicePort {
    Uni<List<UserDTO>> findAll();
}
