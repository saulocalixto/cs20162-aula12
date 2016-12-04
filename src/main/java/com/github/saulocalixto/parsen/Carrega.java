/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author guest-swhrl9
 */
public class Carrega {

    public static ArrayList<String> testes(BufferedReader br) {

        ArrayList<String> testes = new ArrayList<>();
        try {
            String linha = br.readLine();
            while (linha != null) {
                testes.add(linha);
                linha = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Não deu");
            return null;
        }

        return testes;
    }

    public static boolean isUrl(String arquivo) {
        try {
            new URL(arquivo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isArquivo(String arquivo) {
        try {
            new FileReader(arquivo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static BufferedReader getBufferedReader2(String arquivo)
            throws FileNotFoundException {
        FileReader arquivoTeste = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(arquivoTeste);
        return br;
    }

    public static BufferedReader getBufferedReader(String urlString) 
            throws MalformedURLException, IOException {
        URL oracle = new URL(urlString);
        InputStreamReader is = new InputStreamReader(oracle.openStream());
        return new BufferedReader(is);
    }
}
