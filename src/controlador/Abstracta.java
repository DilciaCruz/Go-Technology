/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.Conexion.conexion;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.MantenimientoUsuarios;
import static modelo.MantenimientoUsuarios.con;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static vista.Login.con;

/**
 *
 * @author USUARIO
 */
public abstract class Abstracta {
    private static JasperReport report;
    private static JasperPrint reportFilled;
    private static JasperViewer viever;
    
    Connection con = MantenimientoUsuarios.con;
    
    public static void createReport (Connection con, String path){
        try {
            report = (JasperReport) JRLoader.loadObjectFromFile( path );
            reportFilled = JasperFillManager.fillReport(report,null,con);
        } catch (JRException ex) {
            Logger.getLogger(Abstracta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void showViewer(){
        viever = new JasperViewer(reportFilled);
        viever.setVisible(true);
    }
    public static void exportarPDF(String path){
        try {
            JasperExportManager.exportReportToPdfFile(reportFilled,path);
        } catch (JRException ex) {
            Logger.getLogger(Abstracta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
