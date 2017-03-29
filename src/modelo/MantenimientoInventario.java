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

/**
 *
 * @author Alexei Rodriguez
 */
public class MantenimientoInventario {

    public static Connection con = MantenimientoUsuarios.con;

    public static ResultSet mostrarInventario() {

        ResultSet rs = null;
        try {
            String sqlSelect = "Select codigoMaterial as Codigo, descripcionMaterial as Descripcion, cantidad as Cantidad, reOrden as Cantidad_Reorden,  descripcionEstado as Estado From materiales inner join estados on materiales.codigoEstado=estados.codigoEstado";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            return rs;
        } catch (SQLException e) {
            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public static ResultSet obtenerMaterialPorNombre(String descripcion) {
        ResultSet rs = null;

        try {
            String sqlBuscar = "Select codigoMaterial as Codigo, descripcionMaterial as Descripcion,cantidad as Cantidad, reOrden as Cantidad_Reorden, cantidadMaterialesReservados as Materiales_Reservados,  descripcionEstado as Estado From materiales inner join estados on materiales.codigoEstado=estados.codigoEstado where materiales.descripcionMaterial LIKE \"%" + descripcion + "%\";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            return rs;

        } catch (Exception e) {
            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return rs;
        }

    }

    public static ResultSet obtenerMaterialPorID(String ID) {
        ResultSet rs = null;

        try {
            String sqlBuscar = "Select * from materiales where codigoMaterial = " + ID + " ;";
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

    public static int obtenerCodigoMaterial(String nombre) {

        try {
            String sqlSelect = "Select codigoMaterial from materiales where descripcionMaterial = '" + nombre + "';";
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);
            
            return rs.getInt("codigoMaterial");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.err.println("Error de query");
            return 0;
        }
    }

    public static boolean actualizarMateriales(String nombre, String cantidad, String reOrden, String codigoEstado ,int codigoMaterial) {

        try {
            String sqlActualizar = "UPDATE materiales set descripcionMaterial = '" + nombre + "', cantidad = " + cantidad + ", reOrden = " + reOrden + ", codigoEstado = "+codigoEstado+" where codigoMaterial = " + codigoMaterial + " ;";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(sqlActualizar);
            return true;
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            System.out.println("Error de query");
            return false;
        }

    }
    
    public static boolean insertarMateriales(String nombre, String cantidad, String reOrden, String codigoEstado){
        try {
            String sqlInsertar = "INSERT INTO materiales (descripcionMaterial, cantidad, reOrden, codigoEstado) values ('"+nombre+"', "+cantidad+", "+reOrden+", "+codigoEstado+");";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(sqlInsertar);
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error de query");
            System.out.println(e.getMessage());
        }
        return false;
    
    }
}
