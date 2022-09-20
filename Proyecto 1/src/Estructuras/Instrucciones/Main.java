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
    public static LinkedList<Instruccion> listaFunyMet;
    
    public Main(LinkedList<Instruccion> listaInstrucciones){
    this.listaInstrucciones = listaInstrucciones;
    }
    
    public void addFunyMet(Instruccion instruccion){
         this.listaFunyMet.add(instruccion);
    }
    
    @Override
    public String traducirPython(int tabulaciones) {
        String cadena = "";
        cadena += "def main():\n";
        for(Instruccion ins: listaInstrucciones){
                cadena += ins.traducirPython(tabulaciones+1);
            }
        cadena +="\nif __name__ =='__main__':\n    main()";
        return cadena+"\n";
    }

    @Override
    public String traducirGo(int tabulaciones) {
       String cadena = "";
        cadena += "func main(){\n";
        for(Instruccion ins: listaInstrucciones){
                cadena += ins.traducirGo(tabulaciones+1);
            }
        cadena +="}";
        
        return cadena+"\n";
    }
    
}
