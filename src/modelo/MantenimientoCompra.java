/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
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
 * @author AnabelReyes
 */
public class MantenimientoCompra {

    /* public static Boolean insertarCompra(String codigoOrdenCompra,String nombreProveedor, String descripcionEstado,String fechaEmisionOrdenCompra){
         Connection con=Usuarios.con;
         String encrip = null;
         try {
             String claveUsuario = null;
           encrip= Encriptamiento.obtenerMD5(claveUsuario);
         } catch (NoSuchAlgorithmException ex) {
             Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         try {
            
            String insertarsql ="INSERT INTO ordencompras ( codigoOrdenCompra, nombreProveedor, descripcionEstado, fechaEmisionOrdenCompra) VALUES ('"+codigoOrdenCompra+"','"+nombreProveedor+"','"+descripcionEstado+"','"+fechaEmisionOrdenCompra+"');"; 
            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertarsql);
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
         
        
     

 

    public static ResultSet buscarCompra(String descripcionProyec) {
        Connection con=Usuarios.con;
        ResultSet rs = null;
        
        try {
            String buscarCompra = "SELECT codigoOrdenCompra Codigo, descripcionProyecto Proyecto, nombreProveedor Proveedor, FechaEmisionOrdenCompra Fecha, cantidadMaterialesReservados Total, codigoEstado Estado";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarCompra);
            
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }  
    }
    
    
       public static ResultSet buscarCompraPorProyecto(String descripcionProyecto) {
        Connection con=Usuarios.con;
        ResultSet rs = null;
        
        try {
         
            String buscarCompraPorProyecto ="SELECT codigoOrdenCompra Codigo, descripcionProyecto Proyecto, nombreProveedor Proveedor, FechaEmisionOrdenCompra Fecha, cantidadMaterialesReservados Total, codigoEstado Estado FROM proyectos WHERE descripcionProyecto LIKE \"%"+descripcionProyecto+"%\"";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarCompraPorProyecto);
            
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        
        }
    }*/
  }

   
    



   

