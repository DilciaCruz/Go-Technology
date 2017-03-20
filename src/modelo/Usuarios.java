/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import controlador.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.Login;

/**
 *
 * @author Alexei Rodriguez
 */
public class Usuarios {

    public static final Connection con = Conexion.conexion;
    public static String usuario;
    public static int id;
    public static int intentos = 0;

    public static boolean login(String usuario, String clave) {

        try {

            String qry = "SELECT * FROM empleados WHERE nombreUsuario = '" + usuario + "' AND claveUsuario = '" + clave + "';";
            Statement st;
            st = con.createStatement();

            ResultSet rs = st.executeQuery(qry);

            intentos = obtenerIntentosUsuario(usuario);
            id = obtenerCodigo(usuario);
            if (rs.next()) {
                System.out.println("Acceso correcto.");
                resetIntentos(id);
                System.out.println(intentos);
                return true;
            } else {

                System.out.println(intentos);


                if (intentos < 3) {
                    sumarIntentos(id);
                    System.out.println("Acceso denegado.");
                    return false;
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Acceso Bloqueado");
                    System.out.println("Acceso bloqueado.");
                    bloquearUsuario(usuario);
                    return false;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static int obtenerCodigo(String usuario) {
        try {
            String sqlSelect = "Select codigoEmpleado from empleados where nombreUsuario = '" + usuario + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {

                return rs.getInt("codigoEmpleado");
            } else {

                return 0;

            }
        } catch (SQLException e) {

            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public static void sumarIntentos(int id) {

        try {
            String updateSql = "update empleados set intentos = intentos + 1 where codigoEmpleado = '" + id + "';";

            Statement st;
            st = con.createStatement();
            st.executeUpdate(updateSql);

        } catch (SQLException e) {

            System.out.println("Error de conexion");
            System.out.println(e.getMessage());

        }
    }
    
    public static void resetIntentos(int id){
        
        try {
            String updateSql = "update empleados set intentos = 0 where codigoEmpleado = '" + id + "';";

            Statement st;
            st = con.createStatement();
            st.executeUpdate(updateSql);

        } catch (SQLException e) {

            System.out.println("Error de conexion");
            System.out.println(e.getMessage());

        }
    
    }

    public static void bloquearUsuario(String usuario) {

        try {

            String updateSql = "UPDATE empleados SET codigoEstado = '" + 2 + "' where nombreUsuario = '" + usuario + "';";

            Statement st;
            st = con.createStatement();
            st.executeUpdate(updateSql);

        } catch (SQLException e) {

            System.out.println("Error de Login");
            System.out.println(e.getMessage());
        }
    }
    
    public static int obtenerIntentosUsuario(String usuario){
    
        try {

            String sqlSelect = "Select intentos from empleados where nombreUsuario = '" + usuario + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {

                return rs.getInt("intentos");
            } else {

                return 0;

            }
        } catch (SQLException e) {

            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return 0;
        }
    
    }

    public static int obtenerEstadoUsuario(String usuario) {

        try {

            String sqlSelect = "Select codigoEstado from empleados where nombreUsuario = '" + usuario + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {

                return rs.getInt("codigoEstado");
            } else {

                return 0;

            }
        } catch (SQLException e) {

            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return 0;
        }
    }

}
