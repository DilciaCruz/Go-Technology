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
 * @author VILLALTA    codigoIdentificacion, identificacionCliente,nombreCliente,apellidoCliente,telefonoCliente,correoCliente,direccionCliente,codigoEstado
 */
public class MantenimientoCliente {
    
    public static boolean insertarCliente(int codigoIdentificacion,String identificacionCliente,String nombreCliente,String apellidoCliente,int telefonoCliente,String correoCliente,String direccionCliente,int codigoEstado) {
    Connection con = Usuarios.con;
        
        try {
            
           String insertsql = "INSERT INTO clientes (codigoIdentificacion, identificacionCliente, nombreCliente, apellidoCliente, telefonoCliente, correoCliente, direccionCliente) VALUES ('"+codigoIdentificacion+","+identificacionCliente+","+nombreCliente+","+apellidoCliente+","+telefonoCliente+","+correoCliente+","+direccionCliente+"');";
        
           Statement st;
           st = con.createStatement();
           st.executeUpdate(insertsql);
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}