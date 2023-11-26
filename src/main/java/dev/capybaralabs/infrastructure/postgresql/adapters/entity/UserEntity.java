package dev.capybaralabs.infrastructure.postgresql.adapters.entity;

import dev.capybaralabs.domain.dtos.UserDTO;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Cacheable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends PanacheEntity {
    public String name;
    public String email;
    public String password;

    public UserEntity(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDTO toDTO() {
        return new UserDTO(this.id, this.name, this.email, this.password);
    }
    public static List<UserDTO> toDTO(List<UserEntity> userEntities) {
        return userEntities.stream().map(UserEntity::toDTO).collect(Collectors.toList());
    }
}
