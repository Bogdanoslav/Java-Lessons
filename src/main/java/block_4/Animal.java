package block_4;

public class Animal {
    String name;
    String favFood;
    int lifeSpan;
    boolean predator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavFood() {
        return this.favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }

    public int getLifeSpan() {
        return this.lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public boolean isPredator() {
        return this.predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    void eat(){
        System.out.printf("Животное %s ест %s.\n", this.name, this.favFood);
    }
    void findFood(){
        if(this.predator){
            System.out.printf("Животное %s вышло на охоту.\n", this.name);
        } else {
            System.out.printf("Животное %s ищет растительную пищу.\n", this.name);
        }
    }

}
