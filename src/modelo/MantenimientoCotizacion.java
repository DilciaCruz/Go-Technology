/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Encriptamiento;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vanelly
 */
public class MantenimientoCotizacion {

    public static Boolean insertarDatosDetalleCotizacion(String fechaEmisionCorizacion, float impuesto, String fechaVigencia, int codigoEstado, int codigoCliente, int codigoEmpleado) {
        try {
            Connection con = Usuarios.con;
            String insertarsql = "INSERT INTO cotizaciones (fechaEmisionCorizacion,impuesto,fechaVigencia,codigoEstado,codigoCliente,codigoEmpleado) VALUES ('"+fechaEmisionCorizacion+"','"+impuesto+"','"+fechaVigencia+"','"+codigoEstado+"','"+codigoCliente+"','"+codigoEmpleado+"');";
            Statement st;
            st = con.createStatement();
            st.executeUpdate(insertarsql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
