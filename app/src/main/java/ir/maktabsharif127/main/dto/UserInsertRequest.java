package ir.maktabsharif127.main.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInsertRequest {

    private String firstName;

    private String lastName;

    @NotBlank
    private String mobileNumber;

    @NotBlank
    private String password;

}
