package block_13_ORM;
import block_13_ORM.exceptions.ReadCsvException;
import block_13_ORM.myTable.ClassToTableMapper;
import block_13_ORM.myTable.Table;
import block_13_ORM.annotations.MyTable;
import block_13_ORM.models.Company;
import block_13_ORM.models.User;
import block_13_ORM.services.CompanyService;
import block_13_ORM.services.TableService;
import block_13_ORM.services.UserService;
import block_13_ORM.utils.CSVManager;
import block_13_ORM.utils.ClassGetter;
import block_13_ORM.utils.ResultSetObjectMapper;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    private static final String userMockUrl = "src/main/java/block_13_ORM/resources/user_data.cslv";
    private static final String companyMockUrl = "src/main/java/block_13_ORM/resources/company_data.clsv";

    public static void main(String[] args) throws SQLException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        UserService userService = new UserService();
        CompanyService companyService = new CompanyService();
        TableService tableService = new TableService();
        CSVManager csvManager = new CSVManager();
        List<String[]> userMock;
        List<String[]> companyMock;
        try {
            userMock = csvManager.read(userMockUrl);
        } catch (ReadCsvException e){
            userMock = new ArrayList<>();
            userMock.add(new String[] {"Peter", "103"});
        }
        try {
            companyMock = csvManager.read(companyMockUrl);
        } catch (ReadCsvException e){
            companyMock = new ArrayList<>();
            companyMock.add(new String[] {"Snaptags", "496-655-3842"});
        }
        List<User> users = dataToUserList(userMock);
        List<Company> companies = dataToCompanyList(companyMock);

        ClassGetter classGetter = new ClassGetter("block_13_ORM");
        Set<Class<?>> tableClasses = classGetter.getClasses(MyTable.class);

        for (Class clazz: tableClasses) {
            Table table = ClassToTableMapper.mapClassToTable(clazz);
            tableService.dropTable(table);
            tableService.createTable(table);
        }

        userService.saveAll(users);
        companyService.saveAll(companies);

        //SaveNullException
        //userService.save(null);

        ResultSet rs = userService.getAll();
        users = (List<User>)(Object) ResultSetObjectMapper.mapResultSet(rs,User.class);
        printAllObjects((List<Object>)(Object)users);

        rs = companyService.getAll();
        companies = (List<Company>)(Object) ResultSetObjectMapper.mapResultSet(rs,Company.class);
        printAllObjects((List<Object>)(Object)companies);
    }
    public static List<User> dataToUserList(List<String[]> userMock){
        List<User> users = new ArrayList<>();
        for (String[] row: userMock) {
            User user = new User(row[0], Integer.parseInt(row[1]));
            users.add(user);
        }
        return users;
    }
    public static List<Company> dataToCompanyList(List<String[]> userMock){
        List<Company> companies = new ArrayList<>();
        for (String[] row: userMock) {
            Company companie = new Company(row[0], row[1]);
            companies.add(companie);
        }
        return companies;
    }
    public static void printAllObjects(List<Object> objs){
        for (Object obj: objs) {
            System.out.println(obj);
        }
    }

}
