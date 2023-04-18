package org.carworkshop.infraestructure.servlets;

import org.carworkshop.controllers.RegistroController;
import org.carworkshop.dtos.ClienteDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class Registro extends HttpServlet {

    private static final String registerForm = """
                <!DOCTYPE html><html><body>
                <h1>REGISTRO</h1>
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
                </html>
                """;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        if(request.getServletContext().getAttribute("cliente") instanceof ClienteDto) {
            response.sendRedirect("/panel");
        } else {
            out.println(registerForm);
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Map<String, String> errorList = null;
        try {
            errorList = RegistroController.getClientFields(request);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        if(errorList == null) {
            out.println("<h1>Proceder con el registro</h1>");
        } else {
            errorList.forEach((k, v) -> {
                out.println("<p>ErrorCode: "+k +" ErrorMessage: "+v);
            });
        }


    }


}