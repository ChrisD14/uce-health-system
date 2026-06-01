package ec.edu.uce.auth.service;

import ec.edu.uce.auth.dto.ApiResponse;
import ec.edu.uce.auth.dto.LoginRequest;
import ec.edu.uce.auth.dto.RegisterRequest;
import ec.edu.uce.auth.entity.Role;
import ec.edu.uce.auth.entity.User;
import ec.edu.uce.auth.repository.UserRepository;
import ec.edu.uce.auth.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ec.edu.uce.auth.security.JwtService;
import ec.edu.uce.auth.dto.AuthResponse;
import ec.edu.uce.auth.dto.UserResponse;
import ec.edu.uce.auth.dto.UpdateRoleRequest;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ApiResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.PATIENT)
                .build();

        userRepository.save(user);

        return new ApiResponse("User registered successfully");
    }

    public AuthResponse login(LoginRequest request) {

    User user = userRepository.findByEmail(
            request.getEmail())
            .orElseThrow(() ->
                    new RuntimeException(
                            "User not found"));

    if (!passwordEncoder.matches(
            request.getPassword(),
            user.getPassword())) {

        throw new RuntimeException(
                "Invalid credentials");
    }

    String token =
            jwtService.generateToken(user);

    return AuthResponse.builder()
            .accessToken(token)
            .email(user.getEmail())
            .role(user.getRole().name())
            .build();
}
    private final JwtService jwtService;

    public List<UserResponse> getUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build())
                .toList();
    }

    public UserResponse getUser(UUID id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public UserResponse updateRole(
            UUID id,
            UpdateRoleRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        user.setRole(request.getRole());

        userRepository.save(user);

        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public void deleteUser(UUID id) {

        userRepository.deleteById(id);
    }
}