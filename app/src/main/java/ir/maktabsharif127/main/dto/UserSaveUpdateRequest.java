package ir.maktabsharif127.main.dto;

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

}
