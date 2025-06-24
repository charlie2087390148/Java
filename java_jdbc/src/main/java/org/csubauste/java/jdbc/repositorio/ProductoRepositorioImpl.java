package org.csubauste.java.jdbc.repositorio;

import org.csubauste.java.jdbc.model.Producto;
import org.csubauste.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements IRepositorio<Producto>{
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
                Producto p = CreatObjetoProducto(rs);
                productos.add(p);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return productos;
    }

    private Producto CreatObjetoProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFecha_registro(rs.getDate("fecha_registro"));
        return p;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;
        try(PreparedStatement ps = getConection()
                .prepareStatement("SELECT * FROM productos WHERE id = ?")
        ){
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                producto = CreatObjetoProducto(rs);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto o) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public void actualizar(Producto o) {

    }
}
