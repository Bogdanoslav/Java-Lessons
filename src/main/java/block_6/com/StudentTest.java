package block_6.com;

import block_6.com.UserModel.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student studentBoris = new Student("Boris", 18, 1189, 1);
        System.out.println("Стипендия студента " + studentBoris.getName() + " составляет " + studentBoris.getScholarship() + " грн.");
    }
}
