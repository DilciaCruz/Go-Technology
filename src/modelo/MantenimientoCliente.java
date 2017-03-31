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
import static modelo.MantenimientoUsuarios.con;

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
 
            String mostrarCliente = "SELECT clientes.codigoCliente Codigo, clientes.nombreCliente Nombre,clientes.apellidoCliente Apellido,clientes.identificacionCliente Identificacion,clientes.correoCliente Correo,clientes.direccionCliente Dirección,clientes.telefonoCliente Telefono,estados.descripcionEstado Estado\n" 
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
               String Buscar = "SELECT clientes.codigoCliente Codigo, clientes.nombreCliente Nombre,clientes.apellidoCliente Apellido,clientes.identificacionCliente Identificacion,clientes.correoCliente Correo,clientes.direccionCliente Dirección,clientes.telefonoCliente Telefono,estados.descripcionEstado Estado\n" 
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
            
            String extraerCliente = "SELECT codigoCliente,codigoIdentificacion,identificacionCliente,nombreCliente,apellidoCliente,telefonoCliente,direccionCliente,correoCliente,a.codigoEstado, b.descripcionEstado FROM clientes a inner join estados b on a.codigoEstado =b.codigoEstado  where codigoCliente=" + codigoCliente + ";";
 
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
    
    public static boolean actualizarCliente(int codigo,String codcliente,String cod, String id, String nombres, String apellidos, String tel, String dir, String correo, String estado) {
        Connection con = MantenimientoUsuarios.con;
        try {
            String actualizarsql = "UPDATE clientes SET codigoCliente='" + codcliente + "',codigoIdentificacion='" + cod + "',IdentificacionCliente='" + id + "',nombreCliente='" + nombres + "',apellidoCliente='" + apellidos + "',telefonoCliente='" + tel + "',direccionCliente='" + dir + "',correoCliente='" + correo + "',codigoEstado='" + estado + "' WHERE codigoCliente='" + codigo + "';";
           //String actualizarsql = "UPDATE clientes SET codigoIdentificacion='" + cod + "',identificacionCliente='" + id + "',nombreCliente='" + nombres + "',apellidosCliente='" + apellidos + "',telefonoCliente='" + tel + "',correoElectronico='" + correo + "',direccionEmpleado='" + dir + "',nombreUsuario='" + estado + "' WHERE codigoCliente='" + codigo + "';";
           Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarsql);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
    
    
    
     public static int obtenerCodigo(String codigoCliente) {
        try {
            String sqlSelect = "Select codigoCliente from clientes where codigoCliente = '" + codigoCliente + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {

                return rs.getInt("codigoCliente");
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

