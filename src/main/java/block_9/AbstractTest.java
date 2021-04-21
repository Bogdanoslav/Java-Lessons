package block_9;

import block_9.modelShape.Rectangle;
import block_9.abstractClasses.Shape;
import block_9.modelShape.Triangle;
import block_9.modelUser.Employee;
import block_9.modelUser.Student;
import block_9.abstractClasses.User;

public class AbstractTest {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(3,4);
        Shape triangle = new Triangle(3,4,5);

        System.out.println(rectangle);
        System.out.println(triangle);

        User[] userArr = {new Student("Tolik","Mechnikova"), new Employee("Lisa", "VAZ")};
        for (User user: userArr){
            user.greet();
        }

    }
}
