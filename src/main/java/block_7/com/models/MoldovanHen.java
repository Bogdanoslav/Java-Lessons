package block_7.com.models;

public class MoldovanHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        return 16;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - Молдова. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц";
    }
}
