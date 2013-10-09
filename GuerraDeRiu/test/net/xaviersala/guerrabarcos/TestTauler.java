package net.xaviersala.guerrabarcos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTauler {

    Tauler t;
    Barco b;
    
    @Before
    public void setUp() {
        int[] posicions = { 1, 2, 3 };
        t = new Tauler();
        b = new Barco(posicions);
        t.setBarco(b);
    }
    
    @Test
    public void testSiTornaElResultatCorrecteAlProvarPosicio() {                        
        assertEquals("Encertat però falla",  "aigua", t.provaCasella("0"));
        assertEquals("Encertat però falla",  "tocat", t.provaCasella("1"));
        assertEquals("Encertat però falla",  "tocat", t.provaCasella("3"));
        assertEquals("Encertat però falla",  "aigua", t.provaCasella("4"));                                                     
    }
    
    @Test
    public void testSiTornaError() {
        
        assertEquals("Ha de tornar error amb negatius",  "error", t.provaCasella("-1"));
        assertEquals("Ha de tornar error amb números molt grans",  "error", t.provaCasella("100"));
        assertEquals("Ha de tornar error amb 'null'",  "error", t.provaCasella(null));                            
                              
    }
    
    @Test
    public void testSiEnfonsaBeElsBarcos() {
        
        assertEquals("Encertat però falla",  "tocat", t.provaCasella("1"));
        assertEquals("Encertat però falla",  "tocat", t.provaCasella("2"));
        assertEquals("Hauria d'estar enfonsat",  "enfonsat", t.provaCasella("3"));                   
                              
    }    
    
    @Test
    public void testSiNoPermetRepetirEnfonsaments() {
        
        assertEquals("Encertat però falla",  "tocat", t.provaCasella("1"));
        assertEquals("Ja estava tocat anteriorment",  "aigua", t.provaCasella("1"));
                        
                              
    }       
        
    @Test
    public void testSiEnvienNulls() {
        
        assertEquals("Envio Null i ...", "error", t.provaCasella(null));
        
    }
    
}
