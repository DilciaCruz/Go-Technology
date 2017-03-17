/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;

/**
 *
 * @author Rosa Sandoval
 */
public class Validaciones {

    public static boolean validarEspaciosVacios(String usuario, String clave) {
        if (usuario.equals("") || clave.equals("")) {
            JOptionPane.showMessageDialog(null, "Error, no dejar campos vacios ");
            return false;
        } else {
            return true;
        }
    }

}
