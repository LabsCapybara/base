package dev.capybaralabs.domain.dtos;

import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class UserDTO {

    private Long id;
    public String name;
    public String email;
    public String password;

    public UserDTO fromEntity(UserEntity userEntity) {
        return new UserDTO(
            userEntity.id,
            userEntity.name,
            userEntity.email,
            userEntity.password
        );
    }

    public UserEntity toEntity() {
        return new UserEntity(
            this.id,
            this.name,
            this.email,
            this.password
        );
    }
}
