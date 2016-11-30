/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import java.io.IOException;

/**
 *
 * @author saulocalixto
 */
public class main {

    public static void main(String[] args) throws IOException {

        ToHtml.criarHTML();
        Carrega arquivo = new Carrega();
        Navegacao.pegarTeste(args[0]);
    }

}
