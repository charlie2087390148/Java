package org.csubuaste.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.csubuaste.apiservlet.webapp.headers.models.Producto;
import org.csubuaste.apiservlet.webapp.headers.services.IProductoService;
import org.csubuaste.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IProductoService service = new ProductoServiceImpl();
        String nombre = req.getParameter("producto");
        Optional<Producto> encontrado = service.buscar(nombre);

        if (encontrado.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");

            try(PrintWriter out = resp.getWriter()){
                out.println("<!DOCTYPE html>");
                out.println("<head>");
                out.println("    <meta charset=\"UTF-8\">");
                out.println("    <title>Producto Encontrado</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("    <h1>Producto Encontrado</h1>");
                out.println("    <h3>Producto Encontrado"+encontrado.get().getNombre()+"</h3>");
                out.println("    <h3>Producto Encontrado"+encontrado.get().getPrecio()+"</h3>");
                out.println("</body>");
                out.println("</html>");

            }
        }else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Lo sentimos no se encontro el producto "+ nombre);
        }
    }
}
