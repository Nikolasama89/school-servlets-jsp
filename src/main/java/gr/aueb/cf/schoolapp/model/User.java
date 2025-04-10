package gr.aueb.cf.schoolapp.model;

import gr.aueb.cf.schoolapp.core.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String username;
    private String password;
    private RoleType roleType;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role ='" + roleType.name() + '\'' +
                '}';
    }
}
