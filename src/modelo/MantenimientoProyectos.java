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
            String buscarproyecto = "select detalleProyecto.codigoProyecto Codigo,detallecotizaciones.descripcionDetalle Descripcion_del_proyecto,\n"
                    + "detallecotizaciones.codigoproducto Descripcion_del_producto,cotizaciones.codigoCliente Cliente,detalleproyecto.planos Planos, \n"
                    + "detallecotizaciones.precio Precio_del_proyecto, detallecotizaciones.cantidad Cantidad, proyectos.codigoEstado Estado\n"
                    + "from proyectos inner join detalleProyecto on proyectos.codigoProyecto=detalleproyecto.codigoProyecto \n"
                    + "inner join detallecotizaciones on detalleproyecto.codigoProducto=detallecotizaciones.codigoProducto \n"
                    + "inner join cotizaciones on detallecotizaciones.codigoCotizacion=cotizaciones.codigocotizacion;";
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

            String buscarProyectoEstado = "select detalleProyecto.codigoProyecto Codigo,detallecotizaciones.descripcionDetalle Descripcion_del_proyecto,\n"
                    + "detallecotizaciones.codigoproducto Descripcion_del_producto,cotizaciones.codigoCliente Cliente,detalleproyecto.planos Planos, \n"
                    + "detallecotizaciones.precio Precio_del_proyecto, detallecotizaciones.cantidad Cantidad, proyectos.codigoEstado Estado\n"
                    + "from proyectos inner join detalleProyecto on proyectos.codigoProyecto=detalleproyecto.codigoProyecto \n"
                    + "inner join detallecotizaciones on detalleproyecto.codigoProducto=detallecotizaciones.codigoProducto \n"
                    + "inner join cotizaciones on detallecotizaciones.codigoCotizacion=cotizaciones.codigocotizacion WHERE  estados.descripcionEstado LIKE \"%" + estado + "%\";";
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

            String buscarProyectoEstado = "select detalleProyecto.codigoProyecto Codigo,detallecotizaciones.descripcionDetalle Descripcion_del_proyecto,\n"
                    + "detallecotizaciones.codigoproducto Descripcion_del_producto,cotizaciones.codigoCliente Cliente,detalleproyecto.planos Planos, \n"
                    + "detallecotizaciones.precio Precio_del_proyecto, detallecotizaciones.cantidad Cantidad, proyectos.codigoEstado Estado\n"
                    + "from proyectos inner join detalleProyecto on proyectos.codigoProyecto=detalleproyecto.codigoProyecto \n"
                    + "inner join detallecotizaciones on detalleproyecto.codigoProducto=detallecotizaciones.codigoProducto \n"
                    + "inner join cotizaciones on detallecotizaciones.codigoCotizacion=cotizaciones.codigocotizacion WHERE  detallecotizaciones.descripcionDetalle LIKE \"%" + nombre + "%\";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarProyectoEstado);
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

    public static boolean insertarFechasProyecto(String codigoEstado,int codigoProyecto,String fecha ) {
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

}
