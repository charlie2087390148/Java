import org.csubauste.java.jdbc.model.Producto;
import org.csubauste.java.jdbc.repositorio.IRepositorio;
import org.csubauste.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.csubauste.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc
{
    public static void main(String[] args) {
        try(
                Connection conn = ConexionBaseDatos.getInstance()
//                Statement stmt = conn.createStatement();
//                ResultSet resultado = stmt.executeQuery("Select * from productos")
            ) {
//            while (resultado.next()){
//                System.out.print(resultado.getInt("id") +"\t");
//                System.out.print(resultado.getString("nombre")+"\t");
//                System.out.print(resultado.getInt("precio")+"\t");
//                System.out.println(resultado.getDate("fecha_registro"));
//            }
            IRepositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println);
            System.out.println(repositorio.porId(1L));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
