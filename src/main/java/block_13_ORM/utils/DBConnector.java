package block_13_ORM.utils;

import block_13_ORM.exceptions.DBConnectionError;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection;
    private static String url = "jdbc:h2:~/user_management;AUTO_SERVER=TRUE";
    private static String username = "sa";
    private static String password = "sa";
    //DBAccessError
    //private static String password = "a";

    private DBConnector() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                throw new DBConnectionError("Can't connect to Database. Check your password, username or url ", e);
            }
        }
        return connection;
    }
}
