package org.csubuaste.apiservlet.webapp.headers.services;

import org.csubuaste.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements IProductoService {
    @Override
    public List<Producto> listar() {
        return Arrays.asList(
                new Producto(1L,"notebook","Computacion",175000),
                new Producto(2L,"Escritorio","Oficina",100000),
                new Producto(3L,"Teclado Mecanico","Computacion",40000)
                );
    }

    @Override
    public Optional<Producto> buscar(String nombreproducto) {
        Optional<Producto> encontrado = listar().stream().filter(p->        {
            if (nombreproducto==null || nombreproducto.isBlank()){
                return false;
            }
            return p.getNombre().toLowerCase().contains(nombreproducto.toLowerCase());
        }).findFirst();
        return encontrado;
    }
}
