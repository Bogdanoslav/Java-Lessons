package block_6.com.EmployeeModel;

public class Agent extends Employee{
    int salesVolume;

    public Agent(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    @Override
    public double calcSalary() {
        return 5000 + salesVolume * 0.05;
    }
}
