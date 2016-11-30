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
 * @author guest-pbh5uh
 */
public class ToHtml {

    public static void criarHTML() throws IOException {

        FileWriter arq = new FileWriter("./index.html");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Relatório de Testes</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Resultado geral</h1>\n"
                + "<table>\n"
                + "<tr>\n"
                + "<td><b>Tempo total</b></td>\n"
                + "<td>100ms</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Tempo médio</b></td>\n"
                + "<td>4ms</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Total de testes</b></td>\n"
                + "<td>25</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Corretos</b></td>\n"
                + "<td> + </td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Falhas</b></td>\n"
                + "<td>0</td>\n"
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
                + "<tr>\n"
                + "<td>2 + 3</td>\n"
                + "<td>5</td>\n"
                + "<td>5</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td>2 * 45</td>\n"
                + "<td>90</td>\n"
                + "<td>90</td>\n"
                + "</tr>\n"
                + "</table>\n"
                + "</body>\n"
                + "\n"
                + "</html>");
        
        arq.close();
    }

}
