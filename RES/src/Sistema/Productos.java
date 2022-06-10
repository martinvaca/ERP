package Sistema;

/**
 *
 * @author Martin Vaca
 */
import Reportes.Excel;
import static Sistema.Cantidades.validarnumeros;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Desktop;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;

public class Productos extends javax.swing.JFrame {

    String bd = "restaurante";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "18010413";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    PreparedStatement ps;
    ResultSet rs;
    ButtonGroup btnGr;

    public Productos() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        Categoria ca = new Categoria();
        ca.ConsultarCategoria(cbxCa);
        txtidProducto.setVisible(false);

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
        cbxCa.setSelectedIndex(0);
        txtidProducto.setText(null);
        txtNombre.setText(null);
        txtPrecio.setText(null);
        cbxEstatus.setSelectedIndex(0);
        txtDes.setText(null);
    }

    public void ConsultarProducto(JComboBox cbxProducto) {
        String sql = "SELECT nombre from Productos";
        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxProducto.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void ConsultarIDProducto(JComboBox cbxProducto) {
        String sql = "SELECT idProducto from Productos";
        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxProducto.addItem(rs.getString("idProducto"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblProductos.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            Connection c = null;
            c = this.conectar();
            ps = c.prepareStatement("SELECT idProducto, nombreCategoria, nombre, precio, estatus,descripcion FROM Productos");
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

    public void ConsultarPrecioProductos(JTextField precio, String cbxPro) {

        String sql = "SELECT precio from Productos where nombre= '" + cbxPro + "'";
        System.out.println(sql);
        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                precio.setText(rs.getString("precio"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxEstatus = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JTextField();
        txtidProducto = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cbxCa = new javax.swing.JComboBox<>();

        jButton5.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idProducto", "Categoria", "nombre", "precio", "estatus", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Object.class
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
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setResizable(false);
            tblProductos.getColumnModel().getColumn(1).setResizable(false);
            tblProductos.getColumnModel().getColumn(2).setResizable(false);
            tblProductos.getColumnModel().getColumn(3).setResizable(false);
            tblProductos.getColumnModel().getColumn(4).setResizable(false);
            tblProductos.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setText("nombre");

        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Precio");

        jLabel4.setText("Estatus");

        cbxEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "A", "I" }));

        txtidProducto.setEditable(false);
        txtidProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidProductoActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/borrar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel6.setText("PRODUCTOS");

        jLabel7.setText("Categoria");

        txtDes.setColumns(20);
        txtDes.setRows(5);
        jScrollPane2.setViewportView(txtDes);

        jLabel2.setText("Descripcion");

        cbxCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnBuscar)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel2))
                                            .addComponent(cbxCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegresar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (cbxEstatus.getSelectedItem().equals("Seleccionar") || cbxCa.getSelectedItem().equals("Seleccionar") || txtNombre.getText().equals("") || txtPrecio.getText().equals("") || txtDes.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tiene que llenar Todos los campos");
        } else {
            Connection c = null;
            try {
                c = this.conectar();
                ps = c.prepareStatement("INSERT INTO Productos (  nombre, nombreCategoria, precio, estatus,descripcion) VALUES ( ?,?, ?, ?, ?)");

                ps.setString(1, txtNombre.getText());
                ps.setString(3, txtPrecio.getText());
                ps.setString(2, cbxCa.getSelectedItem().toString());
                ps.setString(4, cbxEstatus.getSelectedItem().toString());
                ps.setString(5, txtDes.getText());

                int res = ps.executeUpdate();

                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Producto Guardado");
                    limpiarCajas();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar Producto");
                    limpiarCajas();
                }
                c.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked

        Connection c = null;
        if (cbxEstatus.getSelectedItem().equals("Seleccionar") || cbxCa.getSelectedItem().equals("Seleccionar") || txtNombre.getText().equals("") || txtPrecio.getText().equals("") || txtDes.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tiene que llenar Todos los campos");
        } else {
            try {
                c = this.conectar();
                ps = c.prepareStatement("UPDATE Productos SET  nombre=?, nombreCategoria=?,precio=?, estatus=? ,descripcion=?  WHERE idProducto=?");

                ps.setString(1, txtNombre.getText());
                ps.setString(2, cbxCa.getSelectedItem().toString());
                ps.setString(3, txtPrecio.getText());
                ps.setString(5, txtDes.getText());
                ps.setString(4, cbxEstatus.getSelectedItem().toString());
                ps.setString(6, txtidProducto.getText());

                int res = ps.executeUpdate();

                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Producto Modificado");
                    limpiarCajas();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
                    limpiarCajas();
                }
                c.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
        }

        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement("SELECT * FROM Productos WHERE nombre=?");
            ps.setString(1, txtNombre.getText());

            rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Producto Encontrado");
                txtidProducto.setText(rs.getString("idProducto"));

                txtNombre.setText(rs.getString("nombre"));
                cbxCa.setSelectedItem(rs.getString("nombreCategoria"));
                txtPrecio.setText(rs.getString("precio"));
                cbxEstatus.setSelectedItem(rs.getString("estatus"));

                txtDes.setText(rs.getString("descripcion"));
            } else {
                JOptionPane.showMessageDialog(null, "Producto no existe");
                limpiarCajas();
            }
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement("UPDATE Productos SET estatus='I' WHERE nombre=?");
            ps.setString(1, txtNombre.getText());
            cbxEstatus.setSelectedIndex(2);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
                limpiarCajas();
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Producto");
                limpiarCajas();
            }
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiarCajas();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.setVisible(false);
        Principal a = new Principal();
        a.setVisible(true);
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        if (cbxEstatus.getSelectedItem().equals("Seleccionar") || cbxCa.getSelectedItem().equals("Seleccionar") || txtNombre.getText().equals("") || txtPrecio.getText().equals("") || txtDes.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tiene que llenar Todos los campos");
        } else {
            Connection c = null;
            try {
                c = this.conectar();
                ps = c.prepareStatement("UPDATE Productos SET  nombre=? ,nombreCategoria=? , precio=?,estatus=?, descripcion=? WHERE idProducto=?");

                ps.setString(1, txtNombre.getText());
                ps.setString(2, cbxCa.getSelectedItem().toString());
                ps.setString(3, txtPrecio.getText());
                ps.setString(4, cbxEstatus.getSelectedItem().toString());
                ps.setString(5, txtDes.getText());
                ps.setString(6, txtidProducto.getText());

                int res = ps.executeUpdate();

                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Producto Mdificado");
                    limpiarCajas();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
                    limpiarCajas();
                }
                c.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        try {
            int fila = tblProductos.getSelectedRow();
            int id = Integer.parseInt(tblProductos.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            Connection c = null;
            c = this.conectar();
            ps = c.prepareStatement("SELECT  idProducto,nombre,nombreCategoria, precio, estatus, descripcion FROM Productos where idProducto=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                txtidProducto.setText(rs.getString("idProducto"));
                txtNombre.setText(rs.getString("nombre"));
                cbxCa.setSelectedItem(rs.getString("nombreCategoria"));;
                txtPrecio.setText(rs.getString("precio"));
                cbxEstatus.setSelectedItem(rs.getString("estatus"));
                txtDes.setText(rs.getString("descripcion"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void txtidProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidProductoActionPerformed

    private void PDF() {
        try {
            FileOutputStream archivo;
            File file = new File("src/pdf/DetallePedido.pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Img/Lo.png");

            Paragraph fech = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            Date date = new Date();
            fech.add(Chunk.NEWLINE);
            fech.add("Factura: 1 \n" + "FECHA: " + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\n\n");

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

            PdfPTable tablacliente = new PdfPTable(4);
            tablacliente.addCell("Nombre del Cliente");
            tablacliente.addCell("Telefono");
            tablacliente.addCell("Direccion");
            tablacliente.addCell("Email");
            tablacliente.setWidthPercentage(100);
            tablacliente.getDefaultCell().setBorder(0);

            try {
                Connection c = null;
                c = this.conectar();
                ps = c.prepareStatement("select reservaciones.nombreCliente, usuarios.telefono, usuarios.direccion, usuarios.email from usuarios \n"
                        + "inner join cliente on usuarios.nombre=cliente.nombreCliente \n"
                        + "inner join reservaciones on cliente.nombreCliente=reservaciones.nombreCliente;");
                rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        tablacliente.addCell(rs.getString(1));
                        tablacliente.addCell(rs.getString(2));
                        tablacliente.addCell(rs.getString(3));
                        tablacliente.addCell(rs.getString(4));

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

            PdfPTable tablaProductos = new PdfPTable(7);
            tablaProductos.addCell("Id");
            tablaProductos.addCell("Mesero");
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
                ps = c.prepareStatement("select idDetPed,Pedidos.nombreEmpleado,Pedidos.noMesa,nombreProducto,cant,precio,subtotal\n"
                        + "from detallePedido inner join Pedidos\n"
                        + "on Pedidos.idPedido=detallePedido.idPedido \n"
                        + "inner join Mesa on Mesa.noMesa=Pedidos.noMesa\n"
                        + "inner join reservaciones on reservaciones.noMesa=Mesa.noMesa;");
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
                    } while (rs.next());
                    doc.add(tablaProductos);

                }
            } catch (DocumentException e) {
                System.out.println(e);
            }

            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a Pagar: ");
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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxCa;
    private javax.swing.JComboBox<String> cbxEstatus;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtidProducto;
    // End of variables declaration//GEN-END:variables
}
