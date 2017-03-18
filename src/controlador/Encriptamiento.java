package controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import vista.Login;

public class Encriptamiento {

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
}
