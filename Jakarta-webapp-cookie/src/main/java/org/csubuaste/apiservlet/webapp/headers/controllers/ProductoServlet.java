package org.csubuaste.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.csubuaste.apiservlet.webapp.headers.models.Producto;
import org.csubuaste.apiservlet.webapp.headers.services.ILoginService;
import org.csubuaste.apiservlet.webapp.headers.services.IProductoService;
import org.csubuaste.apiservlet.webapp.headers.services.LoginServiceImpl;
import org.csubuaste.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos", "/productos.html"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();
        ILoginService serv = new LoginServiceImpl();
        Optional<String> cookieOptional = serv.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <title>Listado de Productos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <h1>Listado de Productos</h1>");
            if (cookieOptional.isPresent()) {
                out.println("   <div>Hola " + cookieOptional.get() + " esta Auutenticado</div>");
            }
            out.println("   <table>");
            out.println("       <tr>");
            out.println("           <th>Id</th>");
            out.println("           <th>Nombre</th>");
            out.println("           <th>Tipo</th>");
            out.println("           <th>Precio</th>");
            out.println("       </tr>");
            productos.forEach(p -> {
                out.println("       <tr>");
                out.println("           <td>" + p.getId() + "</td>");
                out.println("           <td>" + p.getNombre() + "</td>");
                out.println("           <td>" + p.getTipo() + "</td>");
                if (cookieOptional.isPresent()) {
                    out.println("           <td>" + p.getPrecio() + "</td>");
                }
                out.println("       </tr>");
            });
            out.println("   <table>");

        }
    }
}
