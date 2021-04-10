package block_8;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class H2Test {
    public static void main(String[] args) {
        String url = "jdbc:h2:~/user_management";
        String username = "sa";
        String password = "sa";
        String userMockUrl = "src/main/java/block_8/resources/userMock.csv";
        String companyMockUrl = "src/main/java/block_8/resources/companyMock.csv";

        String createTableUsers =   """
                                    CREATE TABLE IF NOT EXISTS users(
                                    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                    first_name varchar(35) NOT NULL,
                                    last_name varchar(35) NOT NULL,
                                    email varchar(254) NOT NULL,
                                    gender char (1) NOT NULL,
                                    company_id int NULL,
                                    FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE SET NULL)
                                    """;

        String createTableCompanies =   """
                                        CREATE TABLE IF NOT EXISTS companies(
                                        id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                        name varchar(35) NOT NULL,
                                        domicile varchar(35) NOT NULL,
                                        phone_number varchar(15) NOT NULL)
                                        """;

        String insertQueryUsers = """
                                    INSERT INTO users (first_name, last_name, email, gender, company_id)
                                    Values (?, ?, ?, ?,  SELECT id from companies WHERE id=?)
                                   """;

        String insertQueryCompanies = """
                                        INSERT INTO companies (name, domicile, phone_number) 
                                        Values (?, ?, ?)
                                      """;

        try(Connection con = DriverManager.getConnection(url,username, password);
            Statement statement = con.createStatement())
        {
            //Создание таблиц если их нет
            statement.execute(createTableCompanies);
            statement.execute(createTableUsers);

            //Чтение Mock-а
            CSVReader csvR= new CSVReader(new FileReader(userMockUrl));
            List<String[]> userMock = csvR.readAll();
            csvR= new CSVReader(new FileReader(companyMockUrl));
            List<String[]> companyMock = csvR.readAll();
            csvR.close();

            //Заполнение таблицы Mock-ами
            PreparedStatement ps = con.prepareStatement(insertQueryCompanies);
            for (int i = 1; i < companyMock.size(); i++) {
                String[] row = companyMock.get(i);
                ps.setString(1, row[0]);
                ps.setString(2, row[1]);
                ps.setString(3, row[2]);
                ps.executeUpdate();
            }
            ps = con.prepareStatement(insertQueryUsers);
            for (int i = 1; i < userMock.size(); i++) {
                String[] row = userMock.get(i);
                ps.setString(1, row[0]);
                ps.setString(2, row[1]);
                ps.setString(3, row[2]);
                ps.setString(4, row[3]);
                int n = Integer.parseInt(row[4]);
                ps.setInt(5, n);
                ps.executeUpdate();
            }

            //Переменные для работы с юзером
            Scanner scanner = new Scanner(System.in);
            int opt;
            int id;
            int numOfRows;


            System.out.printf("Вы находитесь в базе данных %s\n",con.getCatalog());
            do {
                System.out.println("""
                        \t\t<--- Управление БД --->
                        \t1) Вывести всех юзеров
                        \t2) Вывести все компании
                        \t3) Вывести юзеров и компании
                        \t4) Удалить юзера по id
                        \t5) Удалить компанию по id
                        \t6) Выйти из БД
                        """);
                System.out.print("Введите номер команды: ");
                opt = scanner.nextInt();
                ResultSet rs = null;
                switch (opt){
                    case 1 :
                        rs = statement.executeQuery("SELECT * FROM USERS");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " " +
                                    rs.getString(2) + " " +
                                    rs.getString(3) + " " +
                                    rs.getString(4) + " " +
                                    rs.getString(5) + " " +
                                    rs.getInt(6));
                        }
                        break;
                    case 2 :
                        rs = statement.executeQuery("SELECT * FROM COMPANIES");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " " +
                                    rs.getString(2) + " " +
                                    rs.getString(3) + " " +
                                    rs.getString(4) + " ");
                        }
                        break;
                    case 3 :
                        rs = statement.executeQuery("""
                                SELECT users.id, users.first_name, users.last_name, companies.name
                                FROM users
                                JOIN companies ON users.company_id=companies.id;""");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " " +
                                    rs.getString(2) + " " +
                                    rs.getString(3) + " --> Company: " +
                                    rs.getString(4) + " ");
                        }
                        break;
                    case 4 :
                        System.out.print("Введите id: ");
                        id = scanner.nextInt();
                        numOfRows = statement.executeUpdate("DELETE FROM USERS WHERE ID = " + id);
                        rs = statement.executeQuery("SELECT * FROM USERS");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " " +
                                    rs.getString(2) + " " +
                                    rs.getString(3) + " " +
                                    rs.getString(4) + " " +
                                    rs.getString(5) + " " +
                                    rs.getInt(6));
                        }
                        System.out.println("Количество удаленных юзеров: " + numOfRows);
                        break;
                    case 5 :
                        System.out.print("Введите id: ");
                        id = scanner.nextInt();
                        numOfRows = statement.executeUpdate("DELETE FROM COMPANIES WHERE ID = " + id);
                        rs = statement.executeQuery("SELECT * FROM COMPANIES");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " " +
                                    rs.getString(2) + " " +
                                    rs.getString(3) + " " +
                                    rs.getString(4) + " ");
                        }
                        System.out.println("Количество удаленных компаний: " + numOfRows);
                        break;
                    case 6 :
                        break;
                    default:
                        System.out.println("Неизвестная опция.");
                }
                rs.close();
            }while (opt!=6);
            statement.execute("DROP ALL OBJECTS");
        } catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
