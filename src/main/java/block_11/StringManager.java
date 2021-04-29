package block_11;

import java.lang.reflect.Field;

public class StringManager {
    public static String addToString(String str, String add){
        try{
            Class clazz = str.getClass();
            Field hashField = clazz.getDeclaredField("hash");
            hashField.setAccessible(true);
            int hash = str.hashCode();
            str = str.concat(add);
            hashField.set(str,hash);
            return str;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
