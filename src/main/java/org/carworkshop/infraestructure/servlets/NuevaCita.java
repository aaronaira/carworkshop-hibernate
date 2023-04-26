package org.carworkshop.infraestructure.servlets;

import org.carworkshop.controllers.LoginController;
import org.carworkshop.controllers.NuevaCitaController;
import org.carworkshop.controllers.VehiculoController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NuevaCita extends HttpServlet {
    private static final String HtmlOpen = """
            <!DOCTYPE html>
                    <html>
                    <head>
                    <style>
                        div {
                            width: 300px;
                        }
                        li {
                            list-style: none;
                            width: 14%;
                            flex-grow: 0;
                            text-align: right;
                        }
                        ul {
                            display: flex;
                            flex-wrap: wrap;
                            padding: 0;
                        }
                        .first-day {
                            display: flex;
                            justify-content: end;
                            align-items: flex-end;
                        }
                         .cross-day {
                               color: #eee;
                             text-decoration: line-through;
                         }
                    </style>
                    </head>
                    <body>""";
    private static final String HtmlClose = """
                </body>
                </html>""";
    private static final String vehiculoForm = """
                    <h1>Menu</h1>
                    <a href="/panel">Inicio</a>
                    <a href="/panel/nuevovehiculo">Añadir nuevo vehiculo ✔</a>
                    <h2>Añadir un nuevo vehiculo</h2>
                    <form method="post" action="/nueva">
                       <label for="selectVehiculo">
                       <select name="vehiculo" id="selectVehiculo">
                        %s
                       </select>
                       </label>
                      <input type="submit" value="Submit">
                    </form>""";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(LoginController.checkIfUserIsLogged(request)) {
            out.println(HtmlOpen);
            out.println(NuevaCitaController.makeCalendar(request));
            out.println(HtmlClose);
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
