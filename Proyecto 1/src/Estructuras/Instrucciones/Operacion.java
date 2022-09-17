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
        CONCATENACION
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
    public String traducirPython() {
        /* ======== OPERACIONES ARITMETICAS ======== */
        if(tipo== Tipo_operacion.DIVISION){
            return operadorIzq.traducirPython()+ "/" + operadorDer.traducirPython();
        }else if(tipo== Tipo_operacion.MULTIPLICACION){
            return operadorIzq.traducirPython()+ "*" + operadorDer.traducirPython();
        }else if(tipo== Tipo_operacion.RESTA){
            return operadorIzq.traducirPython()+ "-" + operadorDer.traducirPython();
        }else if(tipo== Tipo_operacion.SUMA){
            return operadorIzq.traducirPython()+ "+" + operadorDer.traducirPython();
        }else if(tipo== Tipo_operacion.NEGATIVO){
            return "-" + operadorIzq.traducirPython();
        }else if(tipo==Tipo_operacion.POTENCIA){
            return operadorIzq.traducirPython()+ "**" + operadorDer.traducirPython();
        }else if(tipo==Tipo_operacion.MODULO){
            return operadorIzq.traducirPython() + "%" + operadorDer.traducirPython();
        }
        

        
        /* ======== OPERACIONES UNARIOS ======== */
        else if(tipo == Tipo_operacion.NUMERO){
            return valor.toString();
        }else if(tipo == Tipo_operacion.IDENTIFICADOR){
            return valor.toString();
        }else if(tipo == Tipo_operacion.CADENA){
            return valor.toString();
        }else if(tipo == Tipo_operacion.CARACTER){
            return this.valor.toString();
        }else if(tipo==Tipo_operacion.PARENTESIS){
            return "("+operadorIzq.traducirPython() + ")";
        }else if(tipo==Tipo_operacion.BOOLEAN){
            if("verdadero".equals(this.valor.toString().toLowerCase())){
             return "True";
            }else{
             return "False";
            }
            
        }
        
        /* ======== OPERACIONES RELACIONALES ======== */
        else if(tipo== Tipo_operacion.MAYOR_QUE){
            return operadorIzq.traducirPython()+ ">" + operadorDer.traducirPython();
        }else if(tipo== Tipo_operacion.MENOR_QUE){
            return operadorIzq.traducirPython()+ "<" +operadorDer.traducirPython();
        }else if(tipo== Tipo_operacion.CONCATENACION){
            return operadorIzq.traducirPython() +"+"+operadorDer.traducirPython();
        }else if(tipo==Tipo_operacion.MAYOR_IGUAL_QUE){
            return operadorIzq.traducirPython() + ">=" + operadorDer.traducirPython();
        }else if(tipo==Tipo_operacion.MENOR_IGUAL_QUE){
            return operadorIzq.traducirPython() + "<=" + operadorDer.traducirPython();
        }else if(tipo==Tipo_operacion.IGUAL){
            return operadorIzq.traducirPython() +"=="+operadorDer.traducirPython();
        }else if(tipo==Tipo_operacion.DIFERENTE){
            return operadorIzq.traducirPython() +"!="+operadorDer.traducirPython();
        }else if(tipo==Tipo_operacion.AND){
            return operadorIzq.traducirPython() +"and"+operadorDer.traducirPython();
        }else if(tipo==Tipo_operacion.OR){
            return operadorIzq.traducirPython() +"or"+operadorDer.traducirPython();
        }else if(tipo==Tipo_operacion.NOT){
            return "not "+ operadorIzq.traducirPython();
        }else{
            return "";
        }
    }

    @Override
    public String traducirGo() {
        System.out.println("Aun no se crea en go");
        return "";
    }
    
    
}
