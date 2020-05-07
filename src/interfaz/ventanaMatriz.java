/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import java.awt.Color;
import java.awt.HeadlessException;
import logica.Fraccion;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logica.Historial;
import logica.Matriz;
/**
 *
 * @author Allan
 */
public class ventanaMatriz extends javax.swing.JFrame {

    int alto;
    int ancho;
    ArrayList<ArrayList<ArrayList<JTextField>>> matrizText = new ArrayList<>();
    ArrayList<ArrayList<Fraccion>> Fracciones = new ArrayList<>();
    
    
    public ventanaMatriz(int alto,int ancho) {
        this.getContentPane().setBackground(Color.white);
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        this.alto=alto;
        this.ancho=ancho;
        MontarMatriz();
    }
    
    //Monta la matriz con TextField del tamaño de la matriz
    public void MontarMatriz()
    {
        for(int i=0;i<alto;i++)
        {
            ArrayList<ArrayList<JTextField>> temp = new ArrayList<>();
            for (int j=0;j<ancho;j++)
            {
                ArrayList<JTextField> temp2 = new ArrayList<>();
                JTextField T1;
                T1 = new javax.swing.JTextField();
                JTextField T2;
                T2 = new javax.swing.JTextField();
                getContentPane().add(T1, new org.netbeans.lib.awtextra.AbsoluteConstraints((j*80)+20, (i*80)+50, 30, 30));
                getContentPane().add(T2, new org.netbeans.lib.awtextra.AbsoluteConstraints((j*80)+20, (i*80)+82, 30, 30));
                //Valida que los datos ingresados sean digitos o un guión
                T1.addKeyListener(new java.awt.event.KeyAdapter() 
                {
                    public void keyTyped(java.awt.event.KeyEvent evt) 
                    {
                        press(evt);
                    }
                });
                T2.addKeyListener(new java.awt.event.KeyAdapter() 
                {
                    public void keyTyped(java.awt.event.KeyEvent evt) 
                    {
                        press(evt);
                    }
                });
                
                ////
                JLabel lab = new JLabel();
                lab.setText("_____");
                getContentPane().add(lab, new org.netbeans.lib.awtextra.AbsoluteConstraints((j*80)+18, (i*80)+67, 40, -1));
                T2.setText("1");
                temp2.add(T1);
                temp2.add(T2);
                temp.add(temp2);
            }
            matrizText.add(temp);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnContinuar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(505, 377));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnContinuar.setBackground(new java.awt.Color(255, 255, 255));
        btnContinuar.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 120, 40));

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 120, 40));

        jLabelTitulo.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        jLabelTitulo.setText("Por favor, llene los espacios indicados:");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void press(java.awt.event.KeyEvent evt) { 
        int code = evt.getKeyCode(); 
        char caracter = evt.getKeyChar(); 
        if (!('0'<=caracter && caracter<='9'))
        {
            if (caracter != '-')
            {
                evt.consume();
            }
            
        }
    }
    
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    
    //Crea el objeto Matriz según lo ingresado y lo envía a la VentanaOperaciones
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        ArrayList<ArrayList<Fraccion>> fracc = new ArrayList<>();
        for (int i = 0; i<alto;i++){
            ArrayList<Fraccion> temp = new ArrayList<>();
            for (int j=0; j<ancho;j++){
                ArrayList<JTextField> elementos = matrizText.get(i).get(j);
                JTextField numerador = elementos.get(0);
                JTextField denominador = elementos.get(1);
                //valida los espacios vacíos
                try{
                    if (numerador.getText().length()==0|| denominador.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null,"Uno o más espacios están vacíos","Error",JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    //Valida que los denominadores no sean 0
                        else if(Integer.parseInt(denominador.getText())==0){
                            JOptionPane.showMessageDialog(null,"El denominador de una de las fracciones es 0","Error",JOptionPane.WARNING_MESSAGE);
                            return;
                    }
                    else
                    {
                        int num = Integer.valueOf(numerador.getText());
                        int deno = Integer.valueOf(denominador.getText());
                        Fraccion nodo = new Fraccion(num, deno);
                        temp.add(nodo);
                    }
                }
                catch(java.lang.NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Valores inválidos","Error",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            fracc.add(temp);
        }
        Matriz dato = new Matriz(fracc);
        Historial hist =new Historial();
        hist.agregarMatriz(dato);
        VentanaOperaciones ventana = new VentanaOperaciones(dato,hist);
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnContinuarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables

}
