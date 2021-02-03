package Lessons9;

import java.sql.*;

public class DatabaseConnection {
    static Connection connection;
    static Statement statement;
    static PreparedStatement preparedStatement;
    static String primaryLoad = "\"CREATE TABLE if not exists Catss(CatID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name TEXT NOT NULL, Age INTEGER NOT NULL, Type TEXT NOT NULL, Sex TEXT NOT NULL);\";";
    static String updateStr = "insert into Cats(Name, Age, Type, Sex) values ('Barsik', 2, Bobtail, M), ('Izolda', 1, Siam, W), ('Dymok', 3, Homeless,M);";
    static String queryStr1 = "select * from Cats;";
    private static String preparedStr = "insert into Cats(Name, Age, Type, Sex) values (?, ?, ?, ?)";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        connect();
        statement = connection.createStatement();
        // создание таблицы и добавление записей
//        primaryLoad();

        addBd();

        inOutBigArray();

        inOutBigArraySavePoint();

        outFieldBD();

        outArrayCat();

        close();
    }

    private static void inOutBigArray() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 0; i < 100; i++) {
            preparedStatement.setString(1, "Rob" + i);
            preparedStatement.setInt(2, i * 2);
            preparedStatement.setString(3, "Bobtail");
            preparedStatement.setString(3, "M");
            preparedStatement.executeUpdate();
        }
        connection.commit();
        // запрос
        ResultSet rs = statement.executeQuery(queryStr1);
        // чтение/вывод таблицы в консоль
        while (rs.next()){
            System.out.println("Cats in BD " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
        }
    }

    private static void inOutBigArraySavePoint() throws SQLException {
        // точка возврата rollback
        Savepoint sp = connection.setSavepoint();
        for (int i = 0; i < 100; i++) {

            if (i == 30) connection.commit();
            if (i == 50) connection.rollback();
            preparedStatement.setString(1, "Rob" + i);
            preparedStatement.setInt(2, i * 2);
            preparedStatement.setString(3, "Bobtail");
            preparedStatement.setString(3, "M");
            preparedStatement.executeUpdate();
        }
        connection.commit();
        // запрос
        ResultSet rs = statement.executeQuery(queryStr1);
        // чтение/вывод таблицы в консоль
        while (rs.next()){
            System.out.println("Cats in BD " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
        }
    }

    private static void addBd() throws SQLException {
        // добавление в БД запись из класса Cat
        preparedStatement = connection.prepareStatement(preparedStr);
        Cat cat = new Cat(1,"Baron", 4, "Bobtail", "M");
        preparedStatement.setString(1, cat.getName());
        preparedStatement.setInt(2, cat.getAge());
        preparedStatement.setString(3, cat.getType());
        preparedStatement.setString(4, cat.getSex());
//        System.out.println(preparedStatement.executeUpdate());
        preparedStatement.executeUpdate();
    }

    private static void outArrayCat() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from Cats;");
        Cat[] cats = new Cat[7];
        int i = 0;
        while (rs.next()) {
            System.out.println("Cats in BD " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
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

    private static void outFieldBD() throws SQLException {
        // запрос
        ResultSet rs = statement.executeQuery(queryStr1);
        // чтение/вывод таблицы в консоль
        while (rs.next()){
            System.out.println("Cats in BD " + rs.getString("Name") + " Age: " + rs.getInt("Age")+ " Type: "+ rs.getString("Type")+ " Sex: "+ rs.getString("Sex"));
        }
    }

    // создание таблицы и добавление записей
    private static void primaryLoad() throws SQLException {
        statement.execute(primaryLoad);
        statement.executeUpdate(updateStr);
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
