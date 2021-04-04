package block_7.com.models;

public class RussianFarm extends Farm{

    @Override
    public Hen createHen() {
        return new RussianHen();
    }
}
