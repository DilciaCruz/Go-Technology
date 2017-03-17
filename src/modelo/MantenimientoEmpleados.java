/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
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
         try {
            
            String insertarsql ="INSERT INTO empleados (identificacion,nombreEmpleado,apellidosEmpleado,telefonoEmpleado,correoElectronico,direccionEmpleado,nombreUsuario,claveUsuario,codigoPuesto,codigoEstado) VALUES ('"+identidadEmpleado+"','"+nombreEmpleado+"','"+apellidoEmpleado+"','"+telefonoEmpleado+"','"+correoEmpleado+"','"+direccionEmpleado+"','"+nombreUsuario+"','"+claveUsuario+"','"+codigoPuesto+"','"+codigoEstado+"');"; 
            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertarsql);
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
         
        
     }
    
}

   