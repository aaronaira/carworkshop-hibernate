package org.carworkshop.infraestructure.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntradaVehiculo extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
       String matricula = request.getParameter("matricula");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
