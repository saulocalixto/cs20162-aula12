/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author saulocalixto
 */
public class CalcularTest {

    @Test
    public void testarParse() {
        String teste = "3 + 5";
        Assert.assertEquals(8f, Calcular.calcularExpressao(teste), 0.001f);
    }

     @Test
     public void excessao() throws Exception {
         String teste = "3 + 5 + 3;;";
         Calcular.calcularExpressao(teste);
     }
     
     @Test
     public void chamarConstrutor() {
         Calcular calcula = new Calcular();
     }

}
