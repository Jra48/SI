/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 * 
 * @author JAVIER
 */
public class Manhattan implements Heuristica{
    
    private TNodo fin;
    
    public Manhattan(TNodo fin){
        this.fin = fin;
    }
    
    /**
     * 
     * @param inicio
     * @return devolvemos el valor de las filas
     */
    public int getFilas(TNodo inicio){
        return (fin.getPosicion()[0] - inicio.getPosicion()[0]);
    }
    
    /**
     * 
     * @param inicio
     * @return devolvemos el valor de las columnas
     */
    public int getColumnas(TNodo inicio){
        return (fin.getPosicion()[1] - inicio.getPosicion()[1]);
    }
    /**
     * 
     * @param inicio nodo del inicio
     * @return devuelve la distancia manhattan calculada
     * Con columna calculamos el valor de las columnas y 
     * con fila calculamos el valor de las filas 
     */
    public int calcularDistancia(TNodo inicio){
        int fila = getFilas(inicio);   
        int columna = getColumnas(inicio);
        int D = 9;  //incrementandola podemos hacer que mejore h()!
        int resultado;
        
        resultado = D*Math.abs(fila) + Math.abs(columna);
       
        return resultado;  
    }
    
    public String toString(){
         return this.getClass().getName();
    }
    
}