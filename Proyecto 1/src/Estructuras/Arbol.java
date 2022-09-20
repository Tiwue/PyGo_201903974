/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    
    public void graficar() throws IOException{
        FileWriter archivo = null;
        PrintWriter writter = null;
        StringBuilder s = new StringBuilder();
        s.append("digraph G{\n");
        s.append("\"Nodo").append(raiz.hashCode()).append("\" [ label = \"").append(raiz.getValor()).append("\",];\n");
        graficar(raiz, s);
        s.append("}");
        
       
       try{
                archivo = new FileWriter("./Reportes\\ARBOL_201903974\\ARBOL.dot");
                writter = new PrintWriter(archivo);
                writter.println(s.toString());
            }catch (Exception e){
                System.out.println("No se pudo generar el archivo...");
                e.printStackTrace();
            }finally{
                try{
                    if(archivo != null){
                        archivo.close();
                    }
                }catch(Exception e2){
                    e2.printStackTrace();
                }
    }
    
       String comando = "dot";
            
            String rutaDot = "./Reportes\\ARBOL_201903974\\ARBOL.dot";
            String rutaPNG = "./Reportes\\ARBOL_201903974\\ARBOL.jpg";
            
            String tParam = "-Tjpg";
            String tOParam = "-o";
            
            String[] cmd = new String[5];
            cmd[0] = comando;
            cmd[1] = tParam;
            cmd[2] = rutaDot;
            cmd[3] = tOParam;
            cmd[4] = rutaPNG;
            
            Runtime rt = Runtime.getRuntime();
            
            rt.exec( cmd );
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
