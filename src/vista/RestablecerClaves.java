/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.Encriptamiento;
import dkasamuebles.DKasaMuebles;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import static modelo.Usuarios.con;
import static vista.Login.*;

/**
 *
 * @author Astrid
 */
public class RestablecerClaves extends javax.swing.JFrame {

    int intLimiteCaracteresMin = 4;
    int intLimiteCaracteresMax = 16;
    public static String clave;

    /**
     * Creates new form RestablecerClaves
     */
    public RestablecerClaves() {
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
        jLabel4 = new javax.swing.JLabel();
        txtConfirmarClave = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtClaveNueva = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 452));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Restablecimiento de Clave");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Credenciales", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Confirmar Clave");

        txtConfirmarClave.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtConfirmarClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfirmarClaveKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConfirmarClaveKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Clave Nueva");

        txtClaveNueva.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtClaveNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveNuevaActionPerformed(evt);
            }
        });
        txtClaveNueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClaveNuevaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveNuevaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Usuario");

        txtUsuario.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtConfirmarClave)
                    .addComponent(txtClaveNueva, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(txtUsuario))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClaveNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtConfirmarClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        btnConfirmar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnConfirmar))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(666, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.restablecerClavefrm.setVisible(false);
        DKasaMuebles.mv.menuPrincipalfrm.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        String sqlSel = "select * from empleados where claveUsuario=? ";

        String encrip = null;
        //try {
            //encrip = Encriptamiento.obtenerMD5(txtClaveActual.getText());
        //} catch (NoSuchAlgorithmException ex) {
          //  Logger.getLogger(RestablecerClaves.class.getName()).log(Level.SEVERE, null, ex);
        //}

        try {
            PreparedStatement ps = con.prepareStatement(sqlSel);

            ps.setString(1, encrip);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                actualizarClave();
            } else if (txtClaveNueva.getText().equals("") || txtConfirmarClave.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error, no dejar campos vacios ");
                //txtClaveActual.requestFocus();
            } else if (txtClaveNueva.getText().length() < intLimiteCaracteresMin || txtConfirmarClave.getText().length() < intLimiteCaracteresMin) {
                JOptionPane.showMessageDialog(null, "La clave no puede ser menos de 8 caracteres");
                txtClaveNueva.requestFocus();
                txtClaveNueva.setText("");
                txtConfirmarClave.setText("");
                txtUsuario.setText("");
            } /*else {
                JOptionPane.showMessageDialog(null, "Error, clave actual incorrecta ");
                txtClaveActual.requestFocus();
                txtClaveActual.setText("");
                txtUsuario.setText("");
            }*/
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtClaveNuevaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveNuevaKeyPressed
        // TODO add your handling code here:
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente sus credenciales");
            evt.consume();
            txtClaveNueva.setText("");
        }
    }//GEN-LAST:event_txtClaveNuevaKeyPressed

    private void txtConfirmarClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarClaveKeyPressed
        // TODO add your handling code here:
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente sus credenciales");
            evt.consume();
            txtConfirmarClave.setText("");
        }
    }//GEN-LAST:event_txtConfirmarClaveKeyPressed

    private void txtConfirmarClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarClaveKeyTyped
        // TODO add your handling code here:
        char charTeclaPresionada = evt.getKeyChar();
        if (charTeclaPresionada == KeyEvent.VK_ENTER) {
            btnConfirmar.doClick();
        }

        if (txtConfirmarClave.getText().length() >= intLimiteCaracteresMax) {
            evt.consume();
        }

        /*if (txtConfirmarClave.getText().length() <= intLimiteCaracteresMin) {
            evt.consume();
        }*/
    }//GEN-LAST:event_txtConfirmarClaveKeyTyped

    private void txtClaveNuevaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveNuevaKeyTyped
        // TODO add your handling code here:
        if (txtClaveNueva.getText().length() >= intLimiteCaracteresMax) {
            evt.consume();
        }

    }//GEN-LAST:event_txtClaveNuevaKeyTyped

    private void txtClaveNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveNuevaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveNuevaActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isLetter(validar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestablecerClaves().setVisible(true);
            }
        });
    }

    private void actualizarClave() {
        char[] a = txtClaveNueva.getPassword();
        char[] b = txtConfirmarClave.getPassword();

        String usuario = txtUsuario.getText();
        Connection con = Conexion.conexion;

        String encrip = null;
        try {
            encrip = Encriptamiento.obtenerMD5(txtClaveNueva.getText());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RestablecerClaves.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            if ((Arrays.equals(a, b)) == true) {
                String sqlUpdateClave = "UPDATE empleados set claveUsuario='" + encrip + "' WHERE nombreUsuario='" + usuario + "';";
                Statement st;
                st = con.createStatement();
                st.executeUpdate(sqlUpdateClave);
                JOptionPane.showMessageDialog(null, "Clave modificada exitosamente");
                txtClaveNueva.setText("");
                txtConfirmarClave.setText("");
                txtUsuario.setText("");
            } else
            {
                JOptionPane.showMessageDialog(null, "Error, las contraseñas no coinciden");
                txtClaveNueva.setText("");
                txtConfirmarClave.setText("");
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtClaveNueva;
    private javax.swing.JPasswordField txtConfirmarClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
