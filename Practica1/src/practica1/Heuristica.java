/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 * 
 * @author JAVIER
 */
public interface Heuristica {
    
    //Método que sobreescribiran las derivadas, con el calcularemos la distancia
    //Si por ejemplo es la diagonal será otro dtipo de distancia que si fuese de manhattan
    public int calcularDistancia(TNodo inicio);
    
    @Override
    public String toString();
    
}
