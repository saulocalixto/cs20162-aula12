package com.github.saulocalixto.parsen;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author saulocalixto
 */
public class CarregaTest {

    /**
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testLerArquivo() throws FileNotFoundException {
        String str = "primeira\nsegunda\nterceira\n";
        InputStream is = new ByteArrayInputStream(str.getBytes());
        InputStreamReader isr = new InputStreamReader(is);

        BufferedReader br = new BufferedReader(isr);

        List<String> testes = Carrega.testes(br);
        assertEquals(3, testes.size());
        assertEquals("primeira", testes.get(0));
        assertEquals("segunda", testes.get(1));
        assertEquals("terceira", testes.get(2));
    }

    /**
     *
     */
    @Test
    public void identificaUrlCorretamente() {
        assertTrue(Carrega.isUrl("http://cnn.com"));
        assertFalse(Carrega.isUrl("x.txt"));
    }
}
