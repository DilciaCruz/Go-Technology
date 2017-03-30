/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dkasamuebles.DKasaMuebles;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ComboBoxItem;
import modelo.ComboBoxMod;

import modelo.MantenimientoFacturacion;
import modelo.MantenimientoUsuarios;

/**
 *
 * @author Jose
 */
public class Factura extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    public static String Dato[] = new String[4];
    /**
     * Creates new form factura
     */
    public Factura() {
        initComponents();
        this.setTitle("DkasaMuebles - Nueva Factura");
        this.setExtendedState(MAXIMIZED_BOTH);
        
        
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripcion");
        tblProductos.setModel(modelo);

        Connection con = MantenimientoUsuarios.con;
        //La fecha de emisioon generada desde que inicia el constructor para que lo pueda hacer cuando se habre la pantalla

        try {
            ResultSet rs = MantenimientoFacturacion.fehaActual();
            if (rs.first()) {
                txtFechaEmisionFactura.setText(rs.getDate("fecha_emision").toString());
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

            cmbEstadoFactura.setModel(aModel);
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
        
         //combo de Tipo de Pago
        try {

            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from tipoPagos;");
            ComboBoxMod aModel = new ComboBoxMod();

            while (rs.next()) {
                ComboBoxItem item = new ComboBoxItem();
                item.setItem(rs.getString("codigoTipoPago"), rs.getString("descripcionTipoPago"));
                aModel.addItem(item);
            }

            cmbTipoPago.setModel(aModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        //En el formulario presenta el primer valor del combo que esta en BD
        cmbVendedor.setSelectedIndex(0);
        cmbProducto.setSelectedIndex(0);
        cmbTipoPago.setSelectedIndex(0);
        cmbEstadoFactura.setSelectedIndex(0);

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
        btnGenerarFactura = new javax.swing.JButton();
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
        jLabel13 = new javax.swing.JLabel();
        txtanticipoProyecto = new javax.swing.JTextField();
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
        cmbEstadoFactura = new javax.swing.JComboBox<>();
        txtFechaEmisionFactura = new javax.swing.JTextField();
        cmbVendedor = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbTipoPago = new javax.swing.JComboBox<>();
        label4 = new java.awt.Label();
        txtSubTotal = new javax.swing.JTextField();
        txtImpuesto = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Facturación");

        btnGenerarFactura.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnGenerarFactura.setText("Generar");
        btnGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFacturaActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

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

        txtImpuestoParametro.setEnabled(false);

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescripcion.setRows(3);
        txtDescripcion.setTabSize(0);
        txtDescripcion.setToolTipText("");
        txtDescripcion.setMaximumSize(new java.awt.Dimension(284, 119));
        txtDescripcion.setMinimumSize(new java.awt.Dimension(284, 119));
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel13.setText("Anticipo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbProducto, 0, 401, Short.MAX_VALUE)
                    .addComponent(txtImpuestoParametro)
                    .addComponent(txtCantidad)
                    .addComponent(jScrollPane1)
                    .addComponent(txtPrecio)
                    .addComponent(txtanticipoProyecto))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtanticipoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Clientes"));

        jLabel5.setText("Nombre del Cliente");

        jLabel6.setText("Identificación");

        jLabel7.setText("Dirección");

        txtNombre.setEnabled(false);

        txtIdentificacion.setEnabled(false);

        txtDireccion.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Factura"));

        jLabel2.setText("Fecha de Emisión");

        jLabel3.setText("Estado de Factura");

        jLabel4.setText("Tipo Pago");

        cmbEstadoFactura.setToolTipText("");
        cmbEstadoFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoFacturaActionPerformed(evt);
            }
        });

        txtFechaEmisionFactura.setEnabled(false);

        jLabel11.setText("Vendedor");

        cmbTipoPago.setToolTipText("");
        cmbTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbVendedor, 0, 417, Short.MAX_VALUE)
                    .addComponent(txtFechaEmisionFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                    .addComponent(cmbTipoPago, 0, 417, Short.MAX_VALUE)
                    .addComponent(cmbEstadoFactura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbEstadoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txtFechaEmisionFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        label4.setText("Total a Pagar");

        txtSubTotal.setEnabled(false);
        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });

        txtImpuesto.setEnabled(false);
        txtImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImpuestoActionPerformed(evt);
            }
        });

        txtTotalPagar.setEnabled(false);

        label2.setText("Sub Total");

        label3.setText("ISV");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Nombre Producto", "Descripción", "Estado", "Cantidad", "Precio", "Anticipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(156, 156, 156))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(520, 520, 520))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(btnGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnGenerarFactura)
                    .addComponent(btnRegresar)
                    .addComponent(btnSalir))
                .addGap(65, 65, 65))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFacturaActionPerformed
        
    }//GEN-LAST:event_btnGenerarFacturaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
                                       
       /* if (txtPrecio.getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtCantidad.getText().isEmpty()||txtanticipoProyecto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hay Campos Vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else*/ {
        ComboBoxItem estado = (ComboBoxItem) cmbEstadoFactura.getModel().getSelectedItem();
        ComboBoxItem vendedor = (ComboBoxItem) cmbVendedor.getModel().getSelectedItem();
        ComboBoxItem tipoPago = (ComboBoxItem) cmbTipoPago.getModel().getSelectedItem();
        ComboBoxItem producto = (ComboBoxItem) cmbProducto.getModel().getSelectedItem();

        String codigoEstado = estado.getValue();
        String codigoEmpleado = vendedor.getValue();
        String codigoTipoPago = tipoPago.getValue();
        String codigoProducto = producto.getValue();

        String fechaEmisionFactura = txtFechaEmisionFactura.getText();
        String impuesto = txtImpuestoParametro.getText();
        String DatoSelected = DKasaMuebles.DatoSelected;
        Integer codigo = 0;
        int codigoFactura = MantenimientoFacturacion.obtenerCodigo(codigoEstado);

        String anticipoProyecto= txtanticipoProyecto.getText();
        String cantidad;
        String precioUnitario;
        String descripcion;
        String insertarDetalleFactura;

        if (MantenimientoFacturacion.insertarDatosFacturacion(fechaEmisionFactura,impuesto,codigoTipoPago,codigoEmpleado,codigoEstado,DatoSelected)) {

            JOptionPane.showMessageDialog(this, "Guardado exitosamente en la Base de Datos");
            ResultSet rs = MantenimientoFacturacion.extraerUltimoCodigoFacturacion();

            try {
                if (rs.first()) {

                    codigo = rs.getInt("MAX(codigoCotizacion)");

                }

            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = MantenimientoUsuarios.con;

           
                
            for (int i = 0; i <= tblProductos.getRowCount(); i++) {
                try {
                    
                    codigoEstado = tblProductos.getValueAt(i, 0).toString();
                    codigoProducto = tblProductos.getValueAt(i, 1).toString();
                    anticipoProyecto= tblProductos.getValueAt(i, 2).toString();
                    precioUnitario = tblProductos.getValueAt(i, 3).toString();
                    cantidad = tblProductos.getValueAt(i, 4).toString();
                    descripcion = tblProductos.getValueAt(i, 5).toString();

                    insertarDetalleFactura = "INSERT INTO detalleFactura (codigoEstado,codigoProducto, anticipoProyecto,precioUnitario, cantidad, descripcion) VALUES ('" + codigoEstado + "','" + codigoProducto + "','" + anticipoProyecto + "','" + precioUnitario + "','" + cantidad + "','" + descripcion + "');";

                    PreparedStatement ps = con.prepareStatement(insertarDetalleFactura);
                    ps.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(NuevaCotización.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex);
                }

            }
            JOptionPane.showMessageDialog(this, "Guardado exitosamente en la Base de Datos ");

        } else {

            JOptionPane.showMessageDialog(this, "Error al guardar en la Base de Datos ");
        }

        }
        txtImpuesto.setText("");
        txtSubTotal.setText("");
        txtTotalPagar.setText("");
        cmbEstadoFactura.setSelectedIndex(0);
    

        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente su identificacion");
            evt.consume();
            txtCantidad.setText("");
        }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        precio = Float.parseFloat(txtPrecio.getText());
        cantidad = Integer.parseInt(txtCantidad.getText());
        impuestoParametro = Float.parseFloat(txtImpuestoParametro.getText());

        subtotal = (precio * cantidad);
        impuesto = (subtotal * impuestoParametro);
        totalPagar = (subtotal + impuesto);

        txtImpuesto.setText(String.format("%3.2f", impuesto).replace(".00", ""));
        txtSubTotal.setText(String.format("%3.2f", subtotal).replace(".00", ""));
        txtTotalPagar.setText(String.format("%3.2f", totalPagar).replace(".00", ""));


    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        int codigoBoton = evt.getKeyCode();

        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
            JOptionPane.showMessageDialog(null, "Ingrese manualmente su identificacion");
            evt.consume();
            txtPrecio.setText("");
        }

    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
         precio = Float.parseFloat(txtPrecio.getText());
        cantidad = Integer.parseInt(txtCantidad.getText());
        impuestoParametro = Float.parseFloat(txtImpuestoParametro.getText());

        subtotal = (precio * cantidad);
        impuesto = (subtotal * impuestoParametro);
        totalPagar = (subtotal + impuesto);

        txtImpuesto.setText(String.format("%3.2f", impuesto).replace(".00", ""));
        txtSubTotal.setText(String.format("%3.2f", subtotal).replace(".00", ""));
        txtTotalPagar.setText(String.format("%3.2f", totalPagar).replace(".00", ""));
    }//GEN-LAST:event_txtPrecioKeyReleased

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
        int codigoBoton = evt.getKeyChar();
        if (codigoBoton == KeyEvent.VK_ENTER) {

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
            txtanticipoProyecto.setText("");
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
         String Caracteres = txtDescripcion.getText();
        if (Caracteres.length() >= 100) {
            evt.consume();
        }

    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void cmbEstadoFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoFacturaActionPerformed

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void txtImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImpuestoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        DKasaMuebles.mv.facturafrm.setVisible(false);
        DKasaMuebles.mv.listaFacturasfrm.setVisible(true);
        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cmbTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoPagoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        if (ListaFacturas.codigoBotonPresionado == 2) {

            String codigoProducto;
            String cantidad;
            String precio;
            String descripcionDetalle;
            try {
                String DatoSelected = DKasaMuebles.DatoSelected;

                txtFechaEmisionFactura.setText("");
                
                ResultSet rs = MantenimientoFacturacion.extraerDatosFacturacion(DKasaMuebles.DatoSelected);

                if (rs.next()) {
                    Integer indiceEstado = rs.getInt("codigoEstado");
                    String descripcion = rs.getString("descripcionEstado");
                    Integer indiceVendedor = rs.getInt("codigoEmpleado");
                    String nombreEmpleado = rs.getString("nombreEmpleado");

                    txtFechaEmisionFactura.setText(rs.getString("fechaEmisionFactura"));
                    txtNombre.setText(rs.getString("nombreCliente"));
                    txtIdentificacion.setText(rs.getString("identificacionCliente"));
                    txtDireccion.setText(rs.getString("direccionCliente"));

                    ComboBoxItem comboItem = new ComboBoxItem();
                    ComboBoxItem comboItem1 = new ComboBoxItem();
                    comboItem.setItem(indiceEstado.toString(), descripcion);
                    comboItem1.setItem(indiceVendedor.toString(), nombreEmpleado);

                    cmbEstadoFactura.getModel().setSelectedItem(comboItem);
                    cmbVendedor.getModel().setSelectedItem(comboItem1);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }

            ResultSet rs = MantenimientoFacturacion.extraerDatosDetalle(DKasaMuebles.DatoSelected);
            try {
                if (rs.next()) {
                    String[] columnas = {"Codigo Producto", "Cantidad", "Precio", "Descripcion"};
                    codigoProducto = rs.getString("codigoProducto");
                    cantidad = rs.getString("cantidad");
                    precio = rs.getString("precio");
                    descripcionDetalle = rs.getString("descripcionDetalle");

                    Object[][] data = {{codigoProducto, cantidad, precio, descripcionDetalle}};
                    tblProductos = new JTable(data, columnas);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            try {

                System.out.println(DKasaMuebles.DatoSelected);
                ResultSet rs = MantenimientoFacturacion.extraerDatosCliente(DKasaMuebles.DatoSelected);
                // extraerDatosCliente(ClienteSelected);

                if (rs.next()) {

                    txtNombre.setText(rs.getString("nombreCliente"));
                    txtIdentificacion.setText(rs.getString("identificacionCliente"));
                    txtDireccion.setText(rs.getString("direccionCliente"));

                }

            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

                                      
        
     
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbEstadoFactura;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JComboBox<String> cmbTipoPago;
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
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaEmisionFactura;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtImpuestoParametro;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotalPagar;
    private javax.swing.JTextField txtanticipoProyecto;
    // End of variables declaration//GEN-END:variables

    float subtotal = 0;
    int cantidad = 0;
    float precio = 0;
    float impuesto = 0;
    float impuestoParametro = 0;
    float totalPagar = 0;

}
