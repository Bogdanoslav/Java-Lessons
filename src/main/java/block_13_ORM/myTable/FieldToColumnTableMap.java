package block_13_ORM.myTable;

import java.lang.reflect.Field;

public class FieldToColumnTableMap {
    private Field field;
    private String column;
    private String sqlType;


    public FieldToColumnTableMap(Field field) {
        this.field = field;
        column = OrmAnalyzer.getClassFieldsNames(field);
        sqlType = OrmAnalyzer.getSqlType(field);
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getColumn() {
        return column;
    }

    public Class getType(){
        if(sqlType.equals("int")){
            return Integer.class;
        } else if(sqlType.equals("double")){
            return Double.class;
        }
        return field.getType();
    }
    public String getSqlType() { return sqlType; }
}
