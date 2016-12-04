/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.parsen;

import java.util.ArrayList;

/**
 *
 * @author Saulo A. Calixto
 */
public class Qualidade {

    /**
     * Guarda o resultado parcial dos testes que estão de acordo com o que o
     * usuário espera.
     */
    private static int somaCertos = 0;

    /**
     * Guarda o resultado parcial dos testes que noã estão de acordo com o que o
     * usuário espera.
     */
    private static int somaErrados = 0;

     /**
     * Tempo total que o parse demorou para realizar os testes do usuário.
     */
    private static long tempoTotal = 0;

    /**
     * String que guarda testes sem variáveis, só com os valores.
     */
    private static String expressaoVariavel = null;

    /**
     * Array com os resultados esperados nos testes passados pelo usuários.
     */
    private static final ArrayList<Double> ESPERADO = new ArrayList<>();

    /**
     * Array com os resultados obtidos nos testes passados pelo usuários.
     */
    private static final ArrayList<Double> OBTIDO = new ArrayList<>();

    /**
     * Array com as expressões de teste.
     */
    private static final ArrayList<String> EXPRESSOES = new ArrayList<>();

    /**
     * Total de memória consumida pelo parse para resolver os testes.
     */
    private static long memoriaConsumida;

    /**
     * Constante usada pra converte de nanosegundo para milisegundo.
     */
    private static final long CONVERTE = 1000000000;

    /**
     *
     * @param testes ArrayList com os testes a serem realizados para testar o
     * parser.
     */
    public static void verificaResultado(final ArrayList<String> testes) {

        long startTime = System.nanoTime();

        testes.stream().map((expressao) -> {
            String[] divide = expressao.split(";");
            Double resultadoEsperado = Double.parseDouble(divide[2]);

            long memoriaInicio = usoMemoria();

            Double resultadoObtido = Calcular.calcularExpressao(expressao);

            long memoriaFinal = usoMemoria();
            memoriaConsumida = memoriaFinal - memoriaInicio;

            comparaResultadosCertos(resultadoObtido, resultadoEsperado);
            comparaResultadosErrados(resultadoObtido, resultadoEsperado);
            if (divide[1].length() > 1) {
                expressaoVariavel = VerificarVariavel.getExpressaoNoVariavel();
            } else {
                expressaoVariavel = divide[0];
            }
            ESPERADO.add(resultadoEsperado);
            OBTIDO.add(resultadoObtido);
            return expressao;
        }).forEachOrdered((_item) -> {
            EXPRESSOES.add(expressaoVariavel);
        });

        tempoTotal = (System.nanoTime() - startTime) / CONVERTE;
    }

    /**
     *
     * @return Total de memória consumida pelo parser.
     */
    public static long getMemoriaConsumida() {
        return memoriaConsumida;
    }

    /**
     *
     * @return Testes com valores atribuidos a variáveis.
     */
    public static ArrayList<String> getExpressoes() {
        return EXPRESSOES;
    }

    /**
     *
     * Verifica se os resultados esperados pelo usuário e os obtidos pelo parser
     * estão de acordo.
     *
     * @param obtido Valor double passado pelo parser como resultado da expres-
     * são.
     * @param esperado Valor passado passado pelo usuário representa o valor
     * correto da expressão.
     * @return Retorna quantos testes estão corretos de acordo com o usuário.
     */
    private static int comparaResultadosCertos(final double obtido,
            final double esperado) {
        if (String.format("%1$.3f", obtido)
                .equals(String.format("%1$.3f", esperado))) {
            somaCertos++;
        }
        return somaCertos;
    }

    /**
     *
     * Verifica se os resultados esperados pelo usuário e os obtidos pelo parser
     * estão de acordo ou não.
     *
     * @param obtido Valor double passado pelo parser como resultado da expres-
     * são.
     * @param esperado Valor passado passado pelo usuário representa o valor
     * correto da expressão.
     * @return Retorna quantos testes estão errados de acordo com o usuário.
     */
    private static int comparaResultadosErrados(final double obtido,
            final double esperado) {
        if (!(String.format("%1$.3f", obtido)
                .equals(String.format("%1$.3f", esperado)))) {
            somaErrados++;
        }
        return somaErrados;
    }

    /**
     *
     * @return Retorna a soma de resultados certos de acordo com o teste passado
     * pelo usuário.
     */
    public static int getsomaCertos() {
        return somaCertos;
    }

    /**
     *
     * @return Retorna a soma de resultados errados de acordo com o teste pas-
     * sado pelo usuário.
     */
    public static int getsomaErrados() {
        return somaErrados;
    }

    /**
     *
     * @return Retorna o tempo total que o parser demorou para resolver as ex-
     * pressões.
     */
    public static long getTempoTotal() {
        return tempoTotal;
    }

    /**
     *
     * @return Retorna o médio total que o parser demorou para resolver as ex-
     * pressões.
     */
    public static long getTempoMedio() {
        if ((somaErrados + somaCertos) > 0) {
            return (tempoTotal) / (somaErrados + somaCertos);
        } else {
            return 0;
        }
    }

    /**
     *
     * @return Retorna ArrayList com os resultados esperados pelo usuário em
     * seus testes passados.
     */
    public static ArrayList<Double> getEsperado() {
        return ESPERADO;
    }

    /**
     *
     * @return Retorna o resultado dado pelo parser nos testes passados pelo
     * usuário.
     */
    public static ArrayList<Double> getObtido() {
        return OBTIDO;
    }

    /**
     *
     * @return ArrayList de expressões sem variáveis para fim de representação
     * no relatório.
     */
    public static ArrayList<String> getExpressao() {
        return EXPRESSOES;
    }

    /**
     *
     * @return Retorna total de memória usada pelo parser para realizar os
     * testes.
     */
    private static long usoMemoria() {
        Runtime rt = Runtime.getRuntime();
        rt.gc();
        return rt.totalMemory() - rt.freeMemory();
    }
}
