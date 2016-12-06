/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.parsen;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author saulocalixto
 */
public class VerificarVariavel {

    /**
     * Guarda as expressões sem as variáveis, só com valores.
     */
    private static String expressaoNoVariavel;

    /**
     * Verifica se há alguma variável na expressão.
     *
     * @param expressao Teste passado pelo usuário.
     * @return True ou False, se tiver ou não variável.
     */
    public final boolean haVariavel(final String expressao) {
        return expressao.contains("=");
    }

    /**
     * Método atribui valor às variáveis nas expressões.
     *
     * @param expressao Teste passado pelo usuário para ser resolvido pelo
     * parser.
     * @return Retorna um Map que presenta as variáveis e seus valores para que
     * o parser possa resolver a expressão.
     */
    public static Map atribuirValor(final String expressao) {

        Map<String, Float> ctx = new HashMap<>();

        String[] pontovirgula;

        pontovirgula = expressao.split(";");

        String[] virgula;

        virgula = pontovirgula[1].split(",");

        String[] valores;

        int contar;
        for (contar = 0; contar < virgula.length; contar++) {
            virgula[contar] = virgula[contar].replaceAll(" ", "");
            valores = virgula[contar].trim().split("=");

            pontovirgula[0] = pontovirgula[0].replaceAll(valores[0],
                        valores[1]);

            ctx.put(valores[0], Float.parseFloat(valores[1]));
        }
        expressaoNoVariavel = pontovirgula[0];
        return ctx;
    }

    /**
     *
     * @return Retorna a expressão sem variáveis.
     */
    public static String getExpressaoNoVariavel() {
        return expressaoNoVariavel;
    }
}
