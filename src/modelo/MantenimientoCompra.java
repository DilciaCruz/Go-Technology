/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
import controlador.Encriptamiento;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static modelo.MantenimientoUsuarios.con;

/**
 *
 * @author AnabelReyes
 */
public class MantenimientoCompra {

       public static ResultSet mostrarCompras(String nombreComp) {
      //  Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {
            String buscarCompras = "SELECT ordencompras.codigoOrdenCompra,proyectos.descripcionProyecto, proveedores.nombreProveedor,ordencompras.fechaEmisionOrdencompra, estados.descripcionEstado\n" +
"            from ordencompras inner join proyectos on ordencompras.codigoEstado= proyectos.codigoEstado\n" +
"             inner join proveedores on proveedores.codigoEstado= proyectos.codigoEstado\n" +
"             inner join estados on  estados.codigoEstado= proyectos.codigoEstado;";
            
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
            String buscarCompraNombre = "SELECT ordencompras.codigoOrdenCompra,proyectos.descripcionProyecto, proveedores.nombreProveedor,ordencompras.fechaEmisionOrdencompra, estados.descripcionEstado\n" +
"            from ordencompras inner join proyectos on ordencompras.codigoEstado= proyectos.codigoEstado\n" +
"             inner join proveedores on proveedores.codigoEstado= proyectos.codigoEstado\n" +
"             inner join estados on  estados.codigoEstado= proyectos.codigoEstado WHERE proyectos.descripcionProyecto  LIKE \"%" + descripcionProyecto + "%\"";

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
    //    Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerCompra = "SELECT  codigoOrdenCompra, descripcionProyecto,nombreProveedor,fechaEmisionOrdencompra, descripcionEstado FROM ordencompras where codigoOrdenCompra=" + codigoOrdenCompra + ";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerCompra);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }


    public static boolean actualizarCompra(String codigo, String proyecto , String proveedor, String fecha, String estado) {
        Connection con = MantenimientoUsuarios.con;
        try {

            String actualizarsql = "UPDATE ordencompra SET codigoOrdenCompra='" + codigo + "',descripcionProyecto='" + proyecto + "',fechaEmisionOrdenCompra='" + fecha + "', descripcionEstado='" + estado +  "' WHERE codigoOrdenCompra='" + codigo + "';";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarsql);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCompra.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

  }

   
    



   

