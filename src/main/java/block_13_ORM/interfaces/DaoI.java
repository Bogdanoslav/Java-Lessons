package block_13_ORM.interfaces;

import java.sql.*;
import java.util.List;

public interface DaoI<T> {
    void save(T user) throws SQLException;
    void saveAll(List<T> users) throws SQLException;
    ResultSet getAll() throws SQLException;
}
