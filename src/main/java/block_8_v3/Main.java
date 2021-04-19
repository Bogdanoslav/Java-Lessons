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
        DButils dButils = new DButils();
        UserService userService = new UserService();
        CompanyService companyService = new CompanyService();
        CSVManager csvManager = new CSVManager();

        dButils.dropAllObjects();
        dButils.createTableCompanies();
        dButils.createTableUsers();

        List<String[]> userMock = csvManager.read(userMockUrl);
        List<String[]> companyMock = csvManager.read(companyMockUrl);
        List<User> userList = mockToListUsers(userMock);
        List<Company> companyList = mockToListCompanies(companyMock);
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
                    userService.findUser(askId());
                }
                case FIND_ALL_USERS -> {
                    printUsers(userService.findAllUsers());
                }
                case FIND_ALL_COMPANIES -> {
                    printCompanies(companyService.findAllCompanies());
                }
                case DELETE_USER_BY_ID -> {
                    userService.deleteUser(askId());
                }
                case DELETE_COMPANY_BY_ID -> {
                    companyService.deleteCompany(askId());
                }
                case UNKNOWN ->
                    System.out.println("Неизвестная команда");
                case EXIT ->
                    System.out.println("Программа Завершена");
            }
        }while (choice!=6);
    }
    public static int askId(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("id: ");
        int id = scanner.nextInt();
        return id;
    }
    public static void printCompanies(List<Company> companyList){
        for (Company company: companyList) {
            System.out.println(company);
        }
    }
    public static void printUsers(List<User> userList){
        for (User user: userList) {
            System.out.println(user);
        }
    }
    public static DButils.MenuOptions getMenuOption(int choice){
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
    public static List<Company> mockToListCompanies(List<String[]> companyMock){
        List<Company> companyList = new ArrayList<>();
        for (int i = 1; i < companyMock.size(); i++) {
            String[] row = companyMock.get(i);
            companyList.add(new Company(row[0],row[1],row[2]));
        }
        return companyList;
    }
    public static List<User> mockToListUsers(List<String[]> userMock){
        List<User> userList = new ArrayList<>();
        for (int i = 1; i < userMock.size(); i++) {
            String[] row = userMock.get(i);
            userList.add(new User(row[0],row[1],row[2],row[3],Integer.parseInt(row[4])));
        }
        return userList;
    }
}
