package block_7.com.models;

import block_7.com.enums.HenType;

public class Hen{
    HenType henType;
    int countOfEggsPerMonth;
    public Hen(int countOfEggsPerMonth, HenType henType){
        this.henType = henType;
        this.countOfEggsPerMonth = countOfEggsPerMonth;
    }
    public int getCountOfEggsPerMonth(){
      return countOfEggsPerMonth;
    }
    public String getDescription(){
        return "Я курица";
    }
}
