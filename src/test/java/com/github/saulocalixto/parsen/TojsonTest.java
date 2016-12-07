/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;

import static com.github.saulocalixto.parsen.Tojson.criarJson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author saulocalixto
 */
public class TojsonTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void chamarConstrutor() {
        Tojson json = new Tojson();
        Assert.assertNotNull(json);
    }

    @Test()
    public void ErroLeitura() throws IOException {
        Tojson.writer("c:/saulo.txt");
    }

    @Test(expected = Exception.class)
    public void ErroLeitura2() throws FileNotFoundException, IOException {
        
        Writer writeFile = null;
        writeFile = new FileWriter("asdf");
        criarJson(writeFile);

        Tojson.criarJson(writeFile);
    }
    }
