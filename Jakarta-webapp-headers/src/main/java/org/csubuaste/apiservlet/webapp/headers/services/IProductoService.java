package org.csubuaste.apiservlet.webapp.headers.services;

import org.csubuaste.apiservlet.webapp.headers.models.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> listar();
    Optional<Producto> buscar(String nombreproducto);
}
