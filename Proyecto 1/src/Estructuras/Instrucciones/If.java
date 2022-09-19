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
    
    public static enum Tipo_if{
    IF,
    ELIF
    }
    private final Operacion condicion;
    private Tipo_if tipo;

    public void setTipo(Tipo_if tipo) {
        this.tipo = tipo;
    }
    
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
     * @param tipo
     */
    public If(Operacion a, LinkedList<Instruccion> b, Tipo_if tipo) {
        condicion=a;
        listaInstrucciones=b;
        this.tipo = tipo;
    }
    /**
     * Segundo constructor de la clase, este se utiliza cuando la instrucción tiene
     * clausula ELSE.
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición se cumple
     * @param c Lista de instrucciones que deberían ejecutarse si la condición no se cumple
     * @param tipo
     */
    public If(Operacion a, LinkedList<Instruccion> b, LinkedList<Instruccion> c,Tipo_if tipo) {
        condicion=a;
        listaInstrucciones=b;
        listaInsElse=c;
        this.tipo = tipo;
    }
    /**
     * Tercer constructor de la clase, este se utiliza cuando la instrucción tiene
     * clausula IF (ELSE IF/ ELSE).
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición se cumple
     * @param l Lista de instrucciones que deberían ejecutarse si la condición ElSE IF se cumple
     * @param c Lista de instrucciones que deberían ejecutarse si la condición no se cumple
     * @param tipo
     */
    public If(Operacion a, LinkedList<Instruccion> b, LinkedList<Instruccion> l, LinkedList<Instruccion> c,Tipo_if tipo) {
        condicion=a;
        listaInstrucciones=b;
        listaElseIfInstrucciones = l;
        listaInsElse=c;
        this.tipo = tipo;
    }
    /**
     * Método que ejecuta la instrucción si..entonces, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @return Estra instrucción retorna nulo porque no produce ningún valor en 
     * su ejecución
     */
 

    @Override
    public String traducirPython(int tabulaciones) {
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        
        if(this.tipo == Tipo_if.IF){
             traduccion += tabs + "if "+this.condicion.traducirPython(0)+":\n";
        }else if(this.tipo == Tipo_if.ELIF){
             traduccion += tabs + "elif "+this.condicion.traducirPython(0)+":\n";
        }
        
        if(listaInstrucciones != null)
            for(Instruccion ins: listaInstrucciones){
                traduccion += ins.traducirPython(tabulaciones + 1);
            }
        if(listaElseIfInstrucciones != null){
            
            for(Instruccion ins: listaElseIfInstrucciones){
                traduccion +=  ins.traducirPython(tabulaciones);
            }
        }
        if(listaInsElse != null){
            traduccion += tabs + "else: \n";
            for(Instruccion ins: listaInsElse){
                traduccion += ins.traducirPython(tabulaciones + 1);
            }
        }
        return traduccion+"\n";
    }

    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
