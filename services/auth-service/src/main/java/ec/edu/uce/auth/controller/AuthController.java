package ec.edu.uce.auth.controller;

import ec.edu.uce.auth.dto.ApiResponse;
import ec.edu.uce.auth.dto.LoginRequest;
import ec.edu.uce.auth.dto.RegisterRequest;
import ec.edu.uce.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse register(
            @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public ApiResponse login(
            @RequestBody LoginRequest request) {

        return authService.login(request);
    }

    @GetMapping("/health")
    public String health() {
        return "Auth Service Running";
    }
}