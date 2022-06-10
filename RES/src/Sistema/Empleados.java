package Sistema;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static validaciones.numerosEnteros.validarnumeros;

/**
 *
 * @author Martin Vaca
 */
public class Empleados extends javax.swing.JFrame {

    String bd = "restaurante";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "18010413";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    PreparedStatement ps;
    ResultSet rs;
    ButtonGroup btnGr;

    public Empleados() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        txtidEmpleado.setVisible(false);
        Puestos p = new Puestos();
        p.ConsultarPuestos(cbxPuestos);
        Usuarios u = new Usuarios();
        u.ConsultarUsuariosEmpleados(cbxUsu);
        txtidEmpleado.setVisible(false);

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
        cbxUsu.setSelectedIndex(0);
        cbxPuestos.setSelectedIndex(0);
        txtNumSeg.setText(null);
        cbxTurno.setSelectedIndex(0);
        txtSalario.setText(null);
        cbxEstatus.setSelectedIndex(0);
    }

    public void ConsultarEm(JComboBox cbxem) {
        String sql = "SELECT nomUsuario from Empleados ";
        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxem.addItem(rs.getString("nomUsuario"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void ConsultarMesero(JComboBox cbxem) {
        String sql = "SELECT nomUsuario from Empleados where nombrePuesto='Mesero' ";
        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxem.addItem(rs.getString("nomUsuario"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
        public void ConsultaSalario(JTextField salario, String cbxEm) {

        String sql = "SELECT salario from Empleados where nomUsuario= '" + cbxEm +"'";
        System.out.println(sql);
        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                salario.setText(rs.getString("salario"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblEmpleados.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            Connection c = null;
            c = this.conectar();
            ps = c.prepareStatement("SELECT idEmpleado, nombrePuesto, nomUsuario, numSeguro, turno, salario, estatus FROM Empleados");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumSeg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        cbxTurno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtidEmpleado = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxEstatus = new javax.swing.JComboBox<>();
        cbxPuestos = new javax.swing.JComboBox<>();
        cbxUsu = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empleados");

        jLabel1.setText("Numero de Seguro");

        txtNumSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumSegActionPerformed(evt);
            }
        });

        jLabel2.setText("Turno");

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
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/borrar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Vespertino", "Matutino" }));

        jLabel3.setText("nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setText("EMPLEADOS");

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idEmpleado", "Puesto", "nombre", "numSeguro", "turno", "salario", "estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
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
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);
        if (tblEmpleados.getColumnModel().getColumnCount() > 0) {
            tblEmpleados.getColumnModel().getColumn(0).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(1).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(2).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(3).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(4).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(5).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel5.setText("Puesto");

        txtidEmpleado.setEditable(false);
        txtidEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidEmpleadoActionPerformed(evt);
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

        jLabel6.setText("Salario");

        jLabel7.setText("Estatus");

        cbxEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "A", "I" }));

        cbxPuestos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        cbxUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumSegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumSegActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCajas();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Connection c = null;
        if (cbxEstatus.getSelectedItem().equals("Seleccionar") || cbxPuestos.getSelectedItem().equals("Seleccionar") || cbxTurno.getSelectedItem().equals("Seleccionar") || cbxUsu.getSelectedItem().equals("Seleccionar") || txtNumSeg.getText().equals("") || txtSalario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tiene que llenar Todos los campos");
        } else if (!validarnumeros(txtSalario.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Tienen que ser numeros no letras y numeros Mayores a 0");
        }
        else {
            try {
                c = this.conectar();
                ps = c.prepareStatement("INSERT INTO Empleados ( nombrePuesto,nomUsuario, numSeguro, turno, salario, estatus) VALUES (?, ?, ?, ?, ?, ?)");
                ps.setString(1, cbxPuestos.getSelectedItem().toString());
                ps.setString(2, cbxUsu.getSelectedItem().toString());
                ps.setString(3, txtNumSeg.getText());
                ps.setString(4, cbxTurno.getSelectedItem().toString());
                ps.setString(5, txtSalario.getText());
                ps.setString(6, cbxEstatus.getSelectedItem().toString());

                int res = ps.executeUpdate();

                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Empleado Guardado");
                    limpiarCajas();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar Empleado");
                    limpiarCajas();
                }
                c.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (cbxEstatus.getSelectedItem().equals("Seleccionar") || cbxPuestos.getSelectedItem().equals("Seleccionar") || cbxTurno.getSelectedItem().equals("Seleccionar") || cbxUsu.getSelectedItem().equals("Seleccionar") || txtNumSeg.getText().equals("") || txtSalario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tiene que llenar Todos los campos");
        }  else if (!validarnumeros(txtSalario.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Tienen que ser numeros no letras y numeros Mayores a 0");
        }else {
            Connection c = null;
            try {
                c = this.conectar();
                ps = c.prepareStatement("UPDATE Empleados SET  nombrePuesto=?,nomUsuario=?, numSeguro=?, turno=?, salario=?, estatus=? WHERE idEmpleado=?");
                ps.setString(1, cbxPuestos.getSelectedItem().toString());
                ps.setString(2, cbxUsu.getSelectedItem().toString());
                ps.setString(3, txtNumSeg.getText());
                ps.setString(4, cbxTurno.getSelectedItem().toString());
                ps.setString(5, txtSalario.getText());
                ps.setString(6, cbxEstatus.getSelectedItem().toString());
                ps.setString(7, txtidEmpleado.getText());

                int res = ps.executeUpdate();

                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Empleado Mdificado");
                    limpiarCajas();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar Empleado");
                    limpiarCajas();
                }
                c.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtidEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidEmpleadoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement("UPDATE empleados SET estatus='I' WHERE idEmpleado=?");
            ps.setInt(1, Integer.parseInt(txtidEmpleado.getText()));
            cbxEstatus.setSelectedIndex(2);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Empleado Eliminado");
                limpiarCajas();
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Empleado");
                limpiarCajas();
            }
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.setVisible(false);
        Principal a = new Principal();
        a.setVisible(true);
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        try {
            int fila = tblEmpleados.getSelectedRow();
            int id = Integer.parseInt(tblEmpleados.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            Connection c = null;
            c = this.conectar();
            ps = c.prepareStatement("SELECT idEmpleado, nombrePuesto, nomUsuario, numSeguro, turno,  salario ,estatus FROM empleados where idEmpleado=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                txtidEmpleado.setText(String.valueOf(id));
                cbxPuestos.setSelectedItem(rs.getString("nombrePuesto"));
                cbxUsu.setSelectedItem(rs.getString("nomUsuario"));
                txtNumSeg.setText(rs.getString("numSeguro"));
                cbxTurno.setSelectedItem(rs.getString("turno"));
                txtSalario.setText(rs.getString("salario"));
                cbxEstatus.setSelectedItem(rs.getString("estatus"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxEstatus;
    private javax.swing.JComboBox<String> cbxPuestos;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JComboBox<String> cbxUsu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtNumSeg;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtidEmpleado;
    // End of variables declaration//GEN-END:variables
}
