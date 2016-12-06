/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.parsen;

import java.io.IOException;
import java.util.ArrayList;

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

        ArrayList<String> arraytestes = new ArrayList<>();

        try {
            if (Carrega.isUrl(args[0])) {
                arraytestes = Carrega.testes(Carrega.getBufferedReader(args[0]));
            } else if (Carrega.isArquivo(args[0])) {
                arraytestes = Carrega.testes(Carrega.
                        getBufferedReader2(args[0]));
            }
            Qualidade.verificaResultado(arraytestes);
        } catch (IOException e) {
            erro("Arquivo não encontrado.\n" + e.getMessage());
        }

        if (args.length == 2) {
            if (args[1].equals("-h")) {
                ToHtml h = new ToHtml();
                h.write("./qp.html", ToHtml.corpoHtml());
                System.out.println("Arquivo html criado no diretório corrente");
            } else {
                erro("Arquivo não encontrado.\n");
            }
        } else if (args.length == 1) {
            Tojson.Writer("./qp.json");
            System.out.println("Arquivo json criado no diretório corrente");
        } else {
            erro("Arquivo não encontrado.\n");
        }
        System.exit(0);
    }

    public static void erro(final String err) {
        System.out.println(err);
        System.exit(1);
    }

}
