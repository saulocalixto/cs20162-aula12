/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.parsen;

import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saulo A. Calixto
 */
public class Calcular {

    /**
     * Pega o tempo inicial antes de executar o programa.
     */
    private static final long ST = System.nanoTime();

    /**
     * Guarda cada tempo de execução do programa.
     */
    private static long tempoParcial;

    /**
     * Guarda o tempo total de execução do programa.
     */
    private static long tempoTotal = 0;

    /**
     * ArrayList com expressões mal formadas.
     */
    private static final ArrayList<String> TESTEERRO = new ArrayList<>();

    /**
     * Captura uma expressão passada pelo usuário e devolve o resultado dessa
     * expressão.
     *
     * @param expressao argumento passado pelo usuário que representa uma
     * expressão matemática a ser resolvida pelo parser.
     * @return retorna o resultado da expressão passada como argumento.
     */
    public static double calcularExpressao(final String expressao) {

        double resultado = 0;

        VerificarVariavel verificar = new VerificarVariavel();

        if (expressao != null) {
            List<Token> calcula = new Lexer(expressao).tokenize();
            Parser processador = new Parser(calcula);
            try {
                if (verificar.haVariavel(expressao)) {
                    resultado = processador.expressao()
                            .valor(VerificarVariavel.atribuirValor(expressao));
                } else {
                    resultado = processador.expressao().valor();
                }
            } catch (IllegalArgumentException erro) {
                TESTEERRO.add(expressao);
                throw new IllegalArgumentException();
            }
        } else {
            TESTEERRO.add(expressao);
            throw new IllegalArgumentException();
        }
        tempoParcial = (System.nanoTime() - ST);
        tempoTotal += tempoParcial;
        return resultado;
    }

    /**
     * @return retorna o tempo total que o programa levou para executar.
     */
    public static long tempoTotal() {
        return tempoTotal;
    }

    /**
     * @return retorna expressões mal formadas para relatório.
     */
    public static ArrayList<String> getTesteErro() {
        return TESTEERRO;
    }

}
