package block_6.com.AnimalModel;

public class Cat extends Animal{
    private boolean hisses;

    public Cat(String food, String location, boolean hisses) {
        super(food, location);
        this.hisses = hisses;
    }

    public boolean isHisses() {
        return hisses;
    }

    public void setHisses(boolean hisses) {
        this.hisses = hisses;
    }

    @Override
    public void makeNoise() {
        System.out.println("Кот мяукает");
    }

    @Override
    public void eat() {
        System.out.println("Кот кушает Вискас");
    }
}
