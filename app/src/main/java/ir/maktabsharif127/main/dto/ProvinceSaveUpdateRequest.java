package ir.maktabsharif127.main.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceSaveUpdateRequest {

    @NotNull(groups = ValidationGroup.Update.class)
    @Null(groups = ValidationGroup.Save.class)
    private Long id;

    @NotBlank
    private String name;
}
