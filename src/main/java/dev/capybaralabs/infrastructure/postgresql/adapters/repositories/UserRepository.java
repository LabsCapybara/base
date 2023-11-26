package dev.capybaralabs.infrastructure.postgresql.adapters.repositories;

import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

public interface UserRepository extends PanacheRepository<UserEntity> {
    Uni<UserEntity> findByName(String name);

}
