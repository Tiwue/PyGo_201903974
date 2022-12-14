/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

/**
 *
 * @author steve
 */
public class Operacion implements Instruccion{

    
      public static enum Tipo_operacion{
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        POTENCIA,
        MODULO,
        PARENTESIS,
        NEGATIVO,
        NUMERO,
        FLOAT,
        CARACTER,
        IDENTIFICADOR,
        CADENA,
        BOOLEAN,
        MAYOR_QUE,
        MENOR_QUE,
        MAYOR_IGUAL_QUE,
        MENOR_IGUAL_QUE,
        IGUAL,
        DIFERENTE,
        OR,
        AND,
        NOT,
        CONCATENACION,
        VARIABLE
    }
    /**
     * Tipo de operación a ejecutar.
     */
    private final Tipo_operacion tipo;
    /**
     * Operador izquierdo de la operación.
     */
    private Operacion operadorIzq;
    /**
     * Operador derecho de la operación.
     */
    private Operacion operadorDer;
    /**
     * Valor específico si se tratara de una literal, es decir un número o una 
     * cadena.
     */
    private Object valor;
    /**
     * Constructor de la clase para operaciones binarias (con dos operadores), estas
     * operaciones son:
     * SUMA, RESTA, MULTIPLICACION, DIVISION, CONCATENACION, MAYOR_QUE, MENOR_QUE
     * @param operadorIzq Operador izquierdo de la operación
     * @param operadorDer Opeardor derecho de la operación
     * @param tipo Tipo de la operación
     */
    public Operacion(Operacion operadorIzq, Operacion operadorDer, Tipo_operacion tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
    }

