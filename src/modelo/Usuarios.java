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
import vista.Login;

/**
 *
 * @author Alexei Rodriguez
 */
public class Usuarios {

    public static final Connection con = Conexion.conexion;
    public static String usuario;
    int intentos = 0;

    public static boolean login(String usuario, String clave) {

        try {
            
            String qry = "SELECT * FROM empleados WHERE nombreUsuario = '" + usuario + "' AND claveUsuario = '" + clave + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            

            if (rs.next()) {
                System.out.println("Acceso correcto.");
                System.out.println(intentos);
                return true;
            } else {

                System.out.println(intentos);

                if (intentos < 3) {
                    sumarIntentos(usuario);
                    System.out.println("Acceso denegado.");
                    return false;
                } else {
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
    
    public static int obtenerIntentos(String usuario){
        try {
            String 
        } catch (Exception e) {
        }
    }
    
    public static void sumarIntentos(String usuario){
        
        try {
            String updateSql = "update empleados set intentos = intentos + 1 where nombreUsuario = '"+ usuario +"';";
            
            Statement st;
            st = con.createStatement();
            st.executeLargeUpdate(updateSql);
            
        } catch (SQLException e) {
            
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
            
        }
    }

    public static boolean bloquearUsuario(String usuario) {

        try {

            String updateSql = "UPDATE empleados SET codigoEstado = '" + 2 + "' where nombreUsuario = '" + usuario + "';";

            Statement st;
            st = con.createStatement();
            st.executeUpdate(updateSql);

            return true;

        } catch (SQLException e) {

            System.out.println("Error de Login");
            System.out.println(e.getMessage());
            return false;
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


