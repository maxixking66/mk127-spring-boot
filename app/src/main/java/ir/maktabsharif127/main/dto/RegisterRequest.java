package ir.maktabsharif127.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest implements Serializable {

    private String mobileNumber;

    private String username;

    private String password;
}
