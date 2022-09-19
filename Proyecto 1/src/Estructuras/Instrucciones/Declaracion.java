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
public class Declaracion implements Instruccion {
    
    public static enum Tipo_dato{
        NUMERO,
        CADENA,
        BOOLEAN,
        CARACTER
    }
    
    private Tipo_dato tipo;
    
    private final String listaNombresVariables;
    private Operacion valores;
    
   public Declaracion( String nombres, Tipo_dato tipo, Operacion valor){
     this.tipo = tipo;
     this.listaNombresVariables = nombres;
     this.valores = valor;
   }
   
   public Declaracion( String nombres, Tipo_dato tipo){
     this.tipo = tipo;
     this.listaNombresVariables = nombres;
   }
   
   
   
    @Override
    public String traducirPython(int tabulaciones) {
        
       String cadena = "";
       String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "\t";
            }
        cadena += tabs; 
       String[] nombres = listaNombresVariables.split(",");
       for(int i=0;i<nombres.length;i++){
           if(i==nombres.length-1){
               cadena += nombres[i];
           }else{
               cadena += nombres[i] + ", ";
           }
       }
       cadena +=" = ";
       for (int i=0;i<nombres.length;i++ ){
           if(i==nombres.length-1){
               cadena += valores.traducirPython(0);
           }else{
               cadena += valores.traducirPython(0) + ", ";
           }       
       }
       return cadena+"\n";
    }

    @Override
    public String traducirGo() {
        return "";
    }
    
}
