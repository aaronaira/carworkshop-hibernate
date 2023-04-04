package org.carworkshop.infraestructure.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        out.println("<h1> Login </h1>");
        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>HTML Forms</h2>\n" +
                "\n" +
                "<form method=\"post\" action=\"/login\">\n" +
                "  <label for=\"fname\">First name:</label><br>\n" +
                "  <input type=\"text\" id=\"fname\" name=\"fname\" value=\"John\"><br>\n" +
                "  <label for=\"lname\">Last name:</label><br>\n" +
                "  <input type=\"text\" id=\"lname\" name=\"lname\" value=\"Doe\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> \n" +
                "</body>\n" +
                "</html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");

        PrintWriter out = response.getWriter();

        out.println("<h2>" + fname + "</h2>");
        out.println("<h2>" + lname + "</h2>");

    }


}