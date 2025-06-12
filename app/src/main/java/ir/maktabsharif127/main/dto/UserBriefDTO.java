package ir.maktabsharif127.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBriefDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private UserBriefDTO dto;
    private Boolean isActive;
    private List<String> numbers;
}
