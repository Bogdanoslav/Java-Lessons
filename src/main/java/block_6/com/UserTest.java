package block_6.com;

import block_6.com.UserModel.Worker;

public class UserTest {
    Worker workerIvan = new Worker("Иван",25,1000);
    Worker workerVasya = new Worker("Вася",26,2000);

    int salarySum = workerIvan.getSalary()+workerVasya.getSalary();
}
