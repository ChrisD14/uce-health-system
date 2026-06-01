package ec.edu.uce.user.service;

import ec.edu.uce.user.dto.CreateProfileRequest;
import ec.edu.uce.user.dto.UpdateProfileRequest;
import ec.edu.uce.user.entity.UserProfile;
import ec.edu.uce.user.repository.UserProfileRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository repository;

    public UserProfile createProfile(
            CreateProfileRequest request) {

        UserProfile profile =
                UserProfile.builder()
                        .authUserId(request.getAuthUserId())
                        .email(request.getEmail())
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .phone(request.getPhone())
                        .faculty(request.getFaculty())
                        .career(request.getCareer())
                        .gender(request.getGender())
                        .birthDate(request.getBirthDate())
                        .build();

        return repository.save(profile);
    }

    public List<UserProfile> getAllProfiles() {

        return repository.findAll();
    }

    public UserProfile getProfileById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Profile not found"));
    }

    public UserProfile updateProfile(
            Long id,
            UpdateProfileRequest request) {

        UserProfile profile =
                getProfileById(id);

        profile.setFirstName(
                request.getFirstName());

        profile.setLastName(
                request.getLastName());

        profile.setPhone(
                request.getPhone());

        profile.setFaculty(
                request.getFaculty());

        profile.setCareer(
                request.getCareer());

        profile.setGender(
                request.getGender());

        profile.setBirthDate(
                request.getBirthDate());

        profile.setPhotoUrl(
                request.getPhotoUrl());

        return repository.save(profile);
    }

    public void deleteProfile(Long id) {

        repository.deleteById(id);
    }
}