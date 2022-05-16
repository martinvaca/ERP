package restaurant;

/**
 *
 * @author Martin Vaca
 */
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Productos extends javax.swing.JFrame 
{
    String bd="erp";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="admin";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    PreparedStatement ps;
    ResultSet rs;
    ButtonGroup btnGr;
    
    public Productos() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
//           tblProductos.addMouseListener(new MouseAdapter()
//       {
//           public void mousePressed(MouseEvent Mouse_evt)
//           {
//                JTable table= (JTable)Mouse_evt.getSource();
//               Point point = Mouse_evt.getPoint();
//               int row= table.rowAtPoint(point);
//               if(Mouse_evt.getClickCount()==1)
//               {
//                   txtNombre.setText(tblProductos.getValueAt(tblProductos.getSelectedRow(),1).toString());
//                    txtidProducto.setText(tblProductos.getValueAt(tblProductos.getSelectedRow(),2).toString());
//                    txtPrecio.setText(tblProductos.getValueAt(tblProductos.getSelectedRow(),3).toString());
//                    txtidCategoria.setText(tblProductos.getValueAt(tblProductos.getSelectedRow(),4).toString());
//                    txtDes.setText(tblProductos.getValueAt(tblProductos.getSelectedRow(),5).toString());
//                    //cbxEstatus.setText(tblProductos.getValueAt(tblProductos.getSelectedRow(),1).toString());
//                    
//                         // cbxHora.setText(tblRes.getValueAt(tblRes.getSelectedRow(),5).toString());
//                           // cbxHoraFin.setText(tblRes.getValueAt(tblRes.getSelectedRow(),6).toString());
//                             // jdtCalendar.getCalendar()(tblRes.getValueAt(tblRes.getSelectedRow(),7).toString());
//                              
//               }             
//           }
//       });
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
             txtidCategoria.setText(null);
            txtidProducto.setText(null);
         
            txtNombre.setText(null);
            txtPrecio.setText(null);
            cbxEstatus.setSelectedIndex(0);
            txtDes.setText(null);
        }   

    private void cargarTabla()
        {
            DefaultTableModel modeloTabla = (DefaultTableModel) tblProductos.getModel();
            modeloTabla.setRowCount(0);
            
            PreparedStatement ps;
            ResultSet rs;
            ResultSetMetaData rsmd;
            int columnas;
            
            try
            {
                Connection c=null;
                c= this.conectar();
                ps=c.prepareStatement("SELECT idProducto, nombre, precio, estatus,idcategoria,Descripcion FROM Productos");
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
        jLabel5 = new javax.swing.JLabel();
        txtidProducto = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtidCategoria = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        jButton5.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idProducto", "nombre", "precio", "estatus", "idCategoria", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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

        jLabel5.setText("idProducto");

        txtidProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidProductoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

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

        jLabel7.setText("idCategoria");

        txtDes.setColumns(20);
        txtDes.setRows(5);
        jScrollPane2.setViewportView(txtDes);

        jLabel2.setText("Descripcion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(52, 52, 52)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtidCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtidCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnRegresar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
            
         if (txtNombre.getText().trim().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);
        } else if (txtPrecio.getText().trim().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);
        } if (cbxEstatus.getSelectedItem().toString().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);
        } else if (txtDes.getText().trim().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);
        }

        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("INSERT INTO Productos (  idProducto,nombre, precio, estatus,idCategoria,descripcion) VALUES ( ?,?,?, ?, ?, ?)");
            
           
            ps.setString(1, txtidProducto.getText());
            ps.setString(2, txtNombre.getText());
            ps.setString(3, txtPrecio.getText());
            ps.setString(4, cbxEstatus.getSelectedItem().toString());
            ps.setString(5, txtidCategoria.getText());
             ps.setString(6, txtDes.getText());
  
            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Producto Guardado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Guardar Producto");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
                
        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("UPDATE Productos SET  nombre=?, precio=?,descripcion=?, estatus=? , idCategoria=? WHERE idProducto=?");
            
          
           
            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtPrecio.getText());
             ps.setString(3, txtDes.getText());
            ps.setString(4, cbxEstatus.getSelectedItem().toString());
           
            ps.setString(5, txtidCategoria.getText());
             ps.setString(6, txtidProducto.getText());
            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Producto Mdificado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
               
        if (txtNombre.getText().trim().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);
        }

        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("SELECT * FROM Productos WHERE nombre=?");
            ps.setString(1, txtNombre.getText());
            
             rs = ps.executeQuery();
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Producto Encontrado");
                txtidProducto.setText(rs.getString("idProducto"));
    
                txtNombre.setText(rs.getString("nombre"));
                txtPrecio.setText(rs.getString("precio"));
                cbxEstatus.setSelectedItem(rs.getString("estatus"));
                txtidCategoria.setText(rs.getString("idcateogria"));
                txtDes.setText(rs.getString("descripcion"));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Producto no existe");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
    
        Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("UPDATE Productos SET estatus='I' WHERE nombre=?");
            ps.setString(1,txtNombre.getText());
           cbxEstatus.setSelectedIndex(2);

            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Producto");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }    
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiarCajas();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.setVisible(false);
        PrincipalAdministrador1  a = new PrincipalAdministrador1();
        a.setVisible(true);
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
    if (txtNombre.getText().trim().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);
        
        }  else if (txtPrecio.getText().trim().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);
            } else if (cbxEstatus.getSelectedItem().toString().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);
        }    else if (txtDes.getText().toString().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos","Error", JOptionPane.WARNING_MESSAGE);

    Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("UPDATE Productos SET  nombre=? , precio=?,estatus=?,idcategoria=? , descripcion=? WHERE idProducto=?");
            
           
            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtPrecio.getText());
            ps.setString(3, cbxEstatus.getSelectedItem().toString());
            
              ps.setString(4, txtidCategoria.getText());
                ps.setString(5, txtDes.getText());
                ps.setString(6, txtidProducto.getText());
 
            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Producto Mdificado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
           
    }//GEN-LAST:event_btnModificarActionPerformed
    }
    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        try {
            int fila = tblProductos.getSelectedRow();
            int id = Integer.parseInt(tblProductos.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            Connection c = null;
            c = this.conectar();
            ps=c.prepareStatement("SELECT  nombre,idProducto, precio, estatus, idcategoria,descripcion FROM Productos where idProducto=?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            
           while(rs.next()){
           
           
           txtNombre.setText(rs.getString("nombre"));
           txtidProducto.setText(rs.getString("idProducto"));
           txtPrecio.setText(rs.getString("precio"));
           cbxEstatus.setSelectedItem(rs.getString("estatus"));
           txtidCategoria.setText(String.valueOf(id));
            txtDes.setText(rs.getString("descripcion"));
}

        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void txtidProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidProductoActionPerformed

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
    private javax.swing.JComboBox<String> cbxEstatus;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtidCategoria;
    private javax.swing.JTextField txtidProducto;
    // End of variables declaration//GEN-END:variables
}
