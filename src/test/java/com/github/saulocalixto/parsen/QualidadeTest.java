/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;


import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author saulocalixto
 */
public class QualidadeTest {
    
    @Test
    public void chamarConstrutor() {
        Qualidade quali = new Qualidade();
    }
    
    @Test
    public void testarQualidade() {
        ArrayList<String> testes = new ArrayList<>();
        Qualidade.verificaResultado(testes);
        Assert.assertEquals(0, Qualidade.getTempoMedio());
    }

    
}
