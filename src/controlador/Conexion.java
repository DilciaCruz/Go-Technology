/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rosa Sandoval
 */
public class Conexion {
    
    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario="root";
    private static final String clave="1234";
    private static final String url="jdbc:mysql://localhost:3306/desarrollo";
    
    public Conexion() {
        
        conexion=null;
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,usuario,clave);
            if(conexion!=null){
                System.out.println("Conexion a la base de datos establecida correctamente");
            }
        } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Ocurrió un error en la conexion a la base de datos");
        }
        
    }
    
    //este metodo nos retorna la conexion a la base de datos
    public Connection getConexion(){
        return conexion;
    }
    
    
    //con este metodo nos desconectamos de la base de datos
    public void desconectar(){
        conexion=null;
        if(conexion==null){
            System.out.println("Conexion finalizada");
        }
    }
    
}
