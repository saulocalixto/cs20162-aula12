/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author saulocalixto
 */
public class VerificarVariavel {

    public boolean haVariavel(String expressao) {
        return expressao.contains("=");
    }

    

    public static Map atribuirValor(String expressao) {

        Map<String, Float> ctx = new HashMap<>();
        
        String[] pontovirgual;
        
        pontovirgual = expressao.split(";");
        
        String[] virgula;
        
        virgula = pontovirgual[1].split(",");
        
        String[] valores;
        int contar;
        for(contar = 0; contar < virgula.length; contar++) {
            valores = virgula[contar].trim().split("=");
            ctx.put(valores[0], Float.parseFloat(valores[1]));
            int cont = 0;
            for(cont = 2; cont < valores.length; cont += 2) {
                ctx.put(valores[cont], Float.parseFloat(valores[cont+1]));
            }
        }
        return ctx;
    }
}
