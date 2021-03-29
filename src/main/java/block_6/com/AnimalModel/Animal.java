package block_6.com.AnimalModel;

public class Animal {
    protected String food;
    protected String location;

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void makeNoise(){
        System.out.println("Животное издало звук");
        //System.out.println(name + " делает " + voice);
    }
    public void eat(){
        System.out.println("Животное ест");
        //System.out.println("Любимая пища " + name +  " - это " + voice);
    }
    public void sleep(){
        System.out.println("Животное спит...");
        //System.out.println(name + " спит...");
    }
}
