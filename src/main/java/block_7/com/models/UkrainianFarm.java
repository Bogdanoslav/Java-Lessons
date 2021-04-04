package block_7.com.models;

public class UkrainianFarm extends Farm{

    @Override
    public Hen createHen() {
        return new UkrainianHen();
    }
}
