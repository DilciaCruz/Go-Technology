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
   public static ResultSet mostrarFacturas(String string) {
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
   
   public static ResultSet buscarFacturaEstado(String estado) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String buscarFacturaEstado = " select facturas.codigoFactura Codigo, facturas.fechaEmisionFactura FechaEmision, facturas.impuesto Impuesto, tipoPagos.codigoTipoPago TipoPago, empleados.nombreEmpleado NombreEmpleado,estados.descripcionEstado Estado, clientes.nombreCliente NombreCliente\n"
                    + "from facturas inner join estados on facturas.codigoEstado=estados.codigoEstado \n"
                    + "inner join tipoPagos on tipoPagos.codigoTipoPago=facturas.codigoTipoPago inner join clientes on  clientes.codigoCliente=facturas.codigoCliente inner join empleados on empleados.codigoEmpleado=facturas.codigoEmpleado WHERE  estados.descripcionEstado LIKE \"%" + estado + "%\";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarFacturaEstado);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
   
   public static ResultSet buscarFacturaNombreCliente(String nombreCliente) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String buscarFacturaNombreCliente = "select facturas.codigoFactura Codigo, facturas.fechaEmisionFactura FechaEmision, facturas.impuesto Impuesto, tipoPagos.codigoTipoPago TipoPago, empleados.nombreEmpleado NombreEmpleado,estados.descripcionEstado Estado, clientes.nombreCliente NombreCliente\n"
                    + "from facturas inner join estados on facturas.codigoEstado=estados.codigoEstado \n"
                    + "inner join tipoPagos on tipoPagos.codigoTipoPago=facturas.codigoTipoPago inner join clientes on  clientes.codigoCliente=facturas.codigoCliente inner join empleados on empleados.codigoEmpleado=facturas.codigoEmpleado WHERE  clientes.nombreCliente LIKE \"%" + nombreCliente + "%\";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarFacturaNombreCliente);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

   public static ResultSet extraerCodigoClienteCotizacion(String codigoCotizacion) {

        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
            String extraerCodigoCliente = "select codigoCliente from cotizaciones where codigoCotizacion='" + codigoCotizacion+"';";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerCodigoCliente);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoProyectos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
   
   public static int insertarCotizacionFactura(int codigoCotizacion) {
        Connection con = MantenimientoUsuarios.con;
        int numero = 0;
        try {
            String insertSql = "Insert into facturas (codigoCliente) select codigoCliente from cotizaciones where codigoCotizacion = '" + codigoCotizacion + "';";
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
   
   public static int extraerUltimoCodigoFactura() {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        
        int codigo=0;
        try {

            String extraerUltimoCodigoFactura = "SELECT MAX(codigoFactura) from facturas;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerUltimoCodigoFactura);
            
            if (rs.first()) {
                codigo = rs.getInt("MAX(codigoFactura)");
            }

            return codigo;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return codigo;
        }
   
   
    
        }
   
   
   public static ResultSet mostrarProductosFactura(String codigoFactura) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {
            String mostrarProductosPorProyecto = "Select a. codigoProducto,a.descripcionProducto, b.cantidad,b.precioUnitario  from productos a inner join detallefactura b on a.codigoProducto=b.codigoProducto  inner join facturas c on c.codigoFactura=b.codigoFactura where c.codigoFactura='" + codigoFactura + "'";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(mostrarProductosPorProyecto);

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoProyectos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

   
   public static ResultSet extraerDatosFactura(String codigoFactura) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
            String extraerDatosProyecto = "select a.codigoFactura, b.nombreCliente, b.identificacionCliente,b.direccionCliente from facturas a inner join clientes b on a.codigoCliente=b.codigoCliente where a.codigoFactura='" + codigoFactura + "';";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerDatosProyecto);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoProyectos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
}
   

