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
public class If implements Instruccion{
    private final Operacion condicion;
    /**
     * Lista de instrucciones que serán ejecutadas si la condición se cumple.
     */
    private final LinkedList<Instruccion> listaInstrucciones;
    /**
     * Lista de instrucciones que serán ejecutadas si la condición ELSE IF se cumple.
     */
    private LinkedList<Instruccion> listaElseIfInstrucciones;
    /**
     * Lista de instrucciones que se ejecutarán si la condición no se cumple,
     * esta lista existirá solo si la instrucción posee la clausula ELSE, de lo
     * contrario la lista será null.
     */
    private LinkedList<Instruccion> listaInsElse;
    /**
     * Primer constructor de la clase, este se utiliza cuando la instrucción no 
     * tiene clausula ELSE.
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición se cumple
     */
    public If(Operacion a, LinkedList<Instruccion> b) {
        condicion=a;
        listaInstrucciones=b;
    }
    /**
     * Segundo constructor de la clase, este se utiliza cuando la instrucción tiene
     * clausula ELSE.
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición se cumple
     * @param c Lista de instrucciones que deberían ejecutarse si la condición no se cumple
     */
    public If(Operacion a, LinkedList<Instruccion> b, LinkedList<Instruccion> c) {
        condicion=a;
        listaInstrucciones=b;
        listaInsElse=c;
    }
    /**
     * Tercer constructor de la clase, este se utiliza cuando la instrucción tiene
     * clausula IF (ELSE IF/ ELSE).
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición se cumple
     * @param l Lista de instrucciones que deberían ejecutarse si la condición ElSE IF se cumple
     * @param c Lista de instrucciones que deberían ejecutarse si la condición no se cumple
     */
    public If(Operacion a, LinkedList<Instruccion> b, LinkedList<Instruccion> l, LinkedList<Instruccion> c) {
        condicion=a;
        listaInstrucciones=b;
        listaElseIfInstrucciones = l;
        listaInsElse=c;
    }
    /**
     * Método que ejecuta la instrucción si..entonces, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia.
     * @return Estra instrucción retorna nulo porque no produce ningún valor en 
     * su ejecución
     */
 

    @Override
    public String traducirPython() {
        String traduccion = "if "+this.condicion.traducirPython()+":\n";
        if(listaInstrucciones != null)
            for(Instruccion ins: listaInstrucciones){
                traduccion += ins.traducirPython();
            }
        if(listaElseIfInstrucciones != null){
            traduccion += "elif:\n";
            for(Instruccion ins: listaElseIfInstrucciones){
                traduccion += ins.traducirPython();
            }
        }
        if(listaInsElse != null){
            traduccion += "else: \n";
            for(Instruccion ins: listaInsElse){
                traduccion += ins.traducirPython();
            }
        }
        return traduccion;
    }

    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
