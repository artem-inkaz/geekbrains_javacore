package Lessons9;

import Lessons7.RunTrack;
import Lessons7.Wall;
import java.util.Random;
import java.sql.*;
import java.util.Scanner;

public class DatabaseConnection {

    // Для ввода из консоли
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    // Запрашиваемые параметры препятствия
    private static int param;
    private static int paramAge;
    private static String paramName, paramType, paramSex;
    private static int paramRandomId,x;

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static String primaryLoad = "CREATE TABLE if not exists Cats(CatID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name TEXT NOT NULL, Age INTEGER NOT NULL, Type TEXT NOT NULL, Sex TEXT NOT NULL);";
    private static String updateStr = "insert into Cats(Name, Age, Type, Sex) values ('Barsik', 2, 'Bobtail', 'M'), ('Izolda', 1, 'Siam', 'W'), ('Dymok', 3, 'Homeless','M'),('Maruska', 2, 'Siam', 'W'), ('Ryzhyi', 2, 'Bobtail','M');";
    private static String queryStr1 = "select * from Cats;";
    private static String preparedStr = "insert into Cats(Name, Age, Type, Sex) values (?, ?, ?, ?)";
    private static String deleteQueryStr = "delete from Cats where Type like '%Home%';";
    private static String deleteQueryStr2 = "delete from Cats where CatID = ?;";
    private static String updateQueryStr = "update Cats set Name = 'Jungle' where CatID = ?;";
    public static void main(String[] args) throws SQLException, ClassNotFoundException,NullPointerException {
        connect();
        statement = connection.createStatement();

        // создание таблицы и добавление записей объявленных в private static String updateStr
        primaryLoad();

        addBd();

//        inOutBigArray();

//        inOutBigArraySavePoint();

        outFieldBD();

        outArrayCat();

        deleteQueryCat();

        initialData();
        deleteCat(param);

        addCattoBD(new Cat(20,"Bobik",4,"BigBoy","M"));

        initialData2();
        addCattoBD2( paramName,  paramAge, paramType, paramSex);

          updateCat(10);

        close();
    }

