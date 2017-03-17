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
    public ListaPuestos listaPuestosfrm;
    
    public Inventario inventariofrm;
    public Compras comprasfrm;
    public Parametros parametrosfrm;
    public RestablecerClaves restablecerClavefrm;
    public RegistrarCliente registrarClientefrm;
    public MenuPrincipal menuPrincipalfrm;
    public Empleados empleadosfrm;
    public RegistrarEmpleado registrarEmpleadofrm;
    public Cotizaciones cotizacionfrm;
    public NuevaCotización nuevaCotizacionfrm;
    public Proyectos proyectosfrm;
    public Factura facturafrm;
    public Agendas agendafrm;
    public NuevaOrdenCompra nuevaordencomprafrm;
    public OrdenCompraProyecto ordencompraproyectofrm;
    
   public ManejadorVentanas(){
       this.loginfrm = new Login();
       
       this.listaPuestosfrm = new ListaPuestos();
       this.clientesfrm = new Clientes();
       this.restablecerClavefrm = new RestablecerClaves();
       this.parametrosfrm = new Parametros();
       this.inventariofrm = new Inventario();
       this.comprasfrm = new Compras();
       this.registrarClientefrm = new RegistrarCliente();
       this.menuPrincipalfrm = new MenuPrincipal();
       this.registrarEmpleadofrm=new RegistrarEmpleado();
       this.empleadosfrm=new Empleados();
       this.cotizacionfrm = new Cotizaciones();
       this.nuevaCotizacionfrm = new NuevaCotización();
       this.proyectosfrm = new Proyectos();
       this.facturafrm = new Factura();
       this.agendafrm = new Agendas();
       this.nuevaordencomprafrm = new NuevaOrdenCompra();
       this.ordencompraproyectofrm = new  OrdenCompraProyecto();
   }

}
