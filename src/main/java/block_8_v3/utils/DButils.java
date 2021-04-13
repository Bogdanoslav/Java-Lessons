package block_8_v3.utils;

import block_8_v3.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DButils {
    public enum MenuOptions{
        FIND_USER_BY_ID,
        DELETE_USER_BY_ID,
        FIND_USER,
        FIND_ALL_USERS,
        DELETE_COMPANY_BY_ID,
        FIND_COMPANY,
        FIND_ALL_COMPANIES,
        UNKNOWN,
        EXIT
    }
    public static final String SQL_createTableUsers =   """
                                    CREATE TABLE IF NOT EXISTS users(
                                    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                    first_name varchar(35) NOT NULL,
                                    last_name varchar(35) NOT NULL,
                                    email varchar(254) NOT NULL,
                                    gender char (1) NOT NULL,
                                    company_id int NULL,
                                    FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE SET NULL)
                                    """;

    public static final String SQL_createTableCompanies =   """
                                        CREATE TABLE IF NOT EXISTS companies(
                                        id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                        name varchar(35) NOT NULL,
                                        domicile varchar(35) NOT NULL,
                                        phone_number varchar(15) NOT NULL)
                                        """;
    public static final String SQL_dropAllObject="DROP ALL OBJECTS";

    public void createTableUsers(){
        try(Connection con = DBconnector.getConnection();
            Statement statement = con.createStatement())
        {
            statement.execute(SQL_createTableUsers);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void createTableCompanies(){
        try(Connection con = DBconnector.getConnection();
            Statement statement = con.createStatement())
        {
            statement.execute(SQL_createTableCompanies);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void dropAllObjects(){
        try (Connection con = DBconnector.getConnection();
        Statement statement = con.createStatement()){
            statement.executeUpdate(SQL_dropAllObject);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
