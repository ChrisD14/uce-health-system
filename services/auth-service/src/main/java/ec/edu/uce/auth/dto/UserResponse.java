package ec.edu.uce.auth.dto;

import ec.edu.uce.auth.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserResponse {

    private UUID id;

    private String email;

    private Role role;
}