package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public final static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "root";
    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установленно!");
            }

        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвера!");
        }

        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();

            if (connection.isClosed()) {
                System.out.println("Соединение с БД закрыто!");
            }
        } catch (SQLException e) {
            System.err.println("Соединения с БД отсутствовало!");
        }
    }
}