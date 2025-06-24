package org.csubauste.java.jdbc.repositorio;

import org.csubauste.java.jdbc.model.Producto;
import org.csubauste.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements IRepositorio{
    private Connection getConection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }
    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        try (
                Statement st = getConection().createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM productos");
        ){
            while (rs.next()){
                Producto p = new Producto();
                p.setId(rs.getLong("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setFecha_registro(rs.getDate("fecha_registro"));
                productos.add(p);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return productos;
    }

    @Override
    public Object porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Object o) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public void actualizar(Object o) {

    }
}
