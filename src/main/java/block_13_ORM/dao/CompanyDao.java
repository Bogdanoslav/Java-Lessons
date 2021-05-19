package block_13_ORM.dao;

import block_13_ORM.exceptions.SaveNullException;
import block_13_ORM.interfaces.DaoI;
import block_13_ORM.models.Company;
import block_13_ORM.utils.DBConnector;

import java.sql.*;
import java.util.List;

public class CompanyDao implements DaoI<Company> {
    private final static String SAVE_COMPANY_SQL = "INSERT INTO COMPANIES (Name, Phone) VALUES(?,?)";
    private final static String SELECT_COMPANIES_SQL = "SELECT * FROM COMPANIES";
    @Override
    public void save(Company company) throws SQLException {
            Connection con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SAVE_COMPANY_SQL);
            try{
                ps.setString(1,company.getName());
                ps.setString(2,company.getPhone());
            } catch (Exception e){
                throw new SaveNullException("Cannot save null object to database");
            }
            ps.executeUpdate();
    }

    @Override
    public void saveAll(List<Company> companies) throws SQLException {
        for (Company c: companies ) {
            save(c);
        }
    }

    @Override
    public ResultSet getAll() {
        try {
            Connection con = DBConnector.getConnection();
            Statement statement = con.createStatement();
            return statement.executeQuery(SELECT_COMPANIES_SQL);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
