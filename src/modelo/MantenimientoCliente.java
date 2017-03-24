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
import javax.swing.JTable;

/**
 *
 * @author VILLALTA 
  */
public class MantenimientoCliente {
    
    public static boolean insertarCliente(String codigoIdentificacion,String identificacionCliente,String nombreCliente,String apellidoCliente,String telefonoCliente,String correoCliente,String direccionCliente,String codigoEstado){
    Connection con = MantenimientoUsuarios.con;
        
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
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
 
            String mostrarCliente = "SELECT clientes.codigoCliente, clientes.nombreCliente,clientes.apellidoCliente,clientes.identificacionCliente,clientes.correoCliente,clientes.direccionCliente,estados.descripcionEstado \n" 
                                     + "from clientes inner join identificaciones on clientes.codigoIdentificacion = identificaciones.codigoIdentificacion \n"
                                     + "inner join estados on estados.codigoEstado=clientes.codigoEstado;";                         
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(mostrarCliente);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }
    
    public static ResultSet Buscar(String nombreCliente) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
               String Buscar = "SELECT clientes.codigoCliente, clientes.nombreCliente,clientes.apellidoCliente,clientes.identificacionCliente,clientes.correoCliente,clientes.direccionCliente,estados.descripcionEstado \n" 
                                     + "from clientes inner join identificaciones on clientes.codigoIdentificacion = identificaciones.codigoIdentificacion \n"
                                     + "inner join estados on estados.codigoEstado=clientes.codigoEstado WHERE clientes.nombreCliente LIKE \"%" + nombreCliente + "%\"";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(Buscar);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
    
    
    public static ResultSet extraerDatosCliente(String codigoCliente) {
        
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
            
            String extraerCliente = "SELECT codigoIdentificacion,identificacionCliente,nombreCliente,apellidoCliente,telefonoCliente,direccionCliente,correoCliente,codigoEstado FROM clientes where codigoCliente=" + codigoCliente + ";";
 
            //String extraerEmpleado = "SELECT codigoCliente,identificacionCliente,nombreCliente,apellidoCliente,telefonoCliente,direccionCliente,correoCliente FROM clientes where codigoCliente=" + codigoCliente + ";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerCliente);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
    
    public static boolean actualizarCliente(String codigo, String cod, String id, String nombres, String apellidos, String tel, String dir, String correo, String estado) {
        Connection con = MantenimientoUsuarios.con;
        try {
           String actualizarsql = "UPDATE clientes SET codigoIdentificacion='" + cod + "',identificacionCliente='" + id + "',nombreCliente='" + nombres + "',apellidosCliente='" + apellidos + "',telefonoCliente='" + tel + "',correoElectronico='" + correo + "',direccionEmpleado='" + dir + "',nombreUsuario='" + estado + "' WHERE codigoCliente='" + codigo + "';";
           Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarsql);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }   
}
