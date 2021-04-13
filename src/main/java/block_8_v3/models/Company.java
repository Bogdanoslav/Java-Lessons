package block_8_v3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Company {
    //name,domicile,phone_number
    int id;
    String name;
    String domicile;
    String phoneNumber;

    public Company(int id, String name, String domicile, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.domicile = domicile;
        this.phoneNumber = phoneNumber;
    }

    public Company(String name, String domicile, String phoneNumber) {
        this.name = name;
        this.domicile = domicile;
        this.phoneNumber = phoneNumber;
    }
}
