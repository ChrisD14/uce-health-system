package ec.edu.uce.user.dto;

import lombok.Data;

@Data
public class UpdateProfileRequest {

    private String firstName;

    private String lastName;

    private String phone;

    private String faculty;

    private String career;

    private String gender;

    private String birthDate;

    private String photoUrl;
}
