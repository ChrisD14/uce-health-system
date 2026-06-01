package ec.edu.uce.user.controller;

import ec.edu.uce.user.dto.CreateProfileRequest;
import ec.edu.uce.user.entity.UserProfile;
import ec.edu.uce.user.service.UserProfileService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserProfileController {

    private final
    UserProfileService service;

    @PostMapping
    public UserProfile createProfile(
            @RequestBody
            CreateProfileRequest request) {

        return service
                .createProfile(
                        request);
    }
}