/*Lexer Final
*/

package com.mycompany.analizadores;

import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.*;
import java.io.Reader;


%%

%public
%class Lexer
%cup
%unicode
%line
%column

//ini_solicitud


LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]



/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

/* comillas con espacios dentro*/
Qt_Mark_Space = "\""{WhiteSpace}* 



Space_Qt_Mark = {WhiteSpace}*"\""
//Qt_Mark_Space = {WhiteSpace}*"\""
/*Solicitud*/
SOLICITUD = (s|S)(o|O)(l|L)(i|I)(c|C)(i|I)(t|T)(u|U)(d|D)
/*INI*/
INI = (i|I)(n|N)(i|I)
/*fin*/
FIN = (f|F)(i|I)(n|N)
/*  init_solicitud*/
INI_SOLICITUD = {INI}"_"{SOLICITUD}
/*  fin_solicitud*/
FIN_SOLICITUD = {FIN}"_"{SOLICITUD}

INI_SOLICITUDES = {INI}"_"{SOLICITUD}(e|E)(s|S)
/*fin_solicitudes*/
FIN_SOLICITUDES = {FIN}"_"{SOLICITUD}(e|E)(s|S)

//==========================tokens usuario =================
/*crear*/ //c   r   	e 		a   r
CREAR = {Qt_Mark_Space}(c|C)(r|R)(e|E)(a|A)(r|R)
MODICAR = {Qt_Mark_Space}(m|M)(o|O)(d|D)(i|I)(f|F)(i|I)(c|C)(a|A)(r|R)
ELIMINAR = {Qt_Mark_Space}(e|E)(l|L)(i|I)(M|m)(i|I)(n|N)(a|A)(r|R)
LOGIIN = {Qt_Mark_Space}(l|L)(o|O)(g|G)(i|I)(n|N)
/*Usuario*///u 		s  	 u  	a 		r 		i    O
USUARIO = (u|U)(s|S)(u|U)(a|A)(r|R)(i|I)(o|O)

/*crear_uSuAriO*/
CREAR_USUARIO = {CREAR}"_"{USUARIO}{Space_Qt_Mark}

/*modiFicar_uSuAriO*/
MODIFICAR_USUARIO = {MODICAR}"_"{USUARIO}{Space_Qt_Mark}

/*elImInAr_uSuAriO*/
ELIMINAR_USUARIO = {ELIMINAR}"_"{USUARIO}{Space_Qt_Mark}

/*LOgIn_uSuAriO*/
LOGIIN_USUARIO = {LOGIIN}"_"{USUARIO}{Space_Qt_Mark}

/*CREDENCIALES USUARIO*/


USUARIOJS = {Qt_Mark_Space}"USUARIO"{Space_Qt_Mark}
PASSWORDJS = {Qt_Mark_Space}"PASSWORD"{Space_Qt_Mark}
CREDENCIALES_USUARIO  = {Qt_Mark_Space}"CREDENCIALES_USUARIO"{Space_Qt_Mark}
USUARO_OLDJS = {Qt_Mark_Space}"USUARIO_ANTIGUO"{Space_Qt_Mark}
USUARIO_NEWJS = {Qt_Mark_Space}"USUARIO_NUEVO"{Space_Qt_Mark}
PASSWORD_NEWJS = {Qt_Mark_Space}"NUEVO_PASSWORD"{Space_Qt_Mark}

FECHA_CREACION = {Qt_Mark_Space}"FECHA_CREACION"{Space_Qt_Mark}
FECHA_MODIFICACION ={Qt_Mark_Space} "FECHA_MODIFICACION"{Space_Qt_Mark}


//==========================tokens formularios=================

NUEVOX = {Qt_Mark_Space}(n|N)(u|U)(e|E)(v|V)(o|O)
FORMULARIOX = (f|F)(o|O)(r|R)(M|m)(u|U)(l|L)(a|A)(r|R)(i|I)(o|O)


NUEVO_FORMULARIO = {NUEVOX}"_"{FORMULARIOX}{Space_Qt_Mark}
ELIMINAR_FORMULARIO = {ELIMINAR}"_"{FORMULARIOX}{Space_Qt_Mark}
MODIFICAR_FORMULARIO = {MODICAR}"_"{FORMULARIOX}{Space_Qt_Mark}

