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

/**
 *
 * @author Daniela Ordoñez
 */
public class MantenimientoProductos {

    public static final Connection con = Conexion.conexion;

    public static ResultSet mostrarProductos() {

        ResultSet rs = null;
        try {
            String sqlSelect = "Select codigoProducto as Producto, codigoEstado as Estado, descripcionProducto as Descripcion from productos;";
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
            String sqlBuscar = "SELECT * FROM productos where descripcionProducto ='" + descripcionProducto + "';";
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

    public static boolean insertarProducto(String codigoEstado, String descripcionProducto ) {
        
        try {
            String sqlInsertar = "INSERT into productos (codigoEstado,descripcionProducto) VALUES ('" + codigoEstado + "','" +  descripcionProducto + "');";
            Statement st;
            st = con.createStatement();
            st.executeQuery(sqlInsertar);

            return true;
        } catch (Exception e) {
            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return false;
        }
    }

}
