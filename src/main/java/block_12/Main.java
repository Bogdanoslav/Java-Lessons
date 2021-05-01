package block_12;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        MyClass myClass = new MyClass();
        Class clazz = myClass.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            Number numberAnnotation = field.getAnnotation(Number.class);
            sum+=numberAnnotation.value();
        }
        System.out.println("Сумма = " + sum);

        //2) объясни пожалуйста почему если у меня есть метод с аннотацией @Override
        //то в случае если я попробую с помощью рефлексии проанализировать эту анотацию - то я получу null?
        //MyClass.class.getMethod("xxxxxxx").getAnnotation(Override.class) <<<< null

        //Ответ: Потому что аннтоация override хранится только на этапе source.
    }
}
