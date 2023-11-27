package dev.capybaralabs.domain.dtos;

import dev.capybaralabs.infrastructure.postgresql.adapters.entity.UserEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public UserEntity toEntity() {
        return new UserEntity(
            this.id,
            this.name,
            this.email,
            this.password
        );
    }

    public UserDTO toDTO() {
        return new UserDTO(
            this.id,
            this.name,
            this.email,
            this.password
        );
    }
}
