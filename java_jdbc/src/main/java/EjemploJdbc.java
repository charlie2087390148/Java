import org.csubauste.java.jdbc.model.Categoria;
import org.csubauste.java.jdbc.model.Producto;
import org.csubauste.java.jdbc.repositorio.IRepositorio;
import org.csubauste.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.csubauste.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc
{
    public static void main(String[] args) {


            IRepositorio<Producto> repositorio = new ProductoRepositorioImpl();

            System.out.println("==========================LISTAR==========================");
            repositorio.listar().forEach(System.out::println);
            System.out.println("==========================POR ID==========================");
            System.out.println(repositorio.porId(1L));
            System.out.println("==========================INSERT==========================");
            Producto prod = new Producto(0L,"Notebook Ommen HP",2900,new Date());
            Categoria categoria = new Categoria(3L,"");
            prod.setCategorias(categoria);
            repositorio.guardar(prod);

            repositorio.listar().forEach(System.out::println);
            System.out.println("==========================Eliminar==========================");

/*HASTA AQUI HAY MODIFICACIONES EN BASE DE DATOS SE DEJA EL BACKUP DE TODA LA BD EN el archivo SQL*/
    }
}
