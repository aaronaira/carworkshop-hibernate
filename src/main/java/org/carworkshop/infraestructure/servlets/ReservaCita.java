package org.carworkshop.infraestructure.servlets;

import org.carworkshop.controllers.ReservaCitaController;
import org.carworkshop.dtos.ClienteDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ReservaCita extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Finaliza tu reserva de cita</h1>");

        out.println("<form method=\"post\" action=\"/panel/reservacita\">");
        Map<LocalDate, List<String>> fechas = (Map<LocalDate, List<String>>) request.getServletContext().getAttribute("fechas");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dia = LocalDate.parse(request.getParameter("fecha"), formatter);

        List<String> horasDisponibles = fechas.get(dia);
        out.println("<p>Día de reserva: " + request.getParameter("fecha") + "</p>");
        out.println("<label id='selectDate'>Selecciona una hora: <select name=\"selectHour\" id=\"selectDate\">");
        horasDisponibles.forEach(hora -> out.println("<option value='%s'>%s".replace("%s", hora)));
        out.println("</select><label><br><br>");

        out.println("<label id='diagnostico'>Introduce un breve diagnostico:<br>");
        out.println("<textarea id=\"diagnostico\" name=\"diagnostico_cliente\" rows=\"10\" cols=\"50\">Introduce una breve descripción del diagnóstico de tu vehículo. Por ejemplo: hace un ruido al frenar</textarea>");
        out.println("<br><button>Enviar</button></form>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String fecha = request.getParameter("fecha");
        String selectDate = request.getParameter("selectHour");
        String diagnostico = request.getParameter("diagnostico_cliente");

        ReservaCitaController.saveDiagnostico(request);



    }

}
