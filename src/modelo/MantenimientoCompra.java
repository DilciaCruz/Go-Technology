/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
import static controlador.Conexion.conexion;
import controlador.Encriptamiento;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static modelo.MantenimientoUsuarios.con;

/**
 *
 * @author AnabelReyes
 */
public class MantenimientoCompra {

    public static Boolean insertarCompra(String fechaEmisionOrdenCompra, String codigoProveedor, String codigoEmpleado, String codigoEstado) {
        Connection con = MantenimientoUsuarios.con;

        try {

            String insertarsql = "INSERT INTO ordencompras (fechaEmisionOrdenCompra, codigoProveedor, codigoEmpleado, codigoEstado) VALUES ('" + fechaEmisionOrdenCompra + "','" + codigoProveedor + "','" + codigoEmpleado + "', '" + codigoEstado + "' );";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertarsql);

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }

    }

    public static ResultSet extraerUltimoCodigoOrdenCompra() {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerUltimoCodigoOrdenCompra = "SELECT MAX(codigoOrdenCompra) from ordencompras;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerUltimoCodigoOrdenCompra);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static ResultSet mostrarCompras(String nombreComp) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {
            String buscarCompras = "select codigoOrdenCompra, fechaEmisionOrdenCompra, descripcionProyecto, "
                    + "nombreProveedor, descripcionEstado, nombreEmpleado from ordencompras inner join proveedores "
                    + "on ordencompras.codigoProveedor = proveedores.codigoProveedor inner join estados on "
                    + "ordencompras.codigoEstado = estados.codigoEstado inner join  empleados on "
                    + "ordencompras.codigoEmpleado = empleados.codigoEmpleado  inner join proyectos "
                    + "on empleados.codigoEstado = proyectos.codigoEstado;";

            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarCompras);

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static ResultSet buscarCompraPorNombre(String descripcionProyecto) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {
            String buscarCompraNombre = "select codigoOrdenCompra, fechaEmisionOrdenCompra, descripcionProyecto, "
                    + "nombreProveedor, descripcionEstado, nombreEmpleado from ordencompras inner join proveedores "
                    + "on ordencompras.codigoProveedor = proveedores.codigoProveedor inner join estados on "
                    + "ordencompras.codigoEstado = estados.codigoEstado inner join  empleados on "
                    + "ordencompras.codigoEmpleado = empleados.codigoEmpleado  inner join proyectos "
                    + "on empleados.codigoEstado = proyectos.codigoEstado WHERE proyectos.descripcionProyecto  LIKE \"%" + descripcionProyecto + "%\"";

            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarCompraNombre);

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static ResultSet extraerDatosCompras(String codigoOrdenCompra) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerCompra = "select codigoOrdenCompra, fechaEmisionOrdenCompra, a.codigoProveedor,b.nombreProveedor,a.codigoEmpleado, c.nombreEmpleado, a.codigoEstado,d.descripcionEstado from ordencompras a inner join proveedores b on a.codigoProveedor=b.codigoProveedor inner join empleados c on a.codigoEmpleado=c.codigoEmpleado inner join estados d on a.codigoEstado=d.codigoEstado  where codigoOrdenCompra= '" + codigoOrdenCompra + "';";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerCompra);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static ResultSet extraerDatosComprasMateriales() {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerCompra = "select a.codigoMaterial, b.descripcionMaterial, cantidadMaterial From detalleordencompra AS a inner join materiales as b on a.codigoMaterial= b.codigoMaterial;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerCompra);

            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return rs;
        }

    }

    

    public static boolean actualizarCompra(int codigo,String codigoCompra, String fechaEmision, String codigoProveedor, String codigoEmpleado, String codigoEstado) {
        Connection con = MantenimientoUsuarios.con;
        try {

            String actualizarsql = "UPDATE ordencompras SET codigoOrdenCompra='" + codigoCompra + "',fechaEmisionOrdenCompra='" + fechaEmision + "',codigoProveedor='" + codigoProveedor + "', codigoEmpleado='" + codigoEmpleado + "', codigoEstado='" + codigoEstado + "' WHERE codigoOrdenCompra='" + codigo + "'";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarsql);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static ResultSet buscarComprasEstado(String estado) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String buscarComprasEstado = "select codigoOrdenCompra, fechaEmisionOrdenCompra, descripcionProyecto, "
                    + "nombreProveedor, descripcionEstado, nombreEmpleado from ordencompras inner join proveedores "
                    + "on ordencompras.codigoProveedor = proveedores.codigoProveedor inner join estados on "
                    + "ordencompras.codigoEstado = estados.codigoEstado inner join  empleados on "
                    + "ordencompras.codigoEmpleado = empleados.codigoEmpleado  inner join proyectos "
                    + "on empleados.codigoEstado = proyectos.codigoEstado  WHERE  estados.descripcionEstado LIKE \"" + estado + "\";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarComprasEstado);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
    
     public static int obtenerCodigo(String codigoOrdenCompra) {
        try {
            String sqlSelect = "Select codigoOrdenCompra from ordencompras where codigoOrdenCompra = '" + codigoOrdenCompra + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {

                return rs.getInt("codigoOrdenCompra");
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
