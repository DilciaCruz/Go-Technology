/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Encriptamiento;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rosa Sandoval
 */
public class MantenimientoEmpleados {

    public static Boolean insertarEmpleados(String identidadEmpleado, String nombreEmpleado, String apellidoEmpleado, String telefonoEmpleado, String correoEmpleado, String direccionEmpleado, String nombreUsuario, String claveUsuario, String codigoPuesto, String codigoEstado) {
        Connection con = MantenimientoUsuarios.con;
        String encrip = null;
        try {
            encrip = Encriptamiento.obtenerMD5(claveUsuario);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        try {

            String insertarsql = "INSERT INTO empleados (identificacion,nombreEmpleado,apellidosEmpleado,telefonoEmpleado,correoElectronico,direccionEmpleado,nombreUsuario,claveUsuario,codigoPuesto,codigoEstado) VALUES ('" + identidadEmpleado + "','" + nombreEmpleado + "','" + apellidoEmpleado + "','" + telefonoEmpleado + "','" + correoEmpleado + "','" + direccionEmpleado + "','" + nombreUsuario + "','" + encrip + "','" + codigoPuesto + "','" + codigoEstado + "');";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertarsql);

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }

    }

    public static ResultSet mostrarEmpleado(String nombreEmp) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {
            String buscarEmpleado = "select empleados.codigoEmpleado Código, empleados.nombreEmpleado Nombres, empleados.apellidosEmpleado Apellidos,empleados.nombreUsuario Usuario, puestos.descripcionPuesto Puesto,estados.descripcionEstado Estado\n"
                    + "from empleados inner join puestos on empleados.codigoPuesto=puestos.codigoPuesto \n"
                    + "inner join estados on estados.codigoEstado=puestos.codigoEstado;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarEmpleado);

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static ResultSet buscarEmpleadoPorNombre(String nombreEmpleado) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {
            String buscarEmpleadoNombre = "select empleados.codigoEmpleado Código, empleados.nombreEmpleado Nombres, empleados.apellidosEmpleado Apellidos,empleados.nombreUsuario Usuario, puestos.descripcionPuesto Puesto,estados.descripcionEstado Estado\n"
                    + "from empleados inner join puestos on empleados.codigoPuesto=puestos.codigoPuesto \n"
                    + "inner join estados on estados.codigoEstado=puestos.codigoEstado WHERE empleados.nombreEmpleado LIKE \"%" + nombreEmpleado + "%\"";

            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarEmpleadoNombre);

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

    public static ResultSet extraerDatosEmpleado(String codigoEmpleado) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;
        try {

            String extraerEmpleado = "SELECT identificacion ,nombreEmpleado ,apellidosEmpleado,telefonoEmpleado,correoElectronico, direccionEmpleado,nombreUsuario,claveUsuario FROM empleados where codigoEmpleado=" + codigoEmpleado + ";";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerEmpleado);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static boolean actualizarEmpleado(String codigo, String id, String nombres, String apellidos, String tel, String correo, String dir, String usuario, String clave) {
        Connection con = MantenimientoUsuarios.con;
        try {

            String actualizarsql = "UPDATE empleados SET identificacion='" + id + "',nombreEmpleado='" + nombres + "',apellidosEmpleado='" + apellidos + "',telefonoEmpleado='" + tel + "',correoElectronico='" + correo + "',direccionEmpleado='" + dir + "',nombreUsuario='" + usuario + "',claveUsuario='" + clave + "' WHERE codigoEmpleado='" + codigo + "';";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(actualizarsql);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
