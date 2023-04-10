package org.carworkshop.controllers;

import org.carworkshop.daos.LoginDao;
import org.carworkshop.dtos.ClienteDto;
import org.carworkshop.entities.Login;

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
        Pattern patternPassword = Pattern.compile("\\w{0,15}", Pattern.CASE_INSENSITIVE);

        Matcher matcherEmail = patternEmail.matcher(email);
        Matcher matcherPassword = patternPassword.matcher(password);

        boolean matcherEmailFound = matcherEmail.find();
        boolean matcherPasswordFound = matcherPassword.find();

        return matcherEmailFound && matcherPasswordFound;

    }

    public static Optional<ClienteDto> checkIfUserExists(String email, String password) throws NoSuchAlgorithmException {
        LoginDao loginDao = new LoginDao();
        String userPasswordInput = hashpassword(password);
        Optional<Login> login = loginDao.get(email).filter(k -> k.getPassword().equals(userPasswordInput));

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

    private static String hashpassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashpass = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        byte[] encoded = Base64.getEncoder().encode(Arrays.toString(hashpass).getBytes());

        return new String(encoded);
    }


}