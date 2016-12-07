/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.parsen;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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
     * Método gera relatório em um arquivo json com o resultado dos testes
     * passados.
     *
     * @param writeFile writer que contém o arquivo que será criado.
     * @throws IOException Excessão caso ocorra algum erro na criação do json.
     */
    @SuppressWarnings("unchecked")
    public static void criarJson(final Writer writeFile) throws IOException {

        JSONObject jsonObject = new JSONObject();

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
        jsonObject.put("Resultados", resultadosArray);

        if (Calcular.getTesteErro().size() > 0) {
            JSONObject err = new JSONObject();
            JSONArray erros = new JSONArray();
            for (int cont = 0; cont < Calcular.getTesteErro().size();
                    cont++) {
                err.put("expressãoMalFormada",
                        Calcular.getTesteErro().get(cont));
                erros.add(err);
            }
            jsonObject.put("Erro de Sintaxe", erros);
        }

        try {
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
        } catch (FileNotFoundException e) {
            return;
        }
    }

    /**
     * Método um writer que representa o arquivo que será criado.
     *
     * @param nomeArquivo Nome e endereço do aquivo que será criado.
     * @throws IOException Excessão caso ocorra algum erro na criação do json.
     */
    public static void writer(final String nomeArquivo) throws IOException {
        try {
            Writer writeFile = null;
            writeFile = new FileWriter(nomeArquivo);
            criarJson(writeFile);
        } catch (IOException e) {
            return;
        }
    }
}