PARAMENTROS_FORMULARIOJS = {Qt_Mark_Space}"PARAMETROS_FORMULARIO"{Space_Qt_Mark}
IDJS = {Qt_Mark_Space}"ID"{Space_Qt_Mark}
TITULOJS = {Qt_Mark_Space}"TITULO"{Space_Qt_Mark}
NOMBREJS = {Qt_Mark_Space}"NOMBRE"{Space_Qt_Mark}
TEMA = {Qt_Mark_Space}"TEMA"{Space_Qt_Mark}
USUARIO_CREACION = {Qt_Mark_Space}"USUARIO_CREACION"{Space_Qt_Mark}


//====================COMPONENTES=====================

AGREGAR = (a|A)(g|G)(r|R)(e|E)(g|G)(a|A)(r|R)
COMPONENTE =(c|C)(o|O)(m|M)(p|P)(o|O)(n|N)(e|E)(n|N)(t|T)(e|E)

CAMPO = "CAMPO"
AGREGAR_COMPONENTE =  {Qt_Mark_Space}{AGREGAR}"_"{COMPONENTE}{Space_Qt_Mark}
ELIMINAR_COMPONENTE = {ELIMINAR}"_"{COMPONENTE}{Space_Qt_Mark}
MODIFICAR_COMPONENTE = {MODICAR}"_"{COMPONENTE}{Space_Qt_Mark}

PARAMETROS_COMPONENTE = {Qt_Mark_Space}"PARAMETROS_COMPONENTE"{Space_Qt_Mark}
NOMBRE_CAMPOJS ={Qt_Mark_Space} "NOMBRE_"{CAMPO}{Space_Qt_Mark}
ID_FORM  = {Qt_Mark_Space}"FORMULARIO"{Space_Qt_Mark}
CLASE = {Qt_Mark_Space}"CLASE"{Space_Qt_Mark}
INDICE = {Qt_Mark_Space}"INDICE"{Space_Qt_Mark}
TEXTO_VISIBLE = {Qt_Mark_Space}"TEXTO_VISIBLE"{Space_Qt_Mark}
ALINEACION ={Qt_Mark_Space} "ALINEACION"{Space_Qt_Mark}
REQUERIDO = {Qt_Mark_Space}"REQUERIDO"{Space_Qt_Mark}
OPCIONES = {Qt_Mark_Space}"OPCIONES"{Space_Qt_Mark}
FILAS = {Qt_Mark_Space}"FILAS"{Space_Qt_Mark}
COLUMNAS = {Qt_Mark_Space}"COLUMNAS"{Space_Qt_Mark}
URL = {Qt_Mark_Space}"URL"{Space_Qt_Mark}


//===================== value clase======================

CAMPO_TEXTO =  {Qt_Mark_Space}"CAMPO_TEXTO"{Space_Qt_Mark}
AREA_TEXTO = {Qt_Mark_Space}"AREA_TEXTO"{Space_Qt_Mark}
CHECKBOX = {Qt_Mark_Space}"CHECKBOX"{Space_Qt_Mark}
RADIO = {Qt_Mark_Space}"RADIO"{Space_Qt_Mark}
FICHERO = {Qt_Mark_Space}"FICHERO"{Space_Qt_Mark}
IMAGEN = {Qt_Mark_Space}"IMAGEN"{Space_Qt_Mark}
COMBO = {Qt_Mark_Space}"COMBO"{Space_Qt_Mark}
BOTON = {Qt_Mark_Space}"BOTON"{Space_Qt_Mark}

//===================== value ALINEACION======================

CENTRAR = {Qt_Mark_Space}"CENTRAR"{Space_Qt_Mark}
IZQUIERDA = {Qt_Mark_Space}"IZQUIERDA"{Space_Qt_Mark}
DERECHA = {Qt_Mark_Space}"DERECHA"{Space_Qt_Mark}
JUSTIFICAR ={Qt_Mark_Space} "JUSTIFICAR"{Space_Qt_Mark}


//===================REPORTERIA===========================

CONSULTAR = (c|C)(o|O)(n|N)(s|S)(u|U)(l|L)(t|T)(a|A)
DATOS = (d|D)(a|A)(t|T)(o|O)(s|S)

CONSULTAR_DATOS = {Qt_Mark_Space}{CONSULTAR}"_"{DATOS}{Space_Qt_Mark}

