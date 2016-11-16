/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;
import java.util.List;


/**
 *
 * @author saulocalixto
 */
public class Calcular {

    public static void calcularExpressao(String expressao) {
        
        VerificarVariavel verificar = new VerificarVariavel();

        if (expressao != null) {
            List<Token> calcula = new Lexer(expressao).tokenize();
            Parser processador = new Parser(calcula);
            try {
                if(verificar.haVariavel(expressao)) {
                    System.out.println(processador.expressao()
                            .valor(verificar.atribuirValor(expressao)));
                } else {
                    System.out.println(processador.expressao().valor());
                }
            } catch (IllegalArgumentException erro) {
                System.err.println("Expressão inválida.");
                System.exit(1);
            }
        } else {
            System.err.println("Erro, expressão nula.");
            System.exit(1);
        }

    }
}
