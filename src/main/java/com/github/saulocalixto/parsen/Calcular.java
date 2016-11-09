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

    public static double calcularExpressao(String expressao) {

        List<Token> calcula = new Lexer(expressao).tokenize();
        Parser processador = new Parser(calcula);
        return (processador.expressao().valor());

    }
}
