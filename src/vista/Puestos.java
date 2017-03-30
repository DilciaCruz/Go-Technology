package vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import controlador.TablaDatos;
import dkasamuebles.DKasaMuebles;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyEvent;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import modelo.ComboBoxItem;
import modelo.ComboBoxMod;
import modelo.MantenimientoPuestos;
import modelo.MantenimientoUsuarios;

/**
 *
 * @author USUARIO
 */
public class Puestos extends javax.swing.JFrame {

    /**
     * Creates new form Puestos
     */
    public Puestos() {
        initComponents();
        this.setTitle("DkasaMuebles - Puestos");
        Connection con = MantenimientoUsuarios.con;
        try {

            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from estados where codigoEstado = 1 or codigoEstado = 4;");
            ComboBoxMod aModel = new ComboBoxMod();

            while (rs.next()) {
                ComboBoxItem item = new ComboBoxItem();
                item.setItem(rs.getString("codigoEstado"), rs.getString("descripcionEstado"));
                aModel.addItem(item);
            }

            cmbEstadoPuesto.setModel(aModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        cmbEstadoPuesto.setSelectedIndex(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcionPuesto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbEstadoPuesto = new javax.swing.JComboBox<>();
        txtCodigoPuesto = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Puestos");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insertar/Editar Puestos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Descripcion de Puesto");

        txtDescripcionPuesto.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtDescripcionPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionPuestoActionPerformed(evt);
            }
        });
        txtDescripcionPuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionPuestoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionPuestoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Estado");

        cmbEstadoPuesto.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cmbEstadoPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoPuestoActionPerformed(evt);
            }
        });

        txtCodigoPuesto.setEditable(false);
        txtCodigoPuesto.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtCodigoPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPuestoActionPerformed(evt);
            }
        });
        txtCodigoPuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoPuestoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoPuestoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescripcionPuesto)
                            .addComponent(cmbEstadoPuesto, 0, 414, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCodigoPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtCodigoPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcionPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbEstadoPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(420, 420, 420))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnGuardar)
                    .addComponent(btnRegresar))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(984, 787));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionPuestoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDescripcionPuestoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtDescripcionPuesto.getText().isEmpty() || txtDescripcionPuesto.getText().startsWith(" ")) {
            JOptionPane.showMessageDialog(null, "Hay Campos Vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            ComboBoxItem estado = (ComboBoxItem) cmbEstadoPuesto.getModel().getSelectedItem();
            String codigoEstado = estado.getValue();
            String codigoPuesto = txtCodigoPuesto.getText();
            String descripcionPuesto = txtDescripcionPuesto.getText();
            int codigo = MantenimientoPuestos.obtenerCodigo(codigoPuesto);
            
            

           txtDescripcionPuesto.setText("");
            cmbEstadoPuesto.setSelectedIndex(0);
            if (ListaPuestos.codigobtnPresionado == 1) {
                if (MantenimientoPuestos.insertarPuestos(descripcionPuesto, codigoEstado) && ListaPuestos.codigobtnPresionado == 1) {
                    JOptionPane.showMessageDialog(this, "Guardado exitosamente en la Base de Datos");
                    txtDescripcionPuesto.setText("");
                    cmbEstadoPuesto.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar en la Base de Datos");
                }
            } else {
                
                /*System.out.println(codigoPuesto);
                System.out.println(descripcionPuesto);
                System.out.println(codigoEstado);*/

                if (MantenimientoPuestos.actualizarPuestos(codigo, codigoPuesto, descripcionPuesto, codigoEstado)) {
                    
                    JOptionPane.showMessageDialog(this, "Datos actualizados exitosamente en la Base de Datos");
                    
                    DKasaMuebles.mv.puestosfrm.setVisible(false);
                    DKasaMuebles.mv.listaPuestosfrm.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "No se han guardado los cambios");
                    
                }
            }

        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        txtDescripcionPuesto.setText("");
        cmbEstadoPuesto.setSelectedIndex(0);
        DKasaMuebles.mv.puestosfrm.setVisible(false);
        DKasaMuebles.mv.menuPrincipalfrm.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        txtDescripcionPuesto.setText("");
        cmbEstadoPuesto.setSelectedIndex(0);
        DKasaMuebles.mv.puestosfrm.setVisible(false);
        DKasaMuebles.mv.listaPuestosfrm.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        txtCodigoPuesto.setVisible(false);
        System.out.println(ListaPuestos.codigobtnPresionado);
        if (ListaPuestos.codigobtnPresionado == 2) {
            try {
                String DatoSelected = DKasaMuebles.DatoSelected;
                ResultSet rs = MantenimientoPuestos.extraerDatosPuestos(DKasaMuebles.DatoSelected);

                if (rs.next()) {
                    //int indiceEstado = rs.getInt("codigoEstado");
                    Integer indiceEstado = rs.getInt("codigoEstado");
                    String descripcion = rs.getString("descripcionEstado");;
                    txtCodigoPuesto.setText(rs.getString("codigoPuesto"));
                    //cmbEstadoPuesto.setSelectedIndex(indiceEstado -1);
                    txtDescripcionPuesto.setText(rs.getString("descripcionPuesto"));
                    
                    ComboBoxItem comboItem= new ComboBoxItem();
                    comboItem.setItem(indiceEstado.toString(), descripcion);
                    cmbEstadoPuesto.getModel().setSelectedItem(comboItem);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Puestos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_formWindowActivated

    private void txtDescripcionPuestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionPuestoKeyPressed
        // TODO add your handling code here:
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente su nombre");
            evt.consume();
            txtDescripcionPuesto.setText("");
        }
    }//GEN-LAST:event_txtDescripcionPuestoKeyPressed

    private void txtDescripcionPuestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionPuestoKeyTyped
       // TODO add your handling code here:
         if(txtDescripcionPuesto.getText().length() > 0 && txtDescripcionPuesto.getText().startsWith(" ")){
           JOptionPane.showMessageDialog(null,"Su primer digito es un espacio en blanco");
           txtDescripcionPuesto.setText("");
        
        }else{ 
         char caracter = evt.getKeyChar() ;
        if(((caracter < 'a') || (caracter > 'z'))&&((caracter < 'A') || (caracter > 'Z'))&& (caracter != KeyEvent.VK_SPACE) && (caracter != KeyEvent.VK_BACK_SPACE)){
            evt.consume();                
        }
                
        if(caracter == ' ' && txtDescripcionPuesto.getText().contains(" ")){
            evt.consume();
        }
                           
            String Caracteres = txtDescripcionPuesto.getText();
        
        if(Caracteres.length()>=25){
            evt.consume();
        }
        }
        
        /*char validar = evt.getKeyChar();
        if (!Character.isLetter(validar))//Character.isWhitespace(validar))
                {
            evt.consume();
        }*/
        
        if (txtDescripcionPuesto.getText().length() >= 45) {
            evt.consume();
        }                       
    }//GEN-LAST:event_txtDescripcionPuestoKeyTyped

    private void cmbEstadoPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoPuestoActionPerformed

    private void txtCodigoPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPuestoActionPerformed

    private void txtCodigoPuestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPuestoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPuestoKeyPressed

    private void txtCodigoPuestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPuestoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPuestoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Puestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Puestos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbEstadoPuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCodigoPuesto;
    private javax.swing.JTextField txtDescripcionPuesto;
    // End of variables declaration//GEN-END:variables
}
