/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.*;
/**
 *
 * @author Rosa Sandoval
 */
public class ManejadorVentanas {
    
    public Login loginfrm;
    public ListaFacturas listaFacturasfrm;
    public Empleados empleadosfrm;
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
    public MenuPrincipal menuPrincipalfrm;
    public NuevaCotización nuevaCotizacionfrm;
    public NuevaFacturaImpresa nuevaFacturaImpresafrm;
    public NuevaOrdenCompra nuevaOrdenComprafrm;
    public OrdenCompraProyecto ordenCompraProyectofrm;
    public Parametros parametrosfrm;
    public Proyectos proyectosfrm;
    public Puestos puestosfrm;
    public RegistrarCliente registrarClientefrm;
    public RegistrarEmpleado registrarEmpleadofrm;
    public RestablecerClaves restablecerClavefrm;
    public NuevoMaterial nuevoMaterialfrm;
    public CambioClaveUsuarios CambioClaveUsuariosfrm;
    public Productos nuevoProductofrm;
    public ListaProductos ListaProductosfrm;
    public InventarioMaterialReservado inventarioMaterialReservadofrm;
    public PerfilUsuario perfilUsuariofrm;
       
    
   public ManejadorVentanas(){
        try {
            this.agendafrm = new Agendas();
            this.listaFacturasfrm = new ListaFacturas();
            this.clientesfrm = new Clientes();
            this.empleadosfrm = new Empleados();
            this.registrarEmpleadofrm = new RegistrarEmpleado();
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
            this.nuevaCotizacionfrm = new NuevaCotización();
            this.nuevaFacturaImpresafrm = new NuevaFacturaImpresa();
            this.nuevaOrdenComprafrm = new NuevaOrdenCompra();
            this.ordenCompraProyectofrm = new OrdenCompraProyecto();
            this.parametrosfrm = new Parametros();
            this.proyectosfrm = new Proyectos();
            this.puestosfrm = new Puestos();
            this.registrarClientefrm = new RegistrarCliente();
            this.restablecerClavefrm = new RestablecerClaves();
            this.nuevoMaterialfrm = new NuevoMaterial();
            this.CambioClaveUsuariosfrm = new CambioClaveUsuarios();
            this.nuevoProductofrm = new Productos();
            this.ListaProductosfrm = new ListaProductos();
            this.inventarioMaterialReservadofrm = new InventarioMaterialReservado();
            this.perfilUsuariofrm = new PerfilUsuario();
            this.perfilUsuariofrm = new PerfilUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorVentanas.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
   }
}
