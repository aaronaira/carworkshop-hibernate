package org.carworkshop.infraestructure.servlets;

import org.carworkshop.controllers.LoginController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NuevoVehiculo extends HttpServlet {
        private static final String vehiculoForm = """
                <!DOCTYPE html>
                    <html>
                    <body>
                    <h1>Menu</h1>
                    <a href="/panel">Inicio</a>
                    <a href="/panel/nuevovehiculo">Añadir nuevo vehiculo ✔</a>
                    <h2>Añadir un nuevo vehiculo</h2>
                    <form method="post" action="/panel/nuevovehiculo">
                      <label for="matricula">Matricula:</label><br>
                      <input type="text" id="matricula" name="matricula"><br>
                      <label for="marca">Marca:</label><br>
                      <input type="text" id="marca" name="marca"><br>
                      <label for="modelo">Modelo:</label><br>
                      <input type="text" id="modelo" name="modelo"><br>
                      <label for="vyear">Año:</label><br>
                      <input type="number" id="vyear" name="vyear"><br>
                      <label for="tipo_vehiculo">Tipo vehiculo:</label><br>
                      <select name="tipo_vehiculo" id="tipo_vehiculo">
                        <option selected value="1">Coche</option>
                        <option value="2">Moto</option>
                        <option value="3">Furgoneta</option>
                        <option value="4">Camion</option>
                      </select><br>
                      <label for="bastidor">Bastidor:</label><br>
                      <input type="text" id="bastidor" name="bastidor"><br>
                      <br>
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
