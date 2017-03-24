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
import javax.swing.JOptionPane;

/**
 *
 * @author Vanelly
 */
public class MantenimientoCotizacion {

    public static boolean insertarDatosCotizacion(String fechaEmisionCotizacion, String impuesto, String fechaVigencia, String codigoEstado, String codigoCliente, String codigoEmpleado) {
        try {
            Connection con = MantenimientoUsuarios.con;
            String insertarsql = "INSERT INTO cotizaciones (fechaEmisionCotizacion,impuesto,fechaVigencia,codigoEstado,codigoCliente,codigoEmpleado) VALUES ('" + fechaEmisionCotizacion + "'," + impuesto + ",'" + fechaVigencia + "'," + codigoEstado + "," + codigoCliente + "," + codigoEmpleado + ");";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertarsql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean insertarDatosDetalleCotizacion(int codigoCotizacion, String codigoProducto, String cantidad, String precio, String descripcionDetalle) {
        try {
            Connection con = MantenimientoUsuarios.con;
            String insertarsql = "INSERT INTO detallecotizaciones (codigoCotizacion,codigoProducto,cantidad,precio,descripcionDetalle) VALUES (" + codigoCotizacion + ",'" + codigoProducto + "','" + cantidad + "','" + precio + "','" + descripcionDetalle + "');";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertarsql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static ResultSet extraerUltimoCodigoCotizacion() {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerUltimoCodigoCotizacion = "SELECT MAX(codigoCotizacion) from cotizaciones;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerUltimoCodigoCotizacion);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static ResultSet extraerDatosCliente(String codigoCliente) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerCliente = "SELECT codigoCliente ,nombreCliente ,identificacionCliente,direccionCliente FROM clientes where codigoCliente=" + codigoCliente + ";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerCliente);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static ResultSet fehaActual() {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String fechaActual = "SELECT NOW() as fecha_emision;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(fechaActual);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    //Para extraer el parametro del valor de los dias de la cotizacion
    public static ResultSet fechaVigencia() {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
            
            
            
            String fechaVigencia = "SELECT NOW() as fecha_emision, DATE_ADD(NOW(), Interval valor DAY ) as fecha_vigencia, valor FROM parametros where codigoParametro = 2;";
            

            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(fechaVigencia);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
            
       
    }

}
