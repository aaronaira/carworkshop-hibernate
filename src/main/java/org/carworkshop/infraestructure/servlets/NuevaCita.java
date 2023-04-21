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
                             display: flex;
                             width: 300px;
                         }
                         ul {
                             display: flex;
                             padding: 0;
                             flex-wrap: wrap;
                         }
                         li {
                             width: calc(300px / 7);
                             list-style: none;
                         }
                    </style>
                    </head>
                    <body>""";
    private static final String HtmlClose = """
                </body>
                </html>""";
    private static final String calendarForm = """
                <div class="calendar">
                <ul>
                    <li>LUN</li>
                    <li>MAR</li>
                    <li>MIE</li>
                    <li>JUE</li>
                    <li>VIE</li>
                    <li>SAB</li>
                    <li>DOM</li>
                    <li>1</li>
                    <li>2</li>
                    <li>3</li>
                    <li>4</li>
                    <li>5</li>
                    <li>6</li>
                    <li>7</li>
                    <li>8</li>
                    <li>9</li>
                    <li>10</li>
                    <li>11</li>
                    <li>12</li>
                    <li>13</li>
                    <li>14</li>
                    <li>15</li>
                    <li>16</li>
                    <li>17</li>
                    <li>18</li>
                    <li>19</li>
                    <li>20</li>
                    <li>21</li>
                    <li>22</li>
                    <li>23</li>
                    <li>24</li>
                    <li>25</li>
                    <li>26</li>
                    <li>27</li>
                    <li>28</li>
                    <li>29</li>
                    <li>30</li>
                </ul>
                </div>            """;
    private static final String vehiculoForm = """
                    <h1>Menu</h1>
                    <a href="/panel">Inicio</a>
                    <a href="/panel/nuevovehiculo">Añadir nuevo vehiculo ✔</a>
                    <h2>Añadir un nuevo vehiculo</h2>
                    <form method="post" action="/panel/nuevacita">
                       <label for="selectVehiculo">
                       <select name="lista_vehiculos" id="selectVehiculo">
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
            out.printf(vehiculoForm, NuevaCitaController.getAllVehiculos(request));
            out.println(NuevaCitaController.makeCalendar());
            out.println(HtmlClose);
        } else {
            response.sendRedirect("/login");
        }


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



    }
}
