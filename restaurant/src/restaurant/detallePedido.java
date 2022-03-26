/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;

/**
 *
 * @author Sebastian
 */
public class detallePedido extends javax.swing.JFrame {

    String bd="erp";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    PreparedStatement ps;
    ResultSet rs;
    ButtonGroup btnGr;
    
    public detallePedido() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        txtidDetPed.setVisible(false);
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
            txtidDetPed.setText(null);
            txtidProducto.setText(null);
            txtidPedido.setText(null);
            txtCantidad.setText(null);
            txtPrecio.setText(null);
            txtSubtota.setText(null);
            
        }    
        
        private void cargarTabla()
        {
            DefaultTableModel modeloTabla = (DefaultTableModel) tbldetallePedido.getModel();
            modeloTabla.setRowCount(0);
            
            PreparedStatement ps;
            ResultSet rs;
            ResultSetMetaData rsmd;
            int columnas;
            
            try
            {
                Connection c=null;
                c= this.conectar();
                ps=c.prepareStatement("SELECT idDetPed, idDetPed, idProducto, idPedido, cant, precio, subtotal FROM detallePedido");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        txtidProducto = new javax.swing.JTextField();
        txtidPedido = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Detalle de Pedido");

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_eliminar1.setText("Eliminar");
        btn_eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar1ActionPerformed(evt);
            }
        });

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
                "idDetPed", "idProducto", "idPedido", "cantidad", "Precio", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(detallePedido);

        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        jLabel2.setText("idDetPed");

        jLabel3.setText("idProducto");

        jLabel4.setText("idPedido");

        jLabel5.setText("Precio");

        jLabel6.setText("Subtotal");

        jLabel7.setText("cantidad");

        txtDetPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDetPedActionPerformed(evt);
            }
        });

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtDetPed))
                                            .addComponent(jLabel5)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtidProducto, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnbuscar)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(txtidPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_regresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_modificar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_limpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtidPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_regresar)
                            .addComponent(btn_guardar)
                            .addComponent(btn_limpiar)
                            .addComponent(btn_eliminar1)
                            .addComponent(btn_modificar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDetPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar))))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("INSERT INTO detallePedido (idDetPed, idProducto, idPedido, cant, precio, subtotal) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, txtidDetPed.getText());
            ps.setString(2, txtidProducto.getText());
            ps.setString(3, txtidPedido.getText());
            ps.setString(4, txtCantidad.getText());
            ps.setString(5, txtPrecio.getText());
            ps.setString(6, txtSubtotal.getText());

            int res = ps.executeUpdate();

            if(res>0)
            {
                JOptionPane.showMessageDialog(null, " Guardado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Guardar ");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        limpiarCajas();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar1ActionPerformed
        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("DELETE FROM detallePedido WHERE idDetPed=?");
            ps.setInt(1, Integer.parseInt(txtidDetPed.getText()));

            int res = ps.executeUpdate();

            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Consulta Eliminada");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Eliminar la consulta");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_btn_eliminar1ActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("UPDATE detallePedido SET idDetPed=?, idProducto=?, idPedido=?, cant=?, precio=?, subtotal=? WHERE idDetPed=?");
            ps.setString(1, txtidDetPed.getText());
            ps.setString(2, txtidProducto.getText());
            ps.setString(3, txtidPedido.getText());
            ps.setString(4, txtCantidad.getText());
            ps.setString(5, txtPrecio.getText());
            ps.setString(6, txtSubtotal.getText());

            int res = ps.executeUpdate();

            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Consulta Mdificada");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Modificar la consulta");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        this.setVisible(false);
        PrincipalAdministrador  a = new PrincipalAdministrador();
        a.setVisible(true);
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("SELECT * FROM detallePedido WHERE idDetPed=?");
            ps.setString(1, txtDetPed.getText());

            rs = ps.executeQuery();

            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Consulta Encontrada");
                txtidDetPed.setText(rs.getString("idDetPed"));
                txtidProducto.setText(rs.getString("idProducto"));
                txtidPedido.setText(rs.getString("idPedido"));
                txtCantidad.setText(rs.getString("cantidad"));
                txtPrecio.setText(rs.getString("precio"));
                txtSubtotal.setText(rs.getString("Subtotal"));

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Consulta no encontrada");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtDetPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDetPedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDetPedActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

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
    private javax.swing.JButton btn_eliminar1;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JTable detallePedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDetPed;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtidPedido;
    private javax.swing.JTextField txtidProducto;
    // End of variables declaration//GEN-END:variables
}
