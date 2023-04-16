package org.carworkshop.controllers;

import javax.servlet.http.*;

import org.carworkshop.Enums.ErroresLogin;
import org.carworkshop.daos.LoginDao;
import org.carworkshop.dtos.ClienteDto;
import org.carworkshop.entities.Login;
import org.carworkshop.entities.Sesion;
import org.carworkshop.helpers.Hash;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
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

    public static boolean checkIfUserExists(String email, String password, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException {
        LoginDao loginDao = new LoginDao();
        String userPasswordInput = Hash.createHash(password);
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60*60);

        if(!checkUserFields(email, password)) {
            session.setAttribute("cliente", ErroresLogin.PASSWORD_WRONG.getErrorMessage());
            return false;
        }

        Optional<Login> login = loginDao.get(email).filter(k -> k.getPassword().equals(userPasswordInput));


        if (login.isPresent()) {
            session.setAttribute("cliente", parseToClienteDto(login.get()));
            return true;
        } else {
            session.setAttribute("cliente", ErroresLogin.EMAIL_NOT_FOUND.getErrorMessage());
            return false;
        }
    }

    public static boolean checkIfUserIsLogged(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        return session.getAttribute("cliente") instanceof ClienteDto;

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