package org.csubuaste.java.apiservlet.webapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String usename = req.getParameter("username1");
        String pass  = req.getParameter("password1");
        String email = req.getParameter("email");
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
        out.print("    </ul>");
        out.print("</body>");
        out.print("</html>");

        }catch(Exception ex){

        }
    }
}
