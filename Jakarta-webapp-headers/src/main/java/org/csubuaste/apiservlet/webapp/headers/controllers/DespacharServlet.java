package org.csubuaste.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/despachar")
public class DespacharServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //no requiqere el context path
        //une asu peticion el otro servlet como si fuera uno, question que no hace el salto hacia el otro servlet si no lo une, solo use el request actual
        getServletContext().getRequestDispatcher("/productos.html").forward(req,resp);

    }
}
