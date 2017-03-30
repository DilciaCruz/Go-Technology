/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniela Ordoñez
 */
public class MantenimientoProductos {

    public static final Connection con = Conexion.conexion;

    public static ResultSet mostrarProductos() {

        ResultSet rs = null;
        try {
            String sqlSelect = "select productos.codigoProducto as Codigo_Producto,estados.descripcionEstado as Estado , productos.descripcionProducto as Descripcion from productos inner join estados on estados.codigoEstado=productos.codigoEstado;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            return rs;
        } catch (SQLException e) {

            return rs;
        }
    }

    public static ResultSet buscarProductoPorNombre(String descripcionProducto) {

        ResultSet rs = null;
        try {
            String sqlBuscar = "SELECT productos.codigoProducto Codigo, estados.descripcionEstado Estado, productos.descripcionProducto Descripcion FROM productos inner join estados on productos.codigoEstado = estados.codigoEstado where productos.descripcionProducto LIKE \"%" + descripcionProducto + "%\"";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);

            return rs;
        } catch (SQLException e) {
            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public static ResultSet extraerDatosProducto(String codigoProducto) {

        ResultSet rs = null;

        try {
            String extraerProducto = "SELECT codigoProducto, a.codigoEstado, b.descripcionEstado, descripcionProducto FROM productos a inner join estados b on a.codigoEstado = b.codigoEstado where codigoProducto=" + codigoProducto + ";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerProducto);

            return rs;
        } catch (SQLException ex) {
            System.out.println("Error de query");
            return rs;
        }

    }

    public static boolean insertarProducto(String codigoEstado, String descripcionProducto) {

        try {
            String sqlInsertar = "INSERT into productos (codigoEstado,descripcionProducto) VALUES (" + codigoEstado + " , '" + descripcionProducto + "');";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(sqlInsertar);

            return true;
        } catch (SQLException e) {
            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean actualizarProducto(int codigo, String codigoProducto, String codigoEstado, String descripcionProducto) {

        try {
            String actualizarProducto = "UPDATE productos SET codigoEstado= '" + codigoEstado + "', descripcionProducto= '" + descripcionProducto + "' WHERE codigoProducto= '" + codigoProducto + "';";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarProducto);
            return true;

        } catch (SQLException ex) {
            System.out.println("Error de query");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static int obtenerCodigoProducto(String codigoProducto) {
        try {
            String sqlSelect = "Select codigoProducto from productos where codigoProducto= '" + codigoProducto + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {
                return rs.getInt("codigoProducto");
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
