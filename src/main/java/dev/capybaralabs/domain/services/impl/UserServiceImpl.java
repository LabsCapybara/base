package dev.capybaralabs.domain.services.impl;

import dev.capybaralabs.domain.User;
import dev.capybaralabs.domain.services.UserService;
import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import dev.capybaralabs.infrastructure.postgresql.adapters.repositories.UserRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Override
    public Uni<List<UserEntity>> findAll() {
        return userRepository.findAll().list();
    }
}
