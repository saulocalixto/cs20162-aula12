/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guest-pbh5uh
 */
public class Navegacao {

    private static List<String> arraytestes = new ArrayList<>();

    public static void pegarTeste(String testes) throws IOException {

        if (Carrega.isUrl(testes)) {
            arraytestes = Carrega.testes(Carrega.getBufferedReader(testes));
        } else if (Carrega.isArquivo(testes)) {
            arraytestes = Carrega.testes(Carrega.getBufferedReader2(testes));
        }
    }

    public static void iterarArray() {

        Qualidade.verificaResultado(arraytestes);

    }

}
