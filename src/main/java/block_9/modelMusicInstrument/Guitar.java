package block_9.modelMusicInstrument;

import block_9.interfaces.MusicInstrumentI;

public class Guitar implements MusicInstrumentI {
    private int stringNumber;

    public Guitar(int stringNumber) {
        this.stringNumber = stringNumber;
    }

    @Override
    public void play() {
        System.out.println("Играет гитара с " + stringNumber + " струнами" + ". В тональности " + KEY);
    }

    public int getStringNumber() {
        return stringNumber;
    }

    public void setStringNumber(int stringNumber) {
        this.stringNumber = stringNumber;
    }
}
