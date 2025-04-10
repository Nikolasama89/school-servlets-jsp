package gr.aueb.cf.schoolapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class BaseUserDTO {
    private String username;
    private String password;
    private String confirmedPassword;


    public BaseUserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
