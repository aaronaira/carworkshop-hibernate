package org.carworkshop.infraestructure.servlets;

import org.carworkshop.controllers.LoginController;
import org.carworkshop.dtos.ClienteDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (LoginController.checkIfUserIsLogged(request)) {
            request.getServletContext().setAttribute("cliente", null);
            response.sendRedirect("/login");
        }
    }
}


