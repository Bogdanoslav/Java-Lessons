package block_6.com;

import block_6.com.AnimalModel.*;

public class AnimalTest {
    public static void main(String[] args) {
        Animal[] vetQueue = {
                new Cat("Огурцы", "Дом", false),
                new Dog("Каша", "Улица", true),
                new Horse("Овес","Иподром","Вороная")
        };

        Vet vet = new Vet();

        for (Animal animal: vetQueue) {
            vet.treatAnimal(animal);
        }
    }
}
