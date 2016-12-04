/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.parsen;

import java.io.IOException;

/**
 *
 * @author Saulo A. Calixto
 */
public class Main {

    /**
     *
     * @param args Argumento passado pelo usuário, contém o endereço do arquivo
     * que será testado, pode estar no próprio computador ou na internet. Há
     * também a possibilidade de passar um segundo parâmetro -h, que representa
     * o tipo de relatório a ser gerado. No caso de haver o parâmetro -h o rela-
     * tório será em html. Se não houver um segundo parâmetro o relatório será
     * em arquivo json.
     *
     * @throws IOException Caso aja algum erro nos parâmetros passados.
     */
    public static void main(final String[] args) throws IOException {

        Navegacao.pegarTeste(args[0]);

        if (args.length == 2) {
            if (args[1].equals("-h")) {
                ToHtml.criarHTML();
                System.out.println("Arquivo html criado no diretório corrente");
            } else {
                System.out.println("Argumento inválido");
            }
        } else if (args.length == 1) {
            Tojson.criarJson();
            System.out.println("Arquivo json criado no diretório corrente");
        }
    }

}
