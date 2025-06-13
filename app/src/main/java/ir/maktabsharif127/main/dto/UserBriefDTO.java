package ir.maktabsharif127.main.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "first-name")
    private String firstName;
    @JsonAlias(value = "last_name")
    private String lastName;
    @JsonProperty(value = "myDTO")
    private UserBriefDTO dto;
    private Boolean isActive;
    private List<String> numbers;
}
