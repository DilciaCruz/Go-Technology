/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.TablaDatos;
import dkasamuebles.DKasaMuebles;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.MantenimientoCliente;

/**
 *
 * @author Astrid
 */
public class Clientes extends javax.swing.JFrame {
    public static int codigobtnPresionado;
    /**
     * Creates new form clientes
     */
    public Clientes() {
        initComponents();
       ResultSet rs = MantenimientoCliente.mostrarClientes("");
       TablaDatos dt = new TablaDatos(rs);
       tblDatosCliente.setModel(dt);
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
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatosCliente = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();
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
        mnuListaFacturas = new javax.swing.JMenuItem();
        mnuNuevaFactura = new javax.swing.JMenuItem();
        mnuAgendas = new javax.swing.JMenu();
        mnuAgenda = new javax.swing.JMenuItem();

        jToolBar1.setRollover(true);

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Buscar");

        txtBuscar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblDatosCliente.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tblDatosCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Cliente", "Nombre", "Apellido", "Identificación", "Correo", "Dirección", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatosCliente);

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Lista de Clientes");

        btnSalir.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(61, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEditar1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnEditar1.setText("Editar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
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
        mnuFacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFacturacionActionPerformed(evt);
            }
        });

        mnuListaFacturas.setText("Facturas");
        mnuListaFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListaFacturasActionPerformed(evt);
            }
        });
        mnuFacturacion.add(mnuListaFacturas);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jLabel1)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        codigobtnPresionado = 1;
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

        int filaseleccionada;
        filaseleccionada = tblDatosCliente.getSelectedRow();
        if (filaseleccionada == -1) {
            
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
            
        } else {
            
            String ClienteCodigo = tblDatosCliente.getModel().getValueAt(filaseleccionada, 0).toString();
            
            System.out.println(ClienteCodigo);
            DKasaMuebles.DatoSelected = ClienteCodigo;
            DKasaMuebles.mv.clientesfrm.setVisible(false);
            DKasaMuebles.mv.nuevaCotizacionfrm.setVisible(true);
        }


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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        ResultSet rs = MantenimientoCliente.Buscar(txtBuscar.getText());
        TablaDatos dt = new TablaDatos(rs);
        tblDatosCliente.setModel(dt);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void mnuProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProyectosActionPerformed
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.listaProyectofrm.setVisible(true);
    }//GEN-LAST:event_mnuProyectosActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        // TODO add your handling code here:
        int filaseleccionada;
        codigobtnPresionado = 2;
        filaseleccionada = tblDatosCliente.getSelectedRow();
        if (filaseleccionada == -1) {
            
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
            
        } else {
            
            String codigoCliente = tblDatosCliente.getModel().getValueAt(filaseleccionada, 0).toString();
            
            DKasaMuebles.DatoSelected = codigoCliente;
            DKasaMuebles.mv.registrarClientefrm.setVisible(true);
            DKasaMuebles.mv.clientesfrm.setVisible(false);
        }
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ResultSet rs = MantenimientoCliente.mostrarClientes("");
        TablaDatos dt = new TablaDatos(rs);
        tblDatosCliente.setModel(dt);
    }//GEN-LAST:event_formWindowActivated

    private void mnuFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFacturacionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mnuFacturacionActionPerformed

    private void mnuListaFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListaFacturasActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.listaFacturasfrm.setVisible(true);
    }//GEN-LAST:event_mnuListaFacturasActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        if(txtBuscar.getText().isEmpty()){
            ResultSet rs = MantenimientoCliente.mostrarClientes("");
            TablaDatos dt = new TablaDatos(rs);
            tblDatosCliente.setModel(dt);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
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
    private javax.swing.JMenuItem mnuListaFacturas;
    private javax.swing.JMenuItem mnuNuevaCotizacion;
    private javax.swing.JMenuItem mnuNuevaFactura;
    private javax.swing.JMenuItem mnuNuevoProyecto;
    private javax.swing.JMenu mnuProyecto;
    private javax.swing.JMenuItem mnuProyectos;
    private javax.swing.JMenuItem mnuRegistrarCliente;
    public javax.swing.JTable tblDatosCliente;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
