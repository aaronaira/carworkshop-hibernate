package org.carworkshop.infraestructure.servlets;

import org.carworkshop.controllers.SesionController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Optional;

public class Logout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();

        if(cookies != null) {
            for (Cookie cookie: cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                SesionController.saveClientEndSession(cookie.getValue());
                response.sendRedirect("/login");
            }
        }

    }

}