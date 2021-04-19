package block_8_v3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBconnector {
        static Connection connection;
        static String url = "jdbc:h2:~/user_management;AUTO_SERVER=TRUE";
        static String username = "sa";
        static String password = "sa";

        private  DBconnector(){

        }

        public static Connection getConnection() throws SQLException {
            if(connection==null){
                connection = DriverManager.getConnection(url, username, password);
            }
            return connection;
        }
}
