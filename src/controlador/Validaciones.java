/**
 * Elaborado por Alexei Rodriguez y Franklin Villalta
 * Fecha 24/07/2017 12:09 pm
 * Versión 1.3
 */
package controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
    //Validación del correo 
    public static boolean email_validation(String email) {
        boolean status = false;     
    String email_Pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";    
    Pattern pattern = Pattern.compile(email_Pattern);
    Matcher matcher = pattern.matcher(email);    
    if(matcher.matches()){
        status = true;
    }else{
        status = false;        
    }
        return status;
    }
    
}
