package net.xaviersala.guerrabarcos;

public class Barco {

    int[] posicions;
    int numTocades;
    boolean enfonsat;
    
    /**
     * Crea un barco a partir de les posicions que se li passsen. El marca com a
     * no enfonsat
     * 
     * @param pos: posicions on està el barco
     */
    public Barco(int[] pos) {
        posicions = pos;   
        enfonsat = false;
    }
    
    /**
     * Comprova si el barco té alguna part en la posició especificada
     * 
     * @param casella Casella a comprovar
     * @return Retorna si l'hem trobat o no
     */
    public boolean comprovaPosicio(int casella) {
        
        if (casella<0) return false;
        
        for(int i=0; i< posicions.length; i++) {
            if (posicions[i] == casella) {
                posicions[i] = -1;
                numTocades++;  
                
                if (numTocades == posicions.length) {
                    enfonsat = true;
                    
                }
                return true;
            }
        }
        
        return false;
        
    }
    
    /** 
     * Comprova si el vaixell està enfonsat o no
     * 
     * @return Retorna si està enfonsat
     */
    public boolean estaEnfonsat() {
        return enfonsat;
    }
}
