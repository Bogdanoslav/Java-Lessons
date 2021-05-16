package block_13_ORM.myTable;

import java.lang.reflect.Field;
import java.util.List;

public class ClassToTableMapper {
    public static Table mapClassToTable(Class clazz){
        String tableName = OrmAnalyzer.getTableName(clazz);
        Field[] fields = OrmAnalyzer.getClassFields(clazz);
        List<FieldToColumnTableMap> colfieldMaps = OrmAnalyzer.getColfieldMaps(fields);
        return new Table(tableName, colfieldMaps);
    }
}
