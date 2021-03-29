package block_6.com.UserModel;

public class DriverTest {
    public static void main(String[] args) {
        Driver driver = new Driver("Vladislave", 25, 10000, 10, "A");
        System.out.printf("У водителя %s категория вождения %s , а стаж составляет %d лет", driver.getName(), driver.getDriverCategory(), driver.getExperience());
    }
}
