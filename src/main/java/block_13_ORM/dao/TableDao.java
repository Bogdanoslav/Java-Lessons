package block_13_ORM.dao;

import block_13_ORM.MyTable.Table;
import block_13_ORM.MyTable.TableSqlCreator;
import block_13_ORM.utils.DBconnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableDao {
    public void create(Table table) {
        try {
            Connection con = DBconnector.getConnection();
            Statement statement = con.createStatement();
            TableSqlCreator tableSqlCreator = new TableSqlCreator(table);
            statement.executeUpdate(tableSqlCreator.createNewTableSql());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void drop(Table table){
        try{
            Connection con = DBconnector.getConnection();
            Statement statement = con.createStatement();
            TableSqlCreator tableSqlCreator = new TableSqlCreator(table);
            statement.executeUpdate(tableSqlCreator.createDropTableSql());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
