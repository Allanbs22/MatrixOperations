/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * Objeto que almacena la matriz y los metodos para efectuar operaciones con las filas
 */
public class Matriz {
     ArrayList<ArrayList<Fraccion>> mat;
     int alto,ancho;
     
    public Matriz(ArrayList<ArrayList<Fraccion>> mat){
        this.mat=mat;
        alto = mat.size();
        ancho = mat.get(0).size();
    }

    public ArrayList<ArrayList<Fraccion>> getMat() {
        return mat;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    
    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }
    
    
    //Calcula el determinante de una matriz
    public Fraccion Determinante(ArrayList<ArrayList<Fraccion>> mat){
        Fraccion[][] array = new Fraccion[mat.size()][mat.size()];
        for (int i = 0; i < mat.size(); i++) {
            ArrayList<Fraccion> row = mat.get(i);
            array[i] = row.toArray(new Fraccion[row.size()]);
        }
        return Determinante2(0,array);
    }
    
    
    //Calcula la matriz adjunta de una matriz recibida
    public ArrayList<ArrayList<Fraccion>> adjunta(ArrayList<ArrayList<Fraccion>> mat){
        Fraccion[][] array = new Fraccion[mat.size()][mat.size()];
        for (int i = 0; i < mat.size(); i++) {
            ArrayList<Fraccion> row = mat.get(i);
            array[i] = row.toArray(new Fraccion[row.size()]);
        }
        array=AdjuntaMatriz(array);
        ArrayList<ArrayList<Fraccion>> res = new ArrayList();
        for(int i = 0;i < array.length; i++){
            Fraccion[] data = array[i];
            ArrayList<Fraccion> row = new ArrayList();
            for(int j = 0;j < data.length; j++)
                row.add(data[j]);
            res.add(row);
        }
        return res;
    }
    
    /*
    Funcion que hace el calculo del determinanteFuncion que obtiene las submatrices, 
    necesaria para determinantes y para matrices adjuntas

    */
    public Fraccion Determinante2(int i, Fraccion [][]matriz){
        if(matriz.length==2){
            Fraccion deter = (matriz[0][0].Multiplicar(matriz[1][1])).resta(matriz[0][1].
                    Multiplicar(matriz[1][0]));              
            return deter;
        }
        else{
            Fraccion deter = new Fraccion(0,1);
            for (int j = 0; j < matriz.length; j++){
                Fraccion[][]temp = this.SubMatriz(i,j,matriz);
                deter = deter.suma(new Fraccion((int)Math.pow(-1,i+j),1).Multiplicar(matriz[i][j])
                        .Multiplicar(Determinante2(0,temp)));             
            }
            return deter;
        }
   }
    
    /*
    Funcion que obtiene las submatrices, necesaria para determinantes y para matrices adjuntas
    */
    private Fraccion[][]SubMatriz(int i,int j,Fraccion [][]matriz){
        Fraccion[][]temp=new Fraccion[matriz.length-1][matriz.length-1];
        int count1=0;
        int count2;
        for (int k = 0; k < matriz.length; k++){
            if (k!=i){
                count2=0;
                for (int l = 0; l < matriz.length; l++){
                    if (l!=j){
                        temp[count1][count2]=matriz[k][l];
                        count2++;
                    }
                }
                count1++;
            }
        }
        return temp;
    }

    /*
    Calcula la adjunta de la matriz, la retorna en forma de arreglo bidimensional, la funcion 
    principal se encarga de convertirla al formato estandar de ArrayList
    */
    public Fraccion [][]AdjuntaMatriz(Fraccion [][]matriz)
    {
        if(matriz.length==2){
            Fraccion[][]temp=new Fraccion[matriz.length][matriz.length];
            temp[0][0]=matriz[1][1];
            temp[0][1]=matriz[1][0].Multiplicar(new Fraccion(-1,1));
            temp[1][0]=matriz[0][1].Multiplicar(new Fraccion(-1,1));
            temp[1][1]=matriz[0][0];
            return temp;
        }
        Fraccion[][]tempAdjunta=new Fraccion[matriz.length][matriz.length];   
        for (int i = 0; i < tempAdjunta.length; i++){
            for (int j = 0; j < tempAdjunta.length; j++){
                Fraccion[][]temp  = this.SubMatriz(i, j, matriz) ;          
                Fraccion elementoAdjunto = new Fraccion((int)Math.pow(-1,i+j),1).Multiplicar(this.Determinante2(0,temp));           
                tempAdjunta[i][j]=elementoAdjunto;          
            }
        }
        return TranspuestaMatriz(tempAdjunta);
    }
    
    
    public Fraccion [][]TranspuestaMatriz(Fraccion [][]matriz)
    {
        Fraccion[][]tempTranspuesta=new Fraccion[matriz.length][matriz.length];  
        for (int i = 0; i < tempTranspuesta.length; i++)
            for (int j = 0; j < tempTranspuesta.length; j++)           
                tempTranspuesta[i][j]=matriz[j][i];
        return tempTranspuesta;  
    }
    
    
    
    public void intFilas(int fila1, int fila2){
        ArrayList<Fraccion> temp = mat.get(fila1);
        mat.set(fila1,mat.get(fila2));
        mat.set(fila2,temp);
    }
    
    public void multEscalar(int fila,Fraccion escalar){
        for(int i=0;i<mat.get(fila).size();i++){
            ArrayList<Fraccion> actual =mat.get(fila);
            Fraccion dato = actual.get(i).Multiplicar(escalar);
            actual.set(i,dato);
            mat.set(fila,actual);
        }
    }
    
    
    public void sumarMult(int fila1,Fraccion multiplo,int fila2){
        for(int i=0;i<mat.get(fila1).size();i++){
            ArrayList<Fraccion> filaMat2 =mat.get(fila2);
            Fraccion dato = filaMat2.get(i).Multiplicar(multiplo);
            ArrayList<Fraccion> actual =mat.get(fila1);
            Fraccion dato2 = actual.get(i).suma(dato);
            actual.set(i, dato2);
            mat.set(fila1,actual);
        }
    }
}

