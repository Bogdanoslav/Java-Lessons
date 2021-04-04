package block_7.com.models;

import block_7.com.enums.HenType;

public class RussianHen extends Hen{
    public RussianHen(int countOfEggsPerMonth, HenType henType) {
        super(countOfEggsPerMonth, henType);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - Россия. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц";
    }
}
