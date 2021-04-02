package block_6.com.AnimalModel;

public class Dog extends Animal{
    private boolean herdingDog;

    public Dog(String food, String location, boolean herdingDog) {
        super(food, location);
        this.herdingDog = herdingDog;
    }

    public boolean isHerdingDog() {
        return herdingDog;
    }

    public void setHerdingDog(boolean herdingDog) {
        this.herdingDog = herdingDog;
    }

    @Override
    public void makeNoise() {
        System.out.println("Собака гавкает");
    }

    @Override
    public void eat() {
        System.out.println("Собака кушает косточку");
    }
}
