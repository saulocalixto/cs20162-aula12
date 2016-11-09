/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import static com.github.saulocalixto.parsen.Calcular.calcularExpressao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author guest-swhrl9
 */
public class LerArquivo {

    Scanner ler = new Scanner(System.in);

    public void LerArquivo(String endereco) {

        System.out.println("Digite o endereço do arquivo");

        try {
            FileReader expressao = new FileReader(endereco);
            BufferedReader lerEnd = new BufferedReader(expressao);
            
            String linha = lerEnd.readLine();
            while(linha != null) {
                System.out.println(Calcular.calcularExpressao(linha));
                System.out.println(linha);
                linha = lerEnd.readLine();
            }
            
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
        }
    }
}
