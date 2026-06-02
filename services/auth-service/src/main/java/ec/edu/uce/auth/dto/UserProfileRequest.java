package ec.edu.uce.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfileRequest {

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