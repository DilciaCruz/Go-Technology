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
    
    public Agendas agendafrm;
    public Clientes clientesfrm;
    public Compras comprasfrm;
    public Cotizaciones cotizacionfrm;
    public Factura facturafrm;
    public ImprimirCotizacion imprimirCotizacionfrm;
    public Inventario inventariofrm;
    public ListaParametros listaParametrosfrm;
    public ListaProyecto listaProyectofrm;
    public ListaPuestos listaPuestosfrm;
    public Login loginfrm;
    public MenuPrincipal menuPrincipalfrm;
    public NuevaCotización nuevaCotizacionfrm;
    public NuevaFacturaImpresa nuevaFacturaImpresafrm;
    public NuevaOrdenCompra nuevaOrdenComprafrm;
    public OrdenCompraProyecto ordenCompraProyectofrm;
    public Parametros parametrosfrm;
    public Proyectos proyectosfrm;
    public Puestos puestosfrm;
    public RegistrarCliente registrarClientefrm;
    public RestablecerClaves restablecerClavefrm;
    
    
    
   public ManejadorVentanas(){
       this.agendafrm = new Agendas();
       this.clientesfrm = new Clientes();
       this.comprasfrm = new Compras();
       this.cotizacionfrm = new Cotizaciones();
       this.facturafrm = new Factura();
       this.imprimirCotizacionfrm = new ImprimirCotizacion();
       this.inventariofrm = new Inventario();
       this.listaParametrosfrm = new ListaParametros();
       this.listaProyectofrm = new ListaProyecto(); 
       this.listaPuestosfrm = new ListaPuestos(); 
       this.loginfrm = new Login(); 
       this.menuPrincipalfrm = new MenuPrincipal(); 
       this.nuevaCotizacionfrm = new NuevaCotizacion();
       this.nuevaFacturaImpresafrm = new NuevaFacturaImpresa(); 
       this.nuevaOrdenComprafrm = new NuevaOrdenCompra(); 
       this.ordenCompraProyectofrm = new OrdenCompraProyecto(); 
       this.parametros = new Parametros(); 
       this.proyectos = new Proyectos();
       this.puestos = new Puestos();
       this.registrarCliente = new RegistrarCliente();
       this.registrarEmpleado = new RegistrarEmpleado();
       this.restablecerClave = new RegistrarClaves();
       
   }
}
