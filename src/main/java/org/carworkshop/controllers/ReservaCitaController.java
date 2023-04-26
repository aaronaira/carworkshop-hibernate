package org.carworkshop.controllers;

import org.carworkshop.daos.CabeceraDiagnosticoDao;
import org.carworkshop.daos.CitaDao;
import org.carworkshop.daos.ClienteDao;
import org.carworkshop.daos.VehiculoDao;
import org.carworkshop.dtos.ClienteDto;
import org.carworkshop.dtos.VehiculoDto;
import org.carworkshop.entities.CabeceraDiagnostico;
import org.carworkshop.entities.Cita;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Vehiculo;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ReservaCitaController {

    private static String formReservaCita = """ 
            <h1>Reserva Tu Cita</h1>
            <a href="/panel">Inicio</a>
            <a href="/panel/nuevovehiculo">Añadir nuevo vehiculo ✔</a>
            <h2>Añadir un nuevo vehiculo</h2>
            <form method="post" action="/panel/reservacita">
               <label for="selectVehiculo">
               <select name="vehiculo" id="selectVehiculo">
                    %vehiculos
               </select>
               </label>
               <br>
               <br>
               <label id="dateSelected"><input type="date" name="date" value="%date" min="%date" max="%date"> </label>
               <br>
               <br>
               <label id='selectDate'>Selecciona una hora: <select name=\"selectHour\" id=\"selectDate\">
                    %horas
               </select></label>
               <br>
               <br>
               <label id='diagnostico'>Introduce un breve diagnostico:<br>
               <textarea id="diagnostico" name="diagnostico_cliente" rows="10" cols="50">Introduce una breve descripción del diagnóstico de tu vehículo. Por ejemplo: hace un ruido al frenar</textarea>
               </label>
               <br>
               <br>
              <input type="submit" value="Submit">
            </form>
            """;

    public static String makeReservaCitaForm(HttpServletRequest request, String fecha) {
        return formReservaCita
                .replace("%vehiculos", getAllVehiculos(request))
                .replace("%horas", getAllHoras(request))
                .replace("%date", fecha);


    }

    public static boolean makeReservaCita(HttpServletRequest request) {
        Map<String, String> citaData = mapRequestToHashmap(request.getParameterMap());
        VehiculoDao vehiculoDao = new VehiculoDao();
        Optional<Vehiculo> vehiculo = vehiculoDao.get(citaData.get("vehiculo"));

        try {
            CabeceraDiagnostico diagnostico = saveCabeceraDiagnostico(vehiculo.get());
            saveCita(vehiculo.get(), diagnostico, citaData.get("date"), citaData.get("selectHour"));
            return true;
        } catch (Exception e) {
            System.out.println(e + "<<<< AKI");
            return false;
        }

    }

    private static Cita saveCita(Vehiculo vehiculo, CabeceraDiagnostico diagnostico, String fecha, String hora) {
        CitaDao citaDao = new CitaDao();
        Cita cita = new Cita();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(fecha + " " + hora, formatter);

        Date convertedDatetime = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        cita.setFechaHora(new Timestamp(convertedDatetime.getTime()));
        cita.setIdVehiculo(vehiculo);
        cita.setIdCliente(vehiculo.getCliente());
        cita.setIdDiagnostico(diagnostico);

        citaDao.save(cita);

        return cita;
    }

    private static CabeceraDiagnostico saveCabeceraDiagnostico(Vehiculo vehiculo) {
        CabeceraDiagnosticoDao cabeceraDiagnosticoDao = new CabeceraDiagnosticoDao();
        CabeceraDiagnostico cabeceraDiagnostico = new CabeceraDiagnostico();

        cabeceraDiagnostico.setIdVehiculo(vehiculo);
        cabeceraDiagnostico.setFechaHora(new Timestamp(new Date().getTime()));

        cabeceraDiagnosticoDao.save(cabeceraDiagnostico);

        return cabeceraDiagnostico;
    }

    private static Map<String, String> mapRequestToHashmap(Map<String, String[]> params) {
        Map<String, String> datamap = new HashMap<>();

        params.forEach((key, value) -> {
            datamap.put(key, value[0]);
        });

        return datamap;
    }

    private static String getAllVehiculos(HttpServletRequest request) {
        ClienteDto clienteDto = (ClienteDto) request.getServletContext().getAttribute("cliente");
        ClienteDao clienteDao = new ClienteDao();

        Optional<Cliente> cliente = clienteDao.get(clienteDto.getId());
        List<VehiculoDto> allVehiculos = parseToVehiculoDto(cliente.get().getVehiculos());

        return parseDataVehiculosToHtmlForm(allVehiculos);
    }

    private static String getAllHoras(HttpServletRequest request) {
        Map<LocalDate, List<LocalTime>> horas = (Map<LocalDate, List<LocalTime>>) request.getServletContext().getAttribute("fechas");
        String getHoras;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fecha = (String) request.getParameter("fecha");

        LocalDate fechaLocalDate = LocalDate.parse(fecha, formatter);

        AtomicInteger index = new AtomicInteger();
        getHoras = horas.get(fechaLocalDate).stream().map(item -> {
            String isSelected = index.incrementAndGet() == 1 ? "selected" : "";
            return "<option " + isSelected + " value=" + item + ">" + item + "</option>";
        }).collect(Collectors.joining());

        return getHoras;
    }

    private static String parseDataVehiculosToHtmlForm(List<VehiculoDto> vehiculos) {
        AtomicInteger index = new AtomicInteger();
        return vehiculos.stream().map((vehiculo) -> {
            String isSelected = index.incrementAndGet() == 1 ? "selected" : "";
            return "<option " + isSelected + " value=" + vehiculo.getMatricula() + ">"
                    + vehiculo.getMarca() + " "
                    + vehiculo.getModelo() + " "
                    + vehiculo.getMatricula() + " "
                    + vehiculo.getBastidor()
                    + "</option>";

        }).collect(Collectors.joining());
    }

    private static List<VehiculoDto> parseToVehiculoDto(List<Vehiculo> vehiculos) {

        return vehiculos.stream().map(vehiculo ->
                new VehiculoDto(vehiculo.getId(), vehiculo.getMatricula(), vehiculo.getMarca(),
                        vehiculo.getModelo(), vehiculo.getVYear(), vehiculo.getCliente().getId(),
                        vehiculo.getTipoVehiculo(), vehiculo.getBastidor())).toList();
    }
}
