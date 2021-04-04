package block_7.com.models;

import block_7.com.enums.HenType;

public class BelarussianHen extends Hen{

    public BelarussianHen(int countOfEggsPerMonth, HenType henType) {
        super(countOfEggsPerMonth, henType);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - Белоруссия. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц";
    }

}
