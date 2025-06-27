package org.csubauste.java.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    //String url="jdbc:mysql://localhost:3306/curso_java?serverTimezone=UTC";
    private static String url="jdbc:mysql://localhost:3306/curso_java?serverTimezone=America/Lima";
    private static String usename ="root";
    private static String pasword = "";
    private static BasicDataSource pool;
    public static BasicDataSource getInstance() throws SQLException {
        if (pool==null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(usename);
            pool.setPassword(pasword);
            pool.setInitialSize(3);/*default 0 y aumenta en 1 ; 3 conexciones abiertas para iniciar*/
            pool.setMinIdle(3);/*default 8; minimo numero de conexiones inactivas , que esta esperando a ser utilizadas*/
            pool.setMaxIdle(8); /*maximo numero de conexiones inactivas*/
            pool.setMaxTotal(8);

        }
        return pool;
    }
    public static Connection getConnection() throws SQLException {
        return  getInstance().getConnection();
    }
}
