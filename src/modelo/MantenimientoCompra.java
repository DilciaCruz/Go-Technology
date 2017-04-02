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

       private static String claveUsuario;
    
    
     public static Boolean insertarCompra(String codigoOrdenCompra, String descripcionProyecto, String nombreProveedor, String fechaEmisionOrdenCompra, String descripcionEstado, String nombreEmpleado) {
        Connection con = MantenimientoUsuarios.con;
        String encrip = null;
        try {
            encrip = Encriptamiento.obtenerMD5(claveUsuario);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        try {

            String insertarsql = "INSERT INTO ordencompras (codigoOrdenCompra, descripcionProyecto, nombreProveedor, fechaEmisionOrdenCompra, descripcionEstado, nombreEmpleado) VALUES ('" + codigoOrdenCompra + "','" + descripcionProyecto + "','" + nombreProveedor + "','" + fechaEmisionOrdenCompra + "','" + descripcionEstado+"', '" + nombreEmpleado+"', );";
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

    public static ResultSet buscarCompraPorNombre(String descripcionProyecto ) {
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

            String extraerCompra = "SELECT  codigoOrdenCompra, descripcionProyecto,nombreProveedor,fechaEmisionOrdenCompra, descripcionEstado,nombrempleado FROM ordencompras where codigoOrdenCompra=" + codigoOrdenCompra + ";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerCompra);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }


    public static boolean actualizarCompra(String codigo, String proyecto , String proveedor, String fecha, String estado, String Empleado) {
        Connection con = MantenimientoUsuarios.con;
        try {

            String actualizarsql = "UPDATE ordencompra SET codigoOrdenCompra='" + codigo + "',descripcionProyecto='" + proyecto + "',fechaEmisionOrdenCompra='" + fecha + "', descripcionEstado='" + estado + "', NombreEmpleado='" + Empleado +  "' WHERE codigoOrdenCompra='" + codigo + "'";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarsql);
            return true;

        } catch (SQLException ex) {
           Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean insertarCompra(String codigoOrdenCompra, String nombreProveedor, String codigoEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
    


   

