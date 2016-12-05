/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.parsen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Saulo A. Calixto
 */
public class Carrega {

    /**
     *
     * Método para carregar o arquivo que contém os testes que o usuário deseja
     * realizar.
     *
     * @param br Arquivo BufferedReader usado para encontrar o arquivo de
     * testes no pc do usuário, ou na internet.
     *
     * @return Retorna um ArrayLists com todas as expressões que devem ser sub-
     * metidas a testes.
     */
    public static ArrayList<String> testes(final BufferedReader br) {

        ArrayList<String> testes = new ArrayList<>();
        try {
            String linha = br.readLine();
            while (linha != null) {
                testes.add(linha.replaceAll(" ", ""));
                linha = br.readLine();
            }
        } catch (Exception e) {
            return null;
        }

        return testes;
    }

    /**
     *
     * Método verifica se o endereço passado pelo usuário é um endereço na
     * internet.
     *
     * @param arquivo Caminho em que se encontra o arquivo para testes, pode
     * estar na internet, url, ou no próprio computador.
     * @return True ou false, se for endereço no computador ou não.
     */
    public static boolean isUrl(final String arquivo) {
        try {
            new URL(arquivo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

     /**
     *
     * Método verifica se o endereço passado pelo usuário é um endereço de
     * algum diretório do computador do usuário.
     *
     * @param arquivo Caminho em que se encontra o arquivo para testes, pode
     * estar na internet, url, ou no próprio computador.
     * @return True ou false, se for endereço url ou não.
     */
    public static boolean isArquivo(final String arquivo) {
        try {
            System.out.println(new FileReader(arquivo));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param arquivo Caminho onde se encontra o arquivo a ser testado.
     * @return Arquivo BufferedReader usado para encontrar o arquivo de
     * testes no pc do usuário, ou na internet.
     * @throws FileNotFoundException Se o arquivo não for encontrado.
     */
    public static BufferedReader getBufferedReader2(final String arquivo)
            throws FileNotFoundException {
        FileReader arquivoTeste = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(arquivoTeste);
        return br;
    }

    /**
     *
     * @param urlString Caminho onde se encontra o arquivo a ser testado.
     * @return Arquivo BufferedReader usado para encontrar o arquivo de
     * testes no pc do usuário, ou na internet.
     * @throws MalformedURLException Se não for um endereço url válido.
     * @throws IOException Se houver algum erro no endereço passado.
     */
    public static BufferedReader getBufferedReader(final String urlString)
            throws MalformedURLException, IOException {
        URL oracle = new URL(urlString);
        InputStreamReader is = new InputStreamReader(oracle.openStream());
        return new BufferedReader(is);
    }
}
