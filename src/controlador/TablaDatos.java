/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rosa Sandoval
 */
public class TablaDatos  extends AbstractTableModel {
    
    private Integer rowCount = 0;
    private Integer columnCount = 0;
    private List<List> data = new ArrayList<>();
    private List<String> columns = new ArrayList<>();
    
    
    public TablaDatos(ResultSet rs){
        try {
            //Cargamos las columnas
            this.columnCount = rs.getMetaData().getColumnCount();
            
            for(int i=0;i<this.columnCount;i++){
                columns.add(rs.getMetaData().getColumnLabel(i+1));
            }
            
            
            //Cargamos las filas
            rs.beforeFirst();
            
            while(rs.next()){
                List row = new ArrayList();
                
                for(int i=0;i<this.columnCount;i++){
                    row.add(rs.getObject(this.columns.get(i)));
                }
                
                this.data.add(row);
            }
            
            this.rowCount = this.data.size();
            
        } catch (SQLException ex) {
            Logger.getLogger(TablaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @Override
    public int getRowCount() {
        return this.rowCount;
    }

    @Override
    public int getColumnCount() {
        return this.columnCount;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return this.columns.get(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }
    
    public void setColumnName(int columnIndex, String columnName){
        this.columns.set(columnIndex, columnName);
    }
    
    public void setRowCount(int count){
        this.rowCount = count;
    }
    
    public void setColumnCount(int count){
        this.columnCount = count;
    }
    
}
