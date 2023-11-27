package dev.capybaralabs.domain.adapters.services;

import dev.capybaralabs.domain.User;
import dev.capybaralabs.domain.dtos.UserDTO;
import dev.capybaralabs.domain.ports.interfaces.UserServicePort;
import dev.capybaralabs.infrastructure.postgresql.adapters.repositories.UserRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.Duration;
import java.util.List;

@ApplicationScoped
public class UserService implements UserServicePort {

    @Inject
    UserRepository userRepository;

    @Override
    public Uni<List<UserDTO>> listAllUsers() {
        return userRepository.listAllUser().map(User::toDTO);
    }

    @Override
    public Uni<UserDTO> findByName(String name) {
        return userRepository.findByName(name).map(User::toDTO);
    }

    @Override
    public Uni<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email).map(User::toDTO);
    }

    @Override
    public Uni<UserDTO> save(UserDTO userDTO) {
        return userRepository.save(userDTO).map(User::toDTO);
    }

    @Override
    public Uni<Void> delete(UserDTO userDTO) {
        return userRepository.delete(userDTO);
    }
}
