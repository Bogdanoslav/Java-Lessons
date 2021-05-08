package block_13_ORM.services;

import block_13_ORM.dao.CompanyDao;
import block_13_ORM.dao.UserDao;
import block_13_ORM.models.Company;
import block_13_ORM.models.User;

import java.sql.ResultSet;
import java.util.List;

public class CompanyService {
    CompanyDao companyDao = new CompanyDao();
    public void save(Company company){
        companyDao.save(company);
    }
    public ResultSet getAll(){ return companyDao.getAll(); }
    public void saveAll(List<Company> companies){companyDao.saveAll(companies);}
}
