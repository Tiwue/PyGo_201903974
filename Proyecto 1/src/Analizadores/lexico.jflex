package analizadores;
import java_cup.runtime.Symbol; 
import Estructuras.*;

%% 
%class Lexico
%public 
%line 
%char 
%cup 
%unicode
%ignorecase

%init{ 
    yyline = 1; 
    yychar = 1; 
%init} 


BLANCOS=[ \r\t]+
D=[0-9]+
DD=[0-9]+("."[  |0-9]+)?



%{
    public void addError(MiError error)
    {
        Interfaz.Principal.errores.add(error);
    }
%}


%%

"Evaluar"           {return new Symbol(sym.REVALUAR,yyline,yychar, yytext());} 
"if"                {return new Symbol(sym.RIF,yyline,yychar, yytext());} 
"else"              {return new Symbol(sym.RELSE,yyline,yychar, yytext());}
"mientras"          {return new Symbol(sym.RMIENTRAS,yyline,yychar, yytext());} 

";"                 {return new Symbol(sym.PTCOMA,yyline,yychar, yytext());} 
"("                 {return new Symbol(sym.PARIZQ,yyline,yychar, yytext());} 
")"                 {return new Symbol(sym.PARDER,yyline,yychar, yytext());} 
"["                 {return new Symbol(sym.CORIZQ,yyline,yychar, yytext());} 
"]"                 {return new Symbol(sym.CORDER,yyline,yychar, yytext());} 
"{"                 {return new Symbol(sym.LLAVIZQ,yyline,yychar, yytext());} 
"}"                 {return new Symbol(sym.LLAVDER,yyline,yychar, yytext());}

"+"                 {return new Symbol(sym.MAS,yyline,yychar, yytext());} 
"-"                 {return new Symbol(sym.MENOS,yyline,yychar, yytext());} 
"*"                 {return new Symbol(sym.POR,yyline,yychar, yytext());} 
"/"                 {return new Symbol(sym.DIVIDIDO,yyline,yychar, yytext());} 

"&&"                {return new Symbol(sym.AND,yyline,yychar, yytext());} 
"<"                 {return new Symbol(sym.MENQUE,yyline,yychar, yytext());} 
">"                 {return new Symbol(sym.MAYQUE,yyline,yychar, yytext());} 
"="                 {return new Symbol(sym.IGUAL,yyline,yychar, yytext());} 

\n {yychar=1;}

{BLANCOS} {} 
{D} {return new Symbol(sym.ENTERO,yyline,yychar, yytext());} 
{DD} {return new Symbol(sym.DECIMAL,yyline,yychar, yytext());} 

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
    addError(new Estructuras.MiError(tipoError.LEXICO, "Se detectó un error lexico ("+yytext()+")", yyline, yychar));
}