/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rosa Sandoval
 */
public class Proyectos {
    
    int codigoProyecto;
    float precioUnitario;
    private byte[] foto;
    int cantidad;
    String descripcion;
   

public Proyectos(){}

/*Todo los codigos get*/
    public int getcodigoProyecto(){
        return codigoProyecto;
    }
    public float getprecioUnitario(){
        return precioUnitario;
    }
    public int getcantidad(){
        return cantidad;
    }
    public String getdescripcion(){
        return descripcion;
    }


/*Todo los codigos set*/
    public void setcodigoProyecto(int codigoProyecto){
        this.codigoProyecto = codigoProyecto;
    }
    public void setprecioUnitario(float precioUnitario){
        this.precioUnitario = precioUnitario;
    }
    public void setcantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setdescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
