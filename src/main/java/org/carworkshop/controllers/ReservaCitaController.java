package org.carworkshop.controllers;

import org.carworkshop.daos.CabeceraDiagnosticoDao;
import org.carworkshop.entities.CabeceraDiagnostico;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ReservaCitaController {

     public static boolean saveDiagnostico(HttpServletRequest request) {
         CabeceraDiagnostico cabeceraDiagnostico = new CabeceraDiagnostico();
         CabeceraDiagnosticoDao cabeceraDiagnosticoDao = new CabeceraDiagnosticoDao();
         System.out.println(request.getServletContext().getAttribute("cliente"));
         //cabeceraDiagnostico.setFechaHora(new Timestamp(new Date().getTime()));
         return false;
     }
}
