package org.carworkshop.controllers;

import org.carworkshop.daos.LoginDao;
import org.carworkshop.dtos.ClienteDto;
import org.carworkshop.entities.Login;

import java.util.Optional;


public class LoginController {

    public static Optional<ClienteDto> checkIfUserExists(String email, String password) {
        LoginDao loginDao = new LoginDao();
        Optional<Login> login = loginDao.get(email).filter(k -> k.getPassword().equals(password));

        LoginController loginController = new LoginController();
        return loginController.parseToClienteDto(login);
    }

    public static Optional<ClienteDto> getUser(String email) {
        LoginDao loginDao = new LoginDao();
        Optional<Login> login = loginDao.get(email);

        LoginController loginController = new LoginController();
        return loginController.parseToClienteDto(login);
    }

    private Optional<ClienteDto> parseToClienteDto(Optional<Login> login) {
        return login.map(k -> new ClienteDto(k.getCliente().getId(),
                k.getCliente().getNombre(),
                k.getCliente().getApellidos(),
                k.getCliente().getDni(),
                k.getCliente().getDireccion(),
                k));
    }


}
