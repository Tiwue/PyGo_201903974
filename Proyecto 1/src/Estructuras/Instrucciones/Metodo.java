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
public class Metodo implements Instruccion{
    
    private Object nombre;
    private LinkedList<Instruccion> listaInstrucciones;
    private LinkedList<Instruccion> listaParametros;
    private boolean traducir = false;
   
    public Metodo(String nombre, LinkedList<Instruccion> listaInstrucciones , boolean traducir){
    this.nombre = nombre;
    this.listaInstrucciones = listaInstrucciones;
    this.traducir = traducir;
    }
    
    public Metodo(String nombre, LinkedList<Instruccion> listaParametros, LinkedList<Instruccion> listaInstrucciones , boolean traducir){
    this.nombre = nombre;
    this.listaInstrucciones = listaInstrucciones;
    this.listaParametros = listaParametros;
    this.traducir = traducir;
    }
    
    @Override
    public String traducirPython(int tabulaciones) {
        String traduccion="";
        
        if(traducir){
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        traduccion += tabs + "def " + this.nombre.toString() +"(";
        if(listaParametros != null){
            for(int i = 0;i<listaParametros.size();i++){
                if (i == listaParametros.size()-1){
                 traduccion += listaParametros.get(i).traducirPython(0);
                }else{
                 traduccion += listaParametros.get(i).traducirPython(0)+", ";
                }
            }
                
           
        }
        traduccion +="):\n";
        for(Instruccion ins: listaInstrucciones){
                traduccion += ins.traducirPython(tabulaciones+1);
            }
        }
        
        return traduccion;
    }

    @Override
    public String traducirGo(int tabulaciones) {
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        if(traducir){
        
        traduccion += tabs + "func " + this.nombre.toString() +"(";
        if(listaParametros != null){
            for(int i = 0;i<listaParametros.size();i++){
                if (i == listaParametros.size()-1){
                 traduccion += listaParametros.get(i).traducirGo(0);
                }else{
                 traduccion += listaParametros.get(i).traducirGo(0)+", ";
                }
            }
                
           
        }
        traduccion +="){\n";
        for(Instruccion ins: listaInstrucciones){
                traduccion += ins.traducirGo(tabulaciones+1);
            }
        traduccion += tabs + "}";
        }
        
        
        return traduccion+"\n";
    }
    
}
