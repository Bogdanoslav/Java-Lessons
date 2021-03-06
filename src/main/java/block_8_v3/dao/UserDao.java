package block_8_v3.dao;

import block_8_v3.models.User;
import block_8_v3.utils.DBconnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String SQL_insertUser = """
                                                    INSERT INTO users (first_name, last_name, email, gender, company_id)
                                                    Values (?, ?, ?, ?,  SELECT id from companies WHERE id=?)
                                                """;
    private static final String SQL_deleteUser = "DELETE FROM USERS WHERE ID = ?";
    private static final String SQL_deleteAll = "DELETE FROM USERS";
    private static final String SQL_selectUser = "SELECT * FROM USERS WHERE ID = ?";
    private static final String SQL_selectAllUsers = "SELECT * FROM USERS";
    private static final String SQL_SelectAllUsersCompanies = """
                                                                SELECT users.id, users.first_name, users.last_name, companies.name
                                                                FROM users
                                                                JOIN companies ON users.company_id=companies.id;
                                                            """;

    public void delete(int id) {
        try{
            Connection con = DBconnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_deleteUser);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void save(User user) {
        try{
            Connection con = DBconnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_insertUser);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getGender());
            ps.setInt(5, user.getCompanyId());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

   public User findById(int id) {
        User user = null;
        try{
            Connection con = DBconnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_selectUser);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try{
            Connection con = DBconnector.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL_selectAllUsers);
            while (rs.next()){
                users.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public void deleteAll() {
        try{
            Connection con = DBconnector.getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(SQL_deleteAll);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
