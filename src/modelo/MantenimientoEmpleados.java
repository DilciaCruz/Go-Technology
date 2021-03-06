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
            String buscarEmpleado = "select empleados.codigoEmpleado, empleados.identificacion Identificacion, empleados.nombreEmpleado Nombre, empleados.apellidosEmpleado Apellido,empleados.nombreUsuario Usuario, puestos.descripcionPuesto Puesto,estados.descripcionEstado Estado\n"
                    + "from empleados inner join puestos on empleados.codigoPuesto=puestos.codigoPuesto \n"
                    + "inner join estados on estados.codigoEstado=empleados.codigoEstado;";
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
            String buscarEmpleadoNombre = "select empleados.codigoEmpleado, empleados.nombreEmpleado, empleados.apellidosEmpleado,empleados.nombreUsuario, puestos.descripcionPuesto,estados.descripcionEstado\n"
                    + "from empleados inner join puestos on empleados.codigoPuesto=puestos.codigoPuesto \n"
                    + "inner join estados on estados.codigoEstado=empleados.codigoEstado WHERE empleados.nombreEmpleado LIKE \"%" + nombreEmpleado + "%\""; 
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

            //String extraerEmpleado = "SELECT identificacion ,nombreEmpleado ,apellidosEmpleado,telefonoEmpleado,correoElectronico,codigoPuesto, direccionEmpleado,nombreUsuario,claveUsuario,codigoEstado FROM empleados where codigoEmpleado=" + codigoEmpleado + ";";
            String extraerEmpleado = "SELECT codigoEmpleado,identificacion,nombreEmpleado,apellidosEmpleado,telefonoEmpleado,correoElectronico,codigoPuesto,direccionEmpleado,nombreUsuario,claveUsuario,a.codigoEstado, b.descripcionEstado FROM empleados a inner join estados b on a.codigoEstado =b.codigoEstado  where codigoEmpleado=" + codigoEmpleado + ";";
 
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(extraerEmpleado);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public static boolean actualizarEmpleado(int codigo, String id, String nombres, String apellidos, String tel, String correo, String dir,String codigoPuesto,String codigoEstado){
        Connection con = MantenimientoUsuarios.con;
        try {

            String actualizarsql = "UPDATE empleados SET identificacion='" + id + "',nombreEmpleado='" + nombres + "',apellidosEmpleado='" + apellidos + "',telefonoEmpleado='" + tel + "',correoElectronico='" + correo + "',direccionEmpleado='" + dir + "',codigoPuesto='" + codigoPuesto + "' ,codigoEstado='" + codigoEstado + "' WHERE codigoEmpleado='" + codigo + "';";
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
