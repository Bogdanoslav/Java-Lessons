package block_8_v3.services;

import block_8_v3.dao.UserDao;
import block_8_v3.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class UserService {
    private UserDao userDao = new UserDao();

    public User findUser(int id) {
        return userDao.findById(id);
    }
    public void deleteUser(int id) {
        userDao.delete(id);
    }
    public void deleteAll() {
        userDao.deleteAll();
    }
    public void save(User user) {
        userDao.save(user);
    }
    public List<User> findAllUsers() {
        return userDao.findAll();
    }
}
