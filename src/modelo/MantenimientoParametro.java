/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level; 
import static vista.Login.con;

/**
 *
 * @author VILLALTA
 */
public class MantenimientoParametro {

    public static ResultSet mostrarParametro(String codigoParametro) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
 
            String mostrarCliente = "SELECT codigoParametro codigo,descripcionParametro Descripción, valor Valor FROM desarrollo.parametros;" ;                         
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(mostrarCliente);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

   public static ResultSet extraerDatosParametro(String codigoParametro) {
        
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {
            
            String extraerCliente = "SELECT descripcionParametro,valor FROM parametros where codigoParametro=" + codigoParametro + ";"; 
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerCliente);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }    
   
    public static boolean actualizarParametro(int codigo,String descripcionParametro, String valor) {
        Connection con = MantenimientoUsuarios.con;
        try {
            String actualizarsql = "UPDATE parametros SET descripcionParametro='" + descripcionParametro + "',valor='" + valor + "' WHERE codigoParametro='" + codigo + "';";
           
           Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarsql);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static int obtenerCodigo(String descripcionParametro) {
        try {
            String sqlSelect = "Select codigoParametro from parametros where descripcionParametro = '" + descripcionParametro + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);
            if (rs.next()) {
                return rs.getInt("codigoParametro");
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