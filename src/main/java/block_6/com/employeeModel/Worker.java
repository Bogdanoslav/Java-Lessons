package block_6.com.EmployeeModel;

public class Worker extends Employee {
    int hoursWorked;

    public Worker(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calcSalary() {
        return 100*hoursWorked;
    }
}
