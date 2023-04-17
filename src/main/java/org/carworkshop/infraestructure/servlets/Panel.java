package org.carworkshop.infraestructure.servlets;

import org.carworkshop.controllers.LoginController;
import org.carworkshop.dtos.ClienteDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Panel extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(LoginController.checkIfUserIsLogged(request)) {
            ClienteDto cliente = (ClienteDto) request.getServletContext().getAttribute("cliente");
            out.println("<h1>Panel</h1>");
            out.println("<h2>Logueado: " + cliente.getEmail());
            out.println("<h2>Nombre: " + cliente.getNombre());
            out.println("<h2>Apellidos: " + cliente.getApellidos());
            out.println("<h2>DNI: " + cliente.getDni());
            out.println("<h2>Direccion: " + cliente.getDireccion());
            out.println("<h1>MENU</h1>");
            out.println("<a href='/panel/nuevovehiculo'>Agregar un nuevo vehículo</a>");
            out.println("<a href='/panel/nuevacita'>Pedir cita</a>");
        } else {
            response.sendRedirect("/login");
        }





    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}