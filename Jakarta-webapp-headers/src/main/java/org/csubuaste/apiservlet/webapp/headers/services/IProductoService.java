package org.csubuaste.apiservlet.webapp.headers.services;

import org.csubuaste.apiservlet.webapp.headers.models.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> listar();
}
