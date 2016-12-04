/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Saulo de Araújo Calixto
 */
public class ToHtml {

    static int certos = Qualidade.getsomaCertos();
    static int errados = Qualidade.getsomaErrados();

    public static void criarHTML() throws IOException {

        FileWriter arq = new FileWriter("./qp.html");
        PrintWriter gravarArq = new PrintWriter(arq);
        System.out.println("Criando arquivo.");
        gravarArq.printf(corpoHtml());

        arq.close();
    }

    private static String corpoHtml() {
        String html = "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Relatório de Testes</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Resultado geral</h1>\n"
                + "<table>\n"
                + "<tr>\n"
                + "<td><b>Tempo total</b></td>\n"
                + "<td>" + (Qualidade.getTempoTotal()) + "ms</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Tempo médio</b></td>\n"
                + "<td>" + (Qualidade.getTempoMedio()) + "ms</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Total de testes</b></td>\n"
                + "<td>" + (certos + errados) + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Corretos</b></td>\n"
                + "<td>" + (certos) + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Falhas</b></td>\n"
                + "<td>" + (errados) + "</td>\n"
                + "</tr>\n"
                + "</table>\n"
                + "\n"
                + "<h1>Relatório detalhado dos testes</h1>\n"
                + "<table>\n"
                + "<tr>\n"
                + "<th>Expressão</th>\n"
                + "<th>Esperado</th>\n"
                + "<th>Obtido</th>\n"
                + "</tr>\n"
                + "<tr>\n";
        for (int cont = 0; cont < Qualidade.getObtido().size(); cont++) {
            html += "<td>" + (Qualidade.getExpressoes().get(cont)) + "</td>\n";
            html += "<td>" + (Qualidade.getEsperado().get(cont)) + "</td>\n";
            html += "<td>" + (Qualidade.getObtido().get(cont)) + "</td>\n";
            html += "</tr>\n";
        }

        html += "</table>\n"
                + "</body>\n"
                + "\n"
                + "</html>";
        
        return html;
    }

}
