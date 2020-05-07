package logica;


/**
 * 
 * Clase que almacena la fracción y realiza las operaciones basicas en ellas (suma, resta, multiplicación y div)
 */
public class Fraccion 
{
    int numerador;
    int denominador;
    
    public Fraccion(int num, int deno)
    {
        numerador = num;
        denominador = deno;
        simplificar();
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }
    
    public String to_String(){
        String res=String.valueOf(this.numerador);
        if(this.denominador !=1){
            res+="/"+this.denominador;
        }
        return res;
    }
    
    /**
     * @param nodo
     * E:2 Factores
     * S:Operación efectuada
     * @return 
     */
    public Fraccion Multiplicar(Fraccion nodo)
    {
        int res1 = this.numerador*nodo.numerador;
        int res2 = this.denominador*nodo.denominador;
        simplificar();
        Fraccion respuesta = new Fraccion(res1,res2);
        return respuesta;
    }
    
    /**
     * 
     * @param nodo
     * E:Dividendo y divisor
     * S:Operación efectuada
     * @return 
     */
    public Fraccion Dividir(Fraccion nodo)
    {
        this.denominador*=nodo.numerador;
        this.numerador*=nodo.denominador;
        simplificar();
        Fraccion respuesta = new Fraccion(numerador,denominador);
        return respuesta;
    }
    
    /**
     * 
     * @param nodo
     * E:Sumandos
     * S:Suma efectuada
     * @return 
     */
    public Fraccion suma(Fraccion nodo)
    {
        int denominadorr;
        int res=0;
        denominadorr = this.denominador*nodo.denominador;
        res+=((denominadorr/this.denominador)*this.numerador);
        res+=((denominadorr/nodo.denominador)*nodo.numerador);
        //this.denominador = denominadorr;
        //this.numerador = res;
        simplificar();
        Fraccion respuesta = new Fraccion(res,denominadorr);
        return respuesta;
    }
    
    /**
     * 
     * @param nodo 
     * E:Minuendo y sustraendo
     * S:Resta efectuada
     * @return 
     */
   
    public Fraccion resta(Fraccion nodo)
    {
        int denominadorr;
        int res=0;
        denominadorr = this.denominador*nodo.denominador;
        res+=((denominadorr/this.denominador)*this.numerador);
        res-=((denominadorr/nodo.denominador)*nodo.numerador);
        //this.denominador = denominadorr;
        //this.numerador = res;
        simplificar();
        Fraccion respuesta = new Fraccion(res,denominadorr);
        return respuesta;
    }
    
    
    /**
     * E:Numerador y denominador
     * S:Numerador y denominador simplificado
     */
    public void simplificar()
    {
        if (this.denominador<0)
        {
            this.numerador*=-1;
            this.denominador*=-1;
        }
        for(int multiplo = 2;multiplo<numerador+1 || multiplo<denominador+1;multiplo++)
        {
            if(numerador%multiplo==0 && denominador%multiplo==0)
            {
                numerador=numerador/multiplo;
                denominador=denominador/multiplo;
                multiplo=1;
            }
        }
    }
}

