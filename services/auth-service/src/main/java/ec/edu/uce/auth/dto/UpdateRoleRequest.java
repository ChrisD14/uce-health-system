package ec.edu.uce.auth.dto;

import ec.edu.uce.auth.entity.Role;
import lombok.Data;

@Data
public class UpdateRoleRequest {

    private Role role;
}