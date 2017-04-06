/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.TablaDatos;
import dkasamuebles.DKasaMuebles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.ComboBoxItem;
import modelo.ComboBoxMod;
import modelo.MantenimientoInventario;
import modelo.MantenimientoUsuarios;

/**
 *
 * @author Alexei Rodriguez
 */
public class Inventario extends javax.swing.JFrame {

    /**
     * Creates new form Inventario
     */
    public Inventario() {
        initComponents();
        this.setTitle("DkasaMuebles - Inventario");
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
        tblInventario = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuInventario = new javax.swing.JMenu();
        mnuNuevoMaterial = new javax.swing.JMenuItem();
        mnuMaterialesReservados = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Punto de reorden", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblInventario);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Buscar");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Filtrar");

        txtBuscar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        cmbEstado.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cmbEstado.setToolTipText("Seleccione un Estado");
        cmbEstado.setName("Seleccione un Estado"); // NOI18N
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
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
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBuscar)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Inventario");

        btnEditar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setPreferredSize(new java.awt.Dimension(63, 31));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        mnuInventario.setText("Inventario");

        mnuNuevoMaterial.setText("Nuevo Material");
        mnuNuevoMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNuevoMaterialActionPerformed(evt);
            }
        });
        mnuInventario.add(mnuNuevoMaterial);

        mnuMaterialesReservados.setText("Materiales Reservados");
        mnuMaterialesReservados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMaterialesReservadosActionPerformed(evt);
            }
        });
        mnuInventario.add(mnuMaterialesReservados);

        jMenuBar1.add(mnuInventario);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(403, 403, 403))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(982, 787));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        ResultSet rs = MantenimientoInventario.obtenerMaterialPorNombre(txtBuscar.getText(), cmbEstado.getSelectedItem().toString());
        TablaDatos tb = new TablaDatos(rs);
        tblInventario.setModel(tb);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.menuPrincipalfrm.setVisible(true);
        DKasaMuebles.mv.inventariofrm.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void mnuNuevoMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNuevoMaterialActionPerformed
        DKasaMuebles.mv.inventariofrm.setVisible(false);
        DKasaMuebles.mv.nuevoMaterialfrm.setVisible(true);
        
        DKasaMuebles.codigoBotonPresionado = 1;
    }//GEN-LAST:event_mnuNuevoMaterialActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.codigoBotonPresionado = 2;
        int filaSelecionada = tblInventario.getSelectedRow();

        if (filaSelecionada == -1) {

            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");

        } else {

            String codigoMaterial = tblInventario.getModel().getValueAt(filaSelecionada, 0).toString();

            DKasaMuebles.DatoSelected = codigoMaterial;
            DKasaMuebles.mv.nuevoMaterialfrm.setVisible(true);
            DKasaMuebles.mv.inventariofrm.setVisible(false);
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ResultSet rs = MantenimientoInventario.mostrarInventario();
        TablaDatos tb = new TablaDatos(rs);
        tblInventario.setModel(tb);
        try {
            Connection con = MantenimientoUsuarios.con;
            Statement st;
            st = con.createStatement();
            ResultSet rst = st.executeQuery("select * from estados where codigoEstado = 4 or codigoEstado = 10 or codigoEstado = 11 or codigoEstado = 12;");
            ComboBoxMod Modelo = new ComboBoxMod();

            while (rst.next()) {
                ComboBoxItem item = new ComboBoxItem();
                item.setItem(rst.getString("codigoEstado"), rst.getString("descripcionEstado"));
                Modelo.addItem(item);
            }

            cmbEstado.setModel(Modelo);
        } catch (SQLException e) {

            System.out.println("Error de query");
            System.out.println(e.getMessage());
        }

        cmbEstado.setSelectedIndex(1);
    }//GEN-LAST:event_formWindowActivated

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
        /*ResultSet rs = MantenimientoInventario.obtenerMaterialPorEstado(cmbEstado.getSelectedItem().toString());
        TablaDatos tb = new TablaDatos(rs);
        tblInventario.setModel(tb);*/
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void mnuMaterialesReservadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMaterialesReservadosActionPerformed
        DKasaMuebles.mv.inventariofrm.setVisible(false);
        DKasaMuebles.mv.inventarioMaterialReservadofrm.setVisible(true);
    }//GEN-LAST:event_mnuMaterialesReservadosActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnuInventario;
    private javax.swing.JMenuItem mnuMaterialesReservados;
    private javax.swing.JMenuItem mnuNuevoMaterial;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
