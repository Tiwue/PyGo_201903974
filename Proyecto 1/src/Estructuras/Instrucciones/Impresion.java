/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

/**
 *
 * @author steve
 */
public class Impresion implements Instruccion {

    private Operacion expresion;
    private Tipo_print tipo;

    public static enum Tipo_print {
        PRINT,
        PRINTLN
    }

    public Impresion(Operacion expresion, Tipo_print tipo) {
        this.expresion = expresion;
        this.tipo = tipo;
    }

    @Override
    public String traducirPython(int tabulaciones) {
        String traduccion = "";
        String tabs = "";
        for (int i = 0; i < tabulaciones; i++) {
            tabs += "    ";
        }
        traduccion += tabs;

        traduccion += "print(";

        traduccion += this.expresion.traducirPython(0) + " )";
        return traduccion + "\n";

    }

    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
