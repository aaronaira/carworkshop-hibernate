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

        String fecha = request.getParameter("fecha");

        out.println(ReservaCitaController.makeReservaCitaForm(request, fecha));

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String fecha = request.getParameter("date");
        String vehiculo = request.getParameter("vehiculo");
        String selectDate = request.getParameter("selectHour");
        String diagnostico = request.getParameter("diagnostico_cliente");

        if(ReservaCitaController.makeReservaCita(request)) out.println("La reserva se realizó con éxito! ❤");

        out.println("<h1>LA FECHA ES: " + fecha + "\nEL VEHICULO ES: " + vehiculo + "\nA LA HORA: " + selectDate + "\nY EL DIAGNOSTICO ES: " + diagnostico);



    }

}
