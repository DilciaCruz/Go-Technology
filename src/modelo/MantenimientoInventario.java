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
            String sqlSelect = "Select codigoMaterial as Codigo, descripcionMaterial as Descripcion,cantidad as Cantidad, reOrden as Cantidad_Reorden, cantidadMaterialesReservados as Materiales_Reservados,  descripcionEstado as Estado From materiales inner join estados on materiales.codigoEstado=estados.codigoEstado";
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
}
