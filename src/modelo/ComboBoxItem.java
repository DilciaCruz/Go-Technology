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
public class ComboBoxItem {
    
    private String valor;
    private String titulo;
    
    @Override
    public String toString(){
        return titulo;
    }
    
    public String getValue(){
     return this.valor;
    }
    
    public void setItem(String valor,String titulo ){
        this.valor=valor;
        this.titulo=titulo;
    }

    public void setItem(String toString, Integer descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
