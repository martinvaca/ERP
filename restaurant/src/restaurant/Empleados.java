/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restaurant;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martin Vaca
 */
public class Empleados extends javax.swing.JFrame {
    String bd="erp";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="18010413";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    PreparedStatement ps;
    ResultSet rs;
    ButtonGroup btnGr;
    public Empleados()
    {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        txtidEmpleado.setVisible(false);
        
    }
    
        public Connection conectar()
    {
        
        try 
        {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd,user,password);
            System.out.println("Se conecto a la base de datos: " + bd);
        } 
        catch (ClassNotFoundException | SQLException ex)
        {
            System.out.println("No se conecto a la base de datos: " + bd);
        }
        return cx;
    }
        
        private void limpiarCajas()
        {
            txtidUsuario.setText(null);
            txtPuesto.setText(null);
            txtNumSeg.setText(null);
            cbxTurno.setSelectedIndex(0);
        }    
        
        private void cargarTabla()
        {
            DefaultTableModel modeloTabla = (DefaultTableModel) tblEmpleados.getModel();
            modeloTabla.setRowCount(0);
            
            PreparedStatement ps;
            ResultSet rs;
            ResultSetMetaData rsmd;
            int columnas;
            
            try
            {
                Connection c=null;
                c= this.conectar();
                ps=c.prepareStatement("SELECT idEmpleado, idPuesto, numSeguro, turno, idUsuario FROM Empleados");
                rs=ps.executeQuery();
                rsmd = (ResultSetMetaData) rs.getMetaData();
                columnas=rsmd.getColumnCount();
                
                while(rs.next())
                {
                    Object [] fila = new Object[columnas];
                    for (int i = 0; i < columnas; i++) 
                    {
                        fila[i]=rs.getObject(i+1);
                    }
                    modeloTabla.addRow(fila);
                }
            }
            catch(SQLException e)
            {
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
        txtidUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtPuesto = new javax.swing.JTextField();
        txtidEmpleado = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empleados");

        jLabel1.setText("Numero de Seguro");

        txtNumSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumSegActionPerformed(evt);
            }
        });

        jLabel2.setText("Turno");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Vespertino", "Matutino" }));

        jLabel3.setText("idUsuario");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("EMPLEADOS");

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idEmpleado", "idPuesto", "numSeguro", "turno", "idUsuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        jLabel5.setText("idPuesto");

        txtPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPuestoActionPerformed(evt);
            }
        });

        txtidEmpleado.setEditable(false);
        txtidEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidEmpleadoActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPuesto))
                                    .addComponent(btnGuardar)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnModificar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLimpiar)))))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtidUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)
                            .addComponent(btnLimpiar))
                        .addGap(32, 32, 32))))
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
        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("INSERT INTO Empleados (idUsuario, idPuesto, numSeguro, turno) VALUES (?, ?, ?, ?)");
            ps.setString(1, txtidUsuario.getText());
            ps.setString(2, txtPuesto.getText());
            ps.setString(3, txtNumSeg.getText());
            ps.setString(4, cbxTurno.getSelectedItem().toString());
            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Empleado Guardado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Guardar Empleado");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPuestoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       
                Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("UPDATE Empleados SET idUsuario=?, idPuesto=?, numSeguro=?, turno=? WHERE idEmpleado=?");
            ps.setString(1, txtidUsuario.getText());
            ps.setString(2, txtPuesto.getText());
            ps.setString(3, txtNumSeg.getText());
            ps.setString(4, cbxTurno.getSelectedItem().toString());
            ps.setString(5, txtidEmpleado.getText());
            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Empleado Mdificado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Modificar Empleado");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtidEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidEmpleadoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
       
                Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("SELECT * FROM Empleados WHERE idUsuario=?");
            ps.setString(1, txtidUsuario.getText());
            
             rs = ps.executeQuery();
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Empleado Encontrado");
                txtidEmpleado.setText(rs.getString("idEmpleado"));
                txtPuesto.setText(rs.getString("idPuesto"));
                txtNumSeg.setText(rs.getString("numSeguro"));
                cbxTurno.setSelectedItem(rs.getString("turno"));
                txtidUsuario.setText(rs.getString("idUsuario"));
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Empleado no existe");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("DELETE FROM Empleados WHERE idUsuario=?");
            ps.setInt(1, Integer.parseInt(txtidUsuario.getText()));

            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Empleado Eliminado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Empleado");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }    
    }//GEN-LAST:event_btnEliminarActionPerformed

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
    private javax.swing.JButton btnbuscar;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtNumSeg;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtidEmpleado;
    private javax.swing.JTextField txtidUsuario;
    // End of variables declaration//GEN-END:variables
}
