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
    private static final String userMockUrl = "src/main/java/block_8/resources/userMock.csv";
    private static final String companyMockUrl = "src/main/java/block_8/resources/companyMock.csv";
    private static final String menu = """
                                    \t\t<--- Управление БД --->
                                    \t1) Найти юзера по id
                                    \t2) Вывести всех юзеров
                                    \t3) Вывести все компании
                                    \t4) Удалить юзера по id
                                    \t5) Удалить компанию по id
                                    \t6) Выход
                                    """;

    public static void main(String[] args) {
        DButils dButils = new DButils();
        UserService userService = new UserService();
        CompanyService companyService = new CompanyService();
        CSVManager csvManager = new CSVManager();
        List<String[]> userMock;
        List<String[]> companyMock;
        List<User> userList;
        List<Company> companyList;

        dButils.dropAllObjects();
        dButils.createTableCompanies();
        dButils.createTableUsers();

        userMock = csvManager.read(userMockUrl);
        companyMock = csvManager.read(companyMockUrl);
        userList = mockToListUsers(userMock);
        companyList = mockToListCompanies(companyMock);
        companyService.saveAll(companyList);
        userService.saveAll(userList);

        int choice;
        DButils.MenuOptions optEnum;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(menu);
            System.out.print("Введите номер команды: ");
            choice = scanner.nextInt();
            optEnum = getMenuOption(choice);
            switch (optEnum){
                case FIND_USER ->{
                    int id = askId();
                    userService.findUser(id);
                }
                case FIND_ALL_USERS -> {
                    userList = userService.findAllUsers();
                    printUsers(userList);
                }
                case FIND_ALL_COMPANIES -> {
                    companyList = companyService.findAllCompanies();
                    printCompanies(companyList);
                }
                case DELETE_USER_BY_ID -> {
                    int id = askId();
                    userService.deleteUser(id);
                }
                case DELETE_COMPANY_BY_ID -> {
                    int id = askId();
                    companyService.deleteCompany(id);
                }
                case UNKNOWN ->
                    System.out.println("Неизвестная команда");
                case EXIT ->
                    System.out.println("Программа Завершена");
            }
        }while (choice!=6);
    }
    private static int askId(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("id: ");
        int id = scanner.nextInt();
        return id;
    }
    private static void printCompanies(List<Company> companyList){
        for (Company company: companyList) {
            System.out.println(company);
        }
    }
    private static void printUsers(List<User> userList){
        for (User user: userList) {
            System.out.println(user);
        }
    }
    private static DButils.MenuOptions getMenuOption(int choice){
        DButils.MenuOptions optEnum;
        switch (choice){
            case 1 -> optEnum = DButils.MenuOptions.FIND_USER;
            case 2 -> optEnum = DButils.MenuOptions.FIND_ALL_USERS;
            case 3 -> optEnum = DButils.MenuOptions.FIND_ALL_COMPANIES;
            case 4 -> optEnum = DButils.MenuOptions.DELETE_USER_BY_ID;
            case 5 -> optEnum = DButils.MenuOptions.DELETE_COMPANY_BY_ID;
            case 6 -> optEnum = DButils.MenuOptions.EXIT;
            default -> optEnum = DButils.MenuOptions.UNKNOWN;
        }
        return optEnum;
    }
    private static List<Company> mockToListCompanies(List<String[]> companyMock){
        List<Company> companyList = new ArrayList<>();
        for (int i = 1; i < companyMock.size(); i++) {
            String[] row = companyMock.get(i);
            companyList.add(new Company(row[0],row[1],row[2]));
        }
        return companyList;
    }
    private static List<User> mockToListUsers(List<String[]> userMock){
        List<User> userList = new ArrayList<>();
        for (int i = 1; i < userMock.size(); i++) {
            String[] row = userMock.get(i);
            userList.add(new User(row[0],row[1],row[2],row[3],Integer.parseInt(row[4])));
        }
        return userList;
    }
}
