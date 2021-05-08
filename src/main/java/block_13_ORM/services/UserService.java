package block_13_ORM.services;

import block_13_ORM.models.User;
import block_13_ORM.dao.UserDao;

import java.sql.ResultSet;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();
    public void save(User user){
        userDao.save(user);
    }
    public ResultSet getAll(){ return userDao.getAll(); }
    public void saveAll(List<User> users){userDao.saveAll(users);}
}
