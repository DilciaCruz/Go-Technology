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
    
    public static final Connection con = Conexion.conexion;
    
    

    public static boolean puestos(String descripcionPuesto) {
        
        try {
            String sql = "INSERT INTO puestos (descripcionPuesto= '"+descripcionPuesto+"') VALUES (?) ";
            
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                System.out.println("Acceso correcto.");
                return true;
            }else{
                System.out.println("Acceso denegado.");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoPuestos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
        
}
