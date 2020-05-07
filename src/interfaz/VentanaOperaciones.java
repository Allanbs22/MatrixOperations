/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logica.Fraccion;
import logica.Historial;
import logica.Matriz;

/**
 *
 * @author Allan
 */
public class VentanaOperaciones extends javax.swing.JFrame {
    Matriz dato;
    static Historial historial;
    static int veces = 0;
    int cont = 0;
    public VentanaOperaciones(Matriz info,Historial historial) {
        this.getContentPane().setBackground(Color.white);
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        dato = info;
        this.historial = historial;
        MontarMatriz();
        if (veces == 0)
        {
            historial.agregarPaso("Matriz inicial");
            ArrayList<ArrayList<Fraccion>> ne = crearMatriz(dato.getMat());
            System.out.println("ne:   "+ne+ "\njjhhd:   "+dato.getMat());
            historial.agregarMatriz(new Matriz(ne));
            veces++;
        }
    }
    
    
    /**
     * Monta los labels con los elementos de la matriz en la ventana
     */
    public void MontarMatriz()
    {
        for(int i=0;i<dato.getAlto();i++)
        {
            for (int j=0;j<dato.getAncho();j++)
            {
                JLabel T1;
                T1 = new javax.swing.JLabel();
                JLabel T2;
                T2 = new javax.swing.JLabel();
                JLabel lab = new JLabel();
                if(dato.getMat().get(i).get(j).getDenominador()!=1){//si el denominador de la matriz es 1, no lo muestra
                    T2.setText(String.valueOf(dato.getMat().get(i).get(j).getDenominador()));
                    lab.setText("___");
                }
                T1.setText(String.valueOf(dato.getMat().get(i).get(j).getNumerador()));
                getContentPane().add(T1, new org.netbeans.lib.awtextra.AbsoluteConstraints((j*80)+23, (i*80)+50, 30, 30));
                getContentPane().add(T2, new org.netbeans.lib.awtextra.AbsoluteConstraints((j*80)+23, (i*80)+82, 30, 30));
                getContentPane().add(lab, new org.netbeans.lib.awtextra.AbsoluteConstraints((j*80)+18, (i*80)+67, 40, -1));
            }
        }
    }
    public ArrayList<ArrayList<Fraccion>> crearMatriz (ArrayList<ArrayList<Fraccion>> matriz)
    {
        ArrayList<ArrayList<Fraccion>> nueva = new ArrayList<ArrayList<Fraccion>>();
        for (int i=0; i<matriz.size();i++)
        {
            ArrayList<Fraccion> temp = new ArrayList<Fraccion>();
            for (int j = 0;j<matriz.get(i).size();j++)
            {
                Fraccion tem = new Fraccion(matriz.get(i).get(j).getNumerador(), matriz.get(i).get(j).getDenominador());
                temp.add(tem);
            }
            nueva.add(temp);
        }
        return nueva;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMultiplicar = new javax.swing.JButton();
        btnIntercambiar = new javax.swing.JButton();
        btnSumar = new javax.swing.JButton();
        btnVerProceso = new javax.swing.JButton();
        btnIngresarOtraMatriz = new javax.swing.JButton();
        intFila2 = new javax.swing.JTextField();
        intFila1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblFilaMulti = new javax.swing.JTextField();
        lblEscalar2 = new javax.swing.JTextField();
        lblEscalar1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblFilaSuma = new javax.swing.JTextField();
        lblMultiplo2 = new javax.swing.JTextField();
        lblMultiplo1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblFilaSuma2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(811, 564));
        setMinimumSize(new java.awt.Dimension(811, 564));
        setPreferredSize(new java.awt.Dimension(811, 564));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMultiplicar.setBackground(new java.awt.Color(255, 255, 255));
        btnMultiplicar.setText("Multiplicar Fila por un escalar");
        btnMultiplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplicarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMultiplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 180, 40));

        btnIntercambiar.setBackground(new java.awt.Color(255, 255, 255));
        btnIntercambiar.setText("Intercambiar Filas");
        btnIntercambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntercambiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIntercambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 180, 40));

        btnSumar.setBackground(new java.awt.Color(255, 255, 255));
        btnSumar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        btnSumar.setText("Sumar a una fila el multiplo de otra");
        btnSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSumar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 180, 40));

        btnVerProceso.setBackground(new java.awt.Color(255, 255, 255));
        btnVerProceso.setText("Ver proceso");
        btnVerProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProcesoActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 180, 40));

        btnIngresarOtraMatriz.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresarOtraMatriz.setText("Ingresar otra matriz");
        btnIngresarOtraMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarOtraMatrizActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresarOtraMatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, 180, 40));
        getContentPane().add(intFila2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 50, 30));
        getContentPane().add(intFila1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 50, 30));

        jLabel1.setFont(new java.awt.Font("High Tower Text", 0, 14)); // NOI18N
        jLabel1.setText("F1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 40, 30));

        jLabel2.setFont(new java.awt.Font("High Tower Text", 0, 14)); // NOI18N
        jLabel2.setText("F2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 50, 30));
        getContentPane().add(lblFilaMulti, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 50, 30));
        getContentPane().add(lblEscalar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 50, 30));
        getContentPane().add(lblEscalar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 50, 30));

        jLabel3.setText("________");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, 20));

        jLabel4.setFont(new java.awt.Font("High Tower Text", 0, 14)); // NOI18N
        jLabel4.setText("Fila");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 40, -1));

        jLabel5.setFont(new java.awt.Font("High Tower Text", 0, 14)); // NOI18N
        jLabel5.setText("Escalar");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));
        getContentPane().add(lblFilaSuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 50, 30));
        getContentPane().add(lblMultiplo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 50, 30));
        getContentPane().add(lblMultiplo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 50, 30));

        jLabel6.setText("________");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, 20));

        jLabel7.setFont(new java.awt.Font("High Tower Text", 0, 14)); // NOI18N
        jLabel7.setText("Fila");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 40, -1));

        jLabel8.setFont(new java.awt.Font("High Tower Text", 0, 14)); // NOI18N
        jLabel8.setText("Multiplo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, -1, -1));
        getContentPane().add(lblFilaSuma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 50, 30));

        jLabel9.setFont(new java.awt.Font("High Tower Text", 0, 14)); // NOI18N
        jLabel9.setText("Fila 2");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIntercambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntercambiarActionPerformed
        int fila1,fila2;
        try{
            fila1 = Integer.parseInt(intFila1.getText())-1;
            fila2 = Integer.parseInt(intFila2.getText())-1;
        }
        catch(java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Valores inválidos","Error",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(dato.getAlto()<=fila1 || dato.getAlto()<=fila2 || fila1<0 || fila2<0){
            JOptionPane.showMessageDialog(null,"Filas inválidas, por favor intente de nuevo","Error",JOptionPane.WARNING_MESSAGE);
        }
        else if(fila1==fila2){
            JOptionPane.showMessageDialog(null,"Las filas no pueden ser iguales, por favor intente de nuevo","Error",JOptionPane.WARNING_MESSAGE);
        }
        else{
            historial.agregarPaso("F"+(fila1+1)+"<->"+"F"+(fila2+1));
            dato.intFilas(fila1,fila2);
            ArrayList<ArrayList<Fraccion>> ne = crearMatriz(dato.getMat());
            System.out.println("ne:   "+ne+ "\njjhhd:   "+dato.getMat());
            historial.agregarMatriz(new Matriz(ne));
            VentanaOperaciones ventana = new VentanaOperaciones(new Matriz(dato.getMat()),historial);
            ventana.setVisible(true);
            dispose();
        }
        cont+=1;
    }//GEN-LAST:event_btnIntercambiarActionPerformed

    private void btnMultiplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiplicarActionPerformed
        int filaMulti;
        Fraccion escalar;
        try{
            filaMulti = Integer.parseInt(lblFilaMulti.getText())-1;
            escalar = new Fraccion(Integer.parseInt(lblEscalar1.getText()),Integer.parseInt(lblEscalar2.getText()));
        }
        catch(java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Valores inválidos","Error",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(dato.getAlto()<=filaMulti || filaMulti<0){
            JOptionPane.showMessageDialog(null,"Filas inválidas, por favor intente de nuevo","Error",JOptionPane.WARNING_MESSAGE);
        }
        else if(escalar.getDenominador()==0){
            JOptionPane.showMessageDialog(null,"El denominador de las fracciones no puede ser cero","Error",JOptionPane.WARNING_MESSAGE);
        }
        else{
            String paso = "F"+(filaMulti+1)+"*"+escalar.to_String();
            historial.agregarPaso(paso);
            dato.multEscalar(filaMulti,escalar);
            ArrayList<ArrayList<Fraccion>> ne = crearMatriz(dato.getMat());
            historial.agregarMatriz(new Matriz(ne));
            VentanaOperaciones ventana = new VentanaOperaciones(new Matriz(dato.getMat()),historial);
            ventana.setVisible(true);
            dispose();
        }
        cont+=1;
    }//GEN-LAST:event_btnMultiplicarActionPerformed

    private void btnSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumarActionPerformed
        int filaSuma1,filaSuma2;
        Fraccion multiplo;
        try{
            filaSuma1 = Integer.parseInt(lblFilaSuma.getText())-1;
            multiplo = new Fraccion(Integer.parseInt(lblMultiplo1.getText()),Integer.parseInt(lblMultiplo2.getText()));
            filaSuma2 = Integer.parseInt(lblFilaSuma2.getText())-1;
        }
        catch(java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Valores inválidos","Error",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(dato.getAlto()<=filaSuma1 || dato.getAlto()<=filaSuma2 || filaSuma1<0 || filaSuma2<0){
            JOptionPane.showMessageDialog(null,"Filas inválidas, por favor intente de nuevo","Error",JOptionPane.WARNING_MESSAGE);
        }
        else if(multiplo.getDenominador()==0){
            JOptionPane.showMessageDialog(null,"El denominador de las fracciones no puede ser cero","Error",JOptionPane.WARNING_MESSAGE);
        }
        else{
            String paso = "F"+(filaSuma1+1)+"+"+multiplo.to_String()+"*"+"F"+(filaSuma2+1);
            historial.agregarPaso(paso);
            dato.sumarMult(filaSuma1,multiplo,filaSuma2);
            ArrayList<ArrayList<Fraccion>> ne = crearMatriz(dato.getMat());
            System.out.println("ne:   "+ne+ "\njjhhd:   "+dato.getMat());
            historial.agregarMatriz(new Matriz(ne));
            VentanaOperaciones ventana = new VentanaOperaciones(new Matriz(dato.getMat()),historial);
            ventana.setVisible(true);
            dispose();
        }
        cont+=1;
    }//GEN-LAST:event_btnSumarActionPerformed

    private void btnVerProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProcesoActionPerformed
        VentanaResultados ventana = new VentanaResultados(dato,historial,cont);
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVerProcesoActionPerformed

    private void btnIngresarOtraMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarOtraMatrizActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Si sale, se perderán todos los cambios hechos a la matriz, ¿está seguro?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0){
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnIngresarOtraMatrizActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarOtraMatriz;
    private javax.swing.JButton btnIntercambiar;
    private javax.swing.JButton btnMultiplicar;
    private javax.swing.JButton btnSumar;
    private javax.swing.JButton btnVerProceso;
    private javax.swing.JTextField intFila1;
    private javax.swing.JTextField intFila2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lblEscalar1;
    private javax.swing.JTextField lblEscalar2;
    private javax.swing.JTextField lblFilaMulti;
    private javax.swing.JTextField lblFilaSuma;
    private javax.swing.JTextField lblFilaSuma2;
    private javax.swing.JTextField lblMultiplo1;
    private javax.swing.JTextField lblMultiplo2;
    // End of variables declaration//GEN-END:variables
}
