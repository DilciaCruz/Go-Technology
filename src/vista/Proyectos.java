/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.TablaDatos;
import dkasamuebles.DKasaMuebles;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.ComboBoxItem;
import modelo.ComboBoxMod;
import modelo.MantenimientoProyectos;
import modelo.MantenimientoUsuarios;

/**
 *
 * @author VILLALTA
 */
public class Proyectos extends javax.swing.JFrame {

    String ruta = null;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modmaterial = new DefaultTableModel();

    public Proyectos() {
        initComponents();

        modelo.addColumn("Fecha");
        modelo.addColumn("Descripción");

        modmaterial.addColumn("Material");
        modmaterial.addColumn("Cantidad");
        
        this.setTitle("DkasaMuebles - Proyectos");

        try {
            Connection con = MantenimientoUsuarios.con;
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from estados where codigoEstado=5 or  codigoEstado=8 or codigoEstado=9;");
            ComboBoxMod aModel = new ComboBoxMod();
            while (rs.next()) {
                ComboBoxItem item = new ComboBoxItem();
                item.setItem(rs.getString("codigoEstado"), rs.getString("descripcionEstado"));
                aModel.addItem(item);
            }

            cmbEstado.setModel(aModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            Connection con = MantenimientoUsuarios.con;
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from estados where codigoEstado=13 or  codigoEstado=14 or codigoEstado=16 or codigoEstado=15;");
            ComboBoxMod aModel = new ComboBoxMod();
            while (rs.next()) {
                ComboBoxItem item = new ComboBoxItem();
                item.setItem(rs.getString("codigoEstado"), rs.getString("descripcionEstado"));
                aModel.addItem(item);
            }

            cmbEstadoFechas.setModel(aModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            Connection con = MantenimientoUsuarios.con;
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select codigoMaterial, descripcionMaterial from materiales");
            ComboBoxMod aModel = new ComboBoxMod();
            while (rs.next()) {
                ComboBoxItem item = new ComboBoxItem();
                item.setItem(rs.getString("codigoMaterial"), rs.getString("descripcionMaterial"));
                aModel.addItem(item);
            }

            cmbMateriales.setModel(aModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        cmbEstado.setSelectedIndex(0);
        cmbMateriales.setSelectedIndex(0);
        cmbEstadoFechas.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblplano = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtcantidadMateriales = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGarantia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnRegresar1 = new javax.swing.JButton();
        btnAgregarMaterial = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        lblplanos = new javax.swing.JLabel();
        btnsubirplano = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmateriales = new javax.swing.JTable();
        cmbMateriales = new javax.swing.JComboBox<>();
        lbcantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jfecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cmbEstadoFechas = new javax.swing.JComboBox();
        btnagregarfecha = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblfechas = new javax.swing.JTable();
        btnEliminarFeha = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblproductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblruta = new javax.swing.JLabel();
        Cliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnEliminarMaterial = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        btnguargar = new javax.swing.JButton();

        lblplano.setText("jLabel11");

        setPreferredSize(new java.awt.Dimension(1000, 780));
        setResizable(false);
        setSize(new java.awt.Dimension(1800, 780));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Proyectos");

        txtcantidadMateriales.setBackground(new java.awt.Color(204, 204, 204));
        txtcantidadMateriales.setToolTipText("");

        jLabel2.setText("Materiales");

        jLabel8.setText("Estado del proyecto");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        jLabel6.setText("Garantia");

        txtGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGarantiaActionPerformed(evt);
            }
        });

        jLabel7.setText("Precio");

        btnRegresar1.setText("Regresar");

        btnAgregarMaterial.setText("Agregar");
        btnAgregarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMaterialActionPerformed(evt);
            }
        });

        jLabel10.setText("Descripción");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblplanos.setToolTipText("");
        lblplanos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnsubirplano.setText("Subir Plano");
        btnsubirplano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubirplanoActionPerformed(evt);
            }
        });

        tblmateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblmateriales);

        cmbMateriales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbcantidad.setText("Cantidad ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Fechas"));

        jLabel4.setText("Fecha");

        cmbEstadoFechas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnagregarfecha.setText("Agregar");
        btnagregarfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarfechaActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado ");

        tblfechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblfechas);

        btnEliminarFeha.setText("Eliminar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEliminarFeha)
                                .addGap(145, 145, 145)
                                .addComponent(btnagregarfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbEstadoFechas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(cmbEstadoFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnagregarfecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarFeha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(tblproductos);

        jLabel3.setText("Productos");

        Cliente.setText("Cliente");

        btnEliminarMaterial.setText("Eliminar");
        btnEliminarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMaterialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtcantidadMaterialesLayout = new javax.swing.GroupLayout(txtcantidadMateriales);
        txtcantidadMateriales.setLayout(txtcantidadMaterialesLayout);
        txtcantidadMaterialesLayout.setHorizontalGroup(
            txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtcantidadMaterialesLayout.createSequentialGroup()
                .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtcantidadMaterialesLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(txtcantidadMaterialesLayout.createSequentialGroup()
                                    .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                    .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtGarantia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(txtcantidadMaterialesLayout.createSequentialGroup()
                                    .addComponent(Cliente)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtcantidadMaterialesLayout.createSequentialGroup()
                                    .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(lbcantidad))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEliminarMaterial)
                                        .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbMateriales, 0, 277, Short.MAX_VALUE)
                                            .addComponent(txtCantidad)))
                                    .addGap(4, 4, 4)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtcantidadMaterialesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarMaterial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59)
                .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(txtcantidadMaterialesLayout.createSequentialGroup()
                        .addComponent(lblruta, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsubirplano))
                    .addComponent(lblplanos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtcantidadMaterialesLayout.createSequentialGroup()
                    .addContainerGap(718, Short.MAX_VALUE)
                    .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(245, 245, 245)))
        );
        txtcantidadMaterialesLayout.setVerticalGroup(
            txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtcantidadMaterialesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtcantidadMaterialesLayout.createSequentialGroup()
                        .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(txtcantidadMaterialesLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel6))
                            .addGroup(txtcantidadMaterialesLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(txtGarantia, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(txtcantidadMaterialesLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(33, 33, 33)
                                .addComponent(lbcantidad))
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarMaterial)
                            .addComponent(btnEliminarMaterial))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(txtcantidadMaterialesLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblplanos, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsubirplano)
                            .addComponent(lblruta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(txtcantidadMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtcantidadMaterialesLayout.createSequentialGroup()
                    .addContainerGap(590, Short.MAX_VALUE)
                    .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)))
        );

        btnsalir.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnregresar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });

        btnguargar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnguargar.setText("Guardar");
        btnguargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnguargar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcantidadMateriales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1188, 1188, 1188))
            .addGroup(layout.createSequentialGroup()
                .addGap(462, 462, 462)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(txtcantidadMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguargar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1118, 787));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        DKasaMuebles.mv.menuPrincipalfrm.setVisible(true);
        DKasaMuebles.mv.proyectosfrm.setVisible(false);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        DKasaMuebles.mv.proyectosfrm.setVisible(false);
        DKasaMuebles.mv.listaProyectofrm.setVisible(true);
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnguargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguargarActionPerformed


    }//GEN-LAST:event_btnguargarActionPerformed

    private void btnsubirplanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubirplanoActionPerformed

        JFileChooser j = new JFileChooser();

        int ap = j.showOpenDialog(this);

        if (ap == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile().getAbsolutePath();
            lblplanos.setIcon(new ImageIcon(ruta));
            lblruta.setText(ruta);
        }

        ImageIcon fot = new ImageIcon(lblruta.getText());
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblplanos.getWidth(), lblplanos.getHeight(), Image.SCALE_DEFAULT));
        lblplanos.setIcon(icono);
        this.repaint();

    }//GEN-LAST:event_btnsubirplanoActionPerformed

    private void btnAgregarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMaterialActionPerformed

        ComboBoxItem materiales = (ComboBoxItem) cmbMateriales.getModel().getSelectedItem();
        String codigoMaterial = materiales.getValue();
        String cantidadMateriales = txtCantidad.getText();

        if (txtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hay Campos Vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            Object[] material = new Object[2];

            material[0] = cmbMateriales.getSelectedItem().toString();
            material[1] = cantidadMateriales;
            modmaterial.addRow(material);
            tblmateriales.setModel(modmaterial);

            cmbMateriales.setSelectedIndex(0);
            txtCantidad.setText("");
        }


    }//GEN-LAST:event_btnAgregarMaterialActionPerformed

    private void txtGarantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGarantiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGarantiaActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnagregarfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarfechaActionPerformed
        Date fecha = jfecha.getDate();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fechaConvertida = formato.format(fecha);
        ComboBoxItem estado = (ComboBoxItem) cmbEstadoFechas.getModel().getSelectedItem();
        String codigoEstado = estado.getValue();
        //String codigoProyecto=null;
        MantenimientoProyectos.insertarFechasProyecto(codigoEstado, 1, fechaConvertida);

        Object[] fechas = new Object[2];

        fechas[0] = fechaConvertida;
        fechas[1] = cmbEstadoFechas.getSelectedItem().toString();
        modelo.addRow(fechas);
        tblfechas.setModel(modelo);

        jfecha.setCalendar(null);
        cmbEstadoFechas.setSelectedIndex(0);
    }//GEN-LAST:event_btnagregarfechaActionPerformed

    private void btnEliminarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMaterialActionPerformed
        Integer filaSeleccionada = tblmateriales.getSelectedRow();

        if (filaSeleccionada >= 0) {
            modelo.removeRow(filaSeleccionada);
         }
    }//GEN-LAST:event_btnEliminarMaterialActionPerformed

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
            java.util.logging.Logger.getLogger(Proyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proyectos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cliente;
    private javax.swing.JButton btnAgregarMaterial;
    private javax.swing.JButton btnEliminarFeha;
    private javax.swing.JButton btnEliminarMaterial;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnagregarfecha;
    private javax.swing.JButton btnguargar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnsubirplano;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbEstadoFechas;
    private javax.swing.JComboBox<String> cmbMateriales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser jfecha;
    private javax.swing.JLabel lbcantidad;
    private javax.swing.JLabel lblplano;
    private javax.swing.JLabel lblplanos;
    private javax.swing.JLabel lblruta;
    private javax.swing.JTable tblfechas;
    private javax.swing.JTable tblmateriales;
    private javax.swing.JTable tblproductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JPanel txtcantidadMateriales;
    // End of variables declaration//GEN-END:variables
}
