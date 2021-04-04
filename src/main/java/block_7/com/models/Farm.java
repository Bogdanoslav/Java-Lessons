package block_7.com.models;

public abstract class Farm {
    public enum FarmType{
        UKRAINE,
        MOLDOVA,
        BELARUSSIA,
        RUSSIAN
    }
    public String collectEggs(){
        IHen hen = createHen();
        return hen.getDescription();
    }
    abstract Hen createHen();
}
