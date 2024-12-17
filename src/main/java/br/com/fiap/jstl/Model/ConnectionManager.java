package br.com.fiap.jstl.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Connection connection = null;
    public static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    public static final String USER = "rm557700";
    public static final String PASSWORD = "220497";

    public static Connection getConnection() {

        try{
            // Solicitamos a conexão atraves do diver.
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

}
