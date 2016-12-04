/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Saulo A. Calixto
 */
public class Qualidade {

    private static int somaCertos = 0;
    private static int somaErrados = 0;
    private static long tempoTotal = 0;
    private static String expressaoVariavel = null;
    private static ArrayList<Double> esperado = new ArrayList<>();
    private static ArrayList<Double> obtido = new ArrayList<>();
    private static ArrayList<String> expressoes = new ArrayList<>();
    final private static long CONVERTE = 1000000000;

    public static void verificaResultado(ArrayList<String> testes) {

        long startTime = System.nanoTime();

        for (String expressao : testes) {
            String expressaoPassar = null;
            String[] divide = expressao.split(";");
            Double resultadoEsperado = Double.parseDouble(divide[2]);
            Double resultadoObtido = Calcular.calcularExpressao(expressao);
            comparaResultadosCertos(resultadoObtido, resultadoEsperado);
            comparaResultadosErrados(resultadoObtido, resultadoEsperado);

            if (divide[1].length() > 1) {
                Iterator it = VerificarVariavel.atribuirValor(expressao).entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pairs = (Map.Entry) it.next();
                    System.out.println(pairs.getKey().toString() + "-" + pairs.getValue().toString());
                    expressaoVariavel = divide[0].trim().replaceAll(pairs.getKey().
                            toString(), pairs.getValue().toString());
                }
            } else {
                expressaoVariavel = divide[0];
            }

            esperado.add(resultadoEsperado);
            obtido.add(resultadoObtido);
            expressoes.add(expressaoVariavel);
        }

        tempoTotal = (System.nanoTime() - startTime) / CONVERTE;

    }

    public static ArrayList<String> getExpressoes() {
        return expressoes;
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

    public static int getsomaCertos() {
        return somaCertos;
    }

    public static int getsomaErrados() {
        return somaErrados;
    }

    public static long getTempoTotal() {
        return tempoTotal;
    }

    public static long getTempoMedio() {
        return (tempoTotal) / (somaErrados + somaCertos);
    }

    public static ArrayList<Double> getEsperado() {
        return esperado;
    }

    public static ArrayList<Double> getObtido() {
        return obtido;
    }

    public static ArrayList<String> getExpressao() {
        return expressoes;
    }

}
