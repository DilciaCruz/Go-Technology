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
 * @author Astrid
 */
public class MantenimientoFacturacion {
    public static boolean insertarDatosFacturacion(String fechaEmisionFactura, String impuesto, String codigoTipoPago, String codigoEmpleado,String codigoEstado,String codigoCliente) {
        try {
            Connection con = MantenimientoUsuarios.con;
            String insertarsql = "INSERT INTO facturas (fechaEmisionCotizacion,impuesto,codigoTpoPago,codigoEmpleado,codigoEstado,codigoCliente) VALUES ('" + fechaEmisionFactura + "'," + impuesto + "," + codigoTipoPago + "," + codigoEmpleado + "," + codigoEstado + "," + codigoCliente + ",);";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertarsql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static ResultSet extraerUltimoCodigoFacturacion() {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerUltimoCodigoFacturacion = "SELECT MAX(codigoFactura) from facturas;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerUltimoCodigoFacturacion);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    
    public static ResultSet mostrarFacturas() {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
            String mostrarFacturas = "select facturas.codigoFactura Codigo, facturas.fechaEmisionFactura FechaEmision, facturas.impuesto Impuesto, tipoPagos.codigoTipoPago TipoPago, empleados.nombreEmpleado NombreEmpleado,estados.descripcionEstado Estado, clientes.nombreCliente NombreCliente\n"
                    + "from facturas inner join estados on facturas.codigoEstado=estados.codigoEstado \n"
                    + "inner join clientes on  clientes.codigoCliente=facturas.codigoCliente inner join empleados on empleados.codigoEmpleado=cotizaciones.codigoEmpleado;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(mostrarFacturas);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
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

            String obtenerCodigo = "select codigoCotizacion from cotizaciones where codigoEstado='"+codigo+"';";
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

            String extraerDatosCotizacion = "select codigoCotizacion, fechaEmisionCotizacion,impuesto,fechaVigencia,a.codigoEstado,codigoCliente,c.codigoEmpleado, b.descripcionEstado,c.nombreEmpleado from cotizaciones a inner join estados b on a.codigoEstado=b.codigoEstado inner join empleados c on a.codigoEmpleado=c.codigoEmpleado  where codigoCotizacion='" + codigoCotizacion + "';";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerDatosCotizacion);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static boolean actualizarEstadoCotizacion(int codigoCotizacion, String estado) {
        Connection con = MantenimientoUsuarios.con;
        try {

            String actualizarEstadoCotizacion = "update cotizaciones set codigoEstado = '" + estado + "' where codigoCotizacion = '" + codigoCotizacion + "';";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarEstadoCotizacion);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
