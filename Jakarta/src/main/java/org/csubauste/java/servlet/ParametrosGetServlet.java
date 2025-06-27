package org.csubauste.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametrosGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<head>");
        out.print("    <meta charset=\"UTF-8\">");
        out.print("    <title>Parametros get de la url</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <h1>Parametros get de la url</h1>");

        if (saludo != null && nombre !=null){
            out.print("<h2>El Saludo en viado es:"+saludo+ " "+ nombre+"</h2>");
        }else if (saludo != null){
            out.print("    <h2>Saludo enviado es: "+saludo+"</h2>");
        }
        else if (nombre != null){
            out.print("    <h2>El nombre es: "+nombre+"</h2>");
        }else {
            out.print("    <h2>no se han pasado los parametros saludo ni nombre</h2>");
        }

        try{
            Integer codigo = Integer.parseInt(req.getParameter("codigo"));
            out.println("<h3>El codigo es: "+ codigo + "</h3>");
        }catch(NumberFormatException ex){
            out.println("<h3>El codigo no se a enviado es null"+ ex.getMessage());
        }


        out.print("</body>");
        out.print("</html>");

        out.close();
    }
}
