package block_8_v3.dao;

import block_8_v3.models.Company;
import block_8_v3.utils.DBconnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {
    public static final String SQL_selectAllCompanies= "SELECT * FROM COMPANIES";
    public static final String SQL_deleteCompany = "DELETE FROM COMPANIES WHERE id = ?";
    public static final String SQL_insertCompany = """
                                        INSERT INTO companies (name, domicile, phone_number) 
                                        Values (?, ?, ?)
                                      """;
    public static final String SQL_deleteAll = "DELETE FROM COMPANIES";

    public static void deleteAll() {
        try{
            Connection con = DBconnector.getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(SQL_deleteAll);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection con = DBconnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_deleteCompany);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Company> findAll() {
        List<Company> companies = new ArrayList<>();
        try{
            Connection con = DBconnector.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL_selectAllCompanies);
            while (rs.next()){
                companies.add(new Company(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return companies;
    }

    public void save(Company company) {
        try{
            Connection con = DBconnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_insertCompany);
            ps.setString(1, company.getName());
            ps.setString(2, company.getDomicile());
            ps.setString(3, company.getPhoneNumber());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
