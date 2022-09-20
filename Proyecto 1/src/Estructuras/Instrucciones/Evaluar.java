/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

/**
 *
 * @author steve
 */
public class Evaluar implements Instruccion{
    
     private Operacion valor;

    public Evaluar(Operacion valor) {
        this.valor = valor;
    }   

 

    @Override
    public String traducirPython(int tabulaciones) {
       return "estamos evaluando (" + valor.traducirPython(0)+ ")\n";
    }

    @Override
    public String traducirGo(int tabulaciones) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
