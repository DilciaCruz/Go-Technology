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
    public Empleados empleadosfrm;
    public RegistrarEmpleado registrarEmpleadofrm;
    
    
   public ManejadorVentanas(){
       this.loginfrm = new Login();
       this.menuPrincipalfrm = new MenuPrincipal();
       this.registrarEmpleadofrm=new RegistrarEmpleado();
       this.empleadosfrm=new Empleados();
   }

}
