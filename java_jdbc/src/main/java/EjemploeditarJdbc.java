import org.csubauste.java.jdbc.model.Categoria;
import org.csubauste.java.jdbc.model.Producto;
import org.csubauste.java.jdbc.repositorio.IRepositorio;
import org.csubauste.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.csubauste.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploeditarJdbc
{
    public static void main(String[] args) {

            IRepositorio<Producto> repositorio = new ProductoRepositorioImpl();

            System.out.println("==========================LISTAR==========================");
            repositorio.listar().forEach(System.out::println);
            System.out.println("==========================POR ID==========================");
            System.out.println(repositorio.porId(1L));
            System.out.println("==========================INSERT==========================");
            Producto prod = new Producto(4L,"Teclado Corsair Mecanico",700,new Date());
            Categoria categoria = new Categoria(2L,"");
            prod.setCategorias(categoria);

            repositorio.guardar(prod);

            repositorio.listar().forEach(System.out::println);
            System.out.println("==========================Eliminar==========================");

    }
}
