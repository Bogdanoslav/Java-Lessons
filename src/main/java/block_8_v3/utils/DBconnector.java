package block_8_v3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBconnector {
        public static Connection getConnection() throws SQLException {
            String url = "jdbc:h2:~/user_management;AUTO_SERVER=TRUE";
            String username = "sa";
            String password = "sa";
            return DriverManager.getConnection(url, username, password);
        }
}
