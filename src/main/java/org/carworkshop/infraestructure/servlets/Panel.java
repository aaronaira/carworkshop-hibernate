package org.carworkshop.infraestructure.servlets;

import org.carworkshop.controllers.LoginController;
import org.carworkshop.dtos.ClienteDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class Panel extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (request.getCookies() != null) {
            String email = request.getCookies()[0].getValue();
            Optional<ClienteDto> cliente = LoginController.getUser(email);

            cliente.ifPresentOrElse((k) -> {
                        out.println("<h1>Estas logueado como: " + k.getEmail() + "</h1>");
                        out.println("<h1>Nombre: " + k.getNombre() + "</h1>");
                        out.println("<h1>Apellidos: " + k.getApellidos() + "</h1>");
                        out.println("<h1>DNI: " + k.getDni() + "</h1>");
                        out.println("<h1>Direccion: " + k.getDireccion() + "</h1>");
                        out.println("<h1>ID: " + k.getId() + "</h1>");
                    },
                    () -> {
                        try {
                            response.sendRedirect("/login");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

            );

        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


    }