/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 * 
 * @author JAVIER
 */
public class Diagonal implements Heuristica{
    
    TNodo fin;
    
    public Diagonal(TNodo n){
        this.fin = n;
    }
    
    /**
     * 
     * @param inicio
     * @return Guardamos las filas 
     */
    public int getFila(TNodo inicio){
        return Math.abs(inicio.getPosicion()[0] - fin.getPosicion()[0]);
    }
    
    /**
     * 
     * @param inicio
     * @return guardamos las columnas
     */
    public int getColumna(TNodo inicio){
        return Math.abs(inicio.getPosicion()[1] - fin.getPosicion()[1]);
    }
    
    /**
     * 
     * @param inicio
     * @return Calculamos la distancia diagonal
     */
    public int calcularDistancia(TNodo inicio){
        int columna, fila;
        int resultado = 0;
        fila = getFila(inicio);
        columna = getColumna(inicio);
          
        if (columna < fila){
            resultado = 14*columna + 10*(fila - columna);
        }
        else{
            resultado = 14*fila + 10*(columna - fila);
        }
        return resultado;
    }
    
    public String toString(){
         return this.getClass().getName();
    }
}
