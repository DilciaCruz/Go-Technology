/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User123
 */
public class MantenimientoAgenda {

    
        public static ResultSet mostrarAgenda(String fecha) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {
            String buscarAgenda = "select proyectos.descripcionProyecto Proyecto,(select clientes.nombreCliente  from proyectos  inner join clientes on proyectos.codigoCliente=clientes.codigoCliente) Cliente ,agenda.fecha Fecha, estados.descripcionEstado Estado\n"
                    + "from agenda inner join proyectos on proyectos.codigoProyecto=agenda.codigoProyecto \n"
                    + "inner join estados on estados.codigoEstado=agenda.codigoEstado;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarAgenda);

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }
    
}
