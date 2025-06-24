package org.csubauste.java.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    //String url="jdbc:mysql://localhost:3306/curso_java?serverTimezone=UTC";
    private static String url="jdbc:mysql://localhost:3306/curso_java?serverTimezone=America/Lima";
    private static String usename ="root";
    private static String pasword = "";
    private static Connection connection=null;
    public static Connection getInstance() throws SQLException {
        if (connection == null){
            connection = DriverManager.getConnection(url,usename,pasword);
        }
        return connection;
    }
}
