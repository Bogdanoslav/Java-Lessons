package block_9;

import block_9.interfaces.PrintableI;
import block_9.modelPrintable.Book;
import block_9.modelPrintable.Magazine;

public class PrintableTest {
    public static void main(String[] args) {
        PrintableI[] printable = {
                new Book("Атлант расправил плечи","Айн Рэнд"),
                new Book("Крыжовник","Антон Чехов"),
                new Magazine("3D Artist Magazine",13),
                new Magazine("Шрек", 2),
                new Book("Рассказы","Носов Николай")
        };
        for (PrintableI p:printable) {
            p.print();
        }
        System.out.println("\nТолько журналы");
        Magazine.printMagazines(printable);
        System.out.println("\nТолько книги");
        Book.printBooks(printable);
    }

}
