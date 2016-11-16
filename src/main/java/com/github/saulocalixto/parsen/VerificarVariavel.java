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

    

    public Map atribuirValor(String expressao) {

        Map<String, Float> ctx = new HashMap<>();
        int cont;

        for (cont = 0; cont < expressao.length(); cont++) {
            String variavel;
            float valor;

            if (expressao.charAt(cont) == ';') {
                int cont2 = cont + 1;
                while (cont2 != ',') {
                    if (expressao.charAt(cont2) != ',') {
                        if (expressao.contains("a")
                                && expressao.charAt(cont) <= 'z') {

                        }
                    }

                    cont2++;
                }
            }
        }

    }
