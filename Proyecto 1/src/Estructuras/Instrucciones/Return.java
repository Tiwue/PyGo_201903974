/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

/**
 *
 * @author steve
 */
public class Return implements Instruccion{

    private Instruccion condicion;
    private Operacion valor;
    
    public Return(Instruccion condicion){
    
        this.condicion = condicion;
    }
    
    public Return (Operacion valor){
    this.valor = valor;
    }
    
    
    @Override
    public String traducirPython(int tabulaciones) {
        String traduccion="";
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        if(this.condicion != null){
            traduccion += tabs + "return " + this.condicion.traducirPython(0) +"\n";
        }else if(this.valor != null){
            traduccion += tabs + "return " + this.valor.traducirPython(0) +"\n";
        }    
           
            
        return traduccion+"\n";    
    }

    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
