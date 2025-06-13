package ir.maktabsharif127.main.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSaveUpdateRequest {

    @NotNull(groups = ValidationGroup.Update.class)
    private Long id;

    private String firstName;

    private String lastName;

    @NotBlank(groups = {ValidationGroup.Save.class, ValidationGroup.Update.class})
    private String mobileNumber;

    @NotBlank(groups = {ValidationGroup.Save.class, ValidationGroup.Update.class})
    private String password;

    @NotNull(groups = {ValidationGroup.Save.class, ValidationGroup.Update.class})
    @Valid
    private Address address;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {

        @NotBlank(groups = ValidationGroup.Update.class)
        private String address;

        @NotBlank(groups = ValidationGroup.Save.class)
        private String postalCode;
    }

}
