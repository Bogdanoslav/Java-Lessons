package block_8_v3;

import block_8_v3.models.Company;
import block_8_v3.models.User;
import block_8_v3.services.CompanyService;
import block_8_v3.services.UserService;
import block_8_v3.utils.CSVManager;
import block_8_v3.utils.DButils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String userMockUrl = "src/main/java/block_8/resources/userMock.csv";
    public static final String companyMockUrl = "src/main/java/block_8/resources/companyMock.csv";
    public static final String menu = """
                                    \t\t<--- Управление БД --->
                                    \t1) Найти юзера по id
                                    \t2) Вывести всех юзеров
                                    \t3) Вывести все компании
                                    \t4) Удалить юзера по id
                                    \t5) Удалить компанию по id
                                    \t6) Выход
                                    """;

    public static void main(String[] args) {
    //<---- region Setting DB --->
        DButils dButils = new DButils();
        UserService userService = new UserService();
        CompanyService companyService = new CompanyService();
        CSVManager csvManager = new CSVManager();

        dButils.dropAllObjects();
        dButils.createTableCompanies();
        dButils.createTableUsers();

        List<String[]> userMock = csvManager.read(userMockUrl);
        List<String[]> companyMock = csvManager.read(companyMockUrl);
        List<User> userList = new ArrayList<>();
        List<Company> companyList = new ArrayList<>();

        for (int i = 1; i < userMock.size(); i++) {
            String[] row = userMock.get(i);
            userList.add(new User(row[0],row[1],row[2],row[3],Integer.parseInt(row[4])));
        }
        for (int i = 1; i < companyMock.size(); i++) {
            String[] row = companyMock.get(i);
            companyList.add(new Company(row[0],row[1],row[2]));
        }
        for (Company value : companyList) {
            companyService.save(value);
        }
        for (User value : userList) {
            userService.save(value);
        }
    //<--- regionend Setting DB --->
        User user;
        int opt;
        int id;
        DButils.MenuOptions optEnum;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(menu);
            System.out.print("Введите номер команды: ");
            opt = scanner.nextInt();
            switch (opt){
                case 1 -> optEnum = DButils.MenuOptions.FIND_USER;
                case 2 -> optEnum = DButils.MenuOptions.FIND_ALL_USERS;
                case 3 -> optEnum = DButils.MenuOptions.FIND_ALL_COMPANIES;
                case 4 -> optEnum = DButils.MenuOptions.DELETE_USER_BY_ID;
                case 5 -> optEnum = DButils.MenuOptions.DELETE_COMPANY_BY_ID;
                case 6 -> optEnum = DButils.MenuOptions.EXIT;
                default -> optEnum = DButils.MenuOptions.UNKNOWN;
            }
            switch (optEnum){
                case FIND_USER ->{
                        System.out.print("id: ");
                        id = scanner.nextInt();
                        user = userService.findUser(id);
                        if(user!=null)
                            System.out.println("Найденный юзер: " + user);
                        else
                            System.out.println("Юзер не найден");
                }
                case FIND_ALL_USERS -> {
                    userList = userService.findAllUsers();
                    for (User u: userList) {
                        System.out.println(u);
                    }
                }
                case FIND_ALL_COMPANIES -> {
                    companyList = companyService.findAllCompanies();
                    for (Company company: companyList) {
                        System.out.println(company);
                    }
                }
                case DELETE_USER_BY_ID -> {
                    System.out.print("id: ");
                    id = scanner.nextInt();
                    userService.deleteUser(id);
                }
                case DELETE_COMPANY_BY_ID -> {
                    System.out.print("id: ");
                    id = scanner.nextInt();
                    companyService.deleteCompany(id);
                }
                case UNKNOWN ->
                    System.out.println("Неизвестная команда");
                case EXIT ->
                    System.out.println("Программа Завершена");
            }
        }while (opt!=6);
    }
}
