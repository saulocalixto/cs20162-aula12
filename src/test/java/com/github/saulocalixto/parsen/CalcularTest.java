/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;
import java.util.List;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

/**
 *
 * @author saulocalixto
 */
public class CalcularTest {
    
        @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test 
    public void testarParse() throws Exception {
        String teste = "3 + 5";
        Assert.assertEquals(8f, Calcular.calcularExpressao(teste), 0.001f);
    }

     @Test (expected = IllegalArgumentException.class)
     public void excessao() throws IllegalArgumentException {
         String teste = "/3 + 5 + 3//=";
         Calcular.calcularExpressao(teste);
     }
     
    @Test (expected = IllegalArgumentException.class)
     public void expressaoNula() throws IllegalArgumentException { 
         String teste = null;
         Calcular.calcularExpressao(teste);         
     }
     
    @Test
     public void expressaoVariavel() throws Exception {
         String teste = "a + b; a=1, b=2; 3";
         List<Token> calcula = new Lexer(teste).tokenize();
         Parser processador = new Parser(calcula);
         Assert.assertEquals(3f, processador.expressao().valor(VerificarVariavel
                 .atribuirValor(teste)), 0.001f);       
     }
     
     @Test
     public void chamarConstrutor() {
         Calcular calcula = new Calcular();
         Assert.assertNotNull(calcula);
     }

}
