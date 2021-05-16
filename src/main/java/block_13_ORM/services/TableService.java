package block_13_ORM.services;

import block_13_ORM.myTable.Table;
import block_13_ORM.dao.TableDao;

public class TableService {
    TableDao tableDao = new TableDao();

    public void createTable(Table table){
        tableDao.create(table);
    }
    public void dropTable(Table table) {tableDao.drop(table);}
}
