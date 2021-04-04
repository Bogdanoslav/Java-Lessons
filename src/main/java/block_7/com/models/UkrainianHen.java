package block_7.com.models;

public class UkrainianHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        return 27;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - Укрина. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц";
    }
}
