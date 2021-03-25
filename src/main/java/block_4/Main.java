package block_4;

public class Main {
    public static void main(String[] args) {
        Animal cow = new Animal();
        cow.setName("Корова");
        cow.setFavFood("Сено");
        cow.setLifeSpan(16);
        cow.setPredator(false);

        Animal wolf = new Animal();
        wolf.setName("Волк");
        wolf.setFavFood("Мясо");
        wolf.setLifeSpan(14);
        wolf.setPredator(true);

        cow.findFood();
        cow.eat();

        System.out.println();

        wolf.findFood();
        wolf.eat();

        User user = new User();
        user.setId(1);
        user.setName("Boris");
        user.setAge(21);
        System.out.println();
        System.out.printf("id: %d    Имя: %s     Возраст: %d\n", user.getId(), user.getName(), user.getAge());

        Car car = new Car();
        car.setModel("Volkswagen");
        car.setColor("Синий");
        car.setSpeed(220);

        System.out.println();
        System.out.printf("Модель: %s    Цвет: %s     Максимальная скорость: %d\n", car.getModel(), car.getColor(), car.getSpeed());
    }
}
