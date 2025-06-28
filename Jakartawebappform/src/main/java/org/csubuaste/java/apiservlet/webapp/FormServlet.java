package org.csubuaste.java.apiservlet.webapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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
        Boolean Habilitar = req.getParameter("habilitar") != null &&  req.getParameter("habilitar").equals("on");
        String secreto = req.getParameter("secreto");
        List<String> errores = new ArrayList<>();
        //Map<String, String> errores = new HashMap<>();

        if (usename == null || usename.isBlank()) {
            errores.add("el username es requerido!");
            //errores.put("username", "el username es requerido!");
        }
        if (pass == null || pass.isBlank()) {
            errores.add("el password no puede ser vacío!");
            //errores.put("password", "el password no puede ser vacío!");
        }
        if (email == null || !email.contains("@")) {
            errores.add("el email es requerido y debe tener un formato de correo.");
            //errores.put("email", "el email es requerido y debe tener un formato de correo.");
        }
        if (pais == null || pais.equals("") || pais.equals(" ")) {
            errores.add("el pais es requerido!");
            //errores.put("pais", "el pais es requerido!");
        }

        if (lenguajes == null || lenguajes.length == 0) {
            errores.add("debe seleccionar al menos un tema.");
            //errores.put("lenguajes", "debe seleccionar al menos un tema.");
        }
        if (roles == null || roles.length == 0) {
            errores.add("debe seleccionar al menos un role!");
        }
        if (idioma == null) {
            errores.add("debe seleccionar un idioma!");
        }
        try(PrintWriter out = resp.getWriter()){
        if (errores.isEmpty()) {

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


        }else{
            errores.forEach(err->{
                out.println("<li>"+err+"</li>");
            });
            out.println("<p><a href=\"/Jakartawebappform\">Regresar</a></p>");
            //req.setAttribute("errores", errores);
            //getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }catch(Exception ex){

    }

    }
}
