package block_13_ORM.services;

import block_13_ORM.myTable.Table;
import block_13_ORM.dao.TableDao;

import java.sql.SQLException;

public class TableService {
    TableDao tableDao = new TableDao();

    public void createTable(Table table) throws SQLException {
        tableDao.create(table);
    }
    public void dropTable(Table table) throws SQLException {tableDao.drop(table);}
}
