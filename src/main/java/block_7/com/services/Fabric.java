package block_7.com.services;

import block_7.com.enums.HenType;
import block_7.com.models.*;

public class Fabric {
    public static Hen getHen(HenType type) {
        switch(type) {
            case UKRAINE:
                return new UkrainianHen(22, HenType.UKRAINE);
            case BELARUSSIA:
                return new BelarussianHen(16, HenType.UKRAINE);
            case MOLDOVA:
                return new MoldovanHen(24, HenType.UKRAINE);
            case RUSSIA:
                return new RussianHen(20, HenType.UKRAINE);
            default:
                return null;
        }
    }
}
