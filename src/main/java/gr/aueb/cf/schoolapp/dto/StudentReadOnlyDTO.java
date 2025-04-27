package gr.aueb.cf.schoolapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentReadOnlyDTO extends BaseStudentDTO{
    private Integer id;
    private String uuid;

    public StudentReadOnlyDTO() {}

    public StudentReadOnlyDTO(Integer id, String uuid, String firstname, String lastname,
                              String vat, String fatherName, String phoneNum, String email,
                              String street, String streetNum, String zipCode, Integer cityId) {
        super(firstname, lastname, vat, fatherName, phoneNum, email, street, streetNum, zipCode, cityId);
        this.id = id;
        this.uuid = uuid;
    }

}
