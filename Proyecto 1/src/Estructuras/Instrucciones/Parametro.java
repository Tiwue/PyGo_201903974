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
    private Operacion nombre;
    private Tipo_dato tipo; 
    
    public Parametro(Operacion nombre, Tipo_dato tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
            
    public static enum Tipo_dato{
        NUMERO,
        FLOAT,
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
        traduccion += this.nombre.traducirPython(0);
            
        return traduccion;    
    }

    @Override
    public String traducirGo(int tabulaciones) {
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        traduccion += this.nombre.traducirGo(0) ;
        if(tipo ==Tipo_dato.NUMERO){
       traduccion += " int";
       }else if(tipo ==Tipo_dato.FLOAT){
       traduccion += " float64";
       }
       else if(tipo ==Tipo_dato.CADENA){
       traduccion += " string";
       }else if(tipo ==Tipo_dato.FLOAT){
       traduccion += " byte";
       }else if(tipo ==Tipo_dato.FLOAT){
       traduccion += " bool";
       }    
        return traduccion;  
    }
    
}
