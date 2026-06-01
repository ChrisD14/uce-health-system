package ec.edu.uce.user.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(
            strategy =
                    GenerationType.IDENTITY
    )
    private Long id;

    private String authUserId;

    private String email;

    private String firstName;

    private String lastName;

    private String phone;

    private String faculty;

    private String career;

    private String gender;

    private String birthDate;

    private String photoUrl;
}