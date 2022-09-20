/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

import java.util.LinkedList;

/**
 *
 * @author steve
 */
public class Llamada implements Instruccion {
    private Object nombre;
    private String parametros;
    
    public Llamada(String nombre ){
    this.nombre = nombre;
    }
    
    public Llamada(String nombre,String parametros ){
    this.nombre = nombre;
    this.parametros = parametros;
    }
    
    @Override
    public String traducirPython(int tabulaciones) {
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        traduccion += tabs + nombre.toString() + " (";
        if(parametros!=null){
         String[] nombres = parametros.split(",");
       for(int i=0;i<nombres.length;i++){
           if(i==nombres.length-1){
               traduccion += nombres[i];
           }else{
               traduccion += nombres[i] + ", ";
           }
       }
        }
        traduccion +=")\n";
        return traduccion;
    }

    @Override
    public String traducirGo(int tabulaciones) {
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        traduccion += tabs + nombre.toString() + " (";
        if(parametros!=null){
         String[] nombres = parametros.split(",");
       for(int i=0;i<nombres.length;i++){
           if(i==nombres.length-1){
               traduccion += nombres[i];
           }else{
               traduccion += nombres[i] + ", ";
           }
       }
        }
        traduccion +=")\n";
        return traduccion;
    }
    
    
}
