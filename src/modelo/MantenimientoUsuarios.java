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

    public static final Connection con = Conexion.conexion;
    public static int id;
    public static int intentos = 0;

    public static boolean login(String usuario, String clave, int codigoPuesto) {

        try {

            String qry = "SELECT * FROM empleados WHERE nombreUsuario = '" + usuario + "' AND claveUsuario = '" + clave + "';";
            Statement st;
            st = con.createStatement();

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

    public static int obtenerCodigo(String usuario) {
        try {
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

    public static int obtenerCodigoPuesto(String usuario) {
        try {
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
    
    public static String obtenerClave(String usuario) {

        try {
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
