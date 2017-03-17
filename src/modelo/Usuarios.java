/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import controlador.Conexion;
import controlador.Validaciones;
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
    public static int intentos = 0;

    public static boolean login(String usuario, String clave) {
        
         

        try {

            String qry = "SELECT * FROM empleados WHERE nombreUsuario = '" + usuario + "' AND claveUsuario = '" + clave + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);

            if (rs.next()) {
                System.out.println("Acceso correcto.");
                return true;
            } else {
                
                System.out.println(intentos);

                if (intentos < 3) {
                    System.out.println("Acceso denegado.");
                    intentos += 1;
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

    public static boolean bloquearUsuario(String usuario) {

        try {

            String updateSql = "UPDATE empleados SET codigoEstado = '" + 2 + "' where nombreUsuario = '" + usuario + "';";

            Statement st;
            st = con.createStatement();
            st.executeUpdate(updateSql);

            return true;

        } catch (Exception e) {

            System.out.println("Error de Login");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean noIngresarBloqueado(String usuario){
        
        
    
        try {
            
            String qry = "SELECT * FROM empleados WHERE nombreUsuario = '" + usuario + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            
            if (rs.next()) {
                
                return true;
            } else {
                return false;

            }
                
            
        } catch (Exception e) {
            System.out.println("Error Usuario bloqueado");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
