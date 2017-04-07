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

    public static ResultSet mostrarCotizaciones() {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
            String mostrarCotizacion = "select cotizaciones.codigoCotizacion Codigo, cotizaciones.fechaEmisionCotizacion FechaEmision, cotizaciones.impuesto Impuesto, cotizaciones.fechaVigencia FechaVigencia,estados.descripcionEstado Estado, clientes.nombreCliente NombreCliente, empleados.nombreEmpleado NombreEmpleado\n"
                    + "from cotizaciones inner join estados on cotizaciones.codigoEstado=estados.codigoEstado \n"
                    + "inner join clientes on  clientes.codigoCliente=cotizaciones.codigoCliente inner join empleados on empleados.codigoEmpleado=cotizaciones.codigoEmpleado;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(mostrarCotizacion);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static ResultSet buscarCotizacionEstado(String estado) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String buscarCotizacionEstado = "select cotizaciones.codigoCotizacion Codigo, cotizaciones.fechaEmisionCotizacion FechaEmision, cotizaciones.impuesto Impuesto, cotizaciones.fechaVigencia FechaVigencia,estados.descripcionEstado Estado, clientes.nombreCliente NombreCliente, empleados.nombreEmpleado NombreEmpleado\n"
                    + "from cotizaciones inner join estados on cotizaciones.codigoEstado=estados.codigoEstado \n"
                    + "inner join clientes on  clientes.codigoCliente=cotizaciones.codigoCliente inner join empleados on empleados.codigoEmpleado=cotizaciones.codigoEmpleado WHERE  estados.descripcionEstado LIKE \"%" + estado + "%\";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarCotizacionEstado);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static ResultSet buscarCotizacionNombreCliente(String nombreCliente) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String buscarCotizacionNombreCliente = "select cotizaciones.codigoCotizacion Codigo, cotizaciones.fechaEmisionCotizacion FechaEmision, cotizaciones.impuesto Impuesto, cotizaciones.fechaVigencia FechaVigencia,estados.descripcionEstado Estado, clientes.nombreCliente NombreCliente, empleados.nombreEmpleado NombreEmpleado\n"
                    + "from cotizaciones inner join estados on cotizaciones.codigoEstado=estados.codigoEstado \n"
                    + "inner join clientes on  clientes.codigoCliente=cotizaciones.codigoCliente inner join empleados on empleados.codigoEmpleado=cotizaciones.codigoEmpleado WHERE  clientes.nombreCliente LIKE \"%" + nombreCliente + "%\";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarCotizacionNombreCliente);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static int obtenerCodigo(String codigo) {
        Connection con = MantenimientoUsuarios.con;
        try {

            String obtenerCodigo = "select codigoCotizacion from cotizaciones where codigoEstado='" + codigo + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(obtenerCodigo);
            return rs.getInt("codigoCotizacion");
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        }

    }

    public static ResultSet extraerDatosCotizacion(String codigoCotizacion) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerDatosCotizacion = "select codigoCotizacion, fechaEmisionCotizacion,impuesto,fechaVigencia,a.codigoEstado,d.codigoCliente,c.codigoEmpleado, b.descripcionEstado,c.nombreEmpleado, d.nombreCliente, d.direccionCliente, d.identificacionCliente from cotizaciones a inner join estados b on a.codigoEstado=b.codigoEstado inner join empleados c on a.codigoEmpleado=c.codigoEmpleado inner join clientes d on d.codigoCliente=a.codigoCliente where codigoCotizacion='" + codigoCotizacion + "';";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerDatosCotizacion);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }
    
    

    public static ResultSet extraerDatosDetalle(String codigoCotizacion) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs= null;
        try {

            String extraerDatosDetalleCotizacion = "select codigoProducto, cantidad, precio,descripcionDetalle from detallecotizaciones where codigoCotizacion='" + codigoCotizacion + "';";
            Statement st;
            st = con.createStatement();
            st.executeQuery(extraerDatosDetalleCotizacion);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static boolean actualizarEstadoCotizacion(String codigoCotizacion, String codigoEstado) {
        Connection con = MantenimientoUsuarios.con;
        try {

            String actualizarEstadoCotizacion = "update cotizaciones set codigoEstado = '"+codigoEstado+"' where codigoCotizacion = '"+codigoCotizacion+"';";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarEstadoCotizacion);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /*  public static ResultSet extraerCodigoProducto(String descripcionProducto) {

        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
            String extraerCodigoProducto = "select codigoProducto from productos where descripcionProducto ='" + descripcionProducto + ";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerCodigoProducto);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }*/
}
