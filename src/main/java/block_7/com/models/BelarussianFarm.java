package block_7.com.models;

public class BelarussianFarm extends Farm {

    @Override
    public Hen createHen() {
        return new BelarussianHen();
    }
}
