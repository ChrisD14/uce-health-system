package main.java.ec.edu.uce.auth.service;

import ec.edu.uce.user.dto.CreateProfileRequest;
import ec.edu.uce.user.entity.UserProfile;
import ec.edu.uce.user.repository.UserProfileRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final
    UserProfileRepository repository;

    public UserProfile createProfile(
            CreateProfileRequest request) {

        UserProfile profile =
                UserProfile.builder()
                        .email(
                                request.getEmail())
                        .firstName(
                                request.getFirstName())
                        .lastName(
                                request.getLastName())
                        .phone(
                                request.getPhone())
                        .faculty(
                                request.getFaculty())
                        .career(
                                request.getCareer())
                        .gender(
                                request.getGender())
                        .birthDate(
                                request.getBirthDate())
                        .build();

        return repository.save(profile);
    }
}
