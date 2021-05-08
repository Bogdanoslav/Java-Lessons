package block_13_ORM.MyTable;

import java.util.List;

public class Table {
    private String tableName;
    private List<FieldToColumnTableMap> tableColumnMap;



    public Table(String tableName, List<FieldToColumnTableMap> tableColumnMap) {
        this.tableName = tableName;
        this.tableColumnMap = tableColumnMap;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<FieldToColumnTableMap> getTableColumnMap() {
        return tableColumnMap;
    }

    public void setTableColumnMap(List<FieldToColumnTableMap> tableColumnMap) {
        this.tableColumnMap = tableColumnMap;
    }

}
