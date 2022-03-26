package restaurant;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Martin Vaca
 */
public class PrincipalAdministrador extends javax.swing.JFrame {

    conexion cx;
    public PrincipalAdministrador() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        cx=new conexion();
        cx.conectar();
        Image img=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/mexican.jpg"));
        mexi.setIcon(new ImageIcon(img.getScaledInstance(mexi.getWidth(), mexi.getHeight(), Image.SCALE_SMOOTH)));
        this.setIconImage(img);
        Image i=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/login.png"));
        jMenu1.setIcon(new ImageIcon(i.getScaledInstance(jMenu1.getWidth(), jMenu1.getHeight(), Image.SCALE_SMOOTH)));
        this.setIconImage(i);
        Image im=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Res.png"));
        menRes.setIcon(new ImageIcon(im.getScaledInstance(menRes.getWidth(), menRes.getHeight(), Image.SCALE_SMOOTH)));
        this.setIconImage(im);
        Image ima=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/taco.png"));
        pr.setIcon(new ImageIcon(ima.getScaledInstance(pr.getWidth(), pr.getHeight(), Image.SCALE_SMOOTH)));
        this.setIconImage(ima);
        Image imag=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/dinero.png"));
        pag.setIcon(new ImageIcon(imag.getScaledInstance(pag.getWidth(), pag.getHeight(), Image.SCALE_SMOOTH)));
        this.setIconImage(imag);
        Image imagen=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/nota.png"));
        menuPedidos.setIcon(new ImageIcon(imagen.getScaledInstance(menuPedidos.getWidth(), menuPedidos.getHeight(), Image.SCALE_SMOOTH)));
        this.setIconImage(imagen);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        mexi = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuUsuarios = new javax.swing.JMenu();
        menuEmpleados = new javax.swing.JMenu();
        menuLogin = new javax.swing.JMenu();
        menuPuestos = new javax.swing.JMenu();
        menuNomina = new javax.swing.JMenu();
        menRes = new javax.swing.JMenu();
        menuReser = new javax.swing.JMenu();
        menMesa = new javax.swing.JMenu();
        menZona = new javax.swing.JMenu();
        pr = new javax.swing.JMenu();
        pag = new javax.swing.JMenu();
        menPago = new javax.swing.JMenu();
        menTipoPago = new javax.swing.JMenu();
        menuPedidos = new javax.swing.JMenu();
        menPedi = new javax.swing.JMenu();
        menDetallePe = new javax.swing.JMenu();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setEnabled(false);

