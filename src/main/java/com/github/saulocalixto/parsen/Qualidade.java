/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

/**
 *
 * @author Saulo A. Calixto
 */
public class Qualidade {

    private static int somaCertos = 0;
    private static int somaErrados = 0;

    public static void verificaResultado(List testes) {

        String[] divide = expressao.split(";");
        Double resultadoEsperado = Double.parseDouble(divide[2]);
        Double resultadoObtido = Calcular.calcularExpressao(expressao);
        
        comparaResultadosCertos(resultadoObtido, resultadoEsperado);
        comparaResultadosErrados(resultadoObtido, resultadoEsperado);

    }

    private static int comparaResultadosCertos(double obtido, double esperado) {
        if (obtido == esperado) {
            somaCertos++;
        }
        return somaCertos;
    }
    
        private static int comparaResultadosErrados(double obtido, double esperado) {
        if (obtido != esperado) {
            somaErrados++;
        }
        return somaErrados;
    }
}
