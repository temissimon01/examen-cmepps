/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package com.mycompany.examencmepps;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author temis
 */
public class regresionLinealTest extends TestCase {
    
    public regresionLinealTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testRegresionLineal() {
        // TODO review the generated test code and remove the default call to fail.
        regresionLineal rl = new regresionLineal(new ArrayList<>());
        assertEquals(rl.RegresionLineal(0), 0.0f);
    }
    
}
