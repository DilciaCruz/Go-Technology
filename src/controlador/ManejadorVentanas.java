/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.*;
/**
 *
 * @author Rosa Sandoval
 */
public class ManejadorVentanas {
    
    public Login loginfrm;
    public MenuPrincipal menuPrincipalfrm;
    public Cotización cotizacionfrm;
    public NuevaCotización nuevaCotizacionfrm;
    public Proyectos proyectosfrm;
    public Factura facturafrm;
    public Agenda agendafrm;
    
   public ManejadorVentanas(){
       this.loginfrm = new Login();
       this.menuPrincipalfrm = new MenuPrincipal();
       this.cotizacionfrm = new Cotización();
       this.nuevaCotizacionfrm = new NuevaCotización();
       this.proyectosfrm = new Proyectos();
       this.facturafrm = new Factura();
       this.agendafrm = new Agenda();
   }
}
