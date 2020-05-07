/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class Historial {
    static ArrayList<Matriz> info;
    ArrayList<String> pasos;
    
    public Historial(){
        info=new ArrayList();
        pasos=new ArrayList();
    }
    
    public void agregarMatriz(Matriz dato){
        info.add(dato);
    }
    
    public void agregarPaso(String paso){
        pasos.add(paso);
    }

    public ArrayList<Matriz> getInfo() {
        return info;
    }

    public ArrayList<String> getPasos() {
        return pasos;
    }
    
    
}
