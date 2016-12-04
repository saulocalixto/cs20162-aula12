/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
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

    /**
     * Quantidade de testes que estão certos.
     */
    private static final int CERTOS = Qualidade.getsomaCertos();

    /**
     * Quantidade de testes que estão errados.
     */
    private static final int ERRADOS = Qualidade.getsomaErrados();

    /**
     * Método cria um relatório com os resultados dos testes em um arquivo HTML.
     *
     * @throws IOException Caso ocorra algum erro na criação do arquivo.
     */
    public static void criarHTML() throws IOException {

        FileWriter arq = new FileWriter("./qp.html");
        PrintWriter gravarArq = new PrintWriter(arq);
        System.out.println("Criando arquivo.");
        gravarArq.printf(corpoHtml());

        arq.close();
    }

    /**
     * @return String com o corpo do relatório html.
     */

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
                + "<td>" + (Qualidade.getTempoTotal()) + " ms</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Tempo médio</b></td>\n"
                + "<td>" + (Qualidade.getTempoMedio()) + " ms</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Memoria Consumida</b></td>\n"
                + "<td>" + (Qualidade.getMemoriaConsumida()) + " bytes</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Total de testes</b></td>\n"
                + "<td>" + (CERTOS + ERRADOS) + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Corretos</b></td>\n"
                + "<td>" + (CERTOS) + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Falhas</b></td>\n"
                + "<td>" + (ERRADOS) + "</td>\n"
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
            html += "<td>" + String.format("%1$.3f", (Qualidade.getEsperado().
                    get(cont))) + "</td>\n";
            html += "<td>" + String.format("%1$.3f", (Qualidade.getObtido().
                    get(cont))) + "</td>\n";
            html += "</tr>\n";
        }

        html += "</table>\n"
                + "</body>\n"
                + "\n"
                + "</html>";

        return html;
    }

}
