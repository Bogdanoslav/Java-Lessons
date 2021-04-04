package block_7.com.models;

import block_7.com.enums.HenType;

public class UkrainianHen extends Hen{

    public UkrainianHen(int countOfEggsPerMonth, HenType henType) {
        super(countOfEggsPerMonth, henType);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - Укрина. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц";
    }
}
