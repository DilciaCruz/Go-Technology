/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.TablaDatos;
import dkasamuebles.DKasaMuebles;
import java.sql.ResultSet;
import modelo.MantenimientoEmpleados;

/**
 *
 * @author Astrid
 */
public class Empleados extends javax.swing.JFrame {

    /**
     * Creates new form empleados
     */
    public Empleados() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatosEmpleado = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuEmpleado = new javax.swing.JMenu();
        mnuRegistrarEmpleado = new javax.swing.JMenuItem();
        mnuRestablecerClaves = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(911, 495));

        tblDatosEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Cargo", "Estado", "Usuario"
            }
        ));
        jScrollPane1.setViewportView(tblDatosEmpleado);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Buscar");

        txtBuscar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Empleados");

        btnSalir.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jMenuBar1.setPreferredSize(new java.awt.Dimension(285, 40));

        mnuEmpleado.setText("Empleado");

        mnuRegistrarEmpleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnuRegistrarEmpleado.setText("Registrar Empleado");
        mnuRegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrarEmpleadoActionPerformed(evt);
            }
        });
        mnuEmpleado.add(mnuRegistrarEmpleado);

        mnuRestablecerClaves.setText("Restablecer Claves de Usuario");
        mnuEmpleado.add(mnuRestablecerClaves);

        jMenuBar1.add(mnuEmpleado);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(402, 402, 402)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSalir)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrarEmpleadoActionPerformed
        // TODO add your handling code here:
         DKasaMuebles.mv.registrarEmpleadofrm.setVisible(true);
         DKasaMuebles.mv.empleadosfrm.setVisible(false);
         
    }//GEN-LAST:event_mnuRegistrarEmpleadoActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.menuPrincipalfrm.setVisible(true);
        DKasaMuebles.mv.nuevaOrdenComprafrm.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnbuscarempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarempleadoActionPerformed
        // TODO add your handling code here:
        ResultSet rs = MantenimientoEmpleados.buscarEmpleado("");
        TablaDatos dt = new TablaDatos(rs);
        tblDatosEmpleado.setModel(dt);
    }//GEN-LAST:event_btnbuscarempleadoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
       ResultSet rs = MantenimientoEmpleados.buscarEmpleado("");
        TablaDatos dt = new TablaDatos(rs);
        tblDatosEmpleado.setModel(dt);
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnuEmpleado;
    private javax.swing.JMenuItem mnuRegistrarEmpleado;
    private javax.swing.JMenuItem mnuRestablecerClaves;
    private javax.swing.JTable tblDatosEmpleado;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
