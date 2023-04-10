package org.carworkshop.controllers;

import org.carworkshop.daos.ClienteDao;
import org.carworkshop.daos.LoginDao;
import org.carworkshop.daos.SesionDao;
import org.carworkshop.dtos.ClienteDto;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Login;
import org.carworkshop.entities.Sesion;

import java.util.Optional;

public class SesionController {

    public static void saveClientStartSession(ClienteDto cliente) {
        SesionDao sesionDao = new SesionDao();
        ClienteDao clienteDao = new ClienteDao();

        Optional<Cliente> clienteEntity = clienteDao.get(cliente.getId());
        Sesion sesion = new Sesion();

        sesion.setCliente(clienteEntity.get());
        sesion.setDtIniciosesion(parseToSQLtimestamp());

        sesionDao.save(sesion);
    }

    public static void saveClientEndSession(String clientEmail) {
        SesionDao sesionDao = new SesionDao();
        LoginDao loginDao = new LoginDao();

        Optional <Login> login = loginDao.get(clientEmail);
        Optional <Sesion> sesion = sesionDao.get(login.get().getCliente().getId());

        sesion.ifPresent(s -> s.setDtFinsesion(parseToSQLtimestamp()));
        sesionDao.update(sesion.get());
    }

    private static java.sql.Timestamp parseToSQLtimestamp() {
        java.util.Date dateJava = new java.util.Date();
        return new java.sql.Timestamp(dateJava.getTime());
    }
}
