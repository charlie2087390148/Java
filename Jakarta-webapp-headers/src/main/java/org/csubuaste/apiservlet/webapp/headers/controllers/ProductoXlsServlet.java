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
import java.util.List;

@WebServlet({"/productos.xls","/productos.html"})
public class ProductoXlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        resp.setContentType("text/html;charset=UTF-8");

        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");
        if (esXls){
            // Existenlibrerias como POI para trabajr excel de manera mas robusta
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition","attachment;filename=productos.xls");
        }

        try(PrintWriter out = resp.getWriter()){
            if(!esXls) {
                out.println("<!DOCTYPE html>");
                out.println("<head>");
                out.println("    <meta charset=\"UTF-8\">");
                out.println("    <title>Listado de Productos</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("    <h1>Listado de Productos</h1>");
                out.println("    <p><a href=\"" + req.getContextPath() + "/productos.xls"+"\">Exportar XLS</a></p>");
                out.println("    <p><a href=\"" + req.getContextPath() + "/productos.json"+"\">Mostrar Json</a></p>");
            }
            out.println("   <table>");
            out.println("       <tr>");
            out.println("           <th>Id</th>");
            out.println("           <th>Nombre</th>");
            out.println("           <th>Tipo</th>");
            out.println("           <th>Precio</th>");
            out.println("       </tr>");
            productos.forEach(p->{
                out.println("       <tr>");
                out.println("           <td>"+p.getId()+"</td>");
                out.println("           <td>"+p.getNombre()+"</td>");
                out.println("           <td>"+p.getTipo()+"</td>");
                out.println("           <td>"+p.getPrecio()+"</td>");
                out.println("       </tr>");
            });
            out.println("   <table>");

            if(!esXls) {
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}
