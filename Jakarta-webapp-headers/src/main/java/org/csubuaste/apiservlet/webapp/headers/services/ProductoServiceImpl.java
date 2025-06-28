package org.csubuaste.apiservlet.webapp.headers.services;

import org.csubuaste.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements IProductoService {
    @Override
    public List<Producto> listar() {
        return Arrays.asList(
                new Producto(1L,"notebook","Computacion",175000),
                new Producto(1L,"Escritorio","Oficina",100000),
                new Producto(1L,"Teclado Mecanico","Computacion",40000)
                );
    }
}
