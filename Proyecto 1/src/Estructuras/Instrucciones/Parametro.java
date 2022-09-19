/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

/**
 *
 * @author steve
 */
public class Parametro implements Instruccion {
    private Object nombre;
    private Tipo_dato tipo; 
    
    public Parametro(String nombre, Tipo_dato tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
            
    public static enum Tipo_dato{
        NUMERO,
        CADENA,
        BOOLEAN,
        CARACTER
    }
    @Override
    public String traducirPython(int tabulaciones) {
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        traduccion += this.nombre.toString();
            
        return traduccion;    
    }

    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
