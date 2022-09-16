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
    public String traducirPython() {
       return "estamos evaluando (" + valor.traducirPython()+ ")\n";
    }

    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
