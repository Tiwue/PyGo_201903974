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
public class DoWhile implements Instruccion{
    private Operacion condicion;
    private LinkedList<Instruccion> listaInstrucciones;
    
    public DoWhile(Operacion condicion, LinkedList<Instruccion> listaInstrucciones){
    this.condicion = condicion;
    this.listaInstrucciones = listaInstrucciones;
    }
    
    @Override
    public String traducirPython(int tabulaciones) {
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        
        traduccion += tabs + "_valor_ = true\n"+tabs + "while _valor_ == True:\n";
        for(Instruccion ins:listaInstrucciones){
            traduccion +=ins.traducirPython(tabulaciones + 1);
        }
        traduccion += "\n"+tabs+"    "+"if "+this.condicion.traducirPython(0)+" :\n"+tabs+"        break\n";
        return traduccion+"\n";
    }

    @Override
    public String traducirGo(int tabulaciones) {
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        traduccion += tabs +"for true {\n";
        for(Instruccion ins:listaInstrucciones){
            traduccion +=ins.traducirGo(tabulaciones + 1);
        }
        traduccion += "\n"+tabs+"    if ("+condicion.traducirGo(0)+"){\n"+tabs+"        break\n"+tabs+"    }";
        traduccion += tabs +"}";
        
        return traduccion + "\n";
    }
    
}
