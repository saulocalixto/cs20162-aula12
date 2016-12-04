/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.parsen;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Saulo Calixto
 */
public class Navegacao {

    /**
     * Array com as expressões que serão testadas.
     */
    private static ArrayList<String> arraytestes = new ArrayList<>();

    /**
     *
     * @param testes Endereço do arquivo que contém os testes a serem realiza-
     * dos.
     * @throws IOException Se não for possível ler o endereço.
     */
    public static void pegarTeste(final String testes) throws IOException {

        try {
            if (Carrega.isUrl(testes)) {
                arraytestes = Carrega.testes(Carrega.getBufferedReader(testes));
            } else if (Carrega.isArquivo(testes)) {
                arraytestes = Carrega.testes(Carrega.
                        getBufferedReader2(testes));
            }

            Qualidade.verificaResultado(arraytestes);
        } catch (IOException e) {
            System.err.println("Arquivo não encontrado.\n" + e.getMessage());
        }

    }

}
