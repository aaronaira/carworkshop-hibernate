package org.carworkshop.controllers;

import org.carworkshop.daos.SesionDao;
import org.carworkshop.dtos.SesionDto;
import org.carworkshop.entities.Sesion;

import java.util.Date;
import java.util.Optional;


public class SesionController {

    public static Optional<SesionDto> checkIfUserExists(int id, Date dtIniciosesion, Date dtFinsesion, Integer idCliente) {
        SesionDao sesionDao = new SesionDao();
        Optional<Sesion> sesion = SesionDao.get(id).filter(k -> k.getId().equals(id));

        SesionController sesionController = new SesionController();
        return SesionController.parseToSesionDto(sesion);
    }
    public static Optional<SesionDto> getUser(int id) {
        SesionDao sesionDao = new SesionDao();
        Optional<Sesion> sesion = sesionDao.get(id);

        SesionController sesionController = new SesionController();
        return sesionController.parseToSesionDto(sesion);
    }
    private static Optional<SesionDto> parseToSesionDto(Optional<Sesion> sesion) {
        return sesion.map(k -> new SesionDto(k.getId(),
                k.getDtIniciosesion(),
                k.getDtFinsesion(),
                k.getIdCliente()
                ));
    }
}
