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
    public Clientes clientesfrm;
    public Inventario inventariofrm;
    public Compras comprasfrm;
    public Parametros parametrosfrm;
    public RestablecerClave restablecerClavefrm;
    public RegistrarCliente registrarClientefrm;
    public MenuPrincipal menuPrincipalfrm;
    public Cotización cotizacionfrm;
    public NuevaCotización nuevaCotizacionfrm;
    public Proyectos proyectosfrm;
    public Factura facturafrm;
    public Agendas agendafrm;
    
   public ManejadorVentanas(){
       this.loginfrm = new Login();
       this.clientesfrm = new Clientes();
       this.restablecerClavefrm = new RestablecerClave();
       this.parametrosfrm = new Parametros();
       this.inventariofrm = new Inventario();
       this.comprasfrm = new Compras();
       this.registrarClientefrm = new RegistrarCliente();
       this.menuPrincipalfrm = new MenuPrincipal();
       this.cotizacionfrm = new Cotización();
       this.nuevaCotizacionfrm = new NuevaCotización();
       this.proyectosfrm = new Proyectos();
       this.facturafrm = new Factura();
       this.agendafrm = new Agendas();
   }
}
