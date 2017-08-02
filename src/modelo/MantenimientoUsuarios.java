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
import javax.swing.JOptionPane;
import vista.Login;

/**
 *
 * @author Alexei Rodriguez
 */
public class MantenimientoUsuarios {
    //variable de tipo público estático que almacena la conexion a la base de datos del sistema
    public static final Connection con = Conexion.conexion;
    
    //variable de tipo público estático para almacenar el ID del usuario
    public static int id;
    
    //variable de tipo público estático que almacenará los intentos de inicio de sesion que realizara el usuario 
    public static int intentos = 0;

    /*función de tipo público estático boleano con los parametros usuario, clave y codigoPuesto 
    del usuario para conocer el rol de éste*/
    public static boolean login(String usuario, String clave, int codigoPuesto) {
        
        try {
            //query que extrae de la tabla empleados los campos de nombreUsuario y claveUsuario
            String qry = "SELECT * FROM empleados WHERE nombreUsuario = '" + usuario + "' AND claveUsuario = '" + clave + "';";
            
            //guardamos la conexion en un statement
            Statement st;
            st = con.createStatement();
            
            //y le pasamos el query dentro del statement, que ira dentro del resultset
            ResultSet rs = st.executeQuery(qry);
            
            intentos = obtenerIntentosUsuario(usuario);
            id = obtenerCodigo(usuario);
            if (rs.next()) {
                System.out.println("Acceso correcto.");
                resetIntentos(id);
                System.out.println(intentos);
                return true;
            } else {

                System.out.println(intentos);

                if (intentos < 3 && codigoPuesto != 1) {
                    System.out.println(codigoPuesto);
                    sumarIntentos(id);
                    System  .out.println("Acceso denegado.");
                    return false;
                } else {

                    if (codigoPuesto == 1) {
                        
                        return false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario Bloqueado");
                        bloquearUsuario(usuario);
                        return false;
                    }
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // funcion publico estatico que obtiene el codigo del usuario por medio del parametro usuario
    public static int obtenerCodigo(String usuario) {
        try {
            //query para seleccionar el nombre del usuario desde la tabla de empleados
            String sqlSelect = "Select codigoEmpleado from empleados where nombreUsuario = '" + usuario + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {

                return rs.getInt("codigoEmpleado");
            } else {

                return 0;

            }
        } catch (SQLException e) {

            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    //funcion publico estatica que obtiene el codigoPuesto del usuario con el parametro usuario
    public static int obtenerCodigoPuesto(String usuario) {
        try {
            //query para extraer el codigoPuesto del empleado filtrado por el nombreUsuario
            String sqlSelect = "Select codigoPuesto from empleados where nombreUsuario = '" + usuario + "';";
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
    
    //funcion que obtiene el codigoPuestos con el parametro descripcionPuesto
    public static int obtenerCodigoPuestos(String descripcionPuesto) {
        try {
            String sqlSelect = "Select codigoPuesto from puestos where descripcionPuesto LIKE \"%" + descripcionPuesto + "%\";";
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
    
    //funcion que obtiene la clave por medio del parametro usuario 
    public static String obtenerClave(String usuario) {

        try {
            //query para extraer los datos del usuario que está logueado 
            String sqlSelect = "select * from empleados where nombreUsuario='" + usuario + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {

                return rs.getString("claveUsuario");

            } else {
                JOptionPane.showMessageDialog(null, "Clave no obtenida");
                return "";

            }
        } catch (SQLException e) {

            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return "";
        }

    }
    
    //funcion que acumula los intentos del usuario al iniciar sesion
    public static void sumarIntentos(int id) {

        try {
            String updateSql = "update empleados set intentos = intentos + 1 where codigoEmpleado = '" + id + "';";

            Statement st;
            st = con.createStatement();
            st.executeUpdate(updateSql);

        } catch (SQLException e) {

            System.out.println("Error de conexion");
            System.out.println(e.getMessage());

        }
    }
    
    //funcion que reestablece los intentos de inicio de sesion al valor inicial
    public static void resetIntentos(int id) {

        try {
            String updateSql = "update empleados set intentos = 0 where codigoEmpleado = '" + id + "';";

            Statement st;
            st = con.createStatement();
            st.executeUpdate(updateSql);

        } catch (SQLException e) {

            System.out.println("Error de conexion");
            System.out.println(e.getMessage());

        }

    }
    
    //funcion que bloquea el acceso del usuario una vez que ha utilizado todos sus intentos de inicio de sesion
    public static void bloquearUsuario(String usuario) {

        try {

            String updateSql = "UPDATE empleados SET codigoEstado = '" + 2 + "' where nombreUsuario = '" + usuario + "';";

            Statement st;
            st = con.createStatement();
            st.executeUpdate(updateSql);

        } catch (SQLException e) {

            System.out.println("Error de Login");
            System.out.println(e.getMessage());
        }
    }
    
    /*funcion que obtiene la cantidad de intentos que el usuario ha realizado para conocer cuantos intentos 
    le quedan disponibles*/
    public static int obtenerIntentosUsuario(String usuario) {

        try {

            String sqlSelect = "Select intentos from empleados where nombreUsuario = '" + usuario + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {

                return rs.getInt("intentos");
            } else {

                return 0;

            }
        } catch (SQLException e) {

            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return 0;
        }

    }
    
    //funcion que muestra el estado que tiene el usuario para acceder al sistema
    public static int obtenerEstadoUsuario(String usuario) {

        try {

            String sqlSelect = "Select codigoEstado from empleados where nombreUsuario = '" + usuario + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            if (rs.next()) {

                return rs.getInt("codigoEstado");
            } else {

                return 0;

            }
        } catch (SQLException e) {

            System.out.println("Error de query");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    //funcion que sirve para cambiar el estado que tendrá el usuario para acceder al sistema
    public static void actualizarEstadoEmpleado(String usuario, int estado) {
        try {
            String updateSql = "UPDATE empleados SET codigoEstado = '" + estado + "' where nombreUsuario = '" + usuario + "';";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(updateSql);
        } catch (SQLException e) {

            System.out.println("Error al actualizar estado");
            System.out.println(e.getMessage());
        }
    }
    
    //funcion que sirve para extraer los datos del usuario
    public static ResultSet extraerDatosUsuario(String codigoEmpleado) {

        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {

            String extraerUsuario = "SELECT codigoEmpleado, nombreUsuario from empleados where codigoEmpleado=" + codigoEmpleado + ";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerUsuario);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
    
    //funcion que sirve para extraer los datos del perfil del usuario que está logueado
    public static ResultSet extraerPerfilUsuario(String nombreUsuario) {

        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {

            String extraerUsuario = "SELECT a.identificacion, a.nombreEmpleado, a.apellidosEmpleado, a.telefonoEmpleado, a.correoElectronico, a.direccionEmpleado, a.nombreUsuario, b.descripcionPuesto  FROM empleados a inner join puestos b on a.codigoPuesto = b.codigoPuesto WHERE nombreUsuario='"+ nombreUsuario+"';";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerUsuario);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }
    
    
    public static int obtenerCodigoPuestos(int codigoPuesto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
