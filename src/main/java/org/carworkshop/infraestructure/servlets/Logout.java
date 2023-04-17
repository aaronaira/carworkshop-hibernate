package org.carworkshop.infraestructure.servlets;

import org.carworkshop.dtos.ClienteDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request.getServletContext().getAttribute("cliente") instanceof ClienteDto) {
            request.getServletContext().setAttribute("cliente", "");
            response.sendRedirect("/login");
        } else {
            response.sendRedirect("/login");
        }
    }
}


