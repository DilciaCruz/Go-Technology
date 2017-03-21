/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Encriptamiento;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rosa Sandoval
 */


public class MantenimientoEmpleados {
    


     public static Boolean insertarEmpleados(String identidadEmpleado,String nombreEmpleado, String apellidoEmpleado,String telefonoEmpleado,String correoEmpleado,String direccionEmpleado,String nombreUsuario,String claveUsuario,String codigoPuesto,String codigoEstado){
         Connection con=Usuarios.con;
         String encrip = null;
         try {
              encrip= Encriptamiento.obtenerMD5(claveUsuario);
         } catch (NoSuchAlgorithmException ex) {
             Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         try {
            
            String insertarsql ="INSERT INTO empleados (identificacion,nombreEmpleado,apellidosEmpleado,telefonoEmpleado,correoElectronico,direccionEmpleado,nombreUsuario,claveUsuario,codigoPuesto,codigoEstado) VALUES ('"+identidadEmpleado+"','"+nombreEmpleado+"','"+apellidoEmpleado+"','"+telefonoEmpleado+"','"+correoEmpleado+"','"+direccionEmpleado+"','"+nombreUsuario+"','"+encrip+"','"+codigoPuesto+"','"+codigoEstado+"');"; 
            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertarsql);
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
         
        
     }

 

    public static ResultSet buscarEmpleado(String nombreEmp) {
        Connection con=Usuarios.con;
        ResultSet rs = null;
        
        try {
            String buscarEmpleado = "SELECT nombreEmpleado Nombres ,apellidosEmpleado Apellido,codigoPuesto Cargo,codigoEstado Estado,nombreUsuario Usuario FROM empleados";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarEmpleado);
            
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }  
    }
    
       public static ResultSet buscarEmpleadoPorNombre(String nombreEmpleado) {
        Connection con=Usuarios.con;
        ResultSet rs = null;
        
        try {
            String buscarEmpleadoNombre = "SELECT nombreEmpleado  FROM empleados WHERE nombreEmpleado LIKE"+nombreEmpleado;
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarEmpleadoNombre);
            
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }  
    }
    
}

   
