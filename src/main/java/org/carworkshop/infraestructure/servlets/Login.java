package org.carworkshop.infraestructure.servlets;

import com.mysql.cj.log.Log;
import lombok.SneakyThrows;
import org.carworkshop.controllers.LoginController;
import org.carworkshop.dtos.ClienteDto;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Login extends HttpServlet {

    public Login() throws IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(LoginController.checkIfUserIsLogged(request)) {
            request.getRequestDispatcher("/WEB-INF/pages/client/panel.jsp")
                    .forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/pages/client/login.jsp")
                    .forward(request, response);
        }

    }

    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(!LoginController.checkIfUserExists(request)) {
          response.sendRedirect("/login");
        }

        if(LoginController.checkIfUserIsLogged(request)) {
            response.sendRedirect("/panel");
        } else {
            response.sendRedirect("/login");
        }


    }


}