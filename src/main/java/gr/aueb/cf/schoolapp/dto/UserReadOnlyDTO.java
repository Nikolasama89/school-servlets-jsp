package gr.aueb.cf.schoolapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserReadOnlyDTO extends BaseUserDTO {

    private Integer id;

    public UserReadOnlyDTO() {}

    public UserReadOnlyDTO(Integer id, String username, String password) {
        super(username, password);
        this.id = id;
    }

}
