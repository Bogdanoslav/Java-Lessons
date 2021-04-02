package block_6.com.PhoneModel;

public class Phone {
    private int number;
    private String model;
    private int weight;

    public Phone(int number, String model, int weight) {
        this(number, model);
        this.weight = weight;
    }
    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
        this.weight = 300;
    }
    public Phone() {
        this.number = 0;
        this.model = "test";
        this.weight = 0;
    }

    public int getNumber() {
        return number;
    }

    public void receiveCall(String name){
        System.out.println("Звонит " + name);
    }
    public void receiveCall(String name, int number){
        System.out.println("Звонит " + name + " " + number);
    }
    public void sendMessage(int...numbers){
        for(int number:numbers){
            System.out.println(number);
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }
}
