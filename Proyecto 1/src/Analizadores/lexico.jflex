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
CARACTER = [\'][ -}][\']
CADENA = [\"]([^\"]|(\\\"))*[\"]
COMENTARIO = ("//".*)|("//".*\n)
COMENTARIOMULTI = "/*"("*"|[\n\s\t])*([^/*]|[\n\s\t])*("*"|[\n\s\t])*"*/"



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
"verdadero"         {return new Symbol(sym.RVERDADERO,yyline,yychar, yytext());}
"falso"             {return new Symbol(sym.RFALSO,yyline,yychar,yytext());}
"potencia"          {return new Symbol(sym.RPOTENCIA,yyline,yychar,yytext());}
"mod"               {return new Symbol(sym.RMOD,yyline,yychar,yytext());}
"mayor"             {return new Symbol(sym.RMAYOR,yyline,yychar,yytext());}
"menor"             {return new Symbol(sym.RMENOR,yyline,yychar,yytext());}
"mayor_o_igual"     {return new Symbol(sym.RMAYORIGUAL,yyline,yychar,yytext());}
"menor_o_igual"     {return new Symbol(sym.RMENORIGUAL,yyline,yychar,yytext());}
"es_igual"          {return new Symbol(sym.RIGUAL,yyline,yychar,yytext());}
"es_diferente"      {return new Symbol(sym.RDIFERENTE,yyline,yychar,yytext());}
"or"                {return new Symbol(sym.ROR,yyline,yychar,yytext());}
"and"               {return new Symbol(sym.RAND,yyline,yychar,yytext());}
"not"               {return new Symbol(sym.RNOT,yyline,yychar,yytext());}
"inicio"            {return new Symbol(sym.RINICIO,yyline,yychar,yytext());}
"fin"               {return new Symbol(sym.RFIN,yyline,yychar,yytext());}

";"                 {return new Symbol(sym.PTCOMA,yyline,yychar, yytext());} 
"("                 {return new Symbol(sym.PARIZQ,yyline,yychar, yytext());} 
")"                 {return new Symbol(sym.PARDER,yyline,yychar, yytext());} 
"["                 {return new Symbol(sym.CORIZQ,yyline,yychar, yytext());} 
"]"                 {return new Symbol(sym.CORDER,yyline,yychar, yytext());} 
"{"                 {return new Symbol(sym.LLAVIZQ,yyline,yychar, yytext());} 
"}"                 {return new Symbol(sym.LLAVDER,yyline,yychar, yytext());}
"$"                 {return new Symbol(sym.DOLAR,yyline,yychar,yytext());}
"+"                 {return new Symbol(sym.MAS,yyline,yychar, yytext());} 
"-"                 {return new Symbol(sym.MENOS,yyline,yychar, yytext());} 
"*"                 {return new Symbol(sym.POR,yyline,yychar, yytext());} 
"/"                 {return new Symbol(sym.DIVIDIDO,yyline,yychar, yytext());} 
"'"                 {return new Symbol(sym.COMSIMPLE,yyline,yychar, yytext());}

"<"                 {return new Symbol(sym.MENQUE,yyline,yychar, yytext());} 
">"                 {return new Symbol(sym.MAYQUE,yyline,yychar, yytext());} 
"="                 {return new Symbol(sym.IGUAL,yyline,yychar, yytext());} 

\n {yychar=1;}

{BLANCOS}           {} 
{D}                 {return new Symbol(sym.ENTERO,yyline,yychar, yytext());} 
{DD}                {return new Symbol(sym.DECIMAL,yyline,yychar, yytext());} 
{CARACTER}          {return new Symbol(sym.CARACTER,yyline,,yychar,yytext());}
{CADENA}            {return new Symbol(sym.CADENA,yyline,,yychar,yytext());}
{COMENTARIO}        {}
{COMENTARIOMULTI}   {}

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
    addError(new Estructuras.MiError(tipoError.LEXICO, "Se detectó un error lexico ("+yytext()+")", yyline, yychar));
}


