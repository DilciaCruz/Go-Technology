/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dkasamuebles.DKasaMuebles;

/**
 *
 * @author Astrid
 */
public class Clientes extends javax.swing.JFrame {

    /**
     * Creates new form clientes
     */
    public Clientes() {
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

        jToolBar1 = new javax.swing.JToolBar();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatosCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        menuClientes = new javax.swing.JMenuBar();
        mnuClientes = new javax.swing.JMenu();
        mnuRegistrarCliente = new javax.swing.JMenuItem();
        mnuCotización = new javax.swing.JMenu();
        mnuCotizaciones = new javax.swing.JMenuItem();
        mnuNuevaCotizacion = new javax.swing.JMenuItem();
        mnuProyecto = new javax.swing.JMenu();
        mnuProyectos = new javax.swing.JMenuItem();
        mnuNuevoProyecto = new javax.swing.JMenuItem();
        mnuFacturacion = new javax.swing.JMenu();
        mnuNuevaFactura = new javax.swing.JMenuItem();
        mnuAgendas = new javax.swing.JMenu();
        mnuAgenda = new javax.swing.JMenuItem();

        jToolBar1.setRollover(true);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Buscar");

        txtBuscar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        tblDatosCliente.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tblDatosCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Identificación", "Correo", "Dirección", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatosCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Clientes.");

        btnEditar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(61, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        menuClientes.setBackground(new java.awt.Color(204, 204, 204));
        menuClientes.setToolTipText("");
        menuClientes.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        menuClientes.setPreferredSize(new java.awt.Dimension(285, 40));

        mnuClientes.setText("Cliente");
        mnuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClientesActionPerformed(evt);
            }
        });

        mnuRegistrarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnuRegistrarCliente.setText("Registrar Cliente");
        mnuRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrarClienteActionPerformed(evt);
            }
        });
        mnuClientes.add(mnuRegistrarCliente);

        menuClientes.add(mnuClientes);

        mnuCotización.setText("Cotización");

        mnuCotizaciones.setText("Cotizaciones");
        mnuCotizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCotizacionesActionPerformed(evt);
            }
        });
        mnuCotización.add(mnuCotizaciones);

        mnuNuevaCotizacion.setText("Nueva Cotización");
        mnuNuevaCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNuevaCotizacionActionPerformed(evt);
            }
        });
        mnuCotización.add(mnuNuevaCotizacion);

        menuClientes.add(mnuCotización);

        mnuProyecto.setText("Proyecto");

        mnuProyectos.setText("Proyectos");
        mnuProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProyectosActionPerformed(evt);
            }
        });
        mnuProyecto.add(mnuProyectos);

        mnuNuevoProyecto.setText("Nuevo Proyecto");
        mnuNuevoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNuevoProyectoActionPerformed(evt);
            }
        });
        mnuProyecto.add(mnuNuevoProyecto);

        menuClientes.add(mnuProyecto);

        mnuFacturacion.setText("Facturación");

        mnuNuevaFactura.setText("Nueva Factura");
        mnuNuevaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNuevaFacturaActionPerformed(evt);
            }
        });
        mnuFacturacion.add(mnuNuevaFactura);

        menuClientes.add(mnuFacturacion);

        mnuAgendas.setText("Agenda");

        mnuAgenda.setText("Agenda");
        mnuAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAgendaActionPerformed(evt);
            }
        });
        mnuAgendas.add(mnuAgenda);

        menuClientes.add(mnuAgendas);

        setJMenuBar(menuClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(401, 401, 401))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(984, 787));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClientesActionPerformed
        // TODO add your handling code here:
     
                        
    }//GEN-LAST:event_mnuClientesActionPerformed

    private void mnuRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrarClienteActionPerformed
        // TODO add your handling code here:
        this.dispose();
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.registrarClientefrm.setVisible(true);
    }//GEN-LAST:event_mnuRegistrarClienteActionPerformed

    private void mnuCotizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCotizacionesActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.cotizacionfrm.setVisible(true);
    }//GEN-LAST:event_mnuCotizacionesActionPerformed

    private void mnuNuevaCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNuevaCotizacionActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.nuevaCotizacionfrm.setVisible(true);
    }//GEN-LAST:event_mnuNuevaCotizacionActionPerformed

    private void mnuNuevoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNuevoProyectoActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.proyectosfrm.setVisible(true);
    }//GEN-LAST:event_mnuNuevoProyectoActionPerformed

    private void mnuNuevaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNuevaFacturaActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.facturafrm.setVisible(true);
    }//GEN-LAST:event_mnuNuevaFacturaActionPerformed

    private void mnuAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAgendaActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.agendafrm.setVisible(true);
    }//GEN-LAST:event_mnuAgendaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.menuPrincipalfrm.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
       DKasaMuebles.mv.clientesfrm.setVisible(false);
       DKasaMuebles.mv.registrarClientefrm.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void mnuProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProyectosActionPerformed
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.listaProyectofrm.setVisible(true);
    }//GEN-LAST:event_mnuProyectosActionPerformed

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuBar menuClientes;
    private javax.swing.JMenuItem mnuAgenda;
    private javax.swing.JMenu mnuAgendas;
    private javax.swing.JMenu mnuClientes;
    private javax.swing.JMenuItem mnuCotizaciones;
    private javax.swing.JMenu mnuCotización;
    private javax.swing.JMenu mnuFacturacion;
    private javax.swing.JMenuItem mnuNuevaCotizacion;
    private javax.swing.JMenuItem mnuNuevaFactura;
    private javax.swing.JMenuItem mnuNuevoProyecto;
    private javax.swing.JMenu mnuProyecto;
    private javax.swing.JMenuItem mnuProyectos;
    private javax.swing.JMenuItem mnuRegistrarCliente;
    private javax.swing.JTable tblDatosCliente;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
