package Sistema;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Martin Vaca
 */
public class Principal extends javax.swing.JFrame {

    Tiempo t = new Tiempo();

    public Principal() {

        initComponents();
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/mexican.jpg"));
        mexi.setIcon(new ImageIcon(img.getScaledInstance(mexi.getWidth(), mexi.getHeight(), Image.SCALE_SMOOTH)));
        this.setIconImage(img);
        setTitle("MENÙ PRINCIPAL");
        setLocationRelativeTo(null);

    }

    public void mostrarTiempo() {
        fecha.setText(t.fechacomp);
        hora.setText(t.horaComp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fecha = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        mexi = new javax.swing.JLabel();
        TBPedidos = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btnPedi = new javax.swing.JButton();
        btnDP = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnU = new javax.swing.JButton();
        btnE = new javax.swing.JButton();
        btnL = new javax.swing.JButton();
        btnP = new javax.swing.JButton();
        btnN = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnPro = new javax.swing.JButton();
        btnPromocion = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnCantidades = new javax.swing.JButton();
        btnIngredinetes = new javax.swing.JButton();
        btnOferta = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnPa = new javax.swing.JButton();
        btnTP = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnR = new javax.swing.JButton();
        btnM = new javax.swing.JButton();
        btnZ = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnPedidos = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        btnReservacion = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fecha.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 106, 23));
        getContentPane().add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 106, 22));

        mexi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/mexican.jpg"))); // NOI18N
        getContentPane().add(mexi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 710, 140));

        TBPedidos.setBackground(new java.awt.Color(255, 255, 255));

        btnPedi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPedi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nota.png"))); // NOI18N
        btnPedi.setText("Pedidos");
        btnPedi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPediMouseClicked(evt);
            }
        });

        btnDP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ayuda.png"))); // NOI18N
        btnDP.setText("Detalle Pedido");
        btnDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnPedi, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(btnDP, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDP, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPedi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        TBPedidos.addTab("tab1", jPanel2);

        btnU.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Clientes.png"))); // NOI18N
        btnU.setText("Usuarios");
        btnU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUMouseClicked(evt);
            }
        });

        btnE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/proveedor.png"))); // NOI18N
        btnE.setText("Empleados");
        btnE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEMouseClicked(evt);
            }
        });

        btnL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/login.png"))); // NOI18N
        btnL.setText("Login");
        btnL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLMouseClicked(evt);
            }
        });

        btnP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/puestos.png"))); // NOI18N
        btnP.setText("Puestos");
        btnP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPMouseClicked(evt);
            }
        });

        btnN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/NominaSustitucion-removebg-preview.png"))); // NOI18N
        btnN.setText("Nomina");
        btnN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNMouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Clientes.png"))); // NOI18N
        jButton1.setText("Clientes");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnU, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnE)
                    .addComponent(btnN, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnL, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnL, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnN, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        TBPedidos.addTab("tab2", jPanel3);

        btnPro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/taco.png"))); // NOI18N
        btnPro.setText("Productos");
        btnPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProMouseClicked(evt);
            }
        });

        btnPromocion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPromocion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/promo.png"))); // NOI18N
        btnPromocion.setText("Promociones");
        btnPromocion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPromocionMouseClicked(evt);
            }
        });

        btnCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/categoria.png"))); // NOI18N
        btnCategoria.setText("Categoria");
        btnCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCategoriaMouseClicked(evt);
            }
        });

        btnCantidades.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCantidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cantidades.png"))); // NOI18N
        btnCantidades.setText("Cantidades");
        btnCantidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCantidadesMouseClicked(evt);
            }
        });

        btnIngredinetes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIngredinetes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ingredientes.png"))); // NOI18N
        btnIngredinetes.setText("Ingredientes");
        btnIngredinetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngredinetesMouseClicked(evt);
            }
        });

        btnOferta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ofertasprodu.png"))); // NOI18N
        btnOferta.setText("OfertasProductos");
        btnOferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOfertaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCantidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPro, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addGap(100, 100, 100)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPromocion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIngredinetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCantidades, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngredinetes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        TBPedidos.addTab("tab3", jPanel4);

        btnPa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/money.png"))); // NOI18N
        btnPa.setText("Pagos");
        btnPa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPaMouseClicked(evt);
            }
        });

        btnTP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nventa.png"))); // NOI18N
        btnTP.setText("TipoPago");
        btnTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnPa, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(btnTP, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTP, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        TBPedidos.addTab("tab4", jPanel5);

        btnR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Res.png"))); // NOI18N
        btnR.setText("Reservaciones");
        btnR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRMouseClicked(evt);
            }
        });

        btnM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/mesa.png"))); // NOI18N
        btnM.setText("Mesa");
        btnM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMMouseClicked(evt);
            }
        });

        btnZ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnZ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/zoa.png"))); // NOI18N
        btnZ.setText("Zona");
        btnZ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnZMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnR, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnM, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnZ, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnR, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnM, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZ, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        TBPedidos.addTab("tab5", jPanel6);

        getContentPane().add(TBPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 710, 370));

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        btnPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nota.png"))); // NOI18N
        btnPedidos.setText("Pedidos");
        btnPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPedidosMouseClicked(evt);
            }
        });

        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Clientes.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
        });

        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosMouseClicked(evt);
            }
        });

        btnPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/money.png"))); // NOI18N
        btnPagos.setText("Pagos");
        btnPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPagosMouseClicked(evt);
            }
        });

        btnReservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Res.png"))); // NOI18N
        btnReservacion.setText("Reservaciones");
        btnReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservacionActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/login.png"))); // NOI18N
        btnCerrar.setText("Cerrar Sesion");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/l.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPagos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPagos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservacionActionPerformed
        TBPedidos.setSelectedIndex(4);
    }//GEN-LAST:event_btnReservacionActionPerformed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        this.setVisible(false);
        Login l = new Login();
        l.setVisible(true);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnPediMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPediMouseClicked
        this.setVisible(false);
        Pedidos p = new Pedidos();
        p.setVisible(true);
    }//GEN-LAST:event_btnPediMouseClicked

    private void btnDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDPMouseClicked
        this.setVisible(false);
        detallePedido dp = new detallePedido();
        dp.setVisible(true);
    }//GEN-LAST:event_btnDPMouseClicked

    private void btnUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUMouseClicked
        this.setVisible(false);
        Usuarios u = new Usuarios();
        u.setVisible(true);
    }//GEN-LAST:event_btnUMouseClicked

    private void btnEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEMouseClicked
        this.setVisible(false);
        Empleados e = new Empleados();
        e.setVisible(true);
    }//GEN-LAST:event_btnEMouseClicked

    private void btnLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLMouseClicked
        this.setVisible(false);
        LoginRegistros l = new LoginRegistros();
        l.setVisible(true);
    }//GEN-LAST:event_btnLMouseClicked

    private void btnPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPMouseClicked
        this.setVisible(false);
        Puestos p = new Puestos();
        p.setVisible(true);
    }//GEN-LAST:event_btnPMouseClicked

    private void btnNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNMouseClicked
        this.setVisible(false);
        Nomina n = new Nomina();
        n.setVisible(true);
    }//GEN-LAST:event_btnNMouseClicked

    private void btnProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProMouseClicked
        this.setVisible(false);
        Productos p = new Productos();
        p.setVisible(true);
    }//GEN-LAST:event_btnProMouseClicked

    private void btnPromocionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromocionMouseClicked
        this.setVisible(false);
        Promociones p = new Promociones();
        p.setVisible(true);
    }//GEN-LAST:event_btnPromocionMouseClicked

    private void btnCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriaMouseClicked
        this.setVisible(false);
        Categoria c = new Categoria();
        c.setVisible(true);
    }//GEN-LAST:event_btnCategoriaMouseClicked

    private void btnCantidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCantidadesMouseClicked
        this.setVisible(false);
        Cantidades ca = new Cantidades();
        ca.setVisible(true);
    }//GEN-LAST:event_btnCantidadesMouseClicked

    private void btnIngredinetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngredinetesMouseClicked
        this.setVisible(false);
        Ingredientes I = new Ingredientes();
        I.setVisible(true);
    }//GEN-LAST:event_btnIngredinetesMouseClicked

    private void btnOfertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOfertaMouseClicked
        this.setVisible(false);
        OfertasProductos ca = new OfertasProductos();
        ca.setVisible(true);
    }//GEN-LAST:event_btnOfertaMouseClicked

    private void btnPaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaMouseClicked
        this.setVisible(false);
        Pagos pa = new Pagos();
        pa.setVisible(true);
    }//GEN-LAST:event_btnPaMouseClicked

    private void btnTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTPMouseClicked
        this.setVisible(false);
        TipoPago TP = new TipoPago();
        TP.setVisible(true);
    }//GEN-LAST:event_btnTPMouseClicked

    private void btnRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRMouseClicked
        this.setVisible(false);
        Reservaciones R = new Reservaciones();
        R.setVisible(true);
    }//GEN-LAST:event_btnRMouseClicked

    private void btnMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMMouseClicked
        this.setVisible(false);
        Mesa m = new Mesa();
        m.setVisible(true);
    }//GEN-LAST:event_btnMMouseClicked

    private void btnZMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZMouseClicked
        this.setVisible(false);
        Zona Z = new Zona();
        Z.setVisible(true);
    }//GEN-LAST:event_btnZMouseClicked

    private void btnPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidosMouseClicked
        TBPedidos.setSelectedIndex(0);
    }//GEN-LAST:event_btnPedidosMouseClicked

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        TBPedidos.setSelectedIndex(1);
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseClicked
        TBPedidos.setSelectedIndex(2);
    }//GEN-LAST:event_btnProductosMouseClicked

    private void btnPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPagosMouseClicked
        TBPedidos.setSelectedIndex(3);
    }//GEN-LAST:event_btnPagosMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.setVisible(false);
        Cliente c = new Cliente();
        c.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TBPedidos;
    private javax.swing.JButton btnCantidades;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnDP;
    private javax.swing.JButton btnE;
    private javax.swing.JButton btnIngredinetes;
    private javax.swing.JButton btnL;
    private javax.swing.JButton btnM;
    private javax.swing.JButton btnN;
    private javax.swing.JButton btnOferta;
    private javax.swing.JButton btnP;
    private javax.swing.JButton btnPa;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnPedi;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnPro;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnPromocion;
    private javax.swing.JButton btnR;
    private javax.swing.JButton btnReservacion;
    private javax.swing.JButton btnTP;
    private javax.swing.JButton btnU;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnZ;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel hora;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel mexi;
    // End of variables declaration//GEN-END:variables
}
