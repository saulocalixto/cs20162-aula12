/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.parsen;


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
}
