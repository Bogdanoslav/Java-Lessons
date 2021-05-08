package block_13_ORM.utils;

import block_13_ORM.MyTable.FieldToColumnTableMap;
import block_13_ORM.MyTable.MyOrmAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetObjectMapper {
    public static List<Object> mapResultSet(ResultSet rs, Class clazz) throws SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        List<Object> objects = new ArrayList<>();
        Constructor constructor = clazz.getConstructor();
        List<FieldToColumnTableMap> colfieldMaps = MyOrmAnalyzer.getColfieldMaps(clazz.getDeclaredFields());
        while (rs.next()) {
            Object o = constructor.newInstance();
            for (FieldToColumnTableMap ctMap: colfieldMaps) {
                Field field = ctMap.getField();
                field.setAccessible(true);
                field.set(o, rs.getObject(ctMap.getColumn(), ctMap.getType()));
            }
            objects.add(o);
        }
        return objects;
    }
}
