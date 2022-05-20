/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Sebastian
 */
public class Pedidos extends javax.swing.JFrame {

    String bd="erp";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="18010413";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    PreparedStatement ps;
    ResultSet rs;
    ButtonGroup btnGr;
    
    public Pedidos() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        cargarTablaE();
        

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
            txtidPedido.setText(null);
            cbxMesa.setSelectedIndex(0);
            txttotalPagar.setText(null);
            cbxEm.setSelectedIndex(0);
            cbxEstatus.setSelectedIndex(0);
        }   

    private void cargarTabla()
        {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablePedidos.getModel();
            modeloTabla.setRowCount(0);
            
            PreparedStatement ps;
            ResultSet rs;
            ResultSetMetaData rsmd;
            int columnas;
            
            try
            {
                Connection c=null;
                c= this.conectar();
                ps=c.prepareStatement("select  pedidos.idPedido,m.idMesa,dp.subtotal as totalPagar,u.nombre as Mesero,pedidos.estatus  from usuarios u inner join empleados e on e.idUsuario = u.idUsuario\n" +
"inner join pedidos on pedidos.idEmpleado = e.idEmpleado inner join puestos p on p.idPuesto = e.idPuesto\n" +
"inner join mesa m on m.idMesa = pedidos.idMesa\n" +
"inner join detallePedido dp on dp.idPedido=pedidos.idPedido\n" +
" where tipoUsuario = 'E' ");
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
    
    private void cargarTablaE()
        {
            DefaultTableModel modeloTabla = (DefaultTableModel) tblEm.getModel();
            modeloTabla.setRowCount(0);
            
            PreparedStatement ps;
            ResultSet rs;
            ResultSetMetaData rsmd;
            int columnas;
            
            try
            {
                Connection c=null;
                c= this.conectar();
                ps=c.prepareStatement("select  e.idEmpleado,u.nombre from Empleados e inner join Usuarios u on u.idUsuario=e.idUsuario where tipoUsuario='E' ");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtidPedido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txttotalPagar = new javax.swing.JTextField();
        btn_regresar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();
        labelPedidos = new javax.swing.JLabel();
        btn_modificar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxEstatus = new javax.swing.JComboBox<>();
        cbxMesa = new javax.swing.JComboBox<>();
        cbxEm = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEm = new javax.swing.JTable();
        labelPedidos1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pedidos");

        txtidPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidPedidoActionPerformed(evt);
            }
        });

        jLabel2.setText("#Pedido");

        jLabel3.setText("#Mesa");

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

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jLabel4.setText("Total");

        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idPedido", "idMesa", "totalPagar", "idEmpleado", "estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class
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
        tablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePedidos);
        if (tablePedidos.getColumnModel().getColumnCount() > 0) {
            tablePedidos.getColumnModel().getColumn(0).setResizable(false);
            tablePedidos.getColumnModel().getColumn(1).setResizable(false);
            tablePedidos.getColumnModel().getColumn(2).setResizable(false);
            tablePedidos.getColumnModel().getColumn(3).setResizable(false);
            tablePedidos.getColumnModel().getColumn(4).setResizable(false);
        }

        labelPedidos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelPedidos.setText("Pedidos");

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("#IdEmpleado");

        jLabel5.setText("Estatus");

        cbxEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "A", "I", "P", "C" }));

        cbxMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "2", "3", "4" }));

        cbxEm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "2", "3", "4" }));

        tblEm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idEmpleado", "Nombre Empleado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblEm);
        if (tblEm.getColumnModel().getColumnCount() > 0) {
            tblEm.getColumnModel().getColumn(0).setResizable(false);
            tblEm.getColumnModel().getColumn(1).setResizable(false);
        }

        labelPedidos1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelPedidos1.setText("Empleados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(labelPedidos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(txtidPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(27, 27, 27))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cbxEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnbuscar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(cbxMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txttotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btn_guardar)
                        .addGap(14, 14, 14)
                        .addComponent(btn_modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_limpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btn_regresar)
                        .addGap(710, 710, 710)))
                .addContainerGap(243, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelPedidos1)
                .addGap(161, 161, 161))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(labelPedidos)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelPedidos1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_modificar)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_regresar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        this.setVisible(false);
        PrincipalAdministrador1  a = new PrincipalAdministrador1();
        a.setVisible(true);
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void txtidPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidPedidoActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        limpiarCajas();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        
       if (txttotalPagar.getText().trim().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);
        } 

        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("UPDATE Pedidos SET  idMesa=?, totalPagar=?, estatus=?, idEmpleado=? WHERE idPedido=?");
            
            ps.setString(1, cbxMesa.getSelectedItem().toString());
            ps.setString(2, txttotalPagar.getText());
            ps.setString(3, cbxEstatus.getSelectedItem().toString());
            ps.setString(4, cbxEm.getSelectedItem().toString());
            ps.setString(5, txtidPedido.getText());
 
            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Pedido Mdificado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Modificar Pedido");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
     
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        
        if (txttotalPagar.getText().trim().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);
        } 

        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("INSERT INTO Pedidos (idPedido, idMesa, totalPagar, idEmpleado, estatus) VALUES (?, ?, ?, ?,?)");
            ps.setString(1, txtidPedido.getText());
            ps.setString(2, cbxMesa.getSelectedItem().toString());
            ps.setString(3, txttotalPagar.getText());
            ps.setString(4, cbxEm.getSelectedItem().toString());
            ps.setString(5, cbxEstatus.getSelectedItem().toString());
  
            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Pedido Guardado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Guardar Pedido");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
          
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        
Connection c=null;
        try
        {
            c= this.conectar();
//            ps=c.prepareStatement("DELETE FROM Pedidos WHERE idPedido=?");
//            ps.setInt(1, Integer.parseInt(txtidPedido.getText()));

            ps=c.prepareStatement("UPDATE Pedidos SET estatus='I' WHERE idPedido=?");
            ps.setString(1,txtidPedido.getText());
            cbxEstatus.setSelectedIndex(2);
            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Pedido Eliminado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Pedido");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }    
   
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        if (txtidPedido.getText().trim().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);
        }

        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("SELECT * FROM Pedidos WHERE idPedido=?");
            ps.setString(1, txtidPedido.getText());

            rs = ps.executeQuery();

            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Pedido Encontrado");
                txtidPedido.setText(rs.getString("idPedido"));
                cbxMesa.setSelectedItem(rs.getString("idMesa"));
                txttotalPagar.setText(rs.getString("totalPagar"));
                cbxEm.setSelectedItem(rs.getString("idEmpleado"));
                cbxEstatus.setSelectedItem(rs.getString("estatus"));
                

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Pedido no existente");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void tablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePedidosMouseClicked
       try {
            int fila = tablePedidos.getSelectedRow();
            int id = Integer.parseInt(tablePedidos.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            Connection c = null;
            c = this.conectar();
            ps=c.prepareStatement("SELECT idPedido, idMesa, totalPagar, idEmpleado, estatus FROM Pedidos WHERE idPedido=?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            
           while(rs.next()){
           
           txtidPedido.setText(String.valueOf(id));   
           cbxMesa.setSelectedItem(rs.getString("idMesa"));
           txttotalPagar.setText(rs.getString("totalPagar"));
           cbxEm.setSelectedItem(rs.getString("idEmpleado"));
           cbxEstatus.setSelectedItem(rs.getString("estatus"));
           txtidPedido.setText(String.valueOf(id));
}

        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_tablePedidosMouseClicked

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
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JComboBox<String> cbxEm;
    private javax.swing.JComboBox<String> cbxEstatus;
    private javax.swing.JComboBox<String> cbxMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelPedidos;
    private javax.swing.JLabel labelPedidos1;
    private javax.swing.JTable tablePedidos;
    private javax.swing.JTable tblEm;
    private javax.swing.JTextField txtidPedido;
    private javax.swing.JTextField txttotalPagar;
    // End of variables declaration//GEN-END:variables
}
