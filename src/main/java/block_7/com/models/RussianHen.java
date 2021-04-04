package block_7.com.models;

public class RussianHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        return 23;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - Россия. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц";
    }
}
