
package controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import vista.Login;
import vista.RestablecerClaves;

public class Encriptamiento {
    
    //funcion para convertir la clave del usuario en MD5
    public static String obtenerMD5(String clave) throws NoSuchAlgorithmException {

        Connection con = Login.con;

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(clave.getBytes());
        byte[] b = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte bl : b) {
            sb.append(Integer.toHexString(bl & 0xff));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    //funcion para actualizar la clave del usuario a MD5 una vez que se crea el usuario
    public static void main(String[] args){
                
        String nuevaclave = RestablecerClaves.clave;
        
        Connection con = Login.con;
        
        String sqlEncriptamiento="UPDATE empleados set claveUsuario=? WHERE nombreUsuario=?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sqlEncriptamiento);
            
            ps.setString(1,obtenerMD5(nuevaclave));
            ps.setString(2,Login.usuario); // le pasamos como parametro 
            int rs = ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Clave encriptada exitosamente"); 
            
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null,"ERROR, Clave No pudo ser encriptada "); 
        }
    }
    
}
