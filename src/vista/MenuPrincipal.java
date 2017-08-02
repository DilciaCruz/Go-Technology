package vista;

import controlador.Conexion;
import controlador.TablaDatos;
import dkasamuebles.DKasaMuebles;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.MantenimientoCliente;
import modelo.MantenimientoEmpleados;
import modelo.MantenimientoUsuarios;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Astrid
 */
public final class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form menuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setTitle("DkasaMuebles - Menu Principal");
        this.setExtendedState(MAXIMIZED_BOTH);

    }

    public void accesoAdministrador() {
        btnCompras.setEnabled(true);
        btnPuestos.setEnabled(true);
        btnParametros.setEnabled(true);
        btnClientes.setEnabled(true);
        btnEmpleados.setEnabled(true);
        btnInventario.setEnabled(true);
        btnProductos.setEnabled(true);
    }

    public void accesoVendedor() {
        btnClientes.setEnabled(true);
        btnEmpleados.setEnabled(false);
        btnPuestos.setEnabled(false);
        btnParametros.setEnabled(false);
        btnInventario.setEnabled(false);
        btnCompras.setEnabled(false);
        btnProductos.setEnabled(false);
    }

    public void accesoBodeguero() {
        btnInventario.setEnabled(true);
        btnCompras.setEnabled(true);
        btnClientes.setEnabled(false);
        btnEmpleados.setEnabled(false);
        btnPuestos.setEnabled(false);
        btnParametros.setEnabled(false);
        btnProductos.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnClientes = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnCompras = new javax.swing.JButton();
        btnPuestos = new javax.swing.JButton();
        btnParametros = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        btnClientes.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dkasamuebles/img/btn-clientes.png"))); // NOI18N
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnEmpleados.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dkasamuebles/img/btn-empleados.png"))); // NOI18N
        btnEmpleados.setEnabled(false);
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnInventario.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dkasamuebles/img/btn-inventario.png"))); // NOI18N
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnCompras.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dkasamuebles/img/btn-compras.png"))); // NOI18N
        btnCompras.setEnabled(false);
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });

        btnPuestos.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnPuestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dkasamuebles/img/btn-puestos.png"))); // NOI18N
        btnPuestos.setEnabled(false);
        btnPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuestosActionPerformed(evt);
            }
        });

        btnParametros.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnParametros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dkasamuebles/img/btn-parametros.png"))); // NOI18N
        btnParametros.setEnabled(false);
        btnParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParametrosActionPerformed(evt);
            }
        });

        btnProductos.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dkasamuebles/img/btn-productos - copia.png"))); // NOI18N
        btnProductos.setEnabled(false);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dkasamuebles/img/btn-empleados - copia_1.png"))); // NOI18N
        btnPerfil.setEnabled(false);
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(98, 98, 98)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(btnCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnParametros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(btnPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Menu Principal");

        btnCerrarSesion1.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnCerrarSesion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dkasamuebles/img/btn-cerrarSesion.png"))); // NOI18N
        btnCerrarSesion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesion1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(578, 578, 578))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCerrarSesion1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnCerrarSesion1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:

        DKasaMuebles.mv.clientesfrm.setVisible(true);


    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        // TODO add your handling code here:

        DKasaMuebles.mv.empleadosfrm.setVisible(true);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        // TODO add your handling code here:

        DKasaMuebles.mv.inventariofrm.setVisible(true);
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed
        // TODO add your handling code here:

        DKasaMuebles.mv.comprasfrm.setVisible(true);
    }//GEN-LAST:event_btnComprasActionPerformed

    private void btnPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuestosActionPerformed
        // TODO add your handling code here:

        DKasaMuebles.mv.listaPuestosfrm.setVisible(true);
    }//GEN-LAST:event_btnPuestosActionPerformed

    private void btnParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParametrosActionPerformed
        // TODO add your handling code here:

        DKasaMuebles.mv.listaParametrosfrm.setVisible(true);
    }//GEN-LAST:event_btnParametrosActionPerformed

    private void btnCerrarSesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesion1ActionPerformed
        // TODO add your handling code here:


        DKasaMuebles.mv.loginfrm.setVisible(true);
        DKasaMuebles.mv.menuPrincipalfrm.setVisible(false);

    }//GEN-LAST:event_btnCerrarSesion1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        int codigoPuesto = MantenimientoUsuarios.obtenerCodigoPuesto(Login.usuario);

        if (codigoPuesto == 1) {
            this.accesoAdministrador();
        }

        if (codigoPuesto == 2) {
            this.accesoVendedor();
        }

        if (codigoPuesto == 3) {
            this.accesoBodeguero();
        }


    }//GEN-LAST:event_formWindowActivated

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.ListaProductosfrm.setVisible(true);
                
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        DKasaMuebles.mv.perfilUsuariofrm.setVisible(true);
    }//GEN-LAST:event_btnPerfilActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion1;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnParametros;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnPuestos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