CONSULTAS = "CONSULTAS"



DIG = 0 | [1-9][0-9]*
CONSULTA_DESC_ = {Qt_Mark_Space}"CONSULTA-"{DIG}{Space_Qt_Mark}
QUERY = ({Qt_Mark_Space} )
SYMBOLOS =  "!" | "@"| "#"| "$"| "%"|"^"| "^"|"&"| "*"| "(" | ")"|"+"  | "="| ";"| "," |"|" | "'"

Identifier = [\^[:jletter:]][\^[:jletterdigit:]]*[:jletter:] [:jletterdigit:]*
ID_TEST = {Qt_Mark_Space}({SYMBOLOS}* (">"|"["|"]"|"<"|"_"|"-")*  [:jletter:]*{WhiteSpace}*[:jletterdigit:]*  (":")* )+{Space_Qt_Mark}
OTRO = ([a-zA-Z]*{DIG}*{SYMBOLOS}*)
ID_CONSULTA = {Qt_Mark_Space}[.]*{Space_Qt_Mark}
   
%%

<YYINITIAL>{

	"\"CONSULTAR_DATOS\""	{System.out.println("text : consultar datos -> "+yytext());return new Symbol (sym.NOMBRE_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{Qt_Mark_Space}"CONSULTAS"{Space_Qt_Mark} 			{System.out.println("BLOQUE DE PARAMETROS : conslta->"+yytext());return new Symbol (sym.BLOQUE_PARAMETROS,yyline+1,yycolumn+1,yytext());} 
	{CONSULTA_DESC_}	{System.out.println("KEY -> : "+yytext()); return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	
	{INI_SOLICITUD}  	{return new Symbol (sym.INI_SOLICITUD,yyline+1,yycolumn+1,yytext()) ;}
	{FIN_SOLICITUD} 	{return new Symbol (sym.FIN_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{INI_SOLICITUDES} 	{return new Symbol (sym.INI_SOLICITUDES,yyline+1,yycolumn+1,yytext());}
	{FIN_SOLICITUDES} 	{return new Symbol (sym.FIN_SOLICITUDES,yyline+1,yycolumn+1,yytext());}
	
		
//TOKENS REFERENTES AL USUARIO
	{CREAR_USUARIO}		 {return new Symbol (sym.NOMBRE_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{MODIFICAR_USUARIO}	 {return new Symbol (sym.NOMBRE_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{ELIMINAR_USUARIO} 	 {return new Symbol (sym.NOMBRE_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{LOGIIN_USUARIO}   	 {return new Symbol (sym.NOMBRE_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{CREDENCIALES_USUARIO} {return new Symbol (sym.BLOQUE_PARAMETROS,yyline+1,yycolumn+1,yytext());}
	{USUARIOJS}		 	 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{PASSWORDJS}		 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{USUARO_OLDJS}		 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{USUARIO_NEWJS}		 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{PASSWORD_NEWJS}	 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{FECHA_CREACION}	 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{FECHA_MODIFICACION} {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
//TOKENS REFERENTES A UN FORMULARIO
	{NUEVO_FORMULARIO} 	 {return new Symbol (sym.NOMBRE_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{PARAMENTROS_FORMULARIOJS} {return new Symbol (sym.BLOQUE_PARAMETROS,yyline+1,yycolumn+1,yytext());}
	{MODIFICAR_FORMULARIO} {return new Symbol (sym.NOMBRE_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{ELIMINAR_FORMULARIO} {return new Symbol (sym.NOMBRE_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{IDJS} 				 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{TITULOJS}           {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{NOMBREJS}			 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{TEMA}				 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{USUARIO_CREACION}   {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}

//USUARIO_CREACION
//TOKENS REFERENTES A UN COMPONENTTE
	{AGREGAR_COMPONENTE} {return new Symbol (sym.NOMBRE_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{ELIMINAR_COMPONENTE} {return new Symbol (sym.NOMBRE_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{MODIFICAR_COMPONENTE} {return new Symbol (sym.NOMBRE_SOLICITUD,yyline+1,yycolumn+1,yytext());}
	{PARAMETROS_COMPONENTE} {return new Symbol (sym.BLOQUE_PARAMETROS,yyline+1,yycolumn+1,yytext());} 
	{NOMBRE_CAMPOJS}	 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{ID_FORM} 			 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{CLASE} 			 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{INDICE}		     {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{TEXTO_VISIBLE} 	 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{ALINEACION} 		 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{REQUERIDO} 		 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{OPCIONES} 			 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{FILAS} 			 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{COLUMNAS} 			 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}
	{URL} 				 {return new Symbol (sym.KEY,yyline+1,yycolumn+1,yytext());}

//REPORTERIA
	//{CONSULTAR_DATOS}	{return new Symbol (sym.CONSULTAR_DATOS,yyline+1,yycolumn+1,yytext());}
	//{CONSULTA}			{return new Symbol (sym.CONSULTA,yyline+1,yycolumn+1,yytext());}
//	{SELECT}			{return new Symbol (sym.SELECT,yyline+1,yycolumn+1,yytext());}
//	{TO}				{return new Symbol (sym.TO,yyline+1,yycolumn+1,yytext());}
//	{FORM}				{return new Symbol (sym.FORM,yyline+1,yycolumn+1,yytext());}
//	{FLECHA}			{return new Symbol (sym.FLECHA,yyline+1,yycolumn+1,yytext());}
//	{WHERE}				{return new Symbol (sym.WHERE,yyline+1,yycolumn+1,yytext());}
//	{AND}				{return new Symbol (sym.AND,yyline+1,yycolumn+1,yytext());}
//	{OR}				{return new Symbol (sym.OR,yyline+1,yycolumn+1,yytext());}
	

	
	
	
//TIPOS DE CLASE
	{CAMPO_TEXTO}		{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}
	{AREA_TEXTO}		{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}
	{CHECKBOX}			{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}
	{RADIO}				{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}
	{FICHERO}			{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}
	{IMAGEN}			{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}
	{COMBO}				{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}
	{BOTON}				{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}


//TOKENS PARA ALINEAR UN COMPONENTE
	{CENTRAR}   		{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}
	{IZQUIERDA}			{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}
	{DERECHA}			{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}
	{JUSTIFICAR}		{return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());}

///CONSULTAS


//OPERADORES 
	"<"					{return new Symbol (sym.MENOR,yyline+1,yycolumn+1,yytext());}
  //{Qt_Mark_Space}({LETT} | {DIG}|{WhiteSpace})+{Space_Qt_Mark} 

  
   //{Qt_Mark_Space}(. | {WhiteSpace}|[0-9])+{Space_Qt_Mark} {return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());} 
	">"					{return new Symbol (sym.MAYOR,yyline+1,yycolumn+1,yytext());}
	":" 				{return new Symbol ( sym.DOT,yyline+1,yycolumn+1,yytext());}
	//"\""				{return new Symbol (sym.QT_MARK,yyline+1,yycolumn+1,yytext());}
	"{"					{return new Symbol (sym.BRACE_A,yyline+1,yycolumn+1,yytext());}
	"}"					{return new Symbol (sym.BRACE_C,yyline+1,yycolumn+1,yytext());}
	"["					{return new Symbol (sym.BRACKET_A,yyline+1,yycolumn+1,yytext());}
	"]"					{return new Symbol (sym.BRACKET_C,yyline+1,yycolumn+1,yytext());}
	","					{return new Symbol (sym.COLON,yyline+1,yycolumn+1,yytext());}
	"!"					{return new Symbol (sym.ADMIRACION,yyline+1,yycolumn+1,yytext());}
	{ID_TEST}  {System.out.println("ID_TEXT "+ yytext()); return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());} 
	//{ID_CONSULTA}  {System.out.println("ID_CONSULTA "+ yytext()); return new Symbol (sym.ID,yyline+1,yycolumn+1,yytext());} 
	//{Qt_Mark_Space}{InputCharacter}{Space_Qt_Mark}  {System.out.println("ID_CONSULTA "+ yytext()); return new Symbol (sym.QUERY,yyline+1,yycolumn+1,yytext());} 
	{OTRO}				{return new Symbol (sym.DESCONOCIDO,yyline+1,yycolumn+1,yytext());}


{WhiteSpace}	{}

[^]					 {System.out.println("Error lexer Linea:  "+yyline+", Columna"+yycolumn+", texto: "+yytext());}
<<EOF>>            { return new Symbol (sym.EOF); }

}

