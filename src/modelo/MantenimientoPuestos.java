/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static vista.Login.con;

/**
 *
 * @author USUARIO
 */
public class MantenimientoPuestos {

    public static boolean insertarPuestos(String descripcionPuesto, String codigoEstado) {
        Connection con = MantenimientoUsuarios.con;

        try {

            String insertsql = "INSERT INTO puestos (descripcionPuesto, codigoEstado) VALUES ('" + descripcionPuesto + "','" + codigoEstado + "');";

            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertsql);

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoPuestos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static ResultSet mostrarPuestos(String descripcionPuesto) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String mostrarPuestos = "select puestos.codigoPuesto,puestos.descripcionPuesto,estados.descripcionEstado\n"
                    + "from puestos inner join estados on estados.codigoEstado=puestos.codigoEstado;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(mostrarPuestos);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoPuestos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static ResultSet Buscar(String descripcionPuesto) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String Buscar = "select puestos.codigoPuesto Codigo,puestos.descripcionPuesto Descripcion,estados.descripcionEstado Estados from puestos inner join estados on puestos.codigoEstado=estados.codigoEstado WHERE puestos.descripcionPuesto LIKE \"%" + descripcionPuesto + "%\"";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(Buscar);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoPuestos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static ResultSet extraerDatosPuestos(String codigoPuesto) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerPuesto = "SELECT codigoPuesto,descripcionPuesto,a.codigoEstado,b.descripcionEstado FROM puestos a inner join estados b on a.codigoEstado =b.codigoEstado where codigoPuesto=" + codigoPuesto + ";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerPuesto);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoPuestos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
    
     public static int obtenerCodigo(String codigoPuesto) {
        try {
            String sqlSelect = "Select codigoPuesto from puestos where codigoPuesto = '" + codigoPuesto + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);
            if (rs.next()) {
                return rs.getInt("codigoPuesto");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public static boolean actualizarPuestos(int codigo, String codigoPuesto, String descripcionPuesto, String codigoEstado) {
        
        Connection con = MantenimientoUsuarios.con;
        try {

            String actualizarsql = "UPDATE puestos SET codigoPuesto='" + codigoPuesto + "' ,descripcionPuesto='" + descripcionPuesto + "' ,codigoEstado= '" + codigoEstado + "' WHERE codigoPuesto= '" + codigo + "';";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarsql);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoPuestos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
