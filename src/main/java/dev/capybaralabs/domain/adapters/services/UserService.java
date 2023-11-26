package dev.capybaralabs.domain.adapters.services;

import dev.capybaralabs.domain.dtos.UserDTO;
import dev.capybaralabs.domain.ports.interfaces.UserServicePort;
import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import dev.capybaralabs.infrastructure.postgresql.adapters.repositories.UserRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserService implements UserServicePort {

    @Inject
    UserRepository userRepository;

    @Override
    public Uni<List<UserDTO>> findAll() {
        return userRepository.listAll().map(UserEntity::toDTO);
    }
}
