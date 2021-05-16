package block_13_ORM.myTable;

public class TableSqlCreator {
    private Table table;

    public TableSqlCreator(Table table) {
        this.table = table;
    }

    public String createNewTableSql(){
        String createTable = "CREATE TABLE IF NOT EXISTS " + table.getTableName() + "(";
        for (int i = 0; i < table.getTableColumnMap().size(); i++){
            createTable+=columnCreator(table.getTableColumnMap().get(i));
            if(i!=table.getTableColumnMap().size()-1)
                createTable+=",";
        }
        createTable+=");";
        return createTable;
    }
    public String createDropTableSql(){
        String dropTable = "DROP TABLE " + table.getTableName();
        return  dropTable;
    }
    public String columnCreator(FieldToColumnTableMap colField){
        String col = colField.getColumn() + " ";
        col += colField.getSqlType() + " ";
        col += "NOT NULL";
        return col;
    }
}
