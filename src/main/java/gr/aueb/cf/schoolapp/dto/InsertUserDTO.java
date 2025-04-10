package gr.aueb.cf.schoolapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InsertUserDTO extends BaseUserDTO {

    private String role;

    public InsertUserDTO(String username, String password, String confirmedPassword, String role) {
        super(username, password, confirmedPassword);
        this.role = role;
    }

}
