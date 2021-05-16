package block_13_ORM.models;

import block_13_ORM.annotations.MyColumn;
import block_13_ORM.annotations.MyTable;

@MyTable(name = "Companies",description = "Companies data table")
public class Company {
    @MyColumn(name = "name")
    private String name;
    @MyColumn(name = "phone")
    private String phone;

    public Company(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    public Company(){

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


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


}
