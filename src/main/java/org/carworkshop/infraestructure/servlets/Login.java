package org.carworkshop.infraestructure.servlets;

import lombok.SneakyThrows;
import org.carworkshop.Enums.ErroresLogin;
import org.carworkshop.controllers.LoginController;
import org.carworkshop.controllers.SesionController;
import org.carworkshop.dtos.ClienteDto;

import javax.script.ScriptContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;


public class Login extends HttpServlet {

    private static final String logingForm = """
                    <!DOCTYPE html>
                    <html>
                    <body>
                    <h1>LOGIN</h1>
                    <form method="post" action="/login">
                      <label for="email">Email:</label><br>
                      <input type="text" id="email" name="email"><br>
                      <label for="password">Password:</label><br>
                      <input type="password" id="password" name="password"><br><br>
                      <input type="submit" value="Envia">
                    </form>
                    <br>
                    </body>
                    </html>""";

    public Login() throws IOException {
    }

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

//        out.println("<h1> Login </h1>");
//        out.println("""
//                    <!DOCTYPE html>
//                    <html>
//                    <body>
//                    <form method="post" action="/login">
//                      <label for="fname">Email:</label><br>
//                      <input type="text" id="fname" name="fname"><br>
//                      <label for="lname">Password:</label><br>
//                      <input type="text" id="lname" name="lname"><br><br>
//                      <input type="submit" value="Submit">
//                    </form>
//                    </body>
//                    </html>""");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        System.out.println(session.getAttribute("cliente") + " ---> session");

        if(session.getAttribute("cliente") != null) {
            response.sendRedirect("/panel");
        } else {
            out.println(logingForm);
        }

    }

    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(request.getSession().getAttribute("cliente") != null) {
            response.sendRedirect("/panel");
        } else {
            out.println(logingForm + request.getSession().getAttribute("cliente"));
        }

    }


}