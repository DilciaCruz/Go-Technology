/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.TablaDatos;
import dkasamuebles.DKasaMuebles;
import java.awt.event.KeyEvent;
import static java.lang.Math.round;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import static javax.swing.text.html.HTML.Tag.SELECT;
import static jdk.nashorn.internal.parser.DateParser.DAY;
import modelo.ComboBoxItem;
import modelo.ComboBoxMod;
import modelo.MantenimientoCliente;
import modelo.MantenimientoCotizacion;
import static modelo.MantenimientoCotizacion.extraerUltimoCodigoCotizacion;
import modelo.MantenimientoProyectos;

import modelo.MantenimientoUsuarios;
import static vista.Clientes.codigobtnPresionado;

/**
 *
 * @author Vanelly
 */
public class NuevaCotización extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    public static String Dato[] = new String[5];

    /**
     * Creates new form NuevaCotización
     */
    public NuevaCotización() throws SQLException {
        initComponents();

        this.setTitle("DkasaMuebles - Nueva Cotizacion");
        this.setExtendedState(MAXIMIZED_BOTH);
        modelo.addColumn("Codigo Producto");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripcion");

        tblProductos.setModel(modelo);

        Connection con = MantenimientoUsuarios.con;
        //La fecha de emisioon generada desde que inicia el constructor para que lo pueda hacer cuando se habre la pantalla

        try {
            ResultSet rs = MantenimientoCotizacion.fehaActual();
            if (rs.first()) {
                txtFechaEmision.setText(rs.getDate("fecha_emision").toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
        }

        //la fecha de vigencia traida del sistema
        try {
            ResultSet rs = MantenimientoCotizacion.fechaVigencia();
            if (rs.next()) {
                txtFechaVigencia.setText(rs.getDate("fecha_vigencia").toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from parametros where codigoParametro = 1;");

            while (rs.next()) {

                String codigo = rs.getString("codigoParametro");
                float valor;
                valor = rs.getFloat("valor");

                txtImpuestoParametro.setText(Float.toString(valor));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo extraer el valor del impuesto");
        }

        //Combo de estados
        try {

            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from estados where codigoEstado = 5 or codigoEstado = 6 or codigoEstado =7;");
            ComboBoxMod aModel = new ComboBoxMod();

            while (rs.next()) {
                ComboBoxItem item = new ComboBoxItem();
                item.setItem(rs.getString("codigoEstado"), rs.getString("descripcionEstado"));
                aModel.addItem(item);
            }

            cmbEstadoCotizacion.setModel(aModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        //combo de productos
        try {

            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from productos;");
            ComboBoxMod aModel = new ComboBoxMod();

            while (rs.next()) {
                ComboBoxItem item = new ComboBoxItem();
                item.setItem(rs.getString("codigoProducto"), rs.getString("descripcionProducto"));
                aModel.addItem(item);
            }

            cmbProducto.setModel(aModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        //Combo de Vendedor
        try {

            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from empleados;");
            ComboBoxMod aModel = new ComboBoxMod();

            while (rs.next()) {
                ComboBoxItem item = new ComboBoxItem();
                item.setItem(rs.getString("codigoEmpleado"), rs.getString("nombreEmpleado"));
                aModel.addItem(item);
            }

            cmbVendedor.setModel(aModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        //En el formulario presenta el primer valor del combo que esta en BD
        cmbVendedor.setSelectedIndex(0);
        cmbProducto.setSelectedIndex(0);
        cmbEstadoCotizacion.setSelectedIndex(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnGenerarCotizacion1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtImpuestoParametro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnAgregarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtIdentificacion = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbEstadoCotizacion = new javax.swing.JComboBox<>();
        txtFechaEmision = new javax.swing.JTextField();
        txtFechaVigencia = new javax.swing.JTextField();
        cmbVendedor = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCodigoCotizacion = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        txtSubTotal = new javax.swing.JTextField();
        txtImpuesto = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1000, 780));
        setResizable(false);
        setSize(new java.awt.Dimension(1800, 780));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Cotización");

        btnSalir.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnGenerarCotizacion1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnGenerarCotizacion1.setText("Generar");
        btnGenerarCotizacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarCotizacion1ActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGuardarMouseReleased(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion Proyecto"));

        jLabel1.setText("Descripcion");

        jLabel8.setText("Cantidad");

        jLabel9.setText("Precio");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel10.setText("Producto");

        cmbProducto.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel12.setText("Impuesto");

        txtImpuestoParametro.setEditable(false);

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescripcion.setRows(3);
        txtDescripcion.setTabSize(0);
        txtDescripcion.setToolTipText("");
        txtDescripcion.setMaximumSize(new java.awt.Dimension(284, 119));
        txtDescripcion.setMinimumSize(new java.awt.Dimension(284, 119));
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("Eliminar Producto");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbProducto, 0, 401, Short.MAX_VALUE)
                            .addComponent(txtImpuestoParametro)
                            .addComponent(txtCantidad)
                            .addComponent(jScrollPane1)
                            .addComponent(txtPrecio))))
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8))
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtImpuestoParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Clientes"));

        jLabel5.setText("Nombre del Cliente");

        jLabel6.setText("Identificación");

        jLabel7.setText("Dirección");

        txtNombre.setEditable(false);

        txtIdentificacion.setEditable(false);

        txtDireccion.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Cotización"));

        jLabel2.setText("Fecha de Emisión");

        jLabel3.setText("Estado de Cotización");

        jLabel4.setText("Fecha de Vigencia");

        cmbEstadoCotizacion.setToolTipText("");
        cmbEstadoCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoCotizacionActionPerformed(evt);
            }
        });

        txtFechaEmision.setEditable(false);

        txtFechaVigencia.setEditable(false);

        jLabel11.setText("Vendedor");

        jLabel13.setText("Codigo Cotización");

        txtCodigoCotizacion.setEditable(false);
        txtCodigoCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCotizacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbEstadoCotizacion, 0, 417, Short.MAX_VALUE)
                                    .addComponent(txtCodigoCotizacion)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(35, 35, 35)
                                .addComponent(txtFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCodigoCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstadoCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        label4.setText("Total a Pagar");

        txtSubTotal.setEditable(false);
        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });

        txtImpuesto.setEditable(false);
        txtImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImpuestoActionPerformed(evt);
            }
        });

        txtTotalPagar.setEditable(false);

        label2.setText("Sub Total");

        label3.setText("ISV");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProductos);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(94, 94, 94)
                                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(618, 618, 618)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57)
                            .addComponent(btnGenerarCotizacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(594, 594, 594)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 586, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarCotizacion1)
                    .addComponent(btnRegresar)
                    .addComponent(btnSalir)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        if (Clientes.codigobtnPresionado == 2) {
            cmbVendedor.setEnabled(false);
            txtDescripcion.setEditable(false);
            txtPrecio.setEditable(false);
            txtCantidad.setEditable(false);
            cmbProducto.setEnabled(false);
            btnAgregarProducto.setEnabled(false);
            btnEliminarProducto.setEnabled(false);
            Integer codigoProducto;
            /*Integer cantidad;
            String precio;*/
            String descripcionDetalle;
            try {
                String DatoSelected = DKasaMuebles.DatoSelected;
                txtCodigoCotizacion.setText(DatoSelected);

                txtFechaEmision.setText("");
                txtFechaVigencia.setText("");
                ResultSet rs = MantenimientoCotizacion.extraerDatosCotizacion(DKasaMuebles.DatoSelected);

                if (rs.next()) {
                    Integer indiceEstado = rs.getInt("codigoEstado");
                    String descripcion = rs.getString("descripcionEstado");

                    Integer indiceVendedor = rs.getInt("codigoEmpleado");
                    String nombreEmpleado = rs.getString("nombreEmpleado");

                    String fechaEmision = rs.getString("fechaEmisionCotizacion");
                    txtFechaEmision.setText(rs.getString("fechaEmisionCotizacion"));
                    txtFechaVigencia.setText(rs.getString("fechaVigencia"));
                    txtNombre.setText(rs.getString("nombreCliente"));
                    txtIdentificacion.setText(rs.getString("identificacionCliente"));
                    txtDireccion.setText(rs.getString("direccionCliente"));

                    ComboBoxItem comboItem = new ComboBoxItem();
                    ComboBoxItem comboItem1 = new ComboBoxItem();
                    comboItem.setItem(indiceEstado.toString(), descripcion);
                    comboItem1.setItem(indiceVendedor.toString(), nombreEmpleado);

                    cmbEstadoCotizacion.getModel().setSelectedItem(comboItem);
                    cmbVendedor.getModel().setSelectedItem(comboItem1);

                }
                /*if (cmbEstadoCotizacion.getSelectedIndex() != 0) {
                    cmbEstadoCotizacion.setEnabled(false);
                } else {
                    cmbEstadoCotizacion.setEnabled(true);
                }*/

            } catch (SQLException ex) {
                Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection con = MantenimientoUsuarios.con;

            try {
                impuestoParametro = Float.parseFloat(txtImpuestoParametro.getText());
                Statement st;
                st = con.createStatement();
                ResultSet rs = st.executeQuery("select a.codigoProducto, b.descripcionProducto,cantidad, precio,descripcionDetalle from detallecotizaciones a inner join productos b on a.codigoProducto=b.codigoProducto where codigoCotizacion='" + DKasaMuebles.DatoSelected + "';");
                TablaDatos tb = new TablaDatos(rs);
                tblProductos.setModel(tb);

                for (int i = 0; i < tblProductos.getRowCount(); i++) {

                    String canti = tb.getValueAt(i, 2).toString();
                    System.out.println(canti);
                    String pre = tb.getValueAt(i, 3).toString();

                    cantidad = Integer.parseInt(canti);
                    precio = Float.parseFloat(pre);
                    subtotal = (cantidad * precio);

                    acumuladorSubtotal += subtotal;
                    impuesto = (acumuladorSubtotal * impuestoParametro);
                    totalPagar = (acumuladorSubtotal + impuesto);

                    txtImpuesto.setText(String.format("%.2f", impuesto).replace(".00", " "));
                    txtSubTotal.setText(String.format("%.2f", acumuladorSubtotal).replace(".00", " "));
                    txtTotalPagar.setText(String.format("%.2f", totalPagar).replace(".00", " "));
                }

            } catch (SQLException ex) {
                Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
                //JOptionPane.showConfirmDialog(this, ex);

            }


            /*
            int fila = tblProductos.getSelectedRow();

            System.out.println(fila);
            if (fila != -1) {
                txtDescripcion.setText(tblProductos.getValueAt(fila, 0).toString());
            }*/
        } else {

            try {

                System.out.println(DKasaMuebles.DatoSelected);
                ResultSet rs = MantenimientoCotizacion.extraerDatosCliente(DKasaMuebles.DatoSelected);
                // extraerDatosCliente(ClienteSelected);

                if (rs.next()) {

                    txtNombre.setText(rs.getString("nombreCliente"));
                    txtIdentificacion.setText(rs.getString("identificacionCliente"));
                    txtDireccion.setText(rs.getString("direccionCliente"));

                }
                
                
                for (int i = 0; i >= 5; i++) {
            modelo.removeRow(i);

        }

        txtDescripcion.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtSubTotal.setText("");
        txtImpuesto.setText("");
        txtTotalPagar.setText("");
        cmbProducto.setSelectedIndex(0);
        cmbVendedor.setSelectedIndex(0);
                
                cmbEstadoCotizacion.setEnabled(true);
                cmbVendedor.setEnabled(true);
                txtDescripcion.setEditable(true);
                txtPrecio.setEditable(true);
                txtCantidad.setEditable(true);
                cmbProducto.setEnabled(true);
                btnAgregarProducto.setEnabled(true);
                btnEliminarProducto.setEnabled(true);
//            txtCodigoCotizacion.setText("");
                /*for (int i = 0; i >= 5; i++) {
                    modelo.removeRow(i);

                }*/

            } catch (SQLException ex) {
                Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_formWindowActivated

    private void cmbEstadoCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoCotizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoCotizacionActionPerformed

    private void btnGenerarCotizacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarCotizacion1ActionPerformed
        DKasaMuebles.mv.nuevaCotizacionfrm.setVisible(false);
        DKasaMuebles.mv.imprimirCotizacionfrm.setVisible(true);
    }//GEN-LAST:event_btnGenerarCotizacion1ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        DKasaMuebles.mv.nuevaCotizacionfrm.setVisible(false);
        DKasaMuebles.mv.cotizacionfrm.setVisible(true);
        
        for (int i = 0; i >= 5; i++) {
            modelo.removeRow(i);

        }

        txtDescripcion.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtSubTotal.setText("");
        txtImpuesto.setText("");
        txtTotalPagar.setText("");
        cmbProducto.setSelectedIndex(0);
        cmbVendedor.setSelectedIndex(0);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        /*if (txtPrecio.getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hay Campos Vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {*/
        ComboBoxItem estado = (ComboBoxItem) cmbEstadoCotizacion.getModel().getSelectedItem();
        ComboBoxItem vendedor = (ComboBoxItem) cmbVendedor.getModel().getSelectedItem();
        ComboBoxItem producto = (ComboBoxItem) cmbProducto.getModel().getSelectedItem();

        String codigoEstado = estado.getValue();
        String codigoVendedor = vendedor.getValue();
        String codigoProducto = producto.getValue();

        String fechaVigencia = txtFechaVigencia.getText();
        String fechaEmisionCotizacion = txtFechaEmision.getText();
        String impuesto = txtImpuestoParametro.getText();
        String DatoSelected = DKasaMuebles.DatoSelected;

        Integer codigo = 0;
        int codigoCotizacion = MantenimientoCotizacion.obtenerCodigo(codigoEstado);

        String codigoProducto1;
        String cantidadProducto;
        String precioProducto;
        String descripcionDetalle;
        String insertarDetalleCotizacion;

        if (Clientes.codigobtnPresionado == 1) {

            if (MantenimientoCotizacion.insertarDatosCotizacion(fechaEmisionCotizacion, impuesto, fechaVigencia, codigoEstado, DatoSelected, codigoVendedor)) {

                JOptionPane.showMessageDialog(this, "Guardado exitosamente en la Base de Datos en Cotizaciones");

                ResultSet rs = MantenimientoCotizacion.extraerUltimoCodigoCotizacion();

                try {
                    if (rs.first()) {

                        codigo = rs.getInt("MAX(codigoCotizacion)");
                        txtCodigoCotizacion.setText(codigo.toString());
                        System.out.println(codigo);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
                }
                Connection con = MantenimientoUsuarios.con;

                for (int i = 0; i <= tblProductos.getRowCount(); i++) {
                    try {

                        codigoProducto1 = tblProductos.getValueAt(i, 0).toString();
                        cantidadProducto = tblProductos.getValueAt(i, 2).toString();
                        precioProducto = tblProductos.getValueAt(i, 3).toString();
                        descripcionDetalle = tblProductos.getValueAt(i, 4).toString();

                        insertarDetalleCotizacion = "INSERT INTO detallecotizaciones (codigoCotizacion,codigoProducto,cantidad,precio,descripcionDetalle) VALUES ('" + codigo + "','" + codigoProducto1 + "','" + cantidadProducto + "','" + precioProducto + "','" + descripcionDetalle + "');";

                        PreparedStatement ps = con.prepareStatement(insertarDetalleCotizacion);
                        ps.executeUpdate();

                    } catch (SQLException ex) {
                        Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, ex);
                    }

                }

            } else {

                JOptionPane.showMessageDialog(this, "Error al guardar en la Base de Datos en cotizacion");
            }

        } else {
            cmbVendedor.setEnabled(false);
            txtCantidad.setEditable(false);
            txtPrecio.setEditable(false);
            txtDescripcion.setEditable(false);

            if (MantenimientoCotizacion.actualizarEstadoCotizacion(DatoSelected, codigoEstado)) {
                JOptionPane.showMessageDialog(this, "Se ha actualizado en la BD el estado");
                
                Integer codigoEstadoActualizado = Integer.parseInt(codigoEstado);
                String insertarClienteProyectos;
                Integer codigoCliente = 0;

                Connection con = MantenimientoUsuarios.con;
                if (codigoEstadoActualizado == 6) {
                    try {
                        ResultSet rs = MantenimientoProyectos.extraerCodigoClienteCotizacion(DatoSelected);

                        if (rs.first()) {
                            codigoCliente = rs.getInt("codigoCliente");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        insertarClienteProyectos = "INSERT INTO proyectos (codigoCliente) values ('" + codigoCliente + "');";
                        PreparedStatement ps = con.prepareStatement(insertarClienteProyectos);
                        ps.executeUpdate();

                        JOptionPane.showMessageDialog(this, "SE INSERTO EN LA TABLA PROYECTOS");

                    } catch (SQLException ex) {
                        Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "NO SE INSERTO EN LA TABLA PROYECTOS");
                    }
                    
                    cmbEstadoCotizacion.setEnabled(false);

                }
            } else {
                JOptionPane.showConfirmDialog(this, "No se ha actualizado en la BD el estado");
            }

        }

        /*        Integer codCotizacion = Integer.parseInt(DatoSelected);

        System.out.println(codCotizacion);
        System.out.println(codigoEstado);

        int idProyecto;

        if (Integer.parseInt(codigoEstado) == 6) {

            idProyecto = MantenimientoProyectos.insertarCotizacionProyecto(codCotizacion);
            System.out.println("Se actualizo proyecto");

            if (MantenimientoProyectos.insertarDetalleCotizacionDetalleProyecto(idProyecto, codCotizacion)) {
                System.out.println("Se actualizo Detalle Proyecto");
            } else {
                JOptionPane.showMessageDialog(null, "Error insertado de tablas detalle");
            }
        }*/
        txtDescripcion.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        for (int i = 0; i >= 5; i++) {
            modelo.removeRow(i);

        }
        DKasaMuebles.mv.nuevaCotizacionfrm.setVisible(false);
        DKasaMuebles.mv.menuPrincipalfrm.setVisible(true);
        txtDescripcion.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");

        txtSubTotal.setText("");
        txtImpuesto.setText("");
        txtTotalPagar.setText("");
        cmbProducto.setSelectedIndex(0);

        // tblProductos.setModel(new DefaultTableModel());

    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped

        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }

        String Caracter = txtCantidad.getText();

        if (Caracter.length() >= 6) {
            evt.consume();
        }

        int k = (int) evt.getKeyChar();//k = al valor de la tecla presionada   
        if (k == 48 && Caracter.length() < 1) {//Si el caracter ingresado es una letra
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
            JOptionPane.showMessageDialog(null, "No puede ingresar solamente cero", "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped

        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '.')) {
            evt.consume();

        }
        if (caracter == '.' && txtPrecio.getText().contains(".")) {
            evt.consume();
        }
        String Caracteres = txtPrecio.getText();
        if (Caracteres.length() >= 10) {
            evt.consume();
        }

        char charTeclaPresionada = evt.getKeyChar();
        if (charTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAgregarProducto.doClick();
        }
        String Caracter = txtPrecio.getText();
        if (Caracter.length() >= 10) {
            evt.consume();
        }
        int k = (int) evt.getKeyChar();//k = al valor de la tecla presionada   
        if (k == 48 && Caracter.length() < 1) {//Si el caracter ingresado es una letra
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
            JOptionPane.showMessageDialog(null, "No puede ingresar solamente cero", "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente su identificacion");
            evt.consume();
            txtCantidad.setText("");
        }

    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        int codigoBoton = evt.getKeyCode();

        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente su identificacion");
            evt.consume();
            txtPrecio.setText("");
        }

        /* if (codigoBoton == KeyEvent.VK_ENTER) {
            

             ComboBoxItem producto = (ComboBoxItem) cmbProducto.getModel().getSelectedItem();
            String codigoProducto = producto.getValue();

            Dato[0] = codigoProducto;
            Dato[1] = txtCantidad.getText();
            Dato[2] = txtPrecio.getText();
            Dato[3] = txtDescripcion.getText();
            modelo.addRow(Dato);

            cmbProducto.setSelectedIndex(0);
            txtDescripcion.setText("");
            txtCantidad.setText("");
            txtPrecio.setText("");
        }*/

    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        //acumuladorSubtotal = 0;

    }//GEN-LAST:event_txtPrecioKeyReleased

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased

    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void txtImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImpuestoActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
        String Caracteres = txtDescripcion.getText();
        if (Caracteres.length() >= 100) {
            evt.consume();
        }

    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked

        int fila = tblProductos.getSelectedRow();

        System.out.println(fila);


    }//GEN-LAST:event_tblProductosMouseClicked

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            txtDescripcion.transferFocus();
        }
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtCodigoCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCotizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCotizacionActionPerformed

    private void btnGuardarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseReleased
