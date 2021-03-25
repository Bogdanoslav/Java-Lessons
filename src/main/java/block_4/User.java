package block_4;

public class User {
    int id;
    String name;
    int age;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void logIn(){
        System.out.printf("Пользователь %s вошел.\n", this.name);
    }
    void logOut(){
        System.out.printf("Пользователь %s вышел.\n", this.name);
    }
}
