/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restaurant;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian
 */
public class descuentos extends javax.swing.JFrame {

    public descuentos() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);
        String AuxCompra, mensaje;
        double compra;
////Aqui le pones el total del pedido vacota
        AuxCompra=JOptionPane.showInputDialog("ingrese el monto de la compra");
        
        compra = Double.parseDouble(AuxCompra);

        if (compra >= 1200 && compra <= 2000){
        compra -= (compra*0.1);
            
        }
         else if (compra > 2000 && compra <= 5000){
        compra -= (compra*0.15);
            
        }
         else if (compra > 5000){
        compra -= (compra*0.2);            
        }
         else{
          compra=compra;

}
        mensaje=("El monto a pagar despues de aplicar el descuento es: "+compra);
        JOptionPane.showMessageDialog(null, mensaje);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new descuentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
