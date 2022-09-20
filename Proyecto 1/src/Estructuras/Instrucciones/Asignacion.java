/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

/**
 *
 * @author steve
 */
public class Asignacion implements Instruccion {
    
    private final String listaNombresVariables;
    private Operacion valores;
    
    public Asignacion(String nombres, Operacion valores){
       this.listaNombresVariables = nombres;
       this.valores = valores;
    }

    @Override
    public String traducirPython(int tabulaciones) {
       String cadena = "";
       String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
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
    public String traducirGo(int tabulaciones) {
        String cadena = "";
       String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
            
       String[] nombres = listaNombresVariables.split(",");
       for(int i=0;i<nombres.length;i++){
          cadena +=tabs+ nombres[i] +" = "+valores.traducirGo(0)+"\n";
       }
       return cadena+"\n";
    }
}