//                 System.out.println("HOLAAAAAAAAAAAA");


    }//GEN-LAST:event_btnGuardarMouseReleased

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        precio = Float.parseFloat(txtPrecio.getText());
        cantidad = Integer.parseInt(txtCantidad.getText());
        impuestoParametro = Float.parseFloat(txtImpuestoParametro.getText());

        if (precio == 0 || cantidad == 0) {
            JOptionPane.showMessageDialog(null, "No puede ingresar solamente cero", "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
            txtPrecio.setText("");
            txtCantidad.setText("");
        } else {

            /*subtotal = (precio * cantidad);
        acumuladorSubtotal += subtotal;
        impuesto = (acumuladorSubtotal * impuestoParametro);
        totalPagar = (acumuladorSubtotal + impuesto);*/
            ComboBoxItem producto = (ComboBoxItem) cmbProducto.getModel().getSelectedItem();
            String codigoProducto = producto.getValue();

            String descProducto = producto.toString();

            System.out.println("HOLAAAAAAAAAAA");
            System.out.println(codigoProducto);

            Dato[0] = codigoProducto;
            Dato[1] = cmbProducto.getSelectedItem().toString();
            Dato[2] = txtCantidad.getText();
            Dato[3] = txtPrecio.getText();
            Dato[4] = txtDescripcion.getText();

            Boolean encontrado = false;
            for (int i = 0; i < tblProductos.getRowCount(); i++) {

                String codigoProductoTabla = modelo.getValueAt(i, 0).toString();

                //Integer codigo = Integer.parseInt(codigoProductoTabla);
                System.out.println(codigoProductoTabla);
                System.out.println(codigoProducto);
                if (codigoProductoTabla.equals(codigoProducto)) {

                    System.out.println("AAAAAAAAAAAAAAAAAAAA");
                    tblProductos.changeSelection(i, 0, false, false);
                    encontrado = true;
                    JOptionPane.showMessageDialog(this, "NO PUEDE INGRESAR VALORES REPETIDOS");

                }

            }
            if (!encontrado) {
                modelo.addRow(Dato);
            }

            for (int i = 0; i < tblProductos.getRowCount(); i++) {

                String canti = modelo.getValueAt(i, 2).toString();
                String pre = modelo.getValueAt(i, 3).toString();

                cantidad = Integer.parseInt(canti);
                precio = Float.parseFloat(pre);
                subtotal = (cantidad * precio);

            }

            acumuladorSubtotal += subtotal;
            impuesto = (acumuladorSubtotal * impuestoParametro);
            totalPagar = (acumuladorSubtotal + impuesto);

            txtImpuesto.setText(String.format("%.2f", impuesto).replace(".00", " "));
            txtSubTotal.setText(String.format("%.2f", acumuladorSubtotal).replace(".00", " "));
            txtTotalPagar.setText(String.format("%.2f", totalPagar).replace(".00", " "));

            cmbProducto.setSelectedIndex(0);
            txtDescripcion.setText("");
            txtCantidad.setText("");
            txtPrecio.setText("");
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        Integer filaSeleccionada = tblProductos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            modelo.removeRow(filaSeleccionada);

            for (int i = 0; i < tblProductos.getRowCount(); i++) {

                String canti = modelo.getValueAt(i, 2).toString();
                String pre = modelo.getValueAt(i, 3).toString();

                cantidad = Integer.parseInt(canti);
                precio = Float.parseFloat(pre);
                subtotal = (cantidad * precio);

            }
            acumuladorSubtotal -= subtotal;
            impuesto = (acumuladorSubtotal * impuestoParametro);
            totalPagar = (acumuladorSubtotal + impuesto);

            txtImpuesto.setText(String.format("%.2f", impuesto).replace(".00", " "));
            txtSubTotal.setText(String.format("%.2f", acumuladorSubtotal).replace(".00", " "));
            txtTotalPagar.setText(String.format("%.2f", totalPagar).replace(".00", " "));

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        }


    }//GEN-LAST:event_btnEliminarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(NuevaCotización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaCotización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaCotización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaCotización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NuevaCotización().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGenerarCotizacion1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbEstadoCotizacion;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JComboBox<String> cmbVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoCotizacion;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaEmision;
    private javax.swing.JTextField txtFechaVigencia;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtImpuestoParametro;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables

    /* private String String(String string, float aFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    float subtotal = 0;
    int cantidad = 0;
    float precio = 0;
    float impuesto = 0;
    float impuestoParametro = 0;
    float totalPagar = 0;
    float acumuladorSubtotal = 0;

}
