package ec.edu.uce.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {

    private String accessToken;

    private String email;

    private String role;
}