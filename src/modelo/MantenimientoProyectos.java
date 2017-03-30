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
 * @author Rosa Sandoval
 */
public class MantenimientoProyectos {

    public static ResultSet mostrarProyectos(String string) {
        Connection con = MantenimientoUsuarios.con;
        ResultSet rs = null;

        try {
            String buscarproyecto = "select detalleProyecto.codigoProyecto Codigo,detallecotizaciones.descripcionDetalle Descripcion_del_proyecto,\n"
                    + "detallecotizaciones.codigoproducto Descripcion_del_producto,cotizaciones.codigoCliente Cliente,detalleproyecto.planos Planos, \n"
                    + "detallecotizaciones.precio Precio_del_proyecto, detallecotizaciones.cantidad Cantidad, proyectos.codigoEstado Estado\n"
                    + "from proyectos inner join detalleProyecto on proyectos.codigoProyecto=detalleproyecto.codigoProyecto \n"
                    + "inner join detallecotizaciones on detalleproyecto.codigoProducto=detallecotizaciones.codigoProducto \n"
                    + "inner join cotizaciones on detallecotizaciones.codigoCotizacion=cotizaciones.codigocotizacion;";
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(buscarproyecto);

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoProyectos.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
    }

}
