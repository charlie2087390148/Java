package org.csubuaste.java.apiservlet.webapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String usename = req.getParameter("username1");
        String pass  = req.getParameter("password1");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais1");
        String[] lenguajes = req.getParameterValues("lenguajes1");
        String[] roles = req.getParameterValues("roles");

        String idioma = req.getParameter("idioma");
        String Habilitar = req.getParameter("habilitar");
        String secreto = req.getParameter("secreto");
        try(PrintWriter out = resp.getWriter()){
            out.print("<!DOCTYPE html>");
            out.print("<head>");
            out.print("    <meta charset=\"UTF-8\">");
            out.print("    <title></title>");
            out.print("</head>");
            out.print("<body>");
            out.print("    <ul>");
            out.print("     <li>Usename : "+usename+"</li>");
            out.print("     <li>password : "+pass+"</li>");
            out.print("     <li>email : "+email+"</li>");
            out.print("     <li>pais : "+pais+"</li>");
            out.println("   <li><ul>Lenguajes: ");

            Arrays.asList(lenguajes).forEach(lenguaje->{
                out.println("   <li>"+lenguaje+"</li>");
            });

            out.println("   </li></ul>");

            out.println("   <li><ul>Roles:");

            Arrays.asList(roles).forEach(role->{
                out.println("   <li>"+role+"</li>");
            });

            out.println("   </li></ul>");
            out.print("     <li>idioma : "+idioma+"</li>");
            out.print("     <li>habilitar : "+Habilitar+"</li>");
            out.print("     <li>secreto : "+secreto+"</li>");
            out.print("    </ul>");
            out.print("</body>");
            out.print("</html>");

        }catch(Exception ex){

        }
    }
}
