/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VILLALTA codigoIdentificacion,
 * identificacionCliente,nombreCliente,apellidoCliente,telefonoCliente,correoCliente,direccionCliente,codigoEstado
 */
public class MantenimientoCliente {
    
    public static boolean insertarCliente(String codigoIdentificacion,String identificacionCliente,String nombreCliente,String apellidoCliente,String telefonoCliente,String correoCliente,String direccionCliente,String codigoEstado){
    Connection con = Usuarios.con;
        
        try {
            
           String insertsql = "INSERT INTO clientes(codigoIdentificacion,identificacionCliente,nombreCliente,apellidoCliente,telefonoCliente,correoCliente,direccionCliente,codigoEstado) VALUES ("+codigoIdentificacion+","+identificacionCliente+",'"+nombreCliente+"','"+apellidoCliente+"','"+telefonoCliente+"','"+correoCliente+"','"+direccionCliente+"',"+codigoEstado+");";
        
           Statement st;
           st = con.createStatement();
           st.executeUpdate(insertsql);
            
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static ResultSet mostrarClientes(String nombreCliente) {
        Connection con = Usuarios.con;
        ResultSet rs = null;
        try {

            String mostrarCliente = "SELECT nombreCliente Nombres ,apellidoCliente Apellido,identificacionCliente Identificacion,correoCliente Correo,direccionCliente Direccion, codigoEstado Estado FROM clientes";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(mostrarCliente);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
}
