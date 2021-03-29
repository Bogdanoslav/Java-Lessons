package block_6.com;

import block_6.com.EmployeeModel.Agent;
import block_6.com.EmployeeModel.Employee;
import block_6.com.EmployeeModel.Manager;
import block_6.com.EmployeeModel.Worker;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] employees = {
                new Manager(),
                new Manager(),
                new Manager(),
                new Agent(3500),
                new Agent(2700),
                new Agent(6820),
                new Worker(120),
                new Worker(137),
                new Worker(96),
        };
        for (Employee e: employees){
            System.out.println(e.calcSalary());
        }
    }
}
