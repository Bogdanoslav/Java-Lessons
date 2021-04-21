package block_9;

import block_9.interfaces.MusicInstrumentI;
import block_9.modelMusicInstrument.Drums;
import block_9.modelMusicInstrument.Guitar;
import block_9.modelMusicInstrument.Trumpet;

public class MusicInstrumentTest {
    public static void main(String[] args) {
        MusicInstrumentI[] miArr = {
                new Guitar(6),
                new Drums(22),
                new Drums(15),
                new Guitar(7),
                new Trumpet(5),
                new Trumpet(10)
        };
        for(MusicInstrumentI mi: miArr){
            mi.play();
        }
    }
}
