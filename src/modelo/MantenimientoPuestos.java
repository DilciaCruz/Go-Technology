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
 * @author USUARIO
 */
public class MantenimientoPuestos {
    
    public static boolean insertarPuestos(String descripcionPuesto, String codigoEstado) {
    Connection con = Usuarios.con;
        
        try {
            
           String insertsql = "INSERT INTO puestos (descripcionPuesto, codigoEstado) VALUES ('"+descripcionPuesto+"','"+codigoEstado+"');";
           
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
        Connection con = Usuarios.con;
        ResultSet rs = null;
        try {

            String mostrarPuestos = "SELECT codigoPuesto Codigo,descripcionPuesto Descripcion, codigoEstado Estado FROM puestos";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(mostrarPuestos);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }
    
    public static ResultSet Buscar(String descripcionPuesto) {
        Connection con = Usuarios.con;
        ResultSet rs = null;
        try {

            String Buscar = "SELECT codigoPuesto Codigo,descripcionPuesto Descripcion, codigoEstado Estado FROM puestos WHERE descripcionPuesto LIKE \"%"+descripcionPuesto+"%\"";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(Buscar);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
        
}
