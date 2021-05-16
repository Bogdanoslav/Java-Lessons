package block_13_ORM.myTable;

import block_13_ORM.annotations.MyColumn;
import block_13_ORM.annotations.MyTable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class OrmAnalyzer {
    public static String getTableName(Class clazz){
        MyTable myTable = (MyTable) clazz.getAnnotation(MyTable.class);
        return myTable.name();
    }
    public static Field[] getClassFields(Class clazz){
        return clazz.getDeclaredFields();
    }
    public static String getClassFieldsNames(Field field){
        return field.getAnnotation(MyColumn.class).name();
    }
    public static String getStringType(Field field){
        String[] typeSplit = field.getType().getTypeName().split("\\.");
        return typeSplit[typeSplit.length-1];
    }
    public static String getSqlType(Field field){
        String sqlType = "";
        String javaType = getStringType(field);
        switch (javaType){
            case "String":
                sqlType = "varchar(255)";
                break;
            case "int":
                sqlType = "int";
                break;
            case "double":
                sqlType = "double";
                break;
        }
        return sqlType;
    }
    public static List<FieldToColumnTableMap> getColfieldMaps(Field[] fields){
        List<FieldToColumnTableMap> fieldToColumnMaps = new ArrayList<>();
        for (Field f: fields) {
            FieldToColumnTableMap ftctm= new FieldToColumnTableMap(f);
            fieldToColumnMaps.add(ftctm);
        }
        return fieldToColumnMaps;
    }
}
