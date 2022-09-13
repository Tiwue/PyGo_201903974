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
public class Arbol {
    private Nodo raiz;

    public Arbol() {
    }

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }    
    
    public void graficar(){
        StringBuilder s = new StringBuilder();
        s.append("digraph G{\n");
        s.append("\"Nodo").append(raiz.hashCode()).append("\" [ label = \"").append(raiz.getValor()).append("\",];\n");
        graficar(raiz, s);
        s.append("}");
        System.out.println(s.toString());
    }
    
    public void graficar(Nodo raiz, StringBuilder s){        
        LinkedList<Nodo> hijos = raiz.getHijos();
        if(hijos != null){
            for(Nodo hijo: hijos){
                s.append("\"Nodo").append(hijo.hashCode()).append("\" [ label = \"").append(hijo.getValor()).append("\",];\n");
                graficar(hijo, s);
                s.append("\"Nodo").append(raiz.hashCode()).append("\" -> \"Nodo").append(hijo.hashCode()).append("\" [ label = \"\",];\n");
            }
        }
    }
}
