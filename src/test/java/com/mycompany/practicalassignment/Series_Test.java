/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.practicalassignment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author uriel
 */
public class Series_Test {
    
    public Series_Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of StartUp method, of class Series_.
     */
    @Test
    public void testStartUp() {
        System.out.println("StartUp");
        Series_ instance = new Series_();
        int expResult = 0;
        int result = instance.StartUp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CaptureSeries method, of class Series_.
     */
    @Test
    public void testCaptureSeries() {
        System.out.println("CaptureSeries");
        Series_ instance = new Series_();
        instance.CaptureSeries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SearchSeries method, of class Series_.
     */
    @Test
    public void testSearchSeries() {
        System.out.println("SearchSeries");
        Series_ instance = new Series_();
        instance.SearchSeries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateSeries method, of class Series_.
     */
    @Test
    public void testUpdateSeries() {
        System.out.println("UpdateSeries");
        Series_.UpdateSeries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeleteSeries method, of class Series_.
     */
    @Test
    public void testDeleteSeries() {
        System.out.println("DeleteSeries");
        Series_ instance = new Series_();
        instance.DeleteSeries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DisplaySeriesReport method, of class Series_.
     */
    @Test
    public void testDisplaySeriesReport() {
        System.out.println("DisplaySeriesReport");
        Series_ instance = new Series_();
        instance.DisplaySeriesReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
