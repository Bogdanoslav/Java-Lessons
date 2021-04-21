package block_9.modelMusicInstrument;

import block_9.interfaces.MusicInstrumentI;

public class Drums implements MusicInstrumentI {
    private int size;

    public Drums(int size) {
        this.size = size;
    }

    @Override
    public void play() {
        System.out.println("Играет барабан размера " + size + ". В тональности " + KEY);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
