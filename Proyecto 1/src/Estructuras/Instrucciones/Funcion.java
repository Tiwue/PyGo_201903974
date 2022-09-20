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
public class Funcion implements Instruccion {
     private Object nombre;
     private Tipo_dato tipo;
    private LinkedList<Instruccion> listaInstrucciones;
    private LinkedList<Instruccion> listaParametros;
    private boolean traducir = false;
    public static enum Tipo_dato{
        NUMERO,
        CADENA,
        BOOLEAN,
        CARACTER
    }
    public Funcion(String nombre, Tipo_dato tipo,LinkedList<Instruccion> listaInstrucciones, boolean traducir ){
    this.nombre = nombre;
    this.listaInstrucciones = listaInstrucciones;
    this.tipo = tipo;
    this.traducir = traducir;

    }
    
    public Funcion(String nombre, Tipo_dato tipo,LinkedList<Instruccion> listaParametros, LinkedList<Instruccion> listaInstrucciones, boolean traducir ){
    this.nombre = nombre;
    this.listaInstrucciones = listaInstrucciones;
    this.listaParametros = listaParametros;
    this.tipo = tipo;
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
        traduccion += tabs + "def " + this.nombre.toString();
        traduccion+="(";
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
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

