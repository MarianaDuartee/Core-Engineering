package org.marianaduarte.tema10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static Connection connection;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/tema10";
    private static final String usuario = "<user>";
    private static final String senha = "<password>";

    public static Connection conectar() {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, usuario, senha);
            return connection;
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
