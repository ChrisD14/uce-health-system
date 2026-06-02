package ec.edu.uce.user.dto;

import lombok.Data;

@Data
public class CreateProfileRequest {

    private String authUserId;

    private String email;

    private String firstName;

    private String lastName;

    private String phone;

    private String faculty;

    private String career;

    private String gender;

    private String birthDate;
}