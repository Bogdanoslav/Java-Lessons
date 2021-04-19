package block_8_v3.services;

import block_8_v3.dao.CompanyDao;
import block_8_v3.dao.UserDao;
import block_8_v3.models.Company;
import block_8_v3.models.User;

import java.util.List;

public class CompanyService {
    private CompanyDao companyDao = new CompanyDao();

    public void deleteCompany(int id) {
        companyDao.delete(id);
    }
    public void deleteAll() {
        CompanyDao.deleteAll();
    }
    public List<Company> findAllCompanies() {
        return companyDao.findAll();
    }

    public void save(Company company) {
        companyDao.save(company);
    }
    public void saveAll(List<Company> companyList) {
        for (Company company: companyList) {
            companyDao.save(company);
        }
    }
}
