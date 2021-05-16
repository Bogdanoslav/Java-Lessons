package block_13_ORM.dao;

import block_13_ORM.myTable.Table;
import block_13_ORM.myTable.TableSqlCreator;
import block_13_ORM.utils.DBConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableDao {
    public void create(Table table) {
        try {
            Connection con = DBConnector.getConnection();
            Statement statement = con.createStatement();
            TableSqlCreator tableSqlCreator = new TableSqlCreator(table);
            statement.executeUpdate(tableSqlCreator.createNewTableSql());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void drop(Table table){
        try{
            Connection con = DBConnector.getConnection();
            Statement statement = con.createStatement();
            TableSqlCreator tableSqlCreator = new TableSqlCreator(table);
            statement.executeUpdate(tableSqlCreator.createDropTableSql());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
