package block_7.com.models;

public class BelarussianHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        return 17;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - Белоруссия. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц";
    }

}
