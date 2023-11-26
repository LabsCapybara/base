package dev.capybaralabs.domain.dtos;

import dev.capybaralabs.domain.User;
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

    public UserDTO fromEntity(User user) {
        return new UserDTO(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword()
        );
    }

    public User toEntity() {
        return new User(
            this.id,
            this.name,
            this.email,
            this.password
        );
    }
}
