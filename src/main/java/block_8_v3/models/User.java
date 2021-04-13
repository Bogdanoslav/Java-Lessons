package block_8_v3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class User {
    //first_name,last_name,email,gender,CompanyId
    int id;
    String firstName;
    String lastName;
    String email;
    String gender;
    int companyId;

    public User(int id, String firstName, String lastName, String email, String gender, int companyId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.companyId = companyId;
    }

    public User(String firstName, String lastName, String email, String gender, int companyId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.companyId = companyId;
    }
}
