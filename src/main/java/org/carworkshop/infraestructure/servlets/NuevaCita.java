package org.carworkshop.infraestructure.servlets;

import org.carworkshop.controllers.LoginController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NuevaCita extends HttpServlet {
    private static final String vehiculoForm = """
                <!DOCTYPE html>
                    <html>
                    <body>
                    <h1>Menu</h1>
                    <a href="/panel">Inicio</a>
                    <a href="/panel/nuevovehiculo">Añadir nuevo vehiculo ✔</a>
                    <h2>Añadir un nuevo vehiculo</h2>
                    <form method="post" action="/panel/nuevovehiculo">
                       <label for="selectVehiculo>
                       <select>
                        <option value="coche1">coche1</option>
                        <option value="coche2">coche2</option>
                       </select>
                       </label>
                       
                      <input type="submit" value="Submit">
                    </form>
                    </body>
                </html>
        """;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(LoginController.checkIfUserIsLogged(request)) {
            out.println(vehiculoForm);
        } else {
            response.sendRedirect("/login");
        }


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String matricula = request.getParameter("matricula");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        int vyear = Integer.parseInt(request.getParameter("vyear"));
        int tipoVehiculo = Integer.parseInt(request.getParameter("tipo_vehiculo"));
        String bastidor = request.getParameter("bastidor");

        System.out.println(matricula+marca+modelo+vyear+tipoVehiculo);



    }
}
