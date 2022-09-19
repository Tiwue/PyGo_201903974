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
public class Main implements Instruccion {

    private final LinkedList<Instruccion> listaInstrucciones;
    
    public Main (LinkedList<Instruccion> listaInstrucciones){
    this.listaInstrucciones = listaInstrucciones;
    }
    
    
    @Override
    public String traducirPython(int tabulaciones) {
        String cadena = "";
        cadena += "def main():\n";
        for(Instruccion ins: listaInstrucciones){
                cadena += ins.traducirPython(tabulaciones+1);
            }
        cadena +="\nif __name__ =='__main__':\n\tmain()";
        return cadena;
    }

    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
