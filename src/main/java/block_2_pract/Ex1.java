package block_2_pract;

public class Ex1 {
    public static void main(String[] args) {
        for(int i = 0;  i < 10; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        int i = 0;
        while(i++ < 10){
            System.out.print(i + " ");
        }
        System.out.println();
        int a = 3;
        int b = ++a + ++a + a++ + a--; // 4 + 5 + 5 + 6
        System.out.println(b);
        System.out.println(a);
        for(int j = 0;  j < 10; j++){
            if(j%2==0){
                break;
            }
            System.out.println(j);
        }

        String myApril = "Апрель";
        String myMarch = "Март";

        switch (myMarch){
            case "Декабрь":
                System.out.println("Зима");
                break;
            case "Март":
            case "Апрель":
                System.out.println("Весна");
                break;
        }
    }
}
