package dev.capybaralabs.domain.services;

import dev.capybaralabs.domain.User;
import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface UserService {

    Uni<List<UserEntity>> findAll();
}
