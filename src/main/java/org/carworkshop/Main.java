package org.carworkshop;

import jakarta.persistence.Query;
import org.carworkshop.daos.ClienteDao;
import org.carworkshop.daos.LoginDao;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Login;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ClienteDao clienteDao = new ClienteDao();
        LoginDao loginDao = new LoginDao();

//        Cliente cliente = new Cliente();
//        Login login = new Login();
//
//        login.setPassword("asdasd");
//        login.setEmail("aaron00@gmail.com");
//        login.setCliente(cliente);
//
//
//        cliente.setApellidos("aasd");
//        cliente.setNombre("aaron");
//        cliente.setDireccion("calle 2");
//        cliente.setDni("123213123A");
//        cliente.setEmail(login);
//        loginDao.save(login);
//        Login loginBorrar = loginDao.get(login.getId());
//        loginDao.delete(loginBorrar);

       //Login login = loginDao.get("email56@email.com");
//
//        System.out.println(login.getCliente().getDni());
//
        //login.setEmail("email56@email.com");
//
//        loginDao.update(login);

        //Cliente cliente = clienteDao.get("email56@email.com");

        //System.out.println(login.getId());

        Optional<Login> login = loginDao.get("email55@email.com");

        login.ifPresent(k -> System.out.println(k.getEmail()));







    }
}