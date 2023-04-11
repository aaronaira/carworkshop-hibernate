package org.carworkshop.controllers;

import org.carworkshop.Enums.ErroresRegistro;
import org.carworkshop.daos.ClienteDao;
import org.carworkshop.daos.LoginDao;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Login;
import org.carworkshop.helpers.Hash;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroController {

    private static final Map<String, String> clientFields = new HashMap<>();
    private static final Map<String, String> errorList = new HashMap<>();

    public static Map<String, String> getClientFields(HttpServletRequest request) throws NoSuchAlgorithmException {

        request.getParameterMap().forEach((key, value) -> {
            clientFields.put(key, value[0]);
        });

        filterFirstNameSecondNameAddress(clientFields.get("fname"));
        filterFirstNameSecondNameAddress(clientFields.get("lname"));
        filterFirstNameSecondNameAddress(clientFields.get("address"));
        filterPassword(clientFields.get("password"), clientFields.get("passwordConfirm"));
        filterDni(clientFields.get("dni"));
        filterEmail(clientFields.get("email"));

        if(errorList.isEmpty()) {
            registerClient();
            return null;
        } else {
            return errorList;
        }

    }
    private static void registerClient() throws NoSuchAlgorithmException {
        ClienteDao clienteDao = new ClienteDao();
        LoginDao loginDao = new LoginDao();

        Cliente cliente = new Cliente();
        Login login = new Login();

        login.setEmail(clientFields.get("email"));
        login.setPassword(Hash.createHash(clientFields.get("password")));
        login.setCliente(cliente);

        cliente.setNombre(clientFields.get("fname"));
        cliente.setApellidos(clientFields.get("lname"));
        cliente.setDni(clientFields.get("dni"));
        cliente.setDireccion(clientFields.get("address"));

        cliente.setEmail(login);
        loginDao.save(login);
        clienteDao.save(cliente);

    }

    private static void filterFirstNameSecondNameAddress(String name) {
        int nameLength = name.split("").length;
        if(nameLength < 3 || nameLength > 50) errorList.put(ErroresRegistro.NAME.getErrorCode(), ErroresRegistro.NAME.getErrorMessage());
    }

    private static void filterPassword(String password, String passwordConfirm) {
        if(!Objects.equals(password, passwordConfirm)) errorList.put(ErroresRegistro.PASSWORD1.getErrorCode(), ErroresRegistro.PASSWORD1.getErrorMessage());

        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}");
        Matcher matcher = pattern.matcher(password);
        if(!matcher.matches()) errorList.put(ErroresRegistro.PASSWORD.getErrorCode(), ErroresRegistro.PASSWORD.getErrorMessage());
    }

    private static void filterDni(String dni) {
        boolean dniPattern = Pattern.matches("\\d{8}[A-Z|a-z]{1}", dni);
        if(!dniPattern) errorList.put(ErroresRegistro.DNI.getErrorCode(), ErroresRegistro.DNI.getErrorMessage());
    }

    private static void filterEmail(String email) {
        boolean emailPattern = Pattern.matches(".*@*", email);
        if(!emailPattern) errorList.put(ErroresRegistro.EMAIL.getErrorCode(), ErroresRegistro.EMAIL.getErrorMessage());
    }


}
