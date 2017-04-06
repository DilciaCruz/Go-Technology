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
            String insertarsql = "INSERT INTO facturas (fechaEmisionFfactura,impuesto,codigoTipoPago,codigoEmpleado,codigoEstado,codigoCliente) VALUES ('" + fechaEmisionFactura + "'," + impuesto + "," + codigoTipoPago + "," + codigoEmpleado + "," + codigoEstado + "," + codigoCliente + ",);";
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
    
    

    public static ResultSet extraerDatosCliente(String codigoCotizacion) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerCliente = "SELECT a.codigoCotizacion, a.codigoCliente, b.nombreCliente, b.identificacionCliente, b.direccionCliente, a.codigoEmpleado, c.nombreEmpleado from cotizaciones a inner join clientes b on a.codigoCliente=b.codigoCliente inner join empleados c on a.codigoEmpleado=c.codigoEmpleado where codigoCotizacion=" + codigoCotizacion + ";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerCliente);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
    
     public static ResultSet extraerDatosDetalle(String codigoFactura) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs= null;
        try {

            String extraerDatosDetalleFactura = "select codigoEstado,codigoProducto, precioUnitario, cantidad, descripcion from detallefactura where codigoFactura='" + codigoFactura + "';";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(extraerDatosDetalleFactura);
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
                    + "inner join tipoPagos on tipoPagos.codigoTipoPago=facturas.codigoTipoPago inner join clientes on  clientes.codigoCliente=facturas.codigoCliente inner join empleados on empleados.codigoEmpleado=facturas.codigoEmpleado;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(mostrarFacturas);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static ResultSet buscarFacturacionEstado(String estado) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String buscarFacturacionEstado = " select facturas.codigoFactura Codigo, facturas.fechaEmisionFactura FechaEmision, facturas.impuesto Impuesto, tipoPagos.codigoTipoPago TipoPago, empleados.nombreEmpleado NombreEmpleado,estados.descripcionEstado Estado, clientes.nombreCliente NombreCliente\n"
                    + "from facturas inner join estados on facturas.codigoEstado=estados.codigoEstado \n"
                    + "inner join tipoPagos on tipoPagos.codigoTipoPago=facturas.codigoTipoPago inner join clientes on  clientes.codigoCliente=facturas.codigoCliente inner join empleados on empleados.codigoEmpleado=facturas.codigoEmpleado WHERE  estados.descripcionEstado LIKE \"%" + estado + "%\";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarFacturacionEstado);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static ResultSet buscarFacturacionNombreCliente(String nombreCliente) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String buscarFacturacionNombreCliente = "select facturas.codigoFactura Codigo, facturas.fechaEmisionFactura FechaEmision, facturas.impuesto Impuesto, tipoPagos.codigoTipoPago TipoPago, empleados.nombreEmpleado NombreEmpleado,estados.descripcionEstado Estado, clientes.nombreCliente NombreCliente\n"
                    + "from facturas inner join estados on facturas.codigoEstado=estados.codigoEstado \n"
                    + "inner join tipoPagos on tipoPagos.codigoTipoPago=facturas.codigoTipoPago inner join clientes on  clientes.codigoCliente=facturas.codigoCliente inner join empleados on empleados.codigoEmpleado=facturas.codigoEmpleado WHERE  clientes.nombreCliente LIKE \"%" + nombreCliente + "%\";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarFacturacionNombreCliente);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static int obtenerCodigo(String codigo) {
        Connection con = MantenimientoUsuarios.con;
        try {

            String obtenerCodigo = "select codigoFacturacion from facturas where codigoEstado='"+codigo+"';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(obtenerCodigo);
            return rs.getInt("codigoFactura");
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        }

    }

    public static ResultSet extraerDatosFacturacion(String codigoFactura) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerDatosFacturacion = "select a.codigoFactura, a.fechaEmisionFactura,a.impuesto,b.codigoTipoPago,b.descripcionTipoPago,c.codigoEmpleado,c.nombreEmpleado,d.codigoEstado,e.codigoCliente,d.descripcionEstado,e.nombreCliente from facturas a inner join tipoPagos b on a.codigoTipoPago=b.codigoTipoPago, inner join empleados c on c.codigoEmpleado=a.codigoEmpleado,inner join estados d on d.codigoEstado=a.codigoEstado, inner join clientes e on e.codigoCliente=a.codigoCliente   where codigoFactura='" + codigoFactura + "';";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerDatosFacturacion);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static boolean actualizarEstadoFactura(int codigoFactura, String estado) {
        Connection con = MantenimientoUsuarios.con;
        try {

            String actualizarEstadoFactura = "update facturas set codigoEstado = '" + estado + "' where codigoFactura = '" + codigoFactura + "';";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarEstadoFactura);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    public static int insertarCotizacionFactura(int codigoCotizacion) {
        Connection con = MantenimientoUsuarios.con;
        int numero = 0;
        try {
            String insertSql = "Insert into proyectos (codigoCliente) select codigoCliente from cotizaciones where codigoCotizacion = '" + codigoCotizacion + "';";
            Statement st;
            st = con.createStatement();

            numero = st.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);

            return numero;
        } catch (SQLException e) {

            System.out.println("error de query");
            System.out.println(e.getMessage());

            return numero;
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
            

}
   

