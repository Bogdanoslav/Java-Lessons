package block_13_ORM;
import block_13_ORM.MyTable.FieldToColumnTableMap;
import block_13_ORM.MyTable.MyOrmAnalyzer;
import block_13_ORM.MyTable.Table;
import block_13_ORM.annotations.MyTable;
import block_13_ORM.models.Company;
import block_13_ORM.models.User;
import block_13_ORM.services.CompanyService;
import block_13_ORM.services.TableService;
import block_13_ORM.services.UserService;
import block_13_ORM.utils.CSVManager;
import block_13_ORM.utils.ClassGetter;
import block_13_ORM.utils.ResultSetObjectMapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    private static final String userMockUrl = "src/main/java/block_13_ORM/resources/user_data.csv";
    private static final String companyMockUrl = "src/main/java/block_13_ORM/resources/company_data.csv";

    public static void main(String[] args) throws SQLException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        UserService userService = new UserService();
        CompanyService companyService = new CompanyService();
        TableService tableService = new TableService();
        List<FieldToColumnTableMap> colfieldMaps = new ArrayList<>();
        CSVManager csvManager = new CSVManager();
        String tableName;
        Field[] fields;
        List<User> users;
        List<Company> companies;
        List<String[]> userMock;
        List<String[]> companyMock;

        userMock = csvManager.read(userMockUrl);
        users = dataToUserList(userMock);

        companyMock = csvManager.read(companyMockUrl);
        companies = dataToCompanyList(companyMock);

        ClassGetter classGetter = new ClassGetter("block_13_ORM");
        Set<Class<?>> tableClasses = classGetter.getClasses(MyTable.class);

        for (Class clazz: tableClasses) {
            tableName = MyOrmAnalyzer.getTableName(clazz);
            fields = MyOrmAnalyzer.getClassFields(clazz);
            colfieldMaps = MyOrmAnalyzer.getColfieldMaps(fields);

            Table table = new Table(tableName, colfieldMaps);
            tableService.dropTable(table);
            tableService.createTable(table);
        }

        userService.saveAll(users);
        companyService.saveAll(companies);

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
    public static List<FieldToColumnTableMap>fillColfieldMap(Field[] fields){
        List<FieldToColumnTableMap> fieldToColumnMaps = new ArrayList<>();
        for (Field f: fields) {
            FieldToColumnTableMap ftctm= new FieldToColumnTableMap(f);
            fieldToColumnMaps.add(ftctm);
        }
        return  fieldToColumnMaps;
    }
}
