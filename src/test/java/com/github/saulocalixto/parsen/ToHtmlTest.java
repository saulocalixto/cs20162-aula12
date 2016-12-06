///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.github.saulocalixto.parsen;
//
//import com.google.common.collect.Lists;
//import java.io.IOException;
//import java.io.StringWriter;
//import java.util.List;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author saulocalixto
// */
//public class ToHtmlTest {
//
//    public ToHtmlTest() {
//    }
//
//    /**
//     * Test of write method, of class ToHtml.
//     */
//    @Test
//    public void testWrite() throws IOException {
//        List<String> list = Lists.newArrayList();
//        ToHtml html = new ToHtml();
//        list.add("A.");
//        list.add("B.");
//        list.add("C."); 
//        StringWriter stringWriter = new StringWriter();
//        html.write(stringWriter, list);
//        assertEquals("A.\nB.\nC.\n", stringWriter.toString());
//        stringWriter.close();
//    }
//    
//        @Test
//    public void testcorpoHtml() throws IOException {
//        List<String> list = Lists.newArrayList();
//        list.add("A.");
//        list.add("B.");
//        list.add("C."); 
//        assertNotEquals("A.\nB.\nC.\n", ToHtml.corpoHtml());
//    }
//
//}
