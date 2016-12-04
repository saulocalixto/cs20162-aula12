/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.parsen;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author saulocalixto
 */
public class Tojson {

    /**
     * Quantidade de testes que estão CERTOS.
     */
    private static final int CERTOS = Qualidade.getsomaCertos();

    /**
     * Quantidade de testes que estão ERRADOS.
     */
    private static final int ERRADOS = Qualidade.getsomaErrados();

    /**
     * Método gera relatório com o resultado dos testes passados em um arquivo
     * json.
     *
     * @throws IOException Excessão caso ocorra algum erro na criação do json.
     */
    @SuppressWarnings("unchecked")
    public static void criarJson() throws IOException {

        JSONObject jsonObject = new JSONObject();

        FileWriter writeFile = null;

        jsonObject.put("tempoTotal", Qualidade.getTempoTotal());
        jsonObject.put("tempoMedio", Qualidade.getTempoMedio());
        jsonObject.put("memoriaConsumida", Qualidade.getMemoriaConsumida());
        jsonObject.put("total", (CERTOS + ERRADOS));
        jsonObject.put("acertos", (CERTOS));
        jsonObject.put("falhas", (ERRADOS));

        JSONObject resultados = new JSONObject();
        JSONArray resultadosArray = new JSONArray();

        for (int cont = 0; cont < Qualidade.getObtido().size(); cont++) {

            resultados.put("expressão", Qualidade.getExpressao().get(cont));
            resultados.put("esperado", String.format("%1$.3f",
                    (Qualidade.getEsperado().
                            get(cont))));
            resultados.put("obtido", String.format("%1$.3f",
                    (Qualidade.getObtido().
                            get(cont))));
            resultadosArray.add(resultados);
        }

        try {
            writeFile = new FileWriter("./qp.json");
            writeFile.write(jsonObject.toJSONString());
            writeFile.write(resultadosArray.toJSONString());
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
