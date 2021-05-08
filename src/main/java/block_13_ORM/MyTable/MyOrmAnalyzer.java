package block_13_ORM.MyTable;

import block_13_ORM.annotations.MyColumn;
import block_13_ORM.annotations.MyTable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyOrmAnalyzer {
    public static String getTableName(Class clazz){
        MyTable myTable = (MyTable) clazz.getAnnotation(MyTable.class);
        String tableName = myTable.name();
        return tableName;
    }
    public static Field[] getClassFields(Class clazz){
        Field[] fields = clazz.getDeclaredFields();
        return  fields;
    }
    public static String getClassFieldsNames(Field field){
        String name = field.getAnnotation(MyColumn.class).name();
        return name;
    }
    public static String getStringType(Field field){
        String[] typeSplit = field.getType().getTypeName().split("\\.");
        String type= typeSplit[typeSplit.length-1];
        return type;
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
