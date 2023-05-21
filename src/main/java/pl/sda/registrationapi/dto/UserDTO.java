package pl.sda.registrationapi.dto;

import lombok.*;
import pl.sda.registrationapi.enums.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Role role;
    private boolean enabled;
    private String email;
}
