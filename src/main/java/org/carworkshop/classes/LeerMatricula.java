package org.carworkshop.classes;

import javax.swing.*;

public class LeerMatricula {

    static String matricula;

    public static String leerMatricula() {

        matricula = JOptionPane.showInputDialog("Introduzca la matrícula a leer");
        return matricula;
    }

}
