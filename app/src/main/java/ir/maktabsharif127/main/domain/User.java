package ir.maktabsharif127.main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String mobileNumber;
    private ZonedDateTime birthdate;
    private ZonedDateTime createDate;
    private Boolean isActive;
}
