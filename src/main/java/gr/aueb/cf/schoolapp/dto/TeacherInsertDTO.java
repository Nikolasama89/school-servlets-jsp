package gr.aueb.cf.schoolapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TeacherInsertDTO extends BaseTeacherDTO {

    public TeacherInsertDTO() {}

    public TeacherInsertDTO(String firstname, String lastname, String vat,
                            String fatherName, String phoneNum, String email, String street,
                            String streetNum, String zipCode, Integer cityId) {
        super(firstname, lastname, vat, fatherName, phoneNum, email, street, streetNum, zipCode, cityId);
    }
}
