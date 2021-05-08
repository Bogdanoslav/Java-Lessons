package block_13_ORM.dao;

import block_13_ORM.DaoI;
import block_13_ORM.models.Company;
import block_13_ORM.utils.DBconnector;

import java.sql.*;
import java.util.List;

public class CompanyDao implements DaoI<Company> {
    private final static String SAVE_COMPANY_SQL = "INSERT INTO COMPANIES (Name, Phone) VALUES(?,?)";
    private final static String SELECT_COMPANIES_SQL = "SELECT * FROM COMPANIES";
    @Override
    public void save(Company company) {
        try {
            Connection con = DBconnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SAVE_COMPANY_SQL);
            ps.setString(1,company.getName());
            ps.setString(2,company.getPhone());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void saveAll(List<Company> companies) {
        for (Company c: companies ) {
            save(c);
        }
    }

    @Override
    public ResultSet getAll() {
        try {
            Connection con = DBconnector.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_COMPANIES_SQL);
            return rs;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
