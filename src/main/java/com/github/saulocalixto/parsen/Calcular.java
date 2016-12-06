/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.parsen;

import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;
import java.util.List;


/**
 *
 * @author Saulo A. Calixto
 */
public class Calcular {

    /**
     *Captura uma expressão passada pelo usuário e devolve o resultado dessa
     * expressão.
     *
     * @param expressao argumento passado pelo usuário que representa uma
     * expressão matemática a ser resolvida pelo parser.
     * @return retorna o resultado da expressão passada como argumento.
     */
    public static double calcularExpressao(String expressao) {
        
        double resultado = 0;

        VerificarVariavel verificar = new VerificarVariavel();

        if (expressao != null) {
            List<Token> calcula = new Lexer(expressao).tokenize();
            Parser processador = new Parser(calcula);
            try {
                if(verificar.haVariavel(expressao)) {
                    resultado = processador.expressao()
                            .valor(VerificarVariavel.atribuirValor(expressao));
                } else {
                    resultado = processador.expressao().valor();
                }
            } catch (IllegalArgumentException erro) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
        return resultado;
    }

}
