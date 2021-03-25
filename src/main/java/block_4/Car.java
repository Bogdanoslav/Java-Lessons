package block_4;

public class Car {

    String model;
    int speed;
    String color;

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    void startEngine(){
        System.out.println("Двагатель заведен.");
    }
    void stopEngine(){
        System.out.println("Двагатель остановлен.");
    }
}
