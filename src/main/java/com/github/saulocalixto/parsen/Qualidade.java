/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

/**
 *
 * @author guest-ntpgmh
 */
public class Qualidade {
    
    private int somaCertos = 0;
    private int somaErrados = 0;
    
    public boolean verificaResultado(String expressao) {
    
    String[] divide = expressao.split(";");
    String resultadoEsperado = divide[2];
    
    if(Double.parseDouble(resultadoEsperado) 
            == Calcular.calcularExpressao(expressao)) {
        somaCertos++;
        return true;
    } else {
        somaErrados++;
        return false;
    }
}
   
    
    
}
