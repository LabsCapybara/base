package dev.capybaralabs.domain;

import dev.capybaralabs.domain.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    public String name;
    public String email;
    public String password;

    public static List<UserDTO> toDTO(List<User> users) {
        return users.stream().map(User::toDTO).collect(Collectors.toList());
    }

    public UserDTO toDTO() {
        return new UserDTO(
            this.id,
            this.name,
            this.email,
            this.password
        );
    }

    public User toDomain() {
        return new User(
            this.id,
            this.name,
            this.email,
            this.password
        );
    }
}
