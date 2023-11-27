package dev.capybaralabs.infrastructure.postgresql.adapters.repositories;

import dev.capybaralabs.domain.User;
import dev.capybaralabs.domain.dtos.UserDTO;
import dev.capybaralabs.domain.repositories.UserRepositoryPort;
import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserRepository implements UserRepositoryPort, PanacheRepository<UserEntity> {

    @Override
    public Uni<List<User>> listAllUser() {
        return findAll().list().map(UserEntity::toDomain);
    }

    @Override
    public Uni<User> findByName(String name) {
        return find("name", name).firstResult()
                .onItem().ifNotNull().transform(UserEntity::toDomain)
                .onItemOrFailure().transformToUni((entity, throwable) -> {
                    if (entity != null) {
                        return Uni.createFrom().item(entity.toDomain());
                    } else {
                        return Uni.createFrom().item(new User());
                    }
                });
    }

    @Override
    public Uni<User> findByEmail(String email) {
        return find("email", email).firstResult().map(UserEntity::toDomain);
    }

    @Override
    public Uni<User> save(UserDTO userDTO) {
        return persist(userDTO.toEntity()).map(UserEntity::toDomain);
    }

    @Override
    public Uni<Void> delete(UserDTO userDTO) {
        return findById(userDTO.getId())
                .onItem().call(PanacheEntityBase::delete)
                .replaceWithVoid();
    }

}
