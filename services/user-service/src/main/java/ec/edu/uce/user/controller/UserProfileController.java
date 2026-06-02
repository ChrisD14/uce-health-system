package ec.edu.uce.user.controller;

import ec.edu.uce.user.dto.CreateProfileRequest;
import ec.edu.uce.user.dto.UpdateProfileRequest;
import ec.edu.uce.user.entity.UserProfile;
import ec.edu.uce.user.service.UserProfileService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(
        origins = {
                "http://localhost:5173",
                "http://127.0.0.1:5173"
        }
)
public class UserProfileController {

    private final UserProfileService service;

    @PostMapping
    public UserProfile createProfile(
            @RequestBody
            CreateProfileRequest request) {

        return service.createProfile(
                request);
    }

    @GetMapping
    public List<UserProfile> getAllProfiles() {

        return service.getAllProfiles();
    }

    @GetMapping("/{id}")
    public UserProfile getProfileById(
            @PathVariable Long id) {

        return service.getProfileById(id);
    }

    @PutMapping("/{id}")
    public UserProfile updateProfile(
            @PathVariable Long id,
            @RequestBody
            UpdateProfileRequest request) {

        return service.updateProfile(
                id,
                request);
    }

    @DeleteMapping("/{id}")
    public String deleteProfile(
            @PathVariable Long id) {

        service.deleteProfile(id);

        return "Profile deleted successfully";
    }

    @GetMapping("/health")
    public String health() {

        return "User Service Running";
    }

    @GetMapping("/email/{email}")
    public UserProfile getProfileByEmail(
            @PathVariable String email) {

        return service
                .getProfileByEmail(email);
    }
}