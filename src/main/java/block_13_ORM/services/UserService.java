package block_13_ORM.services;

import block_13_ORM.exceptions.SaveNullException;
import block_13_ORM.models.User;
import block_13_ORM.dao.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();
    public void save(User user) throws SQLException {
        if(user==null)
            throw new SaveNullException("Объект User не можеть быть null");
        userDao.save(user);
    }
    public ResultSet getAll() throws SQLException { return userDao.getAll(); }
    public void saveAll(List<User> users) throws SQLException {userDao.saveAll(users);}
}
