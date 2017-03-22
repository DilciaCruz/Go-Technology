/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.Encriptamiento;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import dkasamuebles.*;
import modelo.Usuarios;

/**
 *
 * @author Astrid
 */
public class CambioClaveUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form CambioClaveUsuarios
     */
    public CambioClaveUsuarios() {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNuevaClave = new javax.swing.JPasswordField();
        txtConfirmarClaveNueva = new javax.swing.JPasswordField();
        txtClaveActual = new javax.swing.JPasswordField();
        btnConfirmar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Restablecimiento de Clave");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Credenciales", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Clave Actual");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("Nueva Clave");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setText("Confirmar Nueva Clave");

        txtNuevaClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNuevaClaveKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevaClaveKeyTyped(evt);
            }
        });

        txtConfirmarClaveNueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfirmarClaveNuevaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConfirmarClaveNuevaKeyTyped(evt);
            }
        });

        txtClaveActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClaveActualKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveActualKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(txtConfirmarClaveNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtClaveActual, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNuevaClave, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtClaveActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNuevaClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtConfirmarClaveNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btnConfirmar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton2.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(jButton2))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        //String sqlSel = "select * from empleados where nombreUsuario=? ";
        
        
        String encrip = null;
        String comparar = Usuarios.obtenerClave(Login.usuario);
        
        System.out.println(comparar);
        try {
            encrip = Encriptamiento.obtenerMD5(txtClaveActual.getText());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RestablecerClaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(encrip);
        System.out.println(encrip.equals(comparar));
        
            if (true) {
                actualizarClave();
                Usuarios.actualizarEstadoEmpleado(Login.usuario);
                DKasaMuebles.mv.menuPrincipalfrm.setVisible(true);
                DKasaMuebles.mv.CambioClaveUsuariosfrm.setVisible(false);
            } else if (txtNuevaClave.getText().equals("") || txtConfirmarClaveNueva.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error, no dejar campos vacios ");
            } else if (txtNuevaClave.getText().length() < intLimiteCaracteresMin || txtConfirmarClaveNueva.getText().length() < intLimiteCaracteresMin) {
                JOptionPane.showMessageDialog(null, "La clave no puede ser menos de 8 caracteres");
                txtNuevaClave.requestFocus();
                txtNuevaClave.setText("");
                txtConfirmarClaveNueva.setText("");
            }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtClaveActualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveActualKeyPressed

        int codigoBoton = evt.getKeyCode();

        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente sus credenciales");
            evt.consume();
            txtClaveActual.setText("");
        }
    }//GEN-LAST:event_txtClaveActualKeyPressed

    private void txtNuevaClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevaClaveKeyPressed
        int codigoBoton = evt.getKeyCode();

        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente sus credenciales");
            evt.consume();
            txtNuevaClave.setText("");
        }
    }//GEN-LAST:event_txtNuevaClaveKeyPressed

    private void txtConfirmarClaveNuevaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarClaveNuevaKeyPressed
        int codigoBoton = evt.getKeyCode();

        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente sus credenciales");
            evt.consume();
            txtConfirmarClaveNueva.setText("");
        }
    }//GEN-LAST:event_txtConfirmarClaveNuevaKeyPressed

    private void txtClaveActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveActualKeyTyped
        char validar = evt.getKeyChar();

        if (txtClaveActual.getText().length() >= intLimiteCaracteresMax) {
            evt.consume();
        }
    }//GEN-LAST:event_txtClaveActualKeyTyped

    private void txtNuevaClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevaClaveKeyTyped
        if (txtNuevaClave.getText().length() >= intLimiteCaracteresMax) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNuevaClaveKeyTyped

    private void txtConfirmarClaveNuevaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarClaveNuevaKeyTyped
        if (txtConfirmarClaveNueva.getText().length() >= intLimiteCaracteresMax) {
            evt.consume();
        }

        char charTeclaPresionada = evt.getKeyChar();
        if (charTeclaPresionada == KeyEvent.VK_ENTER) {
            btnConfirmar.doClick();
        }
    }//GEN-LAST:event_txtConfirmarClaveNuevaKeyTyped

    /**
     * @param args the command line arguments
     */
    int intLimiteCaracteresMax = 15;
    int intLimiteCaracteresMin = 7;

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
            java.util.logging.Logger.getLogger(CambioClaveUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambioClaveUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambioClaveUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambioClaveUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambioClaveUsuarios().setVisible(true);
            }
        });
    }

    //Actualizar Clave
    private void actualizarClave() {
        
        Connection con = Conexion.conexion;
        
        
        char[] a = txtNuevaClave.getPassword();
        char[] b = txtConfirmarClaveNueva.getPassword();
        String usuario = Login.usuario;
        String claveNueva = null;
        try {
            claveNueva = Encriptamiento.obtenerMD5(txtNuevaClave.getText());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CambioClaveUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            if ((Arrays.equals(a, b)) == true) {
              
                System.out.println();
                String sqlUpdateClave = "UPDATE empleados set claveUsuario='" + claveNueva + "' WHERE nombreUsuario='" + usuario + "';";
               
                Statement st;
                st = con.createStatement();
                st.executeUpdate(sqlUpdateClave);
                JOptionPane.showMessageDialog(null, "Clave modificada exitosamente");
                txtClaveActual.setText("");
                txtConfirmarClaveNueva.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Error, las contraseñas no coinciden");
                txtClaveActual.setText("");
                txtConfirmarClaveNueva.setText("");
            }

        } catch (HeadlessException | SQLException e) {
            System.out.println("Error");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtClaveActual;
    private javax.swing.JPasswordField txtConfirmarClaveNueva;
    private javax.swing.JPasswordField txtNuevaClave;
    // End of variables declaration//GEN-END:variables
}
