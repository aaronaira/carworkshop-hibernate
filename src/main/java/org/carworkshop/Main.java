package org.carworkshop;

import org.carworkshop.daos.*;
import org.carworkshop.entities.CabeceraDiagnostico;
import org.carworkshop.entities.Cita;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Vehiculo;

import java.sql.Timestamp;
import java.util.Date;
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

        Optional<Cliente> cliente = clienteDao.get(37);

        //System.out.println(login.getId());
        CabeceraDiagnosticoDao cabeceraDiagnosticoDao = new CabeceraDiagnosticoDao();
        Optional<CabeceraDiagnostico> cabeceraDiagnostico = cabeceraDiagnosticoDao.get(1);
        VehiculoDao vehiculoDao = new VehiculoDao();

        Optional<Vehiculo> vehiculo = vehiculoDao.get(1);
        CitaDao citaDao = new CitaDao();

        Cita cita = new Cita();
        Date dateJava = new Date();
        Timestamp sqlFecha = new Timestamp(dateJava.getTime());
        cita.setFechaHora(sqlFecha);
        cita.setIdCliente(cliente.get());
        cita.setIdVehiculo(vehiculo.get());
        cita.setIdDiagnostico(cabeceraDiagnostico.get());
        citaDao.save(cita);

        System.out.println(citaDao.get(1).get().getIdDiagnostico().getIdVehiculo());










    }
}