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
public class While implements Instruccion{
    /**
     * Condición de la sentencia mientras.
     */
    private final Operacion condicion;
    /**
     * Lista de las instrucciones que deben ejecutarse si la condición se cumple.
     */
    private final LinkedList<Instruccion> listaInstrucciones;
    /**
     * Constructor de la clase Mientras
     * @param a condición que debe evaluarse para ejecutar el ciclo
     * @param b instrucciones que deben ejecutarse si la condición se cumpliera
     */
    public While(Operacion a, LinkedList<Instruccion> b) {
        this.condicion=a;
        this.listaInstrucciones=b;
    }
    /**
     * Método que ejecuta la instrucción mientras, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia
     * @return Esta instrucción retorna nulo porque no produce ningun valor
     */
   

    @Override
    public String traducirPython(int tabulaciones) {
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        
        traduccion += tabs + "while "+condicion.traducirPython(0)+":\n";
        for(Instruccion ins:listaInstrucciones){
            traduccion +=ins.traducirPython(tabulaciones + 1);
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
        traduccion += tabs +"for true {\n"+tabs+"    if !("+condicion.traducirGo(0)+"){\n"+ tabs+"    "+"break\n"+tabs+"    }\n";
        for(Instruccion ins:listaInstrucciones){
            traduccion +=ins.traducirGo(tabulaciones + 1);
        }
        traduccion += tabs +"}";
        
        return traduccion + "\n";
    }
}