        mexi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mexican.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mexi, javax.swing.GroupLayout.PREFERRED_SIZE, 689, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mexi, javax.swing.GroupLayout.PREFERRED_SIZE, 442, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(0, 204, 204));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenu1.setText("Usuarios");

        menuUsuarios.setText("Usuarios");
        menuUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuUsuariosMouseClicked(evt);
            }
        });
        menuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(menuUsuarios);

        menuEmpleados.setText("Empleados");
        menuEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEmpleadosMouseClicked(evt);
            }
        });
        jMenu1.add(menuEmpleados);

        menuLogin.setText("Login");
        menuLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLoginMouseClicked(evt);
            }
        });
        jMenu1.add(menuLogin);

        menuPuestos.setText("Puestos");
        menuPuestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPuestosMouseClicked(evt);
            }
        });
        jMenu1.add(menuPuestos);

        menuNomina.setText("Nomina");
        menuNomina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuNominaMouseClicked(evt);
            }
        });
        jMenu1.add(menuNomina);

        jMenuBar1.add(jMenu1);

        menRes.setText("Reservaciones");
        menRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menResMouseClicked(evt);
            }
        });

        menuReser.setText("Reservaciones");
        menuReser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuReserMouseClicked(evt);
            }
        });
        menRes.add(menuReser);

        menMesa.setText("Mesa");
        menMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menMesaMouseClicked(evt);
            }
        });
        menRes.add(menMesa);

        menZona.setText("Zona");
        menZona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menZonaMouseClicked(evt);
            }
        });
        menRes.add(menZona);

        jMenuBar1.add(menRes);

        pr.setText("Productos");
        jMenuBar1.add(pr);

        pag.setText("Pagos");

        menPago.setText("Pagos");
        menPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menPagoMouseClicked(evt);
            }
        });
        pag.add(menPago);

        menTipoPago.setText("TipoPago");
        menTipoPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menTipoPagoMouseClicked(evt);
            }
        });
        pag.add(menTipoPago);

        jMenuBar1.add(pag);

        menuPedidos.setText("Pedidos");

        menPedi.setText("Pedidos");
        menPedi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menPediMouseClicked(evt);
            }
        });
        menuPedidos.add(menPedi);

        menDetallePe.setText("Detalle Pedido");
        menDetallePe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menDetallePeMouseClicked(evt);
            }
        });
        menuPedidos.add(menDetallePe);

        jMenuBar1.add(menuPedidos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuariosActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Usuarios u = new Usuarios();
        u.setVisible(true);
        
    }//GEN-LAST:event_menuUsuariosActionPerformed

    private void menuUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUsuariosMouseClicked
        // TODO add your handling code here:
         this.setVisible(false);
        Usuarios u = new Usuarios();
        u.setVisible(true);
    }//GEN-LAST:event_menuUsuariosMouseClicked

    private void menuEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEmpleadosMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Empleados e = new Empleados();
        e.setVisible(true);
    }//GEN-LAST:event_menuEmpleadosMouseClicked

    private void menuPuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPuestosMouseClicked
        this.setVisible(false);
        Puestos  p = new Puestos();
        p.setVisible(true);
    }//GEN-LAST:event_menuPuestosMouseClicked

    private void menuNominaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuNominaMouseClicked
        this.setVisible(false);
        Nomina  n = new Nomina();
        n.setVisible(true);
    }//GEN-LAST:event_menuNominaMouseClicked

    private void menuLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLoginMouseClicked
       this.setVisible(false);
        LoginRegistros lR= new LoginRegistros();
        lR.setVisible(true);
    }//GEN-LAST:event_menuLoginMouseClicked

    private void menPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menPagoMouseClicked
        this.setVisible(false);
        Pagos p= new Pagos();
        p.setVisible(true);
    }//GEN-LAST:event_menPagoMouseClicked

    private void menTipoPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menTipoPagoMouseClicked
        this.setVisible(false);
        TipoPago TP= new TipoPago();
        TP.setVisible(true);
    }//GEN-LAST:event_menTipoPagoMouseClicked

    private void menPediMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menPediMouseClicked
        this.setVisible(false);
        Pedidos pe= new Pedidos();
        pe.setVisible(true);
    }//GEN-LAST:event_menPediMouseClicked

    private void menDetallePeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menDetallePeMouseClicked
        this.setVisible(false);
        detallePedido DP= new detallePedido();
        DP.setVisible(true);
    }//GEN-LAST:event_menDetallePeMouseClicked

    private void menResMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menResMouseClicked

    }//GEN-LAST:event_menResMouseClicked

    private void menMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menMesaMouseClicked
        this.setVisible(false);
        Mesa m= new Mesa();
        m.setVisible(true);
    }//GEN-LAST:event_menMesaMouseClicked

    private void menuReserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuReserMouseClicked
        this.setVisible(false);
        Reservaciones r= new Reservaciones();
        r.setVisible(true);
    }//GEN-LAST:event_menuReserMouseClicked

    private void menZonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menZonaMouseClicked
        this.setVisible(false);
        Zona z= new Zona();
        z.setVisible(true);
    }//GEN-LAST:event_menZonaMouseClicked


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
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menDetallePe;
    private javax.swing.JMenu menMesa;
    private javax.swing.JMenu menPago;
    private javax.swing.JMenu menPedi;
    private javax.swing.JMenu menRes;
    private javax.swing.JMenu menTipoPago;
    private javax.swing.JMenu menZona;
    private javax.swing.JMenu menuEmpleados;
    private javax.swing.JMenu menuLogin;
    private javax.swing.JMenu menuNomina;
    private javax.swing.JMenu menuPedidos;
    private javax.swing.JMenu menuPuestos;
    private javax.swing.JMenu menuReser;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JLabel mexi;
    private javax.swing.JMenu pag;
    private javax.swing.JMenu pr;
    // End of variables declaration//GEN-END:variables
}
