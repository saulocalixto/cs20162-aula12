/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.parsen;

import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

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
     * @param nomeArquivo
     * @param html
     * @throws IOException Caso ocorra algum erro na criação do arquivo.
     */
    public void write(String nomeArquivo, List<String> html) {
        try {
            Writer out = new FileWriter(new File(nomeArquivo).
                    getAbsoluteFile());
            write(out, html);
        } catch (IOException e) {
        }
    }

    @VisibleForTesting
    void write(Writer writer, List<String> html) {
        PrintWriter out = new PrintWriter(writer);
        try {
            for (int i = 0; i < html.size(); i++) {
                out.println(html.get(i));
            }
        } finally {
            out.close();
        }
    }

    /**
     * @return String com o corpo do relatório html.
     */
    public static List corpoHtml() {

        List<String> html = new ArrayList<>();
        html.add("<html>\n");
        html.add("<head>\n");
        html.add("<meta charset=\"UTF-8\">\n");
        html.add("<title>Relatório de Testes</title>\n");
        html.add("</head>\n");
        html.add("<body>\n");
        html.add("<h1>Resultado geral</h1>\n");
        html.add("<table>\n");
        html.add("<tr>\n");
        html.add("<td><b>Tempo total</b></td>\n");
        html.add("<td>" + (Qualidade.getTempoTotal()) + " ms</td>\n");
        html.add("</tr>\n");
        html.add("<tr>\n");
        html.add("<td><b>Tempo médio</b></td>\n");
        html.add("<td>" + (Qualidade.getTempoMedio()) + " ms</td>\n");
        html.add("</tr>\n");
        html.add("<tr>\n");
        html.add("<td><b>Memoria Consumida</b></td>\n");
        html.add("<td>" + (Qualidade.getMemoriaConsumida())
                + " bytes</td>\n");
        html.add("</tr>\n");
        html.add("<tr>\n");
        html.add("<td><b>Total de testes</b></td>\n");
        html.add("<td>" + (CERTOS + ERRADOS) + "</td>\n");
        html.add("</tr>\n");
        html.add("<tr>\n");
        html.add("<td><b>Corretos</b></td>\n");
        html.add("<td>" + (CERTOS) + "</td>\n");
        html.add("</tr>\n");
        html.add("<tr>\n");
        html.add("<td><b>Falhas</b></td>\n");
        html.add("<td>" + (ERRADOS) + "</td>\n");
        html.add("</tr>\n");
        html.add("</table>\n");
        html.add("\n");
        html.add("<h1>Relatório detalhado dos testes</h1>\n");
        html.add("<table>\n");
        html.add("<tr>\n");
        html.add("<th>Expressão</th>\n");
        html.add("<th>Esperado</th>\n");
        html.add("<th>Obtido</th>\n");
        html.add("</tr>\n");
        html.add("<tr>\n");
        for (int cont = 0; cont < Qualidade.getObtido().size(); cont++) {
            html.add("<td>" + (Qualidade.getExpressoes().
                    get(cont)) + "</td>\n");
            html.add("<td>" + String.format("%1$.3f", (Qualidade.getEsperado().
                    get(cont))) + "</td>\n");
            html.add("<td>" + String.format("%1$.3f", (Qualidade.getObtido().
                    get(cont))) + "</td>\n");
            html.add("</tr>\n");
        }

        html.add("</table>\n");
        html.add("</body>\n");
        html.add("\n");
        html.add("</html>");

        return html;
    }

}
