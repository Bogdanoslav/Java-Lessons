package block_9.modelMusicInstrument;

import block_9.interfaces.MusicInstrumentI;

public class Trumpet implements MusicInstrumentI {
    private int diameter;

    public Trumpet(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public void play() {
        System.out.println("Играет труба с диаметром " + diameter + ". В тональности " + KEY);
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
