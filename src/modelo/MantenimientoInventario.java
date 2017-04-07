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
            String sqlSelect = "select materiales.codigoMaterial as Codigo, "
                    + "materiales.descripcionMaterial as Nombre, "
                    + "materiales.cantidad as Cantidad, "
                    + "materiales.reOrden as 'Punto de Reorden', "
                    + "estados.descripcionEstado from materiales "
                    + "inner join estados on materiales.codigoEstado = estados.codigoEstado;";

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

    public static ResultSet obtenerMaterialPorNombreYEstado(String descripcion, String estado) {
        ResultSet rs = null;

        try {
            String sqlBuscar = "select materiales.codigoMaterial as Codigo, "
                    + "materiales.descripcionMaterial as Nombre, "
                    + "materiales.cantidad as Cantidad, "
                    + "materiales.reOrden as 'Punto de Reorden', "
                    + "estados.descripcionEstado from materiales "
                    + "inner join estados on materiales.codigoEstado = estados.codigoEstado "
                    + "where materiales.descripcionMaterial like \"%" + descripcion + "%\" "
                    + "and estados.descripcionEstado LIKE \"%" + estado + "%\"  group by materiales.codigoMaterial;";
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

    public static ResultSet obtenerEstadosPorCantidad(int cantidad) {

        ResultSet rs = null;

        try {

            String sqlSelect;

            if (cantidad > 0) {

                sqlSelect = "Select * from estados where codigoEstado = 10 or codigoEstado = 4;";

            } else {

                sqlSelect = "Select * from estados where codigoEstado = 11 or codigoEstado = 4;";
            }

            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            return rs;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            System.err.println("Error de query");
            return rs;
        }
    }

    public static boolean actualizarMateriales(String nombre, String cantidad, String reOrden, int codigoEstado, int codigoMaterial) {

        try {
            String sqlActualizar = "UPDATE materiales set descripcionMaterial = '" + nombre + "', cantidad = " + cantidad + ", reOrden = " + reOrden + ", codigoEstado = " + codigoEstado + " where codigoMaterial = " + codigoMaterial + " ;";
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

    public static boolean insertarMateriales(String nombre, String cantidad, String reOrden, int codigoEstado) {

        try {
            String sqlInsertar = "INSERT INTO materiales (descripcionMaterial, cantidad, reOrden, codigoEstado) values ('" + nombre + "', " + cantidad + ", " + reOrden + ", " + codigoEstado + ");";
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

    public static ResultSet mostrarMaterialesReservados() {
        ResultSet rs = null;

        try {
            String sqlSelect = "select materiales.codigoMaterial as 'Codigo Material', "
                    + "materiales.descripcionMaterial as 'Nombre Material', "
                    + "mueblesmateriales.cantidad as 'Cantidad Material Reservado', "
                    + "proyectos.codigoProyecto as 'Codigo Proyecto', "
                    + "proyectos.descripcionProyecto as 'Descripcion Proyecto', "
                    + "productos.descripcionProducto as 'Nombre Producto'"
                    + "  from mueblesmateriales "
                    + "inner join materiales "
                    + "on mueblesmateriales.codigoMaterial = materiales.codigoMaterial "
                    + "inner join proyectos on mueblesmateriales.codigoProyecto = proyectos.codigoProyecto "
                    + "inner join productos on mueblesmateriales.codigoProducto = productos.codigoProducto;";

            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            return rs;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return rs;

        }

    }

    public static ResultSet obtenerMaterialesReservadosPorNombre(String descripcion) {
        ResultSet rs = null;

        try {
            String sqlSelect = "select materiales.codigoMaterial as 'Codigo Material', "
                    + "materiales.descripcionMaterial as 'Nombre Material', "
                    + "mueblesmateriales.cantidad as 'Cantidad Material Reservado', "
                    + "proyectos.codigoProyecto as 'Codigo Proyecto', "
                    + "proyectos.descripcionProyecto as 'Descripcion Proyecto', "
                    + "productos.descripcionProducto as 'Nombre Producto' "
                    + "from mueblesmateriales "
                    + "inner join materiales on mueblesmateriales.codigoMaterial = materiales.codigoMaterial "
                    + "inner join proyectos on mueblesmateriales.codigoProyecto = proyectos.codigoProyecto "
                    + "inner join productos on mueblesmateriales.codigoProducto = productos.codigoProducto "
                    + "where materiales.descripcionMaterial like \"%" + descripcion + "%\";";

            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            return rs;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return rs;
        }
    }

    public static ResultSet mostrarMaterialeReservadoPorID(String ID) {
        ResultSet rs = null;

        try {
            String sqlSelect = "select materiales.codigoMaterial, "
                    + "materiales.descripcionMaterial, "
                    + "mueblesmateriales.cantidad, "
                    + "proyectos.codigoProyecto, "
                    + "proyectos.descripcionProyecto, "
                    + "productos.descripcionProducto"
                    + "from mueblesmateriales "
                    + "inner join materiales "
                    + "on mueblesmateriales.codigoMaterial = materiales.codigoMaterial "
                    + "inner join proyectos on mueblesmateriales.codigoProyecto = proyectos.codigoProyecto "
                    + "inner join productos on mueblesmateriales.codigoProducto = productos.codigoProducto;";

            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            return rs;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return rs;

        }

    }

}
