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
 * @author Vanelly
 */
public class MantenimientoCotizacion {

    public static Boolean insertarDatosDetalleCotizacion(String fechaEmisionCorizacion, float impuesto, String fechaVigencia, int codigoEstado, int codigoCliente, int codigoEmpleado) {
        try {
            Connection con = MantenimientoUsuarios.con;
            String insertarsql = "INSERT INTO cotizaciones (fechaEmisionCorizacion,impuesto,fechaVigencia,codigoEstado,codigoCliente,codigoEmpleado) VALUES ('"+fechaEmisionCorizacion+"','"+impuesto+"','"+fechaVigencia+"','"+codigoEstado+"','"+codigoCliente+"','"+codigoEmpleado+"');";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertarsql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
     public static ResultSet mostrarClientes(String nombreCliente) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String mostrarCliente = "SELECT codigoCliente Codigo,nombreCliente Nombres ,apellidoCliente Apellido,identificacionCliente Identificacion,correoCliente Correo,direccionCliente Direccion, codigoEstado Estado FROM clientes";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(mostrarCliente);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    } public static ResultSet extraerDatosCliente(String codigoCliente) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerCliente = "SELECT codigoCliente ,nombreCliente ,identificacionCliente,direccionCliente FROM clientes where codigoCliente="+codigoCliente+";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerCliente);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

}
