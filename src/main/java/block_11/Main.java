package block_11;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        int hash1, hash2;
        String str1 = "Все-таки строки изменяемы";
        hash1 = str1.hashCode();
        str1 = StringManager.addToString(str1,"почти");
        hash2 = str1.hashCode();
        System.out.println(hash1==hash2);

        Class userClass = Class.forName(User.class.getName());
        User userDef = (User) userClass.getDeclaredConstructor().newInstance();
        User userFull = (User) userClass.getDeclaredConstructor(String.class, int.class).newInstance("Valya",22);
        System.out.println(userDef);
        System.out.println(userFull);
        Field userName = userClass.getDeclaredField("name");
        userName.setAccessible(true);
        userName.set(userDef,"Денчик");
        Field userAge = userClass.getDeclaredField("age");
        userAge.setAccessible(true);
        userAge.set(userDef,3);
        System.out.println("default user after-->");
        System.out.println(userDef);
    }
}
