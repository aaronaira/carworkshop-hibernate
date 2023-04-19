package org.carworkshop.classes;

import org.carworkshop.daos.CitaDao;
import org.carworkshop.entities.Cita;

import java.text.SimpleDateFormat;
import java.util.*;



public class Calendario {

    public static List<String> showCalendar(int y, int m, int d) {

        Calendar calendar = new GregorianCalendar(y, m-1, d);
        //calendar.set(Calendar.DAY_OF_MONTH, 17); //Set the day of month to 1
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); //get day of week for 1st of month
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);


//print month name and year
        System.out.println(new SimpleDateFormat("MMMM YYYY").format(calendar.getTime()));
        System.out.println(" L  M  X  J  V  S  D");

//print initial spaces
        String initialSpace = "";
        for (int i = 0; i < dayOfWeek - 2; i++) {
            initialSpace += "   ";
        }
        System.out.print(initialSpace);

        List<String> newCalendar = new ArrayList<>();


//print the days of the month starting from 1
        for (int i = 0, dayOfMonth = 1; dayOfMonth <= daysInMonth; i++) {
            for (int j = ((i == 0) ? dayOfWeek - 2 : 0); j < 7 && (dayOfMonth <= daysInMonth); j++) {

                String mes = "";
                String day = "";

                if(String.valueOf(m).length() < 2) mes = "0"+m;
                if(String.valueOf(dayOfMonth).length() < 2) day = "0"+dayOfMonth;

                String fechaBonitaCasi = y+"-"+mes+"-"+day;

                if(getCitasFromDB().contains(fechaBonitaCasi)) {
                    newCalendar.add("X");
                } else {
                    newCalendar.add(fechaBonitaCasi);
                }
                dayOfMonth++;
            }
            System.out.println();
        }

        return newCalendar;
    }


    public static List<String> getCitasFromDB() {
        CitaDao citaDao = new CitaDao();
        List<String> allCitas = new ArrayList<>();

        for (Cita cita: citaDao.getAll()) {
            allCitas.add(formatDate(cita.getFechaHora()));
        }
        return allCitas;
    }

    // Method to transform Gregorian date to Date
        public static String formatDate(Date date){

//            Creating an object of GregorianCalendar Class */

//            Calendar cal = Calendar.getInstance();
//            GregorianCalendar gcal = new GregorianCalendar();
//
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String dateFormatted = fmt.format(date);
            return dateFormatted;
        }

}
