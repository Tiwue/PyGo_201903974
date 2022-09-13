/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.LinkedList;
/**
 *
 * @author steve
 */
public class Nodo {
    private LinkedList<Nodo> hijos;
    private String valor;

    public Nodo() {
    }
    
    public Nodo(LinkedList<Nodo> hijos, String valor) {
        this.hijos = hijos;
        this.valor = valor;
    }

    public Nodo(String valor) {
        this.valor = valor;
        this.hijos = new LinkedList<Nodo>();
    }    
    
    public void addSon(String valor){
        this.hijos.add(new Nodo(null, valor));
    }
    
     public void addSon(Nodo valor){
        this.hijos.add(valor);
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }   

    public LinkedList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(LinkedList<Nodo> hijos) {
        this.hijos = hijos;
    }
}
