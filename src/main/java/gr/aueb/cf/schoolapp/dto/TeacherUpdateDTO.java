package gr.aueb.cf.schoolapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TeacherUpdateDTO extends BaseTeacherDTO {
    private Integer id;

    public TeacherUpdateDTO() {

    }

    public TeacherUpdateDTO(Integer id, String firstname, String lastname, String vat,
                            String fatherName, String phoneNum, String email, String street,
                            String streetNum, String zipCode, Integer cityId) {
        super(firstname, lastname, vat, fatherName, phoneNum, email, street, streetNum, zipCode, cityId);
        this.id = id;
    }

    @Override
    public String toString() {
        return "TeacherUpdateDTO{" +
                "id=" + id +
                '}' + super.toString();
    }
}