    public Tipo_operacion getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor.toString();
    }
    
    
    /**
     * Constructor para operaciones unarias (un operador), estas operaciones son:
     * NEGATIVO
     * @param operadorIzq Único operador de la operación
     * @param tipo Tipo de operación
     */
    public Operacion(Operacion operadorIzq, Tipo_operacion tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
    }
    /**
     * Constructor para operaciones unarias (un operador), cuyo operador es 
     * específicamente una cadena, estas operaciones son:
     * IDENTIFICADOR, CADENA , CARACTER
     * @param a Cadena que representa la operación a realizar
     * @param tipo Tipo de operación
     */
    public Operacion(String a, Tipo_operacion tipo) {
        this.valor=a;
        this.tipo = tipo;
    }

    
    @Override
    public String traducirPython(int tabulaciones) {
        
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        /* ======== OPERACIONES ARITMETICAS ======== */
        if(tipo== Tipo_operacion.DIVISION){
            return operadorIzq.traducirPython(tabulaciones)+ " / " + operadorDer.traducirPython(0);
        }else if(tipo== Tipo_operacion.MULTIPLICACION){
            return operadorIzq.traducirPython(tabulaciones)+ " * " + operadorDer.traducirPython(0);
        }else if(tipo== Tipo_operacion.RESTA){
            return operadorIzq.traducirPython(tabulaciones)+ " - " + operadorDer.traducirPython(0);
        }else if(tipo== Tipo_operacion.SUMA){
            return operadorIzq.traducirPython(tabulaciones)+ " + " + operadorDer.traducirPython(0);
        }else if(tipo== Tipo_operacion.NEGATIVO){
            return tabs + "-" + operadorIzq.traducirPython(0);
        }else if(tipo==Tipo_operacion.POTENCIA){
            return operadorIzq.traducirPython(tabulaciones)+ " ** " + operadorDer.traducirPython(0);
        }else if(tipo==Tipo_operacion.MODULO){
            return operadorIzq.traducirPython(tabulaciones) + " % " + operadorDer.traducirPython(0);
        }
        

        
        /* ======== OPERACIONES UNARIOS ======== */
        else if(tipo == Tipo_operacion.NUMERO){
            
            return tabs + valor.toString();
        }else if(tipo == Tipo_operacion.IDENTIFICADOR){
            return tabs + valor.toString();
        }else if(tipo == Tipo_operacion.CADENA){
            String traduccion = valor.toString().replace("\n", "\\n");
            return tabs + "\""+traduccion+"\"";
        }else if(tipo == Tipo_operacion.CARACTER){
            char c='0'; 
            if(this.valor.toString().length()>1){
                int valorAscii = Integer.parseInt(this.valor.toString());
                if((valorAscii>=65 && valorAscii<=90)||(valorAscii>=97 && valorAscii<=122)){
                 c= (char)valorAscii;
                }        
              
            }else{
              c=this.valor.toString().charAt(0);
            }
            
            return tabs + "'"+c+"'";
        }else if(tipo==Tipo_operacion.PARENTESIS){
            return tabs + "("+operadorIzq.traducirPython(0) + ")";
        }else if(tipo==Tipo_operacion.BOOLEAN){
            if("verdadero".equals(this.valor.toString().toLowerCase())){
             return tabs + "True";
            }else{
             return tabs + "False";
            }
            
        }
        
        /* ======== OPERACIONES RELACIONALES ======== */
        else if(tipo== Tipo_operacion.MAYOR_QUE){
            return operadorIzq.traducirPython(tabulaciones)+ " > " + operadorDer.traducirPython(0);
        }else if(tipo== Tipo_operacion.MENOR_QUE){
            return operadorIzq.traducirPython(tabulaciones)+ " < " +operadorDer.traducirPython(0);
        }else if(tipo== Tipo_operacion.CONCATENACION){
            return operadorIzq.traducirPython(tabulaciones) +" + "+operadorDer.traducirPython(0);
        }else if(tipo==Tipo_operacion.MAYOR_IGUAL_QUE){
            return operadorIzq.traducirPython(tabulaciones) + " >= " + operadorDer.traducirPython(0);
        }else if(tipo==Tipo_operacion.MENOR_IGUAL_QUE){
            return operadorIzq.traducirPython(tabulaciones) + " <= " + operadorDer.traducirPython(0);
        }else if(tipo==Tipo_operacion.IGUAL){
            return operadorIzq.traducirPython(tabulaciones) +" == "+operadorDer.traducirPython(0);
        }else if(tipo==Tipo_operacion.DIFERENTE){
            return operadorIzq.traducirPython(tabulaciones) +" != "+operadorDer.traducirPython(0);
        }else if(tipo==Tipo_operacion.AND){
            return operadorIzq.traducirPython(tabulaciones) +" and "+operadorDer.traducirPython(0);
        }else if(tipo==Tipo_operacion.OR){
            return operadorIzq.traducirPython(tabulaciones) +" or "+operadorDer.traducirPython(0);
        }else if(tipo==Tipo_operacion.NOT){
            return tabs + "not "+ operadorIzq.traducirPython(0);
        }else if(tipo==Tipo_operacion.VARIABLE){
            return tabs + this.valor.toString();
        }
        else{
            return "";
        }
    }

    @Override
    public String traducirGo(int tabulaciones) {
        String tabs ="";
            for(int i=0; i<tabulaciones;i++){
            tabs += "    ";
            }
        /* ======== OPERACIONES ARITMETICAS ======== */
        if(tipo== Tipo_operacion.DIVISION){
            return operadorIzq.traducirGo(tabulaciones)+ " / " + operadorDer.traducirGo(0);
        }else if(tipo== Tipo_operacion.MULTIPLICACION){
            return operadorIzq.traducirGo(tabulaciones)+ " * " + operadorDer.traducirGo(0);
        }else if(tipo== Tipo_operacion.RESTA){
            return operadorIzq.traducirGo(tabulaciones)+ " - " + operadorDer.traducirGo(0);
        }else if(tipo== Tipo_operacion.SUMA){
            return operadorIzq.traducirGo(tabulaciones)+ " + " + operadorDer.traducirGo(0);
        }else if(tipo== Tipo_operacion.NEGATIVO){
            return tabs + "-" + operadorIzq.traducirGo(0);
        }else if(tipo==Tipo_operacion.POTENCIA){
            String cadena = tabs + "int(math.Pow(float64(" + operadorIzq.traducirGo(0)+ " ),float64( " + operadorDer.traducirGo(0)+")))";
            return cadena;
        }else if(tipo==Tipo_operacion.MODULO){
            return operadorIzq.traducirGo(tabulaciones) + " % " + operadorDer.traducirGo(0);
        }
        

        
        /* ======== OPERACIONES UNARIOS ======== */
        else if(tipo == Tipo_operacion.NUMERO){
            return tabs + valor.toString();
        }else if(tipo == Tipo_operacion.IDENTIFICADOR){
            return tabs + valor.toString();
        }else if(tipo == Tipo_operacion.CADENA){
            String traduccion = valor.toString().replace("\n", "\\n");
            return tabs + "\""+traduccion+"\"";
        }else if(tipo == Tipo_operacion.CARACTER){
            char c='0'; 
            if(this.valor.toString().length()>1){
                int valorAscii = Integer.parseInt(this.valor.toString());
                if((valorAscii>=65 && valorAscii<=90)||(valorAscii>=97 && valorAscii<=122)){
                 c= (char)valorAscii;
                }        
              
            }else{
              c=this.valor.toString().charAt(0);
            }
            
            return tabs + "'"+c+"'";
        }else if(tipo==Tipo_operacion.PARENTESIS){
            return tabs + "("+operadorIzq.traducirGo(0) + ")";
        }else if(tipo==Tipo_operacion.BOOLEAN){
            if("verdadero".equals(this.valor.toString().toLowerCase())){
             return tabs + "true";
            }else{
             return tabs + "false";
            }
            
        }
        
        /* ======== OPERACIONES RELACIONALES ======== */
        else if(tipo== Tipo_operacion.MAYOR_QUE){
            return operadorIzq.traducirGo(tabulaciones)+ " > " + operadorDer.traducirGo(0);
        }else if(tipo== Tipo_operacion.MENOR_QUE){
            return operadorIzq.traducirGo(tabulaciones)+ " < " +operadorDer.traducirGo(0);
        }else if(tipo== Tipo_operacion.CONCATENACION){
            return operadorIzq.traducirGo(tabulaciones) +" + "+operadorDer.traducirGo(0);
        }else if(tipo==Tipo_operacion.MAYOR_IGUAL_QUE){
            return operadorIzq.traducirGo(tabulaciones) + " >= " + operadorDer.traducirGo(0);
        }else if(tipo==Tipo_operacion.MENOR_IGUAL_QUE){
            return operadorIzq.traducirGo(tabulaciones) + " <= " + operadorDer.traducirGo(0);
        }else if(tipo==Tipo_operacion.IGUAL){
            return operadorIzq.traducirGo(tabulaciones) +" == "+operadorDer.traducirGo(0);
        }else if(tipo==Tipo_operacion.DIFERENTE){
            return operadorIzq.traducirGo(tabulaciones) +" != "+operadorDer.traducirGo(0);
        }else if(tipo==Tipo_operacion.AND){
            return operadorIzq.traducirGo(tabulaciones) +" && "+operadorDer.traducirGo(0);
        }else if(tipo==Tipo_operacion.OR){
            return operadorIzq.traducirGo(tabulaciones) +" || "+operadorDer.traducirGo(0);
        }else if(tipo==Tipo_operacion.NOT){
            return tabs + "!"+ operadorIzq.traducirGo(0);
        }else if(tipo==Tipo_operacion.VARIABLE){
            return tabs + this.valor.toString();
        }
        else{
            return "";
        }
    }
    
    
}
