package org.csubauste.java.jdbc.repositorio;

import org.csubauste.java.jdbc.model.Categoria;
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
        String sql = "SELECT p.*,c.nombre as categoria FROM productos p inner join categorias c on p.categoria_id = c.id;";
        try (
                Statement st = getConection().createStatement();
                ResultSet rs = st.executeQuery(sql);
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
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategorias(categoria);
        return p;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;
        String sql = "SELECT p.*,c.nombre as categoria FROM productos p inner join categorias c on p.categoria_id = c.id WHERE p.id = ?";
        try(PreparedStatement ps = getConection()
                .prepareStatement(sql)
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
        String sql;
        if (o.getId() != 0 && o.getId() > 0) {
            sql = "Update productos set nombre = ? ,precio = ?,categoria_id=?  where id=?";
        } else {
            sql = "INSERT INTO productos( nombre,precio,categoria_id,fecha_registro) VALUES(?,?,?,?)";
        }
        try (PreparedStatement ps = getConection()
                .prepareStatement(sql)
        )
        {
            ps.setString(1,o.getNombre());
            ps.setLong(2, o.getPrecio());
            ps.setLong(3,o.getCategorias().getId());
            if (o.getId() != 0 && o.getId() > 0) {
                ps.setLong(4, o.getId());
            }else{
                ps.setDate(4, new Date(o.getFecha_registro().getTime()));
            }
            ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try (PreparedStatement ps = getConection()
                .prepareStatement("DELETE FROM productos WHERE id = ?")
        ){
            ps.setLong(1,id);
            ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
