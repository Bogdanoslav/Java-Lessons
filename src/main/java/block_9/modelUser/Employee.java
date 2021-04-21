package block_9.modelUser;

import block_9.abstractClasses.User;

public class Employee extends User {
    private String company;

    public Employee(String name, String company) {
        super(name);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public void greet() {
        System.out.println("Hello, my name is " + name + ". I'm working for " + company + " company.");
    }
}
