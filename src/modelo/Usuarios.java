/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import controlador.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Login;
/**
 *
 * @author Alexei Rodriguez
 */
public class Usuarios {
    
    public static final Connection con = Conexion.conexion;
    
    public static boolean login(String usuario, String clave){
        try {
            
            String qry = "SELECT * FROM empleados WHERE nombreUsuario = '"+usuario+"' AND claveUsuario = '"+clave+"';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            
            if(rs.next()){
                System.out.println("Acceso correcto.");
                return true;
            }else{
                System.out.println("Acceso denegado.");
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
