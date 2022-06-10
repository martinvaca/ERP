package Sistema;

import Reportes.Excel;
import static Sistema.Cantidades.validarnumeros;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian
 */
public class detallePedido extends javax.swing.JFrame {

    String bd = "restaurante";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "18010413";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    PreparedStatement ps;
    ResultSet rs;
    ButtonGroup btnGr;
    int precio;
    int cantidad;
    int indice;
    float totalPagar=0;
    Productos pr = new Productos();
    Cantidades c = new Cantidades();

    public detallePedido() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        Productos pr = new Productos();
        pr.ConsultarProducto(cbxProducto);
        Pedidos p = new Pedidos();
        p.ConsultarPedido(cbxIdpe);
    }

    public Connection conectar() {

        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            System.out.println("Se conecto a la base de datos: " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conecto a la base de datos: " + bd);
        }
        return cx;
    }

    private void limpiarCajas() {
        txtDetPed.setText(null);
        cbxProducto.setSelectedIndex(0);
        cbxIdpe.setSelectedIndex(0);
        txtCantidad.setText(null);
        txtPrecio.setText(null);
        txtSubtotal.setText(null);
        cbxEstatus.setSelectedIndex(0);

    }

    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) detallePedido.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            Connection c = null;
            c = this.conectar();
            ps = c.prepareStatement(" Select idDetPed,nombreProducto,idPedido,cant,precio,subtotal,estatus from detallepedido");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void ConsultarDetallePedido(JComboBox cbxDPedido) {
        String sql = "SELECT idDetPed from detallePedido";
        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxDPedido.addItem(rs.getString("idDetPed"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public void ConsultarPrecioDPedidos(JTextField subtotal, int cbxPe) {

        String sql = "SELECT subtotal from detallePedido where idDetPed= '" + cbxPe +"'";
        System.out.println(sql);
        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                subtotal.setText(rs.getString("subtotal"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_eliminar1 = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        detallePedido = new javax.swing.JTable();
        btn_regresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDetPed = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxEstatus = new javax.swing.JComboBox<>();
        cbxProducto = new javax.swing.JComboBox<>();
        cbxIdpe = new javax.swing.JComboBox<>();
        sub = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnExcel = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Detalle de Pedido");

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/borrar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_eliminar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_eliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btn_eliminar1.setText("Eliminar");
        btn_eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar1ActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        detallePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idDetPed", "Nombre Producto", "idPedido", "cantidad", "Precio", "Subtotal", "estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
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
        detallePedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detallePedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(detallePedido);
        if (detallePedido.getColumnModel().getColumnCount() > 0) {
            detallePedido.getColumnModel().getColumn(0).setResizable(false);
            detallePedido.getColumnModel().getColumn(1).setResizable(false);
            detallePedido.getColumnModel().getColumn(2).setResizable(false);
            detallePedido.getColumnModel().getColumn(3).setResizable(false);
            detallePedido.getColumnModel().getColumn(4).setResizable(false);
            detallePedido.getColumnModel().getColumn(5).setResizable(false);
            detallePedido.getColumnModel().getColumn(6).setResizable(false);
        }

        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        jLabel2.setText("idDetPed");

        jLabel3.setText("Producto");

        jLabel4.setText("idPedido");

        jLabel5.setText("Precio");

        jLabel6.setText("Subtotal");

        jLabel7.setText("cantidad");

        txtDetPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDetPedActionPerformed(evt);
            }
        });

        txtPrecio.setEditable(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        txtSubtotal.setEditable(false);
        txtSubtotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSubtotalMouseClicked(evt);
            }
        });
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jLabel8.setText("estatus");

        cbxEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "A", "I" }));

        cbxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cbxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductoActionPerformed(evt);
            }
        });

        cbxIdpe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/money.png"))); // NOI18N

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel.png"))); // NOI18N
        btnExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcelMouseClicked(evt);
            }
        });

        btnPdf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        btnPdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPdfMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btn_regresar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7))
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_eliminar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16))
                                    .addComponent(cbxProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(28, 28, 28))
                                    .addComponent(cbxIdpe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(txtDetPed, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_regresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDetPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxIdpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(27, 27, 27)))
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(btn_eliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        if (txtCantidad.getText().equals("") || txtDetPed.getText().equals("") || cbxProducto.getSelectedItem().equals("Seleccionar") || cbxEstatus.getSelectedItem().equals("Seleccionar") || cbxIdpe.getSelectedItem().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null,"Tiene que llenar Todos los campos");
        } else if (!validarnumeros(txtCantidad.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Tienen que ser numeros no letras y numeros Mayores a 0");
        } 
        else {

            Connection c = null;
            try {
                c = this.conectar();
                ps = c.prepareStatement("INSERT INTO detallePedido (idDetPed, nombreProducto, idPedido, cant, precio, subtotal, estatus) VALUES (?, ?, ?, ?, ?, ?,?)");

                ps.setString(1, txtDetPed.getText());
                ps.setString(2, cbxProducto.getSelectedItem().toString());
                ps.setString(3, cbxIdpe.getSelectedItem().toString());
                ps.setString(4, txtCantidad.getText());
                ps.setString(5, txtPrecio.getText());
                ps.setString(6, txtSubtotal.getText());
                ps.setString(7, cbxEstatus.getSelectedItem().toString());

                int res = ps.executeUpdate();

                if (res > 0) {
                    JOptionPane.showMessageDialog(null, " Guardado");
                    limpiarCajas();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar ");
                    limpiarCajas();
                }
                c.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        limpiarCajas();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar1ActionPerformed
        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement("UPDATE detallePedido SET estatus='I' WHERE idDetPed=?");
            ps.setString(1, txtDetPed.getText());
            cbxEstatus.setSelectedIndex(2);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Consulta Eliminada");
                limpiarCajas();
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar la consulta");
                limpiarCajas();
            }
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_eliminar1ActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

         if (txtCantidad.getText().equals("") || txtDetPed.getText().equals("") || cbxProducto.getSelectedItem().equals("Seleccionar") || cbxEstatus.getSelectedItem().equals("Seleccionar") || cbxIdpe.getSelectedItem().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null,"Tiene que llenar Todos los campos");
        } else if (!validarnumeros(txtCantidad.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Tienen que ser numeros no letras y numeros Mayores a 0");
        } else {
            Connection c = null;
            try {
                c = this.conectar();
                ps = c.prepareStatement("UPDATE detallePedido SET  nombreProducto=?, idPedido=?, cant=?, precio=?, subtotal=?, estatus=? WHERE idDetPed=?");

                ps.setString(1, cbxProducto.getSelectedItem().toString());
                ps.setString(2, cbxIdpe.getSelectedItem().toString());
                ps.setString(3, txtCantidad.getText());
                ps.setString(4, txtPrecio.getText());
                ps.setString(5, txtSubtotal.getText());
                ps.setString(6, cbxEstatus.getSelectedItem().toString());
                ps.setString(7, txtDetPed.getText());

                int res = ps.executeUpdate();

                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Consulta Mdificada");
                    limpiarCajas();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar la consulta");
                    limpiarCajas();
                }
                c.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        this.setVisible(false);
        Principal a = new Principal();
        a.setVisible(true);
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        if (txtDetPed.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
        }

        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement("SELECT * FROM detallePedido WHERE idDetPed=?");
            ps.setString(1, txtDetPed.getText());

            rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Consulta Encontrada");
                txtDetPed.setText(rs.getString("idDetPed"));
                cbxProducto.setSelectedItem(rs.getString("nombreProducto"));
                cbxIdpe.setSelectedItem(rs.getString("idPedido"));
                txtCantidad.setText(rs.getString("cant"));
                txtPrecio.setText(rs.getString("precio"));
                txtSubtotal.setText(rs.getString("Subtotal"));
                cbxEstatus.setSelectedItem(rs.getString("estatus"));

            } else {
                JOptionPane.showMessageDialog(null, "Consulta no encontrada");
                limpiarCajas();
            }
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtDetPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDetPedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDetPedActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed


    }//GEN-LAST:event_txtPrecioActionPerformed

    private void detallePedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detallePedidoMouseClicked

        try {
            int fila = detallePedido.getSelectedRow();
            int id = Integer.parseInt(detallePedido.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            Connection c = null;
            c = this.conectar();
            ps = c.prepareStatement("SELECT idDetPed, nombreProducto, idPedido, cant, precio, subtotal, estatus From detallePedido WHERE idDetPed=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                txtDetPed.setText(String.valueOf(id));
                cbxProducto.setSelectedItem(rs.getString("nombreProducto"));
                cbxIdpe.setSelectedItem(rs.getString("idPedido"));
                txtCantidad.setText(rs.getString("cant"));
                txtPrecio.setText(rs.getString("precio"));
                txtSubtotal.setText(rs.getString("subtotal"));
                cbxEstatus.setSelectedItem(rs.getString("estatus"));
                txtDetPed.setText(String.valueOf(id));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_detallePedidoMouseClicked

    private void cbxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductoActionPerformed
        Productos p = new Productos();
        String pe = cbxProducto.getSelectedItem().toString();
        p.ConsultarPrecioProductos(txtPrecio, pe);

    }//GEN-LAST:event_cbxProductoActionPerformed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed

    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        calcularPrecio();
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void txtSubtotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSubtotalMouseClicked
        calcularPrecio();
    }//GEN-LAST:event_txtSubtotalMouseClicked

    private void btnPdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPdfMouseClicked
        PDF1();
    }//GEN-LAST:event_btnPdfMouseClicked

    private void btnExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcelMouseClicked
        Excel e = new Excel();
        e.reporte();
    }//GEN-LAST:event_btnExcelMouseClicked

    public void calcularPrecio() {
        float precio = Float.parseFloat(txtPrecio.getText());
        float cantidad = Float.parseFloat(txtCantidad.getText());
        float st = precio * cantidad;
        txtSubtotal.setText(String.valueOf(st));
    }

    private void PDF1() {
        try {
            FileOutputStream archivo;
            int id = Integer.parseInt(txtDetPed.getText());
            int idPedido = Integer.parseInt(cbxIdpe.getSelectedItem().toString());
            File file = new File("src/pdf/DetallePedido" + id + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Img/Lo.png");

            Paragraph fech = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            Date date = new Date();
            fech.add(Chunk.NEWLINE);
            fech.add("Factura: " + id + "\n" + "FECHA: " + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\n\n");

            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);

            //Tamaño de las celdas
            float[] columnaEn = new float[]{10f, 40f, 70f, 40f};
            encabezado.setWidths(columnaEn);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            encabezado.addCell(img);

            String ruc = "13453";
            String nombre = "MEXICAN";
            String Telefono = "+52 351-292-6789";
            String Direccion = "Av. Juarez #345";

            encabezado.addCell("");
            encabezado.addCell("Ruc: " + ruc + "\nNombre: " + nombre + "\nTelfono: " + Telefono + "\nDireccion: " + Direccion);
            encabezado.addCell(fech);
            doc.add(encabezado);

            String nombreC = "";
            String TelefonoC = "";
            String DireccionC = "";
            String emailC = "";
            ;

            Paragraph cl = new Paragraph();
            cl.add(Chunk.NEWLINE);

            cl.add("Datos del Cliente" + "\n\n");
            doc.add(cl);

            PdfPTable tablacliente = new PdfPTable(5);
            tablacliente.addCell("ID");
            tablacliente.addCell("Nombre del Cliente");
            tablacliente.addCell("Telefono");
            tablacliente.addCell("Direccion");
            tablacliente.addCell("Email");
            tablacliente.setWidthPercentage(100);
            tablacliente.getDefaultCell().setBorder(0);

            try {
                Connection c = null;
                c = this.conectar();
                ps = c.prepareStatement("select detallePedido.idDetPed,reservaciones.nombreCliente, usuarios.telefono, usuarios.direccion, usuarios.email from usuarios \n"
                        + "inner join cliente on usuarios.nombre=cliente.nombreCliente \n"
                        + "inner join reservaciones on cliente.nombreCliente=reservaciones.nombreCliente\n"
                        + "inner join Mesa on Mesa.noMesa = reservaciones.noMesa\n"
                        + "inner join Pedidos on Mesa.noMesa=Pedidos.noMesa\n"
                        + "inner join detallePedido on Pedidos.idPedido=detallePedido.idPedido where idDetPed='" + id + "';");
                rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        tablacliente.addCell(rs.getString(1));
                        tablacliente.addCell(rs.getString(2));
                        tablacliente.addCell(rs.getString(3));
                        tablacliente.addCell(rs.getString(4));
                        tablacliente.addCell(rs.getString(5));

                    } while (rs.next());
                    doc.add(tablacliente);

                }
            } catch (DocumentException e) {
                System.out.println(e);
            }
            Paragraph pr = new Paragraph();
            pr.add(Chunk.NEWLINE);

            pr.add("Datos del Pedido" + "\n\n");

            doc.add(pr);

            PdfPTable tablaProductos = new PdfPTable(8);
            tablaProductos.addCell("Id");
            tablaProductos.addCell("Mesero");
            tablaProductos.addCell("idPedido");
            tablaProductos.addCell("Numero de Mesa");
            tablaProductos.addCell("Producto");
            tablaProductos.addCell("Cantidad");
            tablaProductos.addCell("Precio");
            tablaProductos.addCell("SubTotal");
            tablaProductos.setWidthPercentage(100);
            tablaProductos.getDefaultCell().setBorder(0);

            try {
                Connection c = null;
                c = this.conectar();
                ps = c.prepareStatement("select idDetPed,Pedidos.nombreEmpleado,Pedidos.idPedido,Pedidos.noMesa,nombreProducto,cant,precio,subtotal\n"
                        + "from detallePedido inner join Pedidos\n"
                        + "on Pedidos.idPedido=detallePedido.idPedido \n"
                        + "inner join Mesa on Mesa.noMesa=Pedidos.noMesa\n"
                        + "inner join reservaciones on reservaciones.noMesa=Mesa.noMesa where Pedidos.idPedido = '" + idPedido + "';");
                rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        tablaProductos.addCell(rs.getString(1));
                        tablaProductos.addCell(rs.getString(2));
                        tablaProductos.addCell(rs.getString(3));
                        tablaProductos.addCell(rs.getString(4));
                        tablaProductos.addCell(rs.getString(5));
                        tablaProductos.addCell(rs.getString(6));
                        tablaProductos.addCell(rs.getString(7));
                        tablaProductos.addCell(rs.getString(8));
                        totalPagar+=Float.parseFloat(rs.getString(8));
                        
                        
                    } while (rs.next());
                    
                    doc.add(tablaProductos);

                }
                
                
                
            } catch (DocumentException e) {
                System.out.println(e);
            }

            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a Pagar: " + totalPagar); //txtSubtotal.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("-------------------------\n\n ");
            firma.add("FIRMA ");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            Paragraph ms = new Paragraph();
            ms.add(Chunk.NEWLINE);
            ms.add("GRACIAS POR SU COMPRA :)");
            ms.setAlignment(Element.ALIGN_CENTER);
            doc.add(ms);

            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException | SQLException e) {
            System.out.println(e);
        }
    }

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
            java.util.logging.Logger.getLogger(detallePedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detallePedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detallePedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detallePedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detallePedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btn_eliminar1;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JComboBox<String> cbxEstatus;
    private javax.swing.JComboBox<String> cbxIdpe;
    private javax.swing.JComboBox<String> cbxProducto;
    private javax.swing.JTable detallePedido;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sub;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDetPed;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSubtotal;
    // End of variables declaration//GEN-END:variables
}
