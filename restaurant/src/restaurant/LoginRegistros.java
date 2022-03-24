package restaurant;

/**
 *
 * @author Martin Vaca
 */
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class LoginRegistros extends javax.swing.JFrame {

    String bd="erp";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="18010413";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    PreparedStatement ps;
    ResultSet rs;
    ButtonGroup btnGr;
    public LoginRegistros()
    {
        initComponents();
        setTitle("Login Registros");
        this.setLocationRelativeTo(null);
        cargarTabla();
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
     
        private void cargarTabla()
        {
            DefaultTableModel modeloTabla = (DefaultTableModel) tblLogin.getModel();
            modeloTabla.setRowCount(0);
            
            PreparedStatement ps;
            ResultSet rs;
            ResultSetMetaData rsmd;
            int columnas;
            
            try
            {
                Connection c=null;
                c= this.conectar();
                ps=c.prepareStatement("SELECT username, password, idEmpleado FROM Login");
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
        
                private void limpiarCajas()
        {
            txtUser.setText(null);
            txtPass.setText(null);
            txtidEmp.setText(null);
        }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLogin = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtidEmp = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblLogin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "username", "password", "idEmpleado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(tblLogin);
        if (tblLogin.getColumnModel().getColumnCount() > 0) {
            tblLogin.getColumnModel().getColumn(0).setResizable(false);
            tblLogin.getColumnModel().getColumn(1).setResizable(false);
            tblLogin.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel2.setText("idEmpleado");

        jLabel3.setText("username");

        jLabel4.setText("password");

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtidEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPass)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtidEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnRegresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("INSERT INTO Login (username, password, idEmpleado) VALUES (?, ?, ?)");
            ps.setString(1, txtUser.getText());
            ps.setString(2, txtPass.getText());
            ps.setString(3, txtidEmp.getText());
            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Login Guardado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Guardar Login");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
    Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("UPDATE Login SET  password=?,idEmpleado=? WHERE username=?");
            
            ps.setString(1, txtPass.getText());
            ps.setString(2, txtidEmp.getText());
            ps.setString(3, txtUser.getText());
            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Se ha Modificado el Login");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Modificar Login");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
      Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("SELECT * FROM Login WHERE username=?");
            ps.setString(1, txtUser.getText());
            
             rs = ps.executeQuery();
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Login Encontrado");
                
                txtUser.setText(rs.getString("username"));
                txtPass.setText(rs.getString("password"));
                txtidEmp.setText(rs.getString("idEmpleado"));
                
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Login no encontrada");
                limpiarCajas();
            }
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }       
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
       Connection c=null;
        try
        {
            c= this.conectar();
            ps=c.prepareStatement("DELETE FROM Login WHERE username=?");
            ps.setString(1, txtUser.getText());

            
            int res = ps.executeUpdate();
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Login Eliminado");
                limpiarCajas();
                cargarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Login");
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
        PrincipalAdministrador  a = new PrincipalAdministrador();
        a.setVisible(true);
    }//GEN-LAST:event_btnRegresarMouseClicked

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
            java.util.logging.Logger.getLogger(LoginRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginRegistros().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLogin;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtidEmp;
    // End of variables declaration//GEN-END:variables
}
