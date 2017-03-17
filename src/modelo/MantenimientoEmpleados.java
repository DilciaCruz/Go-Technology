/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
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
    


     public static Boolean insertar(String identidadEmpleado, String nombreEmpleado, String apellidoEmpleado,String telefonoEmpleado,String correoEmpleado,String direccionEmpleado,String nombreUsuario,String claveUsuario){
         Connection  con=Usuarios.con;
         try {
            
            String insertarsql = "INSERT INTO empleados identificacion,nombreEmpleado,apellidosEmpleado,telefono,correoElectronico,direccionEmpleado,nombreUsuario,claveUsuario"
                    + " VALUES('"+identidadEmpleado+"','"+nombreEmpleado+"','"+apellidoEmpleado+"',,'"+telefonoEmpleado+"',,'"+correoEmpleado+"',,'"+direccionEmpleado+"','"+nombreUsuario+"',,'"+claveUsuario+"');";
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

   