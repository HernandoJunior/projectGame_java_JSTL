package br.com.fiap.jstl.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Connection connection = null;
    public static final String URL = "jdbc:oracle:thin:@192.168.1.103:1521:xe";
    public static final String USER = "system";
    public static final String PASSWORD = "12345678";

    public static Connection getConnection() {

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

}
