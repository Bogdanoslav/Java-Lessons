package block_13_ORM;

import block_13_ORM.models.User;
import block_13_ORM.utils.DBconnector;

import java.sql.*;
import java.util.List;

public interface DaoI<T> {
    public void save(T user);
    void saveAll(List<T> users);
    ResultSet getAll();
}
