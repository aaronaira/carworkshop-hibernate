package org.carworkshop;

import org.carworkshop.daos.ClienteDao;
import org.carworkshop.daos.LoginDao;
import org.carworkshop.daos.SesionDao;
import org.carworkshop.daos.VehiculoDao;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Sesion;
import org.carworkshop.entities.Vehiculo;


import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ClienteDao clienteDao = new ClienteDao();
        LoginDao loginDao = new LoginDao();
        VehiculoDao vehiculoDao = new VehiculoDao();

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

//        SesionDao sesionDao = new SesionDao();
//        Optional<Sesion> sesion = sesionDao.get(1);
//
//        System.out.println(sesion);

        Optional<Cliente> cliente = clienteDao.get(25);
        Optional<Vehiculo> vehiculo = vehiculoDao.get(2);

//        Vehiculo vehiculo1 = new Vehiculo();
//        vehiculo1.setBastidor("123123AB");
//        vehiculo1.setTipoVehiculo(1);
//        vehiculo1.setCliente(cliente.get());
//        vehiculo1.setMatricula("5566GZK");
//        vehiculo1.setMarca("Seat");
//        vehiculo1.setModelo("Ibiza");
//        vehiculo1.setVYear(2010);
//
//
//        vehiculoDao.save(vehiculo1);

        //System.out.println(vehiculo.get().getCliente().getNombre());
        System.out.println(cliente.get().getVehiculos());





    }
}