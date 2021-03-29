package block_6.com.UserModel;

public class Driver extends Worker{
    private int experience;
    private String driverCategory;

    public Driver(String name, int age, int salary, int experience, String driverCategory) {
        super(name, age, salary);
        this.experience = experience;
        this.driverCategory = driverCategory;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDriverCategory() {
        return driverCategory;
    }

    public void setDriverCategory(String driverCategory) {
        this.driverCategory = driverCategory;
    }
}
