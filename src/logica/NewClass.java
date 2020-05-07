/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import interfaz.VentanaOperaciones;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class NewClass {
    public static void main(String[] args){
        ArrayList<Fraccion> fila = new ArrayList();
        ArrayList<Fraccion> fila2 = new ArrayList();
        ArrayList<Fraccion> fila3 = new ArrayList();
        fila.add(new Fraccion(-5,1));
        fila.add(new Fraccion(4,1));
        fila.add(new Fraccion(-3,1));
        ArrayList<ArrayList<Fraccion>> mat = new ArrayList();
        mat.add(fila);
        fila2.add(new Fraccion(10,1));
        fila2.add(new Fraccion(-7,1));
        fila2.add(new Fraccion(6,1));
        mat.add(fila2);
        fila3.add(new Fraccion(8,1));
        fila3.add(new Fraccion(-6,1));
        fila3.add(new Fraccion(5,1));
        mat.add(fila3);
        Matriz de = new Matriz(mat);
        VentanaOperaciones ventana = new VentanaOperaciones(new Matriz(de.adjunta(mat)),new Historial());
        ventana.setVisible(true);
    }
}
