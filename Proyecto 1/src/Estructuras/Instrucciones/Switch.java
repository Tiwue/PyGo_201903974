/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

import Estructuras.listaErrores;
import java.util.LinkedList;

/**
 *
 * @author steve
 */
public class Switch implements Instruccion{
    
    private final Operacion condicion;
    
    private boolean inicio;
    
    private LinkedList<Instruccion> listaCasesInstrucciones;
    
    private LinkedList<Instruccion> listaInsElse;
    
    public Switch(Operacion condicion, LinkedList<Instruccion> listacases ){
        this.inicio = false;
        
        this.condicion = condicion;
        this.listaCasesInstrucciones = listacases;
    }
    
    public Switch(Operacion condicion, LinkedList<Instruccion> listacases, LinkedList<Instruccion> listaInsElse  ){
        this.inicio = false;
        this.condicion = condicion;
        this.listaCasesInstrucciones = listacases;
        this.listaInsElse = listaInsElse;
    }
    
    

    @Override
    public String traducirPython(int tabulaciones) {
        
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            } 
      
        if(listaCasesInstrucciones != null){
           for(Instruccion ins: listaCasesInstrucciones){
                if(this.inicio==false){
                traduccion += tabs + "if "+ this.condicion.traducirPython(0) + " == "+ins.traducirPython(tabulaciones + 1);
                this.inicio=true;
                }else if(this.inicio==true){
                traduccion += tabs + "elif "+ this.condicion.traducirPython(0) + " == "+ ins.traducirPython(tabulaciones + 1);
                }
                
            }
        }
            
        this.inicio=false;
        if(listaInsElse != null){
            traduccion += tabs+ "else: \n";
            for(Instruccion ins: listaInsElse){
                traduccion += ins.traducirPython(tabulaciones + 1);
            }
        }
        return traduccion+"\n";      
    }

    @Override
    public String traducirGo(int tabulaciones) {
         String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            } 
        traduccion += tabs +"switch" + this.condicion.traducirGo(0)+" {";
        if(listaCasesInstrucciones != null){
           for(Instruccion ins: listaCasesInstrucciones){
                traduccion += tabs +"    case "+ins.traducirGo(0);
            }
        }
        if(listaInsElse != null){
            traduccion += tabs+ "    default: \n";
            for(Instruccion ins: listaInsElse){
                traduccion += ins.traducirGo(tabulaciones + 1);
            }
        }
        traduccion += tabs+"}";
        return traduccion;
    }
        
}
