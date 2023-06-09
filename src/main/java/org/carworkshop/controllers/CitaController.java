package org.carworkshop.controllers;

import org.carworkshop.daos.CitaDao;
import org.carworkshop.dtos.CitaDto;
import org.carworkshop.dtos.ClienteDto;
import org.carworkshop.entities.Cita;
import org.carworkshop.mappers.CitaMapper;
import org.carworkshop.mappers.VehiculoMapper;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class CitaController {

    public static void getAllCitas(HttpServletRequest request) {
        CitaDao citaDao = new CitaDao();
        ClienteDto cliente = (ClienteDto) request.getServletContext().getAttribute("cliente");

        Optional<List<Cita>> allCitas = citaDao.getAll(cliente.getId());


        // Parse all citas entity to new Array with Citas DTO

        if(!allCitas.isEmpty()) {
            List<CitaDto> allCitasDto =  allCitas.get().stream()
                    .map(cita -> CitaMapper.parse(cita))
                    .toList();

            request.getServletContext().setAttribute("citas", allCitasDto);

        } else {
            request.getServletContext().setAttribute("citas", null);
        }
    }

}
