/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Estructuras.Instrucciones.Instruccion;
import java.util.LinkedList;

/**
 *
 * @author steve
 */
public class Produccion {
     private Nodo nodo;
    private Instruccion ins;
    private LinkedList<Instruccion> instructions;

    public Produccion() {
    }    

    public Produccion(Nodo nodo, Instruccion ins) {
        this.nodo = nodo;
        this.ins = ins;
    }
    
    public Produccion(Nodo nodo, LinkedList<Instruccion> ins) {
        this.nodo = nodo;
        this.instructions = ins;
    }

    public LinkedList<Instruccion> getInstructions() {
        return instructions;
    }

    public void setInstructions(LinkedList<Instruccion> instructions) {
        this.instructions = instructions;
    }   
    
    public void addIns(Instruccion ins){
        this.instructions.add(ins);
    }

    public void addSon(String valor){
        this.nodo.addSon(valor);
    }
    
    public void addSon(Produccion valor){
        
        this.nodo.addSon(valor.getNode());
    
    }
    
    public void addSons(Produccion valor){
          LinkedList<Nodo> hijos = valor.getSons();
        if(hijos!=null){
        for(Nodo hijo:hijos){
        this.nodo.addSon(hijo);
        }
        }else{
        this.nodo.addSon(valor.getNode());
         
    }
    }
    
   
    
    public Nodo getNode() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }
    
    public LinkedList<Nodo> getSons(){
       return this.nodo.getHijos();
    }

    public Instruccion getIns() {
        return ins;
    }

    public void setIns(Instruccion ins) {
        this.ins = ins;
    }
}
