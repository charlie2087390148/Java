import org.csubauste.java.jdbc.model.Producto;
import org.csubauste.java.jdbc.repositorio.IRepositorio;
import org.csubauste.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.csubauste.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcDelete
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



            System.out.println("==========================LISTAR==========================");
            repositorio.listar().forEach(System.out::println);
            System.out.println("==========================POR ID==========================");
            System.out.println(repositorio.porId(1L));
            System.out.println("==========================DELETE==========================");

            repositorio.eliminar(3L);
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
