package block_13_ORM.models;

import block_13_ORM.annotations.MyColumn;
import block_13_ORM.annotations.MyTable;

@MyTable(name = "Users", description = "User data table")
public class User {
    @MyColumn(name = "Name")
    private String name;
    @MyColumn(name = "Age")
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
