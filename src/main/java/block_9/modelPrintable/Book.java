package block_9.modelPrintable;

import block_9.interfaces.PrintableI;

public class Book implements PrintableI {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    @Override
    public void print() {
        System.out.println("Книга. Название: \"" + name + "\". Автор: " + author);
    }
    public static void printBooks(PrintableI[] printable){
        for (PrintableI p:printable) {
            if(p instanceof Book){
                p.print();
            }
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
