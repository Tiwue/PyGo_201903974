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
    public String traducirPython() {
       String cadena = "";
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
               cadena += valores.traducirPython();
           }else{
               cadena += valores.traducirPython() + ", ";
           }       
       }
       return cadena+"\n";
    }

    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
