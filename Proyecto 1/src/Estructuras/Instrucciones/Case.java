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
public class Case implements Instruccion{

    private final Operacion condicion;
    
    
    private LinkedList<Instruccion> listaInstrucciones;
    
    public Case(Operacion condicion, LinkedList<Instruccion> listaInstrucciones ){
        
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
    }
    
    
    
@Override
    public String traducirPython(int tabulaciones) {
        String traduccion = "";
        traduccion += this.condicion.traducirPython(0)+":\n";
        for(Instruccion ins: listaInstrucciones){
                traduccion += ins.traducirPython(tabulaciones);
            }
        traduccion += "\n";
        return traduccion;
    }
    
    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
