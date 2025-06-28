package org.csubuaste.apiservlet.webapp.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
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

@WebServlet("/productos.json")
public class ProductoJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        ObjectMapper mapper= new ObjectMapper();
        String json = mapper.writeValueAsString(productos);

        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream jsonStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Producto producto = mapper.readValue(jsonStream,Producto.class);

        resp.setContentType("text/html;charset=UTF-8");

        try(PrintWriter out = resp.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <title>Detalle de producto desde JSON</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <h1>Detalle de producto desde JSON</h1>");
            out.println("   <ul>");
            out.println("   <li>Id: "+producto.getId()+"</li>");
            out.println("   <li>Id: "+producto.getNombre()+"</li>");
            out.println("   <li>Id: "+producto.getTipo()+"</li>");
            out.println("   <li>Id: "+producto.getPrecio()+"</li>");
            out.println("   </ul>");
            out.println("</body>");
            out.println("</html>");

        }
    }
}
