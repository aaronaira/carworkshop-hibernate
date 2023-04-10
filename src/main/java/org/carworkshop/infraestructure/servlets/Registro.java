package org.carworkshop.infraestructure.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.carworkshop.controllers.RegistroController;
import org.carworkshop.entities.Cliente;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

public class Registro extends HttpServlet {


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
        out.println("<h1> Registro </h1>");
        out.println("""
                <!DOCTYPE html><html><body>
                <form method="post" action="/registro">
                  <label for="fname">Nombre:</label><br>
                  <input type="text" id="fname" name="fname" required><br>
                  <label for="lname">Last name:</label><br>
                  <input type="text" id="lname" name="lname" required><br>
                  <label for="dni">DNI:</label><br>
                  <input type="text" id="dni" name="dni" required><br>
                  <label for="address">Direccion:</label><br>
                  <input type="text" id="address" name="address" required><br>
                  <label for="password">Contraseña:</label><br>
                  <input type="password" id="password" name="password" required><br>
                  <label for="passwordConfirm">Confirma Contraseña:</label><br>
                  <input type="password" id="passwordConfirm" name="passwordConfirm" required><br>
                  <label for="email">Email:</label><br>
                  <input type="email" id="email" name="email" required><br><br>
                  <input type="submit" name="submit" value="Submit">
                </form>
                </body>
                </html>""");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String fname = request.getParameter("fname");
//        String lname = request.getParameter("lname");
//        String dni = request.getParameter("dni");
//        String address = request.getParameter("address");
//        String password = request.getParameter("password");
//        String passwordConfirm = request.getParameter("passwordConfirm");
//        String email = request.getParameter("email");


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            out.println("<h1>DATOS</h1>");
//        out.println("<h2>" + fname + "</h2>");
//        out.println("<h2>" + lname + "</h2>");
//        out.println("<h2>" + dni + "</h2>");
        RegistroController.getClientFields(request);

    }


}