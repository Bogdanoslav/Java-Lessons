package block_6.com.AnimalModel;

public class Vet {
    public void treatAnimal(Animal animal){
        System.out.println("Животное отправлено на прием. Любимая еда " + animal.getFood() + ". Местонахождение " + animal.getLocation());
    }
}
