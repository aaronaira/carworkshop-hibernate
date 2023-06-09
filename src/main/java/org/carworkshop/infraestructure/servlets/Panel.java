package org.carworkshop.infraestructure.servlets;

import org.carworkshop.controllers.CitaController;
import org.carworkshop.controllers.LoginController;
import org.carworkshop.dtos.ClienteDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Panel extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(LoginController.checkIfUserIsLogged(request)) {

            request.getRequestDispatcher("/WEB-INF/pages/client/panel.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/login");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}