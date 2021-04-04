package block_7.com.models;

import block_7.com.enums.HenType;

public class MoldovanHen extends Hen{


    public MoldovanHen(int countOfEggsPerMonth, HenType henType) {
        super(countOfEggsPerMonth, henType);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - Молдова. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц";
    }
}
