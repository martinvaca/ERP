package Sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Ingredientes extends javax.swing.JFrame {

    String bd = "restaurante";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "18010413";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    PreparedStatement ps;
    ResultSet rs;
    ButtonGroup btnGr;

    public Ingredientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        setTitle("INGREDIENTES");
        texidIngrediente.setVisible(false);

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

    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaIngredientes.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            Connection c = null;
            c = this.conectar();
            ps = c.prepareStatement("SELECT idIngrediente, nombre, estatus  FROM Ingredientes");
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

    private void limpiarCajas() {
        texidIngrediente.setText(null);
        textNombre.setText(null);
        cbxEstatus.setSelectedIndex(0);

    }
    
       public void ConsultarIDIngrediente(JComboBox cbxIngre) {
        String sql = "SELECT idIngrediente from Ingredientes";
        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbxIngre.addItem(rs.getString("idIngrediente"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        textNombre = new javax.swing.JTextField();
        texidIngrediente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        cbxEstatus = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Ingredientes");

        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idIngrediente", "nombre", "estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaIngredientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaIngredientes);

        texidIngrediente.setEditable(false);
        texidIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texidIngredienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel4.setText("Estatus");

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbxEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "A", "I" }));

        jButton6.setText("Regresar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        botonEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(101, 101, 101))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonGuardar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonModificar))
                                    .addComponent(botonEliminar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texidIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texidIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
        Principal a = new Principal();
        a.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        Connection c = null;
        try {
            c = this.conectar();

            ps = c.prepareStatement("UPDATE Ingredientes SET estatus='I' WHERE idIngrediente=?");
            ps.setString(1, texidIngrediente.getText());
            cbxEstatus.setSelectedIndex(2);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Pedido Eliminado");
                limpiarCajas();
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Pedido");
                limpiarCajas();
            }
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        if (cbxEstatus.getSelectedItem().equals("Seleccionar") || textNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tiene que llenar Todos los campos");
        } else {

            Connection c = null;
            try {
                c = this.conectar();
                ps = c.prepareStatement("UPDATE Ingredientes SET  nombre=?, estatus=? WHERE idIngrediente=?");
                ps.setString(1, textNombre.getText());
                ps.setString(2, cbxEstatus.getSelectedItem().toString());
                ps.setString(3, texidIngrediente.getText());
                int res = ps.executeUpdate();

                if (res > 0) {
                    JOptionPane.showMessageDialog(null, " Consulta Modificada");
                    limpiarCajas();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar ");
                    limpiarCajas();
                }
                c.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if (cbxEstatus.getSelectedItem().equals("Seleccionar") || textNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tiene que llenar Todos los campos");
        } else {

            Connection c = null;
            try {
                c = this.conectar();
                ps = c.prepareStatement("INSERT INTO Ingredientes ( nombre, estatus ) VALUES ( ?,?)");
                ps.setString(1, textNombre.getText());

                ps.setString(2, cbxEstatus.getSelectedItem().toString());

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
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void texidIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texidIngredienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texidIngredienteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        Connection c = null;
        try {
            c = this.conectar();
            ps = c.prepareStatement("SELECT * FROM Ingredientes WHERE nombre=?");
            ps.setString(1, texidIngrediente.getText());

            rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Ingrediente Encontrado");
                texidIngrediente.setText(rs.getString("idIngrediente"));
                textNombre.setText(rs.getString("nombre"));
                cbxEstatus.setSelectedItem(rs.getString("estatus"));

            } else {
                JOptionPane.showMessageDialog(null, "Pedido no existente");
                limpiarCajas();
            }
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tablaIngredientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIngredientesMouseClicked

        try {
            int fila = tablaIngredientes.getSelectedRow();
            int id = Integer.parseInt(tablaIngredientes.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            Connection c = null;
            c = this.conectar();
            ps = c.prepareStatement("SELECT idIngrediente, nombre, estatus  From Ingredientes WHERE idIngrediente=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                texidIngrediente.setText(String.valueOf(id));
                textNombre.setText(rs.getString("nombre"));
                cbxEstatus.setSelectedItem(rs.getString("estatus"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }//GEN-LAST:event_tablaIngredientesMouseClicked

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
            java.util.logging.Logger.getLogger(Ingredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingredientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JComboBox<String> cbxEstatus;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTextField texidIngrediente;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
