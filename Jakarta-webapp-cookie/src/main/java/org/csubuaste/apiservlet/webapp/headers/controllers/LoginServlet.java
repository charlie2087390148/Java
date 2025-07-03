package org.csubuaste.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet({"/login","/login.html"})
public class LoginServlet extends HttpServlet {
    final static String USERNAME ="admin";
    final static String PASSWORD ="12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies()!=null?req.getCookies():new Cookie[0];
        Optional<String> cookieOptional = Arrays.stream(cookies)
                .filter(x->"username".equals(x.getName()))
                //.map(c->c.getValue())
                .map(Cookie::getValue)
                .findAny();

        if (cookieOptional.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");

            try(PrintWriter out = resp.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <title>Hola "+cookieOptional.get() +"</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <h1>Hola "+cookieOptional.get() +" ya has Iniciado Session anteriormente</h1>");
            out.println("</body>");
            out.println("</html>");

            }
        }else{
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user");
        String password = req.getParameter("pass");

        if (USERNAME.equals(username) && PASSWORD.equals(password)){
            resp.setContentType("text/html;charset=UTF-8");

            Cookie usernmaeCokie = new Cookie("username",username);
            resp.addCookie(usernmaeCokie);

            try(PrintWriter out = resp.getWriter()){
                out.println("<!DOCTYPE html>");
                out.println("<head>");
                out.println("    <meta charset=\"UTF-8\">");
                out.println("    <title>Login Correcto</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("    <h1>Login Correcto</h1>");
                out.println("    <h3>Hola "+username+" ha iniciado session correctamente</h1>");

                out.println("</body>");
                out.println("</html>");
            }
        }else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Lo sentimos usted no esta autorizado para ingresar a esta pagina");
        }
    }
}
