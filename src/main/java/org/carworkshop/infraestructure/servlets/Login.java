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
            String email = request.getCookies()[0].getValue();
            Optional<ClienteDto> cliente = LoginController.getUser(email);

            out.println("<h1>ID USUARIO: " + cliente.get().getId() + "</h1>");

            out.println("<h1>" + cliente.get().getEmail() + "</h1>");
            out.println("<h1>" + cliente.get().getNombre() + "</h1>");
            out.println("<h1>" + cliente.get().getDni() + "</h1>");
            out.println("<h1>" + cliente.get().getApellidos() + "</h1>");
            out.println("<h1>" + cliente.get().getDireccion() + "</h1>");



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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("fname");
        String password = request.getParameter("lname");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");


        boolean checkFeilds = LoginController.checkUserFields(email, password);

        if(checkFeilds) {

            Optional<ClienteDto> userInfo = LoginController.checkIfUserExists(email, password);

            userInfo.ifPresentOrElse((user)
                            -> {

                        Cookie cookie = new Cookie("user_id", user.getEmail());
                        cookie.setMaxAge(60*60);
                        response.addCookie(cookie);

                        try {
                            response.sendRedirect("/login");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    ,() -> out.println("<h1>Datos incorrectos!</h1><br>" +
                            "<a href=\"/login\">Vuelve al login</a>"));

        } else {
            out.println("<h1> El correo o la contraseña no cumplen los requisistos</h1>");
        }



    }


}