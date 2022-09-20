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
    private LinkedList<Instruccion> parametros;
    
    public Llamada(String nombre ){
    this.nombre = nombre;
    }
    
    public Llamada(String nombre,LinkedList<Instruccion> parametros ){
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
            for(int i = 0;i<parametros.size();i++){
                if (i == parametros.size()-1){
                 traduccion += parametros.get(i).traducirPython(0);
                }else{
                 traduccion += parametros.get(i).traducirPython(0)+", ";
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
            for(int i = 0;i<parametros.size();i++){
                if (i == parametros.size()-1){
                 traduccion += parametros.get(i).traducirGo(0);
                }else{
                 traduccion += parametros.get(i).traducirGo(0)+", ";
                }
            }
        }
        traduccion +=")\n";
        return traduccion;
    }
    
    
}
