/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examencmepps;

/**
 *
 * @author temis
 */
public class RegisterEntry {
    int Proyecto_id;
    int Tamaño_estimado_en_puntos_historia; 
    int Sprints_realizados;
    int Velocidad;
    String Arquitectura; 
    int Complejidad_ciclomática;
    int WMC;
    int Defectos;
    float Esfuerzo;
    
    public RegisterEntry(
            int Proyecto_id,
            int Tamaño_estimado_en_puntos_historia, 
            int Sprints_realizados,
            int Velocidad,
            String Arquitectura, 
            int Complejidad_ciclomática,
            int WMC,
            int Defectos,
            float Esfuerzo
        ){
        this.Proyecto_id = Proyecto_id;
        this.Tamaño_estimado_en_puntos_historia = Tamaño_estimado_en_puntos_historia; 
        this.Sprints_realizados = Sprints_realizados;
        this.Velocidad = Velocidad;
        this.Arquitectura = Arquitectura; 
        this.Complejidad_ciclomática = Complejidad_ciclomática;
        this.WMC = WMC;
        this.Defectos = Defectos;
        this.Esfuerzo = Esfuerzo;
    }
    
    public Object[] getValues(){
        Object[] values = new Object[9];
        
        values[0] = Proyecto_id;
        values[1] = Tamaño_estimado_en_puntos_historia; 
        values[2] = Sprints_realizados;
        values[3] = Velocidad;
        values[4] = Arquitectura; 
        values[5] = Complejidad_ciclomática;
        values[6] = WMC;
        values[7] = Defectos;
        values[8] = Esfuerzo;
        
        return values;
    }
}
