package block_13_ORM.dao;

import block_13_ORM.interfaces.DaoI;
import block_13_ORM.models.User;
import block_13_ORM.utils.DBConnector;

import java.sql.*;
import java.util.List;

public class UserDao implements DaoI<User> {
    private final static String SAVE_USER_SQL = "INSERT INTO USERS (Name, Age) VALUES(?,?)";
    private final static String SELECT_USERS_SQL = "SELECT * FROM USERS";

    @Override
    public void save(User user) throws SQLException {
        Connection con = DBConnector.getConnection();
        PreparedStatement ps = con.prepareStatement(SAVE_USER_SQL);
        ps.setString(1, user.getName());
        ps.setInt(2, user.getAge());
        ps.executeUpdate();
    }

    @Override
    public void saveAll(List<User> users) throws SQLException {
        for (User user : users) {
            save(user);
        }
    }

    @Override
    public ResultSet getAll() throws SQLException {
        Connection con = DBConnector.getConnection();
        Statement statement = con.createStatement();
        return statement.executeQuery(SELECT_USERS_SQL);
    }
}
