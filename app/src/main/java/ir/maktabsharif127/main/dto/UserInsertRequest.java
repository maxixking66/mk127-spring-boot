package ir.maktabsharif127.main.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @Valid
    private Address address;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {

        @NotBlank
        private String address;

        @NotBlank
        @Size(min = 10, max = 10)
        private String postalCode;
    }

}
