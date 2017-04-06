/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rosa Sandoval
 */
public class MantenimientoProyectos {

    public static ResultSet mostrarProyectos(String string) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {
            String buscarproyecto = "select proyectos.codigoProyecto Código, concat(clientes.nombreCliente,'  ',clientes.apellidoCliente)Cliente,proyectos.descripcionProyecto Descripción,\n"
                    + "estados.descripcionEstado Estado from estados inner join proyectos on estados.codigoEstado=proyectos.codigoEstado\n"
                    + "inner join clientes on clientes.codigoCliente=proyectos.codigoCliente;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarproyecto);

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoProyectos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static ResultSet buscarProyectosEstado(String estado) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String buscarProyectoEstado = "select proyectos.codigoProyecto Código, concat(clientes.nombreCliente,'  ',clientes.apellidoCliente)Cliente,proyectos.descripcionProyecto Descripción,\n"
                    + "estados.descripcionEstado Estado from estados inner join proyectos on estados.codigoEstado=proyectos.codigoEstado\n"
                    + "inner join clientes on clientes.codigoCliente=proyectos.codigoCliente  WHERE  estados.descripcionEstado LIKE \"%" + estado + "%\";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarProyectoEstado);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoProyectos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static ResultSet buscarProyectosNombreCliente(String nombre) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String buscarProyectoNombreCliente = "select proyectos.codigoProyecto Código, concat(clientes.nombreCliente,'  ',clientes.apellidoCliente)Cliente,proyectos.descripcionProyecto Descripción,\n"
                    + "estados.descripcionEstado Estado from estados inner join proyectos on estados.codigoEstado=proyectos.codigoEstado\n"
                    + "inner join clientes on clientes.codigoCliente=proyectos.codigoCliente  WHERE  clientes.nombreCliente LIKE \"%" + nombre + "%\";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarProyectoNombreCliente);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoProyectos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static int insertarCotizacionProyecto(int codigoCotizacion) {
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

    public static boolean insertarDetalleCotizacionDetalleProyecto(int codigoProyecto, int codigoCotizacion) {

        Connection con = MantenimientoUsuarios.con;

        try {
            String insertSql = "Insert into detalleproyecto ( codigoProyecto ,codigoProducto, precioUnitario, cantidad, descripcion) select '" + codigoProyecto + "', codigoProducto, precio, cantidad, descripcionDetalle from detallecotizaciones where codigoCotizacion = " + codigoCotizacion + ";";
            Statement st;
            st = con.createStatement();

            st.executeUpdate(insertSql);

            return true;

        } catch (SQLException e) {

            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static boolean insertarFechasProyecto(String codigoEstado, int codigoProyecto, String fecha) {
        Connection con = MantenimientoUsuarios.con;

        try {

            String insertsql = "INSERT INTO agenda(codigoEstado,codigoProyecto,fecha) VALUES (" + codigoEstado + "," + codigoProyecto + ",'" + fecha + "');";

            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertsql);

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoProyectos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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

    public static ResultSet extraerDatosProyecto(String codigoProyecto) {
      Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
            String extraerDatosProyecto = "select proyectos.codigoProyecto, clientes.nombreCliente,clientes.apellidoCliente from proyectos inner join clientes on clientes.codigoCliente=proyectos.codigoCliente  where codigoProyecto='" + codigoProyecto + "';";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerDatosProyecto);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoProyectos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
  
    }

    public static ResultSet mostrarProductosPorProyecto(String codigoProyecto) {
         Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {
            String mostrarProductosPorProyecto = "select  detalleproyecto.codigoProducto,productos.descripcionProducto, detalleproyecto.precioUnitario from detalleproyecto inner join productos on detalleproyecto.codigoProducto=productos.codigoProducto where codigoProyecto='" + codigoProyecto + "';";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(mostrarProductosPorProyecto);

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoProyectos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }
    
    
      public static int extraerUltimoCodigoProyecto() {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        
        int codigo=0;
        try {

            String extraerUltimoCodigoProyecto = "SELECT MAX(codigoProyecto) from proyectos;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerUltimoCodigoProyecto);
            
            if (rs.first()) {
                codigo = rs.getInt("MAX(codigoProyecto)");
            }

            return codigo;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return codigo;
        }

    }
    
    

}
