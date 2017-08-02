/**
 * Elaborado por Alexei Rodriguez y Franklin Villalta
 * Fecha 24/07/2017 12:09 pm
 * Versión 1.3
 */
package vista;

import modelo.MantenimientoCliente;
import controlador.*;
import dkasamuebles.DKasaMuebles;
import static dkasamuebles.DKasaMuebles.ayuda;
import java.sql.Connection;
import modelo.MantenimientoUsuarios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ComboBoxItem;
import modelo.ComboBoxMod;
import java.sql.Statement;

public class RegistrarCliente extends javax.swing.JFrame {

    public RegistrarCliente() {
        initComponents();
        this.setTitle("DkasaMuebles - Registrar Cliente");
        Connection con = MantenimientoUsuarios.con;
        //Carga los tipos de identificación que tiene el clientes
        try {
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from identificaciones;");
            ComboBoxMod aModel = new ComboBoxMod();
            while (rs.next()) {
                ComboBoxItem item = new ComboBoxItem();
                item.setItem(rs.getString("codigoIdentificacion"), rs.getString("descripcionIdentificacion"));
                aModel.addItem(item);
            }
            cmbTipoIdentificacion.setModel(aModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //Carga los diferentes estados que tiene el cliente
        try {
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from estados where codigoEstado = 1 or codigoEstado = 4;");
            ComboBoxMod Modelo = new ComboBoxMod();
            while (rs.next()) {
                ComboBoxItem item = new ComboBoxItem();
                item.setItem(rs.getString("codigoEstado"), rs.getString("descripcionEstado"));
                Modelo.addItem(item);
            }
            cmbEstadoCliente.setModel(Modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        cmbEstadoCliente.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        cmbEstadoCliente = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbTipoIdentificacion = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtcodigoCliente = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        ayuda = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Registrar Clientes");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Identificación");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setText("Estado");

        txtIdentificacion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacionActionPerformed(evt);
            }
        });
        txtIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdentificacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacionKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setText("Dirección");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Nombre");

        txtCorreo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Apellido");

        txtApellido.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("Telefono");

        txtTelefono.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        cmbEstadoCliente.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Tipo de Identificación");

        cmbTipoIdentificacion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cmbTipoIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoIdentificacionActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setText("Correo Electrónico");

        txtDireccion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        txtcodigoCliente.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbTipoIdentificacion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbEstadoCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, 450, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtcodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbEstadoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(txtcodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalir.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(61, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new java.awt.Dimension(61, 23));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setPreferredSize(new java.awt.Dimension(61, 27));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );

        setSize(new java.awt.Dimension(963, 747));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // Este evento nos permite validar el correo electrónico.
        boolean status = Validaciones.email_validation(txtCorreo.getText());
        if (status) {
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese correctamente su correo");
        }
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Verifica que los campos esten llenos
        boolean status = Validaciones.email_validation(txtCorreo.getText());
        if (status) {
            if (txtIdentificacion.getText().isEmpty() || txtNombre.getText().isEmpty() || txtNombre.getText().startsWith(" ") || txtApellido.getText().isEmpty() || txtApellido.getText().startsWith(" ") || txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hay Campos Vacios", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Se asigna una varible a los campos de la base de datos
                ComboBoxItem TipoIdentificacion = (ComboBoxItem) cmbTipoIdentificacion.getModel().getSelectedItem();
                String codigoIdentificacion = TipoIdentificacion.getValue();
                ComboBoxItem estado = (ComboBoxItem) cmbEstadoCliente.getModel().getSelectedItem();
                String codigoEstado = estado.getValue();
                String codigoCliente = txtcodigoCliente.getText();
                String identificacionCliente = txtIdentificacion.getText();
                String nombreCliente = txtNombre.getText();
                String apellidoCliente = txtApellido.getText();
                String telefonoCliente = txtTelefono.getText();
                String correoCliente = txtCorreo.getText();
                String direccionCliente = txtDireccion.getText();
                int codigo = MantenimientoCliente.obtenerCodigo(codigoCliente);
                if (Clientes.codigobtnPresionado == 1) {
                    //Guarda la información en la base de datos
                    if (MantenimientoCliente.insertarCliente(codigoIdentificacion, identificacionCliente, nombreCliente, apellidoCliente, telefonoCliente, direccionCliente, correoCliente, codigoEstado) && Clientes.codigobtnPresionado == 1) {
                        JOptionPane.showMessageDialog(this, "Guardado exitosamente en la Base de Datos");
                        cmbTipoIdentificacion.setSelectedIndex(-1);
                        txtIdentificacion.setText("");
                        txtNombre.setText("");
                        txtApellido.setText("");
                        txtTelefono.setText("");
                        txtDireccion.setText("");
                        txtCorreo.setText("");
                        cmbEstadoCliente.setSelectedIndex(-1);
                        DKasaMuebles.mv.registrarClientefrm.setVisible(false);
                        DKasaMuebles.mv.clientesfrm.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al guardar en la Base de Datos");
                    }
                } else {
                    //Actualiza la informacion de el item modificado
                    if (MantenimientoCliente.actualizarCliente(codigo, codigoCliente, codigoIdentificacion, identificacionCliente, nombreCliente, apellidoCliente, telefonoCliente, direccionCliente, correoCliente, codigoEstado)) {
                        JOptionPane.showMessageDialog(this, "Datos actualizados exitosamente en la Base de Datos");
                        cmbTipoIdentificacion.setSelectedIndex(0);
                        txtIdentificacion.setText("");
                        txtNombre.setText("");
                        txtApellido.setText("");
                        txtTelefono.setText("");
                        txtDireccion.setText("");
                        txtCorreo.setText("");
                        cmbEstadoCliente.setSelectedIndex(0);
                        DKasaMuebles.mv.registrarClientefrm.setVisible(false);
                        DKasaMuebles.mv.clientesfrm.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se han guardado los cambios");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese correctamente su correo");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacionActionPerformed
    }//GEN-LAST:event_txtIdentificacionActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // Se hace limpieza de los campos 
        cmbTipoIdentificacion.setSelectedIndex(0);
        txtIdentificacion.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        cmbEstadoCliente.setSelectedIndex(0);
        DKasaMuebles.mv.registrarClientefrm.setVisible(false);
        DKasaMuebles.mv.clientesfrm.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // Se hace limpieza de los campos
        cmbTipoIdentificacion.setSelectedIndex(0);
        txtIdentificacion.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        cmbEstadoCliente.setSelectedIndex(0);
        DKasaMuebles.mv.registrarClientefrm.setVisible(false);
        DKasaMuebles.mv.menuPrincipalfrm.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtIdentificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionKeyPressed
        //No pertmite copiar ni pegar las cadenas de texto.
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente su identificación");
            evt.consume();
            txtIdentificacion.setText("");
        }
    }//GEN-LAST:event_txtIdentificacionKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        //No pertmite copiar ni pegar las cadenas de texto.
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente su nombre");
            evt.consume();
            txtNombre.setText("");
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyPressed
        //No pertmite copiar ni pegar las cadenas de texto.
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente su apellido");
            evt.consume();
            txtApellido.setText("");
        }
    }//GEN-LAST:event_txtApellidoKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        //No pertmite copiar ni pegar las cadenas de texto.
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente su teléfono");
            evt.consume();
            txtTelefono.setText("");
        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        //No pertmite copiar ni pegar las cadenas de texto. 
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente su direccion");
            evt.consume();
            txtDireccion.setText("");
        }
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyPressed
        //No pertmite copiar ni pegar las cadenas de texto.
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente su correo");
            evt.consume();
            txtCorreo.setText("");
        }
    }//GEN-LAST:event_txtCorreoKeyPressed

    private void txtIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionKeyTyped
        // No pertmite ingresar letras o caracteres especiales
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)) {
            evt.consume();
        }
        // Establece el número de caracteres a ingresar 
        if (txtIdentificacion.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdentificacionKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // No permite ingresar espacio al inicio.
        if (txtNombre.getText().length() > 0 && txtNombre.getText().startsWith(" ")) {
            JOptionPane.showMessageDialog(null, "Su primer digito es un espacio en blanco");
            txtNombre.setText("");
        } else {
            char validar = evt.getKeyChar();
            char caracter = evt.getKeyChar();
            // Ésta decisión nos permite limitar que caracteres se pueden ingresar 
            if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z')) && (caracter != KeyEvent.VK_SPACE) && (caracter != KeyEvent.VK_BACK_SPACE)) {
                evt.consume();
            }
            // Permite ingresar unicamente un espacio.
            if (caracter == ' ' && txtNombre.getText().contains(" ")) {
            }
            String Caracteres = txtNombre.getText();
            // Nos permite darle el tamaño limite de caracteres a ingresar.
            if (Caracteres.length() >= 30) {
                evt.consume();
            }
            //no permite dejar espacios en blanco al inicio
            if (!Character.isLetter(validar)) {
                evt.consume();
            }
        }

        // Nos permite darle el tamaño limite de caracteres a ingresar.
        if (txtNombre.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // No permite ingresar espacio al inicio.
        if (txtApellido.getText().length() > 0 && txtApellido.getText().startsWith(" ")) {
            JOptionPane.showMessageDialog(null, "Su primer digito es un espacio en blanco");
            txtApellido.setText("");
        } else {
            char validar = evt.getKeyChar();
            char caracter = evt.getKeyChar();
            // Ésta decisión nos permite limitar que caracteres se pueden ingresar 
            if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z')) && (caracter != KeyEvent.VK_SPACE) && (caracter != KeyEvent.VK_BACK_SPACE)) {
                evt.consume();
            }
            // Permite ingresar unicamente un espacio.
            if (caracter == ' ' && txtApellido.getText().contains(" ")) {
                evt.consume();
            }
            String Caracteres = txtApellido.getText();
            // Permite darle el tamaño limite de caracteres a ingresar.
            if (Caracteres.length() >= 30) {
                evt.consume();
            }
            //no permite dejar espacios en blanco al inicio
            if (!Character.isLetter(validar)) {
                evt.consume();
            }
        }
        // Permite darle el tamaño limite de caracteres a ingresar.
        if (txtApellido.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // No pertmite ingresar letras o caracteres especiales
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)) {
            evt.consume();
        }
        // Permite darle el tamaño limite de caracteres a ingresar.
        if (txtTelefono.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        // Permite darle el tamaño limite de caracteres a ingresar.
        if (txtCorreo.getText().length() >= 45) {
            evt.consume();
        }
        // Permite ingresar unicamente los caracteres "." y "@".
        char validar = evt.getKeyChar();
        char caracter = evt.getKeyChar();
        //no permite dejar espacios en blanco al inicio
        if (caracter == '.' && txtCorreo.getText().contains(".")) {
            evt.consume();
        }
        if (caracter == '@' && txtCorreo.getText().contains("@")) {
            evt.consume();
        }
        if (caracter == '_' && txtCorreo.getText().contains("_")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        // Permite validar el correo electrónico 
        boolean status = Validaciones.email_validation(txtCorreo.getText());
        if (status) {
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese correctamente su correo");
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void cmbTipoIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoIdentificacionActionPerformed
    }//GEN-LAST:event_cmbTipoIdentificacionActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //Extracción de la informacion del item a modificar
        System.out.println(Clientes.codigobtnPresionado);
        if (Clientes.codigobtnPresionado == 2) {
            try {
                String DatoSelected = DKasaMuebles.DatoSelected;
                ResultSet rs = MantenimientoCliente.extraerDatosCliente(DKasaMuebles.DatoSelected);
                if (rs.next()) {
                    Integer indiceIdentificacion = rs.getInt("codigoIdentificacion");
                    Integer indiceEstado = rs.getInt("codigoEstado");
                    String descripcion = rs.getString("descripcionEstado");
                    txtcodigoCliente.setText(rs.getString("codigoCliente"));
                    cmbTipoIdentificacion.setSelectedIndex(indiceIdentificacion - 1);
                    txtIdentificacion.setText(rs.getString("identificacionCliente"));
                    txtNombre.setText(rs.getString("nombreCliente"));
                    txtApellido.setText(rs.getString("apellidoCliente"));
                    txtTelefono.setText(rs.getString("telefonoCliente"));
                    txtDireccion.setText(rs.getString("direccionCliente"));
                    txtCorreo.setText(rs.getString("correoCliente"));
                    ComboBoxItem comboItem = new ComboBoxItem();
                    comboItem.setItem(indiceEstado.toString(), descripcion);
                    cmbEstadoCliente.getModel().setSelectedItem(comboItem);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }
    }//GEN-LAST:event_formWindowActivated

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
        ayuda();
    }//GEN-LAST:event_ayudaActionPerformed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        if (txtDireccion.getText().length() >= 90) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayuda;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbEstadoCliente;
    private javax.swing.JComboBox<String> cmbTipoIdentificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtcodigoCliente;
    // End of variables declaration//GEN-END:variables
}
