package block_13_ORM.services;

import block_13_ORM.dao.CompanyDao;
import block_13_ORM.exceptions.SaveNullException;
import block_13_ORM.models.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CompanyService {
    CompanyDao companyDao = new CompanyDao();
    public void save(Company company) throws SQLException {
        if(company==null)
            throw new SaveNullException("Объект Company не можеть быть null");
        companyDao.save(company);
    }
    public ResultSet getAll() throws SQLException { return companyDao.getAll(); }
    public void saveAll(List<Company> companies) throws SQLException {companyDao.saveAll(companies);}
}
