package org.carworkshop.controllers;

import org.carworkshop.daos.*;
import org.carworkshop.entities.*;

import javax.swing.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OtController {

    //MÉTODO PARA INTRODUCIR DESCRIPCION DE LA MANO DE OBRA
    private static String setTextoDescripcionOt() {

        String texto;
        texto = JOptionPane.showInputDialog("Introduzca la descripcion, máximo 50 carácteres");
        return texto;
    }

    //MÉTODO PARA INTRODUCIR DESCRIPCION DE LA MANO DE OBRA
    private static int setCantidadPiezasOt() {
        while (true) {
            String input = JOptionPane.showInputDialog("Introduzca la cantidad de piezas usada:");
            try {
                int cantidad = Integer.parseInt(input);
                return cantidad;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe introducir un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //MÉTODO PARA RECOGER HORA ACTUAL
    private static Date setHora() {
        Date fechaActual = new Date();
        return new Timestamp(fechaActual.getTime());
    }

    //METODO PARA RECOGER LA TARIFA SEGUN EL TIPO DE VEHICULO QUE VENGA DADO POR EL DIAGNOSTICO
    private static Tarifa getTarifa (CabeceraDiagnostico cabeceraDiagnostico) throws Exception {
        Vehiculo vehiculo = cabeceraDiagnostico.getIdVehiculo();
        TarifaDao tarifaDao = new TarifaDao();
        List<Tarifa> listaTarifas = tarifaDao.getAll();
        Tarifa tarifaEncontrada = null;

        for (Tarifa tarifa : listaTarifas) {

            if (Objects.equals(vehiculo.getTipoVehiculo(), tarifa.getTipoVehiculo())) {

                tarifaEncontrada = tarifa;
                break;
            }
        }
        return tarifaEncontrada;
    }

    //METODO PARA REGISTRAR LA CABECERA DE LA ORDEN DE TRABAJO A PARTIR DEL DIAGNOSTICO
    private static OtCabecera registerCabeceraOrdenTrabajo(CabeceraDiagnostico cabeceraDiagnostico) {

        OtCabecera otCabecera = new OtCabecera();
        OtCabeceraDao otCabeceraDao = new OtCabeceraDao();

        if (cabeceraDiagnostico != null) {

            otCabecera.setFechaHora(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
            otCabecera.setIdVehiculo(cabeceraDiagnostico.getIdVehiculo());
            otCabecera.setIdDiagnostico(cabeceraDiagnostico);

            otCabeceraDao.save(otCabecera);
        } return otCabecera;
    }

    //METODO  PARA REGISTRAR LAS ORDENES DE TRABAJO DE LA MANO DE OBRA A PARTIR DE LA CABECERA DE LA ORDEN DE TRABAJO
    private static void registerManoObraOt(OtCabecera otCabecera) throws Exception {

        ManoobraOt manoobraOt = new ManoobraOt();
        ManoobraOtDao manoobraOtDao = new ManoobraOtDao();
        LocalDateTime horaInicio = null;
        LocalDateTime horaFin = null;


        if (otCabecera != null) {

            manoobraOt.setIdOt(otCabecera);
            manoobraOt.setTarifa(getTarifa(otCabecera.getIdDiagnostico()));
            manoobraOt.setOperacion(setTextoDescripcionOt());
            manoobraOt.setTsInicio(setHora());
            manoobraOt.setTsFin(null);

            manoobraOtDao.save(manoobraOt);
        }
    }

    //METODO PARA REGISTRAR LA HORA DE FINALIZACION DE LA ORDEN DE TRABAJO POR PARTE DEL EMPLEADO
    private static void registerHoradeFin (ManoobraOt manoobraOt) {

        ManoobraOtDao manoobraOtDao = new ManoobraOtDao();
        manoobraOt.setTsFin(setHora());
        manoobraOtDao.update(manoobraOt);
    }

    //RECOGE TODAS LAS PIEZAS EN UN ARRAYLIST
    private ArrayList<Pieza> selectPiezas() {

        PiezaDao piezaDao = new PiezaDao();
        ArrayList<Pieza> piezas = new ArrayList<>();

        for (Pieza pieza : piezaDao.getAll()) {
            piezas.add(pieza);
        }
        return piezas;
    }

}