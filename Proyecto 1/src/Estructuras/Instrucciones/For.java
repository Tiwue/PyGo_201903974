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
public class For implements Instruccion{
    private Operacion variable;
    private Operacion Val_inicial;
    private Operacion Val_final;
    private Operacion salto=null;
    
    private final LinkedList<Instruccion> listaInstrucciones;
    
    public For(Operacion variable, Operacion inicial, Operacion finaly, LinkedList<Instruccion> listaInstrucciones ){
     this.Val_final = finaly;
     this.listaInstrucciones = listaInstrucciones;
     this.Val_inicial = inicial;
     this.variable = variable;
    }
    public For(Operacion variable, Operacion inicial, Operacion finaly, LinkedList<Instruccion> listaInstrucciones, Operacion salto ){
     this.Val_final = finaly;
     this.listaInstrucciones = listaInstrucciones;
     this.Val_inicial = inicial;
     this.salto = salto;
     this.variable = variable;
    }
    
    @Override
    public String traducirPython(int tabulaciones) {
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        traduccion += tabs;
        if(this.salto != null){
            traduccion += "for " + this.variable.traducirPython(0) + " in range( "+Val_inicial.traducirPython(0) + ", "+ Val_final.traducirPython(0)+", "+ salto.traducirPython(0)+"):\n";  
        }else{
            traduccion += "for " + this.variable.traducirPython(0) + " in range( "+Val_inicial.traducirPython(0) + ", "+ Val_final.traducirPython(0)+"):\n";
        } 
        if(listaInstrucciones != null)
            for(Instruccion ins: listaInstrucciones){
                traduccion += ins.traducirPython(tabulaciones + 1);
            }
            
             
            
        return traduccion+"\n";    
    }

    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