    // Добавление Cats в БД Вариант 3 preparedStr = "insert into Cats(Name, Age, Type, Sex) values (?, ?, ?, ?)";
    public static void addCattoBD(Cat cat) {
        //    Name, Age, Type, Sex
        try  {
            preparedStatement = connection.prepareStatement(preparedStr);
//            preparedStatement.setObject(1, cat.id);
            preparedStatement.setObject(1, cat.name);
            preparedStatement.setObject(2, cat.age);
            preparedStatement.setObject(3, cat.type);
            preparedStatement.setObject(4, cat.sex);
            // Выполняем запрос
            preparedStatement.executeUpdate();

            ResultSet rs = statement.executeQuery(queryStr1);
            // чтение/вывод таблицы в консоль по запросу private static String queryStr1 = "select * from Cats;";
            while (rs.next()){
                System.out.println("Cats in BD ID: " + rs.getString("CatID") + " " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Задаем Данные кота из консоли для добавления в БД функцией addCattoBD2( paramName,  paramAge, paramType, paramSex);
    private static void initialData2() throws SQLException {
        //    Name, Age, Type, Sex
        int age;
        String n,t,s;

        outFieldBD();
        System.out.println("Введите Данные Кота которого хотите добавить в БД ->");
        n = SCANNER.next();
        age = SCANNER.nextInt();
        t = SCANNER.next();
        s = SCANNER.next();
        paramAge = age;
        paramName = n;
        paramType = t;
        paramSex = s;

    }

    // Добавление Cats в БД Вариант 4
    public static void addCattoBD2(String name, int age,String type,String sex) {
        //    Name, Age, Type, Sex
        try  {
            preparedStatement = connection.prepareStatement(preparedStr);
//            preparedStatement.setObject(1, cat.id);
            preparedStatement.setObject(1, name);
            preparedStatement.setObject(2, age);
            preparedStatement.setObject(3, type);
            preparedStatement.setObject(4, sex);
            // Выполняем запрос
            preparedStatement.executeUpdate();

            ResultSet rs = statement.executeQuery(queryStr1);
            // чтение/вывод таблицы в консоль по запросу private static String queryStr1 = "select * from Cats;";
            while (rs.next()){
                System.out.println("Cats in BD ID: " + rs.getString("CatID") + " " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Задаем CatID который хотим удалить
    private static void initialData() throws SQLException {
        int id;
        outFieldBD();
        System.out.println("Введите ID Кота которого хотите удалить из БД ->");
        id = SCANNER.nextInt();
        param = id;
    }

    // Удаление Cats по id Ввод из консоли initialData()
    public static void deleteCat(int id) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement(deleteQueryStr2);
            preparedStatement.setObject(1, id);
            // Выполняем запрос
            preparedStatement.executeUpdate();
            // запрос Query о выводе в консол
            ResultSet rs = statement.executeQuery(queryStr1);
            // чтение/вывод таблицы в консоль по запросу private static String queryStr1 = "select * from Cats;";
            while (rs.next()){
                System.out.println("Cats in BD ID: " + rs.getString("CatID") + " " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Cats по id данный id указываем при инициализации ф-и в Main
    public static void updateCat(int id) throws SQLException {
        try  {
            preparedStatement = connection.prepareStatement(updateQueryStr);
            preparedStatement.setObject(1, id);
            // Выполняем запрос
            preparedStatement.executeUpdate();
            // запрос Query о выводе в консол
            ResultSet rs = statement.executeQuery(queryStr1);
            // чтение/вывод таблицы в консоль по запросу private static String queryStr1 = "select * from Cats;";
            while (rs.next()){
                System.out.println("Cats in BD ID: " + rs.getString("CatID") + " " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete private static String deleteQueryStr = "delete from Cats where Type like '%Home%';";
    private static void deleteQueryCat() throws SQLException {
        preparedStatement = connection.prepareStatement(deleteQueryStr);
        preparedStatement.executeUpdate();
        // запрос Query о выводе в консол
        ResultSet rs = statement.executeQuery(queryStr1);
        // чтение/вывод таблицы в консоль по запросу private static String queryStr1 = "select * from Cats;";
        while (rs.next()){
            System.out.println("Cats in BD ID: " + rs.getString("CatID") + " " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
        }
    }

    // Comit
    private static void inOutBigArray() throws SQLException {
        preparedStatement = connection.prepareStatement(preparedStr);
        connection.setAutoCommit(false);
        for (int i = 0; i < 5; i++) {
            preparedStatement.setString(1, "Rob" + i);
            preparedStatement.setInt(2, i );
            preparedStatement.setString(3, "Bobtail");
            preparedStatement.setString(4, "M");
            preparedStatement.executeUpdate();
        }
        connection.commit();
        // запрос
        ResultSet rs = statement.executeQuery(queryStr1);
        // чтение/вывод таблицы в консоль
        while (rs.next()){
            System.out.println("Cats in BD ID: " + rs.getString("CatID") + " " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
        }
    }

    // точка возврата rollback
    private static void inOutBigArraySavePoint() throws SQLException {
        preparedStatement = connection.prepareStatement(preparedStr);
        // точка возврата rollback
        Savepoint sp = connection.setSavepoint();
        for (int i = 0; i < 100; i++) {

            if (i == 30) connection.commit();
            if (i == 50) connection.rollback();
            preparedStatement.setString(1, "Rob" + i);
            preparedStatement.setInt(2, i * 2);
            preparedStatement.setString(3, "Bobtail");
            preparedStatement.setString(4, "M");
            preparedStatement.executeUpdate();
        }
        connection.commit();
        // запрос
        ResultSet rs = statement.executeQuery(queryStr1);
        // чтение/вывод таблицы в консоль
        while (rs.next()){
            System.out.println("Cats in BD ID: " + rs.getString("CatID") + " " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
        }
    }

    // добавление в БД запись из класса Cat
    private static void addBd() throws SQLException {
        // добавление в БД запись из класса Cat
        preparedStatement = connection.prepareStatement(preparedStr);
        Cat cat = new Cat(1,"Baron", 4, "Bobtail", "M");
        preparedStatement.setString(1, cat.getName());
        preparedStatement.setInt(2, cat.getAge());
        preparedStatement.setString(3, cat.getType());
        preparedStatement.setString(4, cat.getSex());
        System.out.println(preparedStatement.executeUpdate());
//        preparedStatement.executeUpdate();
    }

    // Вывод в консоль всех
    private static void outArrayCat() throws SQLException {
        // Строка запроса Query
        ResultSet rs = statement.executeQuery("select * from Cats;");
        Cat[] cats = new Cat[6];
        int i = 0;
        // Вывод в консоль
        while (rs.next()) {
            // 1-й вариант
            System.out.println("Cats in BD ID: " + rs.getString("CatID") + " " + rs.getString("Name") + " Age: " + rs.getInt("Age") + " Type: " + rs.getString("Type") + " Sex: " + rs.getString("Sex"));
            // 2-й вариант из класса
            Cat cat1 = new Cat(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5)
            );
            cats[i++] = cat1;

        }

        for (Cat cat1 : cats) {
            System.out.println(cat1);
        }
    }

    // чтение/вывод таблицы в консоль по запросу private static String queryStr1 = "select * from Cats;";
    private static void outFieldBD() throws SQLException {
        // запрос Query
        ResultSet rs = statement.executeQuery(queryStr1);
        // чтение/вывод таблицы в консоль по запросу private static String queryStr1 = "select * from Cats;";
        while (rs.next()){
            System.out.println("Cats in BD ID: " + rs.getString("CatID") + " " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
        }
    }

    // создание таблицы и добавление записей
    private static void primaryLoad() throws SQLException {
        statement.execute(primaryLoad);
//        statement.executeUpdate(updateStr);
        System.out.println(statement.executeUpdate(updateStr));
    }

    // создание соединения
    static void connect() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lessons9.db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static void close() throws SQLException {
        connection.close();
    }
}
