package block_13_ORM.dao;

import block_13_ORM.DaoI;
import block_13_ORM.models.User;
import block_13_ORM.utils.DBconnector;

import java.sql.*;
import java.util.List;

public class UserDao implements DaoI<User> {
    private final static String SAVE_USER_SQL = "INSERT INTO USERS (Name, Age) VALUES(?,?)";
    private final static String SELECT_USERS_SQL = "SELECT * FROM USERS";
    @Override
    public void save(User user) {
        try {
            Connection con = DBconnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SAVE_USER_SQL);
            ps.setString(1,user.getName());
            ps.setInt(2,user.getAge());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void saveAll(List<User> users){
        for (User user: users) {
            save(user);
        }
    }
    @Override
    public ResultSet getAll(){
        try {
            Connection con = DBconnector.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_USERS_SQL);
            return rs;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
