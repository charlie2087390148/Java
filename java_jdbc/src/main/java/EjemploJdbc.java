import java.sql.*;

public class EjemploJdbc
{
    public static void main(String[] args) {
        //String url="jdbc:mysql://localhost:3306/curso_java?serverTimezone=UTC";
        String url="jdbc:mysql://localhost:3306/curso_java?serverTimezone=America/Lima";
        String usename ="root";
        String pasword = "";

        try(
                Connection conn = DriverManager.getConnection(url,usename,pasword);
                Statement stmt = conn.createStatement();
                ResultSet resultado = stmt.executeQuery("Select * from productos")
            ) {

            while (resultado.next()){
                System.out.print(resultado.getInt("id") +"\t");
                System.out.print(resultado.getString("nombre")+"\t");
                System.out.print(resultado.getInt("precio")+"\t");
                System.out.println(resultado.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
