package block_9.modelPrintable;

import block_9.interfaces.PrintableI;

public class Magazine implements PrintableI {
    private String name;
    private int issue;

    public Magazine(String name, int issue) {
        this.name = name;
        this.issue = issue;
    }

    @Override
    public void print() {
        System.out.println("Журнал. Название: \"" + name + "\". Номер: " + issue);
    }
    public static void printMagazines(PrintableI[] printable){
        for (PrintableI p:printable) {
            if(p instanceof Magazine){
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

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }
}
