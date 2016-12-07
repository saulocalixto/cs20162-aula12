/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

/**
 *
 * @author saulocalixto
 */
public class MainTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void mainSemArgs() throws IOException {
        exit.expectSystemExitWithStatus(1);
        Main.erro("erro");
    }

    @Test
    public void testMainCriaHTML() throws Exception {
        List<String> testes = new ArrayList<>();
        testes.add("a + b; a=1, b=2; 3");
        testes.add("3.14 * (z + 1);;3.14");
        String caminho = new File(Main.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI().getPath())
                .getParent();
        Path file = Paths.get(caminho + "/teste.txt");
        Files.write(file, testes, Charset.forName("UTF-8"));

        exit.expectSystemExitWithStatus(0);
        Main.main(new String[]{caminho + "/teste.txt", "-h"});
        Files.delete(file);
        file = Paths.get(caminho + "/qp.html");
    }

    @Test
    public void testMainCriaJSON() throws Exception {
        List<String> testes = new ArrayList<>();
        testes.add("a + b; a=1, b=2; 3");
        testes.add("3.14 * (z + 1);;3.14");
        String caminho = new File(Main.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI().getPath())
                .getParent();
        Path file = Paths.get(caminho + "/teste.txt");
        Files.write(file, testes, Charset.forName("UTF-8"));

        exit.expectSystemExitWithStatus(0);
        Main.main(new String[]{caminho + "/teste.txt"});
        Files.delete(file);
        file = Paths.get(caminho + "/qp.json");
    }

    @Test
    public void testMainArgInvalido1() throws Exception {
        List<String> testes = new ArrayList<>();
        testes.add("a + b; a=1, b=2; 3");
        testes.add("3.14 * (z + 1);;3.14");
        String caminho = new File(Main.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI().getPath())
                .getParent();
        Path file = Paths.get(caminho + "/teste.txt");
        Files.write(file, testes, Charset.forName("UTF-8"));

        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{caminho + "/teste.txt", "-h", "-j"});
        Files.delete(file);
    }

    @Test
    public void testMainArgInvalido2() throws Exception {
        List<String> testes = new ArrayList<>();
        testes.add("a + b; a=1, b=2; 3");
        testes.add("3.14 * (z + 1);;3.14");
        String caminho = new File(Main.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI().getPath())
                .getParent();
        Path file = Paths.get(caminho + "/teste.txt");
        Files.write(file, testes, Charset.forName("UTF-8"));

        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{caminho + "/teste.txt", "json"});
        Files.delete(file);
    }

    @Test
    public void testMainArgLink() throws Exception {
        exit.expectSystemExitWithStatus(0);
        Main.main(new String[]{"https://raw.githubusercontent.com"
            + "/saulocalixto/cs20162-aula12/master/testes.txt"});

    }

    @Test
    public void testVazio() throws Exception {
        List<String> testes = new ArrayList<>();
        testes.clear();
        String caminho = new File(Main.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI().getPath())
                .getParent();
        Path file = Paths.get(caminho + "/teste.txt");
        Files.write(file, testes, Charset.forName("UTF-8"));

        exit.expectSystemExitWithStatus(0);
        Main.main(new String[]{caminho + "/teste.txt"});
        Files.delete(file);
        file = Paths.get(caminho + "/qp.json");
    }

    @Test
    public void testResultadosDiferentes() throws Exception {
        List<String> testes = new ArrayList<>();
        testes.add("a + b; a=1, b=2; 5");
        testes.add("3.14 * (z + 1);;3.14");
        String caminho = new File(Main.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI().getPath())
                .getParent();
        Path file = Paths.get(caminho + "/teste.txt");
        Files.write(file, testes, Charset.forName("UTF-8"));

        exit.expectSystemExitWithStatus(0);
        Main.main(new String[]{caminho + "/teste.txt"});
        Files.delete(file);
        file = Paths.get(caminho + "/qp.json");
    }

    @Test
    public void ExprMalFormada() throws Exception {
        List<String> testes = new ArrayList<>();
        testes.add("a + b; a=1, b=2; 3");
        testes.add("//3.14 * (z + 1);;3.14");
        String caminho = new File(Main.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI().getPath())
                .getParent();
        Path file = Paths.get(caminho + "/teste.txt");
        Files.write(file, testes, Charset.forName("UTF-8"));

        exit.expectSystemExitWithStatus(0);
        Main.main(new String[]{caminho + "/teste.txt", "-h"});
        Files.delete(file);
        file = Paths.get(caminho + "/qp.html");
    }

    @Test
    public void testMainCriaJSONNExist() throws Exception {
        List<String> testes = new ArrayList<>();
        testes.add("a + b; a=1, b=2; 3");
        testes.add("3.14 * (z + 1);;3.14");
        String caminho = new File(Main.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI().getPath())
                .getParent();
        Path file = Paths.get(caminho + "/teste.txt");
        Files.write(file, testes, Charset.forName("UTF-8"));

        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{caminho + "/blá.txt"});
        Files.delete(file);
        file = Paths.get(caminho + "/qp.json");
    }
    
    @Test
    public void mainConstrutor() {
        Main main = new Main();
        Assert.assertNotNull(main);
    }
}
