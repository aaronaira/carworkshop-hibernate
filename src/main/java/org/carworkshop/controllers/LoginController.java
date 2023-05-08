package org.carworkshop.controllers;

import org.carworkshop.enums.ErroresLogin;
import org.carworkshop.daos.LoginDao;
import org.carworkshop.dtos.ClienteDto;
import org.carworkshop.entities.Login;
import org.carworkshop.helpers.Hash;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginController {

    public static boolean checkUserFields(String email, String password) {
        Pattern patternEmail = Pattern.compile("\\w.*@.*(com|es|org|info|net|io|dev)", Pattern.CASE_INSENSITIVE);
        Pattern patternPassword = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}");

        Matcher matcherEmail = patternEmail.matcher(email);
        Matcher matcherPassword = patternPassword.matcher(password);

        boolean matcherEmailFound = matcherEmail.find();
        boolean matcherPasswordFound = matcherPassword.find();

        return matcherEmailFound && matcherPasswordFound;
    }

    public static boolean checkIfUserExists(HttpServletRequest request) throws NoSuchAlgorithmException {
        LoginDao loginDao = new LoginDao();
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        String userPasswordInput = Hash.createHash(password);

        if(!checkUserFields(email, password)) {
            request.getServletContext().setAttribute("cliente", ErroresLogin.PASSWORD_WRONG.getErrorMessage());
            return false;
        }

        Optional<Login> login = loginDao.get(email).filter(k -> k.getPassword().equals(userPasswordInput));


        if (login.isPresent()) {
            request.getServletContext().setAttribute("cliente", parseToClienteDto(login.get()));
            return true;
        } else {
            request.getServletContext().setAttribute("cliente", ErroresLogin.EMAIL_NOT_FOUND.getErrorMessage());
            return false;
        }
    }

    public static boolean checkIfUserIsLogged(HttpServletRequest request) {
        return (ClienteDto) request.getServletContext().getAttribute("cliente") instanceof ClienteDto;
    }

    private static ClienteDto parseToClienteDto(Login login) {

        return new ClienteDto(login.getCliente().getId(),
                login.getCliente().getNombre(),
                login.getCliente().getApellidos(),
                login.getCliente().getDni(),
                login.getCliente().getDireccion(),
                login);
    }

}
