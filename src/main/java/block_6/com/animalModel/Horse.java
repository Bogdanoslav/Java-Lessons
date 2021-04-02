package block_6.com.AnimalModel;

public class Horse  extends Animal{
    private String suit;

    public Horse(String food, String location, String suit) {
        super(food, location);
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public void makeNoise() {
        System.out.println("Лошадь делает иго-го");
    }

    @Override
    public void eat() {
        System.out.println("Лошадь кушает овес");
    }
}
