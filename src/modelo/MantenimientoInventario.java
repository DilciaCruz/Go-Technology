/**
 * Elaborado por Alexei Rodriguez y Franklin Villalta
 * Fecha 24/07/2017 12:09 pm
 * Versión 1.3
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MantenimientoInventario {
    
    //importar conexión de la base de datos
    public static Connection con = MantenimientoUsuarios.con;
    
    //extraer todos los elementos del inventario
    public static ResultSet mostrarInventario() {

        ResultSet rs = null;

        try {
            String sqlSelect = "select materiales.codigoMaterial as Codigo, "
                    + "materiales.descripcionMaterial as Nombre, "
                    + "materiales.cantidad as Cantidad, "
                    + "estados.descripcionEstado as Estado from materiales "
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
    
    //funcion para buscar material mediante el nombre y estado
    public static ResultSet obtenerMaterialPorNombreYEstado(String descripcion, String estado) {
        ResultSet rs = null;

        try {
            String sqlBuscar = "select materiales.codigoMaterial as Codigo, "
                    + "materiales.descripcionMaterial as Nombre, "
                    + "materiales.cantidad as Cantidad, "
                    + "estados.descripcionEstado as Estado from materiales "
                    + "inner join estados on materiales.codigoEstado = estados.codigoEstado "
                    + "where materiales.descripcionMaterial like \"%" + descripcion + "%\" "
                    + "and estados.descripcionEstado LIKE '" + estado + "'  group by materiales.codigoMaterial;";
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
    
    //funcion para obtener el material por medio de ID
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
    
    //funcion para actualizar materiales
    public static boolean actualizarMateriales(String nombre, String cantidad, int codigoEstado, int codigoMaterial) {

        try {
            String sqlActualizar = "UPDATE materiales set descripcionMaterial = '" + nombre + "', cantidad = " + cantidad + ", codigoEstado = " + codigoEstado + " where codigoMaterial = " + codigoMaterial + " ;";
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
    
    //funcion para agregar un material nuevo a la bd
    public static boolean insertarMateriales(String nombre, String cantidad, int codigoEstado) {

        try {
            String sqlInsertar = "INSERT INTO materiales (descripcionMaterial, cantidad, reOrden, codigoEstado) values ('" + nombre + "', " + cantidad + ", "+ 0 +" ," + codigoEstado + ");";
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
