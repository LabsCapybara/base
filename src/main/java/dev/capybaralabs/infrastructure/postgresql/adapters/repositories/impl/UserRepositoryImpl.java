package dev.capybaralabs.infrastructure.postgresql.adapters.repositories.impl;

import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import dev.capybaralabs.infrastructure.postgresql.adapters.repositories.UserRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    public Uni<UserEntity> findByName(String name){
        return find("name", name).firstResult();
    }

}
