package block_8_v3.services;

import block_8_v3.dao.UserDao;
import block_8_v3.models.Company;
import block_8_v3.models.User;
import lombok.AllArgsConstructor;

import java.util.List;


public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public User findUser(int id) {
        User user = userDao.findById(id);
        if(user!=null)
            System.out.println("Найденный юзер: " + user);
        else
            System.out.println("Юзер не найден");
        return user;
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
    public void saveAll(List<User> userList) {
        for (User user: userList) {
            userDao.save(user);
        }
    }
    public List<User> findAllUsers() {
        return userDao.findAll();
    }
}
