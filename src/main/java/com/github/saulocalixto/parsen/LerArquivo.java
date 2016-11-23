/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author guest-swhrl9
 */
public class LerArquivo {

    Scanner ler = new Scanner(System.in);

    public void LerArquivo(String endereco) throws IOException {

        try {
            FileReader expressao = new FileReader(endereco);
            BufferedReader lerEnd = new BufferedReader(expressao);
            try {
                String linha = lerEnd.readLine();
                while (linha != null) {
                    System.out.println(Calcular
                            .calcularExpressao(linha.replaceAll(" ", "")));
                    linha = lerEnd.readLine();
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Argumento inválido: " + e.getMessage());
            }

        } catch (IOException e) {
            try {
                URL oracle = new URL(endereco);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(oracle.openStream()));
                String linha;
                while ((linha = in.readLine()) != null) {
                    System.out.println(Calcular
                            .calcularExpressao(linha.replaceAll(" ", "")));
                }
                in.close();
            } catch(IOException f) {
                System.err.println("Argumento inválido: " + f.getMessage());
            }
        }
    }
}
