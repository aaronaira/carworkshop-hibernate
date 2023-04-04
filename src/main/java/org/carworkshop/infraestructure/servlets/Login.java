package org.carworkshop.infraestructure.servlets;

import org.carworkshop.controllers.LoginController;
import org.carworkshop.dtos.ClienteDto;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Optional;

public class Login extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        Cliente cliente = new Cliente();
//        cliente.setNombre("Aaron");
//        cliente.setDni("12345678A");
//        cliente.setApellidos("aira");
//        cliente.setId(1);
//        String encodeObject = Base64.getEncoder().encodeToString(cliente.toString().getBytes());
//
//        Cookie cookie = new Cookie("user_id", encodeObject);
//        cookie.setMaxAge(60*60);
//        response.addCookie(cookie);
//        byte[] decodedBytes = Base64.getDecoder().decode(encodeObject);
//        String cliente0 = new String(decodedBytes);
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Cliente clienteDTO = objectMapper.readValue(cliente0, Cliente.class);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(request.getCookies() != null) {
             out.println("<h1>Estás Logueado como: " + request.getCookies()[0].getValue()+"</h1>");
             out.println("<a href=\"/logout\">Logout</a>");
        } else {
            out.println("<h1> Login </h1>");
            out.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body>\n" +
                    "<form method=\"post\" action=\"/login\">\n" +
                    "  <label for=\"fname\">Email:</label><br>\n" +
                    "  <input type=\"text\" id=\"fname\" name=\"fname\"><br>\n" +
                    "  <label for=\"lname\">Password:</label><br>\n" +
                    "  <input type=\"text\" id=\"lname\" name=\"lname\"><br><br>\n" +
                    "  <input type=\"submit\" value=\"Submit\">\n" +
                    "</form> \n" +
                    "</body>\n" +
                    "</html>");
        }



    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("fname");
        String password = request.getParameter("lname");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        Optional<ClienteDto> userInfo = LoginController.checkIfUserExists(email, password);

        userInfo.ifPresentOrElse((user)
                        -> {
                            Cookie cookie = new Cookie("user_id", user.getNombre());
                            cookie.setMaxAge(60*60);
                            response.addCookie(cookie);
                            out.println("<h1>Estás logueado como: "+ user.getNombre() +" "+ user.getEmail()+"</h1>");
                            }
                        ,() -> out.println("<h1>Datos incorrectos!</h1><br>" +
                        "<a href=\"/login\">Vuelve al login</a>"));

    }


}