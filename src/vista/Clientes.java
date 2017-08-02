/**
 * Elaborado por Alexei Rodriguez y Franklin Villalta
 * Fecha 24/07/2017 12:09 pm
 * Versión 1.3
 */
package vista;
import controlador.TablaDatos;
import dkasamuebles.DKasaMuebles;
import static dkasamuebles.DKasaMuebles.ayuda;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.MantenimientoCliente;

public class Clientes extends javax.swing.JFrame {

    public static int codigobtnPresionado;
    public Clientes() {
        initComponents();
        this.setTitle("DkasaMuebles - Clientes ");
        ResultSet rs = MantenimientoCliente.mostrarClientes("");
        TablaDatos dt = new TablaDatos(rs);
        tblDatosCliente.setModel(dt);
    }
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
        ayuda = new javax.swing.JButton();
        menuClientes = new javax.swing.JMenuBar();
        mnuClientes = new javax.swing.JMenu();
        mnuRegistrarCliente = new javax.swing.JMenuItem();
        mnuCotización = new javax.swing.JMenu();
        mnuCotizaciones = new javax.swing.JMenuItem();
        mnuNuevaCotizacion = new javax.swing.JMenuItem();
        mnuProyecto = new javax.swing.JMenu();
        mnuProyectos = new javax.swing.JMenuItem();
        mnuAgendas = new javax.swing.JMenu();
        mnuAgenda = new javax.swing.JMenuItem();
        mnuFacturacion = new javax.swing.JMenu();
        mnuListaFacturas = new javax.swing.JMenuItem();

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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Cliente", "Nombre", "Apellido", "Identificación", "Correo", "Direccion", "Telefono", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
                .addGap(145, 145, 145)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
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

        ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dkasamuebles/img/ayuda.png"))); // NOI18N
        ayuda.setToolTipText("");
        ayuda.setName("ayuda"); // NOI18N
        ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaActionPerformed(evt);
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

        menuClientes.add(mnuProyecto);

        mnuAgendas.setText("Agenda");

        mnuAgenda.setText("Agenda");
        mnuAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAgendaActionPerformed(evt);
            }
        });
        mnuAgendas.add(mnuAgenda);

        menuClientes.add(mnuAgendas);

        mnuFacturacion.setText("Factura");
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

        menuClientes.add(mnuFacturacion);

        setJMenuBar(menuClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(417, 417, 417)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1112, 733));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClientesActionPerformed
    }//GEN-LAST:event_mnuClientesActionPerformed

    private void mnuRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrarClienteActionPerformed
        // Llamado de la interfaz registro de clientes.
        codigobtnPresionado = 1;
        this.dispose();
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.registrarClientefrm.setVisible(true);
    }//GEN-LAST:event_mnuRegistrarClienteActionPerformed

    private void mnuCotizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCotizacionesActionPerformed
        // Llamado de la interfaz cotización.
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.cotizacionfrm.setVisible(true);
    }//GEN-LAST:event_mnuCotizacionesActionPerformed

    private void mnuNuevaCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNuevaCotizacionActionPerformed
        // Codigo para Seleccionar un item en la Datagrip para crearle una cotización.
        codigobtnPresionado = 1;
        int filaseleccionada;
        filaseleccionada = tblDatosCliente.getSelectedRow();
        if (filaseleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun cliente");
        } else {
            String ClienteCodigo = tblDatosCliente.getModel().getValueAt(filaseleccionada, 0).toString();
            System.out.println(ClienteCodigo);
            DKasaMuebles.DatoSelected = ClienteCodigo;
            DKasaMuebles.mv.clientesfrm.setVisible(false);
            DKasaMuebles.mv.nuevaCotizacionfrm.setVisible(true);
        }       
    }//GEN-LAST:event_mnuNuevaCotizacionActionPerformed

    private void mnuAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAgendaActionPerformed
        //Llamado de la interfaz de agenda.
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.agendafrm.setVisible(true);
    }//GEN-LAST:event_mnuAgendaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // Llamado de la interfaz de menú.
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.menuPrincipalfrm.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // Llamado de la clase MantenimientoCliente con la funcion Buscar en la datagrip.
        ResultSet rs = MantenimientoCliente.Buscar(txtBuscar.getText());
        TablaDatos dt = new TablaDatos(rs);
        tblDatosCliente.setModel(dt);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void mnuProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProyectosActionPerformed
        // Llamado de la interfaz de listaProyectos.
        DKasaMuebles.mv.clientesfrm.setVisible(false);
        DKasaMuebles.mv.listaProyectofrm.setVisible(true);
    }//GEN-LAST:event_mnuProyectosActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        // Codigo para Seleccionar un item en la Datagrip y editarlo.
        int filaseleccionada;
        codigobtnPresionado = 2;
        filaseleccionada = tblDatosCliente.getSelectedRow();
        if (filaseleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
        } else {
            String codigoCliente = tblDatosCliente.getModel().getValueAt(filaseleccionada, 0).toString();
            System.out.println("codigoCliente" + codigoCliente);
            DKasaMuebles.DatoSelected = codigoCliente;
            DKasaMuebles.mv.registrarClientefrm.setVisible(true);
            DKasaMuebles.mv.clientesfrm.setVisible(false);
        }
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Este evento sirve para que cargue los item en la datagrip al iniciar la interfaz.
        ResultSet rs = MantenimientoCliente.mostrarClientes("");
        TablaDatos dt = new TablaDatos(rs);
        tblDatosCliente.setModel(dt);
    }//GEN-LAST:event_formWindowActivated

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // Este evento sirve para que cargue los item en la datagrip cuando este vacio el campo.
        if (txtBuscar.getText().isEmpty()) {
            ResultSet rs = MantenimientoCliente.mostrarClientes("");
            TablaDatos dt = new TablaDatos(rs);
            tblDatosCliente.setModel(dt);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void mnuListaFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListaFacturasActionPerformed
        //Llamado de la interfaz de Lista de Facturas.
        DKasaMuebles.mv.cotizacionfrm.setVisible(false);
        DKasaMuebles.mv.listaFacturasfrm.setVisible(true);
    }//GEN-LAST:event_mnuListaFacturasActionPerformed

    private void mnuFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFacturacionActionPerformed
    }//GEN-LAST:event_mnuFacturacionActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
     ayuda();
    }//GEN-LAST:event_ayudaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayuda;
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
    private javax.swing.JMenu mnuProyecto;
    private javax.swing.JMenuItem mnuProyectos;
    private javax.swing.JMenuItem mnuRegistrarCliente;
    public javax.swing.JTable tblDatosCliente;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
