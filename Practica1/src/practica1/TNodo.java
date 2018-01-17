/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;
import java.util.ArrayList;
/**
 *
 * @author danielpedrajasvandevelde
 */
public class TNodo {
    
    private boolean visitado = false;
    private int fila = 0;
    private int columna = 0;
    private int coste = 0;
    private int real = 0;
    private Heuristica h;
    private TNodo nodoPadre;    //puntero para no perder el padre y poder reconstruir el camino
    
    //constructor por parametros
    TNodo(int x, int y, int real, TNodo papa, Heuristica h){
        fila = x; 
        columna = y; 
        nodoPadre = papa; 
        this.h = h; 
        this.real = real; 
        coste = -1;
    }
    
    TNodo(int x, int y, int real, TNodo papa){
        fila = x; columna = y; nodoPadre = papa; this.real = real; coste = -1;
    }
    
    //devuelve vector con los nodos expandidos (arriba, abajo, izq, dxa)
    public ArrayList<TNodo> expandir(int [][] mundo){
        
        //array de los nodos a los que se puede expandir
        ArrayList <TNodo> expansion = new ArrayList <TNodo>();

        //si puedo expandir hacia arriba expando
        if(fila > 1 && mundo[fila - 1][columna] == 0){
            expansion.add(new TNodo(fila-1, columna, real + 1, this, h));
            //System.out.println("expande arriba");
        }
        //si me puedo expandir hacia la izquierda
        if(columna > 1 && mundo[fila][columna - 1] == 0){
            expansion.add(new TNodo(fila, columna-1, real + 1, this, h));
            //System.out.println("expande izq");
        }
        //si me puedo expandir derecha
        if(columna + 1 < mundo.length - 1 && mundo[fila][columna + 1] == 0){
            expansion.add(new TNodo(fila, columna+1, real + 1, this, h));
            //System.out.println("expande dxa");
        }
        //expansion hacia abajo
        if(fila + 1 < mundo.length - 1 && mundo[fila + 1][columna] == 0){
            expansion.add(new TNodo(fila + 1, columna, real + 1, this, h));
            //System.out.println("expande abajo");
        }
        
        return expansion;
    }
   
    /**
     * 
     * @param b nodo
     * @return devuelve el valor de los costes una vez comparados,
     * si el coste del nodo b es menor que el de actual devolvera -1 para quedarnos con el valor
     * del actual.
     */
    public int comparador(TNodo b){
        int comparator = -1;
        
        if(this.getCoste() > b.getCoste()){
            if(this.getCoste() == b.getCoste()){
                comparator = 0;
            }     
            else{
                comparator = 1;
            }
        }
        
        return comparator;
    }
    
    //getter coste
    public int getCoste(){
        if(coste < 0){
            coste = real + h.calcularDistancia(this);
        }
        
        return coste;
    }
    
    /**
     * 
     * @param tn objeto
     * @return devuelve tru si son iguales las filas y columnas
     * necesario sobreescribirlo para utilizarlo con las JUnit
     */
    public boolean equals(Object tn){
        TNodo nodo = (TNodo) tn;
        boolean aux = false;
        
        if(fila == nodo.fila && columna == nodo.columna){
            aux = true;
        }
        return aux;
    }
    

    
    /**
     * 
     * @return devuelve el vector formado por dos elementos, filas y columnas
     */
    public int[] getPosicion(){
        int[] vecp = new int[2];
        vecp[0] = fila;
        vecp[1] = columna;
        
        return vecp;
    }
    
    /**
     * 
     * @return devuelve el string formado por fila columna
     */
    public String toString(){
        return fila + ", " + columna;
    }
    
    /**
     * 
     * @return devuelve el nodo padre
     */
    public TNodo getPapa(){
        return nodoPadre;
    }
    

}
