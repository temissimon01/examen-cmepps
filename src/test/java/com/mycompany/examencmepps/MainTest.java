/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package com.mycompany.examencmepps;

import junit.framework.TestCase;

/**
 *
 * @author temis
 */
public class MainTest extends TestCase {
    
    public MainTest(String testName) {
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

    /**
     * Test of main method, of class Main.
     */
    public void testGetInputValuesInvalid(){
        Main main = new Main();
        
        Object[] values = main.getInputValues();
        
        for(int i = 0; i < values.length; i++){
            if(values[i] == null){
                fail("Invalid input value, is null");
            }
        }
        
        int Tamaño_estimado_en_puntos_historia = (Integer)values[0];; 
        int Sprints_realizados = (Integer)values[1];
        int Velocidad = (Integer)values[2];
        String Arquitectura = (String)values[3];
        int Complejidad_ciclomática = (Integer)values[4];
        int WMC = (Integer)values[5];
        int Defectos = (Integer)values[6];
        float Esfuerzo = (Float)values[7];
        
        
        assertTrue(Tamaño_estimado_en_puntos_historia > 0 && Tamaño_estimado_en_puntos_historia < 10000);
        assertTrue(Sprints_realizados > 0 && Sprints_realizados < 10000);
        assertTrue(Velocidad > 0 && Velocidad < 10000);
        assertTrue("Web App".equals(Arquitectura) || "J2EE".equals(Arquitectura));
        assertTrue(WMC > 0 && WMC < 10000);
        assertTrue(Defectos >= 0 && Defectos < 10000);
        assertTrue(Esfuerzo > 1 && Esfuerzo < 10000);
    }
    
    public void testGetInputValuesValid(){
        Main main = new Main();
        
        main.getjTextField1().setText("100");
        main.getjTextField2().setText("100");
        main.getjTextField3().setText("100");
        main.getjTextField4().setText("J2EE");
        main.getjTextField5().setText("100");
        main.getjTextField6().setText("100");
        main.getjTextField7().setText("100");
        main.getjTextField8().setText("100.0");
        
        Object[] values = main.getInputValues();
        
        for(int i = 0; i < values.length; i++){
            if(values[i] == null){
                fail("Invalid input value, is null");
            }
        }
        
        int Tamaño_estimado_en_puntos_historia = (Integer)values[0];; 
        int Sprints_realizados = (Integer)values[1];
        int Velocidad = (Integer)values[2];
        String Arquitectura = (String)values[3];
        int Complejidad_ciclomática = (Integer)values[4];
        int WMC = (Integer)values[5];
        int Defectos = (Integer)values[6];
        float Esfuerzo = (Float)values[7];
        
        
        assertTrue(Tamaño_estimado_en_puntos_historia > 0 && Tamaño_estimado_en_puntos_historia < 10000);
        assertTrue(Sprints_realizados > 0 && Sprints_realizados < 10000);
        assertTrue(Velocidad > 0 && Velocidad < 10000);
        assertTrue("Web App".equals(Arquitectura) || "J2EE".equals(Arquitectura));
        assertTrue(WMC > 0 && WMC < 10000);
        assertTrue(Defectos >= 0 && Defectos < 10000);
        assertTrue(Esfuerzo > 1 && Esfuerzo < 10000);
    }
}
