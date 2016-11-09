/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

/**
 *
 * @author saulocalixto
 */
public class main {

    public static void main(String[] args) {

//        String conta;
//        conta = args[0];
//
//        if(conta != null) {
//            try {
//                System.out.println(Calcular.calcularExpressao(conta));
//                System.exit(0);
//            } catch (IllegalArgumentException erro) {
//                System.err.println("Expressão inválida.");
//                System.exit(1);
//            }
//        } else {
//            System.err.println("Erro, expressão nula.");
//            System.exit(1);
//        }
//    }

    LerArquivo arquivo = new LerArquivo();
    String endereco = "/tmp/guest-swhrl9/saulo.txt";
    arquivo.LerArquivo(args[0]);
    }

}
