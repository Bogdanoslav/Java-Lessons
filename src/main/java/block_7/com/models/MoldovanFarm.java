package block_7.com.models;

public class MoldovanFarm extends Farm{

    @Override
    public Hen createHen() {
        return new MoldovanHen();
    }
}
