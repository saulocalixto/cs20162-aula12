/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author saulocalixto
 */
public class ToHtmlTest {
    

    @Test
    public void testStrHTML() {

        String html = ToHtml.corpoHtml();
    }

    @Test
    public void testCriarHTML() throws IOException { 
        
        ToHtml.criarHTML();     
    }
    
    @Test
    public void chamarConstrutor() {
        ToHtml html = new ToHtml();
    }

}
