package block_13_ORM.models;

import block_13_ORM.annotations.MyColumn;
import block_13_ORM.annotations.MyTable;

@MyTable(name = "Companies",description = "Companies data table")
public class Company {
    @MyColumn(name = "Name")
    private String name;
    @MyColumn(name = "Phone")
    private String phone;

    public Company(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    public Company(){

    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
