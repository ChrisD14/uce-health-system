package ec.edu.uce.auth.controller;

import ec.edu.uce.auth.dto.ApiResponse;
import ec.edu.uce.auth.dto.LoginRequest;
import ec.edu.uce.auth.dto.RegisterRequest;
import ec.edu.uce.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ec.edu.uce.auth.dto.AuthResponse;
import org.springframework.security.core.Authentication;
import ec.edu.uce.auth.dto.UserResponse;
import ec.edu.uce.auth.dto.UpdateRoleRequest;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {

        return authService.login(request);
    }

    @GetMapping("/health")
    public String health() {
        return "Auth Service Running";
    }

    @GetMapping("/me")
    public String me(Authentication authentication) {

        System.out.println(
            "AUTH OBJECT: " + authentication
        );

        return authentication.getName();
    }

    @GetMapping("/users")
    public List<UserResponse> users() {

        return authService.getUsers();
    }

    @GetMapping("/users/{id}")
    public UserResponse user(
            @PathVariable UUID id) {

        return authService.getUser(id);
    }

    @PatchMapping("/users/{id}/role")
    public UserResponse updateRole(
            @PathVariable UUID id,
            @RequestBody UpdateRoleRequest request) {

        return authService.updateRole(id, request);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(
            @PathVariable UUID id) {

        authService.deleteUser(id);
    }
}