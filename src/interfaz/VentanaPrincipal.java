package interfaz;

import java.awt.Color;

public class VentanaPrincipal extends javax.swing.JFrame {
    public VentanaPrincipal() {
        this.getContentPane().setBackground(Color.white);
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        ComboAncho = new javax.swing.JComboBox<>();
        ComboAlto = new javax.swing.JComboBox<>();
        lblX = new javax.swing.JLabel();
        lblAlto = new javax.swing.JLabel();
        lblAncho = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(350, 278));
        setMinimumSize(new java.awt.Dimension(350, 278));
        setPreferredSize(new java.awt.Dimension(300, 212));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        lblTitulo.setText("Ingrese el tamaño de la matriz deseado");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 396, 40));

        ComboAncho.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        ComboAncho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5" }));
        getContentPane().add(ComboAncho, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 120, 42));

        ComboAlto.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        ComboAlto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5" }));
        getContentPane().add(ComboAlto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, 42));

        lblX.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        lblX.setText("X");
        getContentPane().add(lblX, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 20, 50));

        lblAlto.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        lblAlto.setText("Alto");
        getContentPane().add(lblAlto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 116, 30));

        lblAncho.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        lblAncho.setText("Ancho");
        getContentPane().add(lblAncho, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 90, 30));

        btnContinuar.setBackground(new java.awt.Color(255, 255, 255));
        btnContinuar.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 140, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        ventanaMatriz ventana = new ventanaMatriz(ComboAlto.getSelectedIndex()+2,ComboAncho.getSelectedIndex()+2);
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnContinuarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboAlto;
    private javax.swing.JComboBox<String> ComboAncho;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel lblAlto;
    private javax.swing.JLabel lblAncho;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblX;
    // End of variables declaration//GEN-END:variables
}
