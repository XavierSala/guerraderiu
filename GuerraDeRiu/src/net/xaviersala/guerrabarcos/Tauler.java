package net.xaviersala.guerrabarcos;

import java.util.ArrayList;

public class Tauler {
     ArrayList<Barco> barcos;

     public static final int POSICIONS = 10;
     
     /**
      * Crea un tauler sense vaixells
      * 
      */
     public Tauler() {
         barcos = new ArrayList<Barco>();
     }
     
     /**
      * Afegeix un barco al tauler
      * 
      * @param posicions: Array amb les posicions
      */
     public void setBarco(int[] posicions) {
         
         barcos.add(new Barco(posicions));
         
     }
     
     /**
      * Afegeix un barco al tauler
      * 
      * @param b Objecte de tipus barco
      */
     public void setBarco(Barco b) {
         barcos.add(b);
     }
          
     /**
      * Comprova si una casella té barco o no
      * 
      * @param casella: Casella a comprovar
      * @return Retorna "aigua", "tocat" o "enfonsat"
      */
     public String provaCasella(String casella) {
         String retorn = "aigua";
         
         if (casella == null) return "error";
         
         int posicio = Integer.parseInt(casella);         
         if (posicio < 0 || posicio >= POSICIONS) return "error";
         
         for(Barco barco: barcos) {
             if (barco.comprovaPosicio(posicio) == true) {
                 if (barco.estaEnfonsat() == true) {
                     retorn = "enfonsat";
                 } else {
                     retorn = "tocat";
                 }                
             }
         }

         return retorn;
     }
     
     /** 
      * Determina el número de barcos vius que queden
      * en el tauler
      * 
      * @return número de barcos
      */
     public int getNumBarcos() {
        
        return barcos.size();         
     }
     
}
