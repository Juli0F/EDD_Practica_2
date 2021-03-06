
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.mycompany.edd_practica_2.parser_usr;

import java_cup.runtime.*;
import com.mycompany.edd_practica_2.CapaLoad;
import com.mycompany.edd_practica_2.UsrLoad;
import java.util.List;
import java.util.ArrayList;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser_Usuario extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser_Usuario() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser_Usuario(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser_Usuario(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\010\000\002\003\003\000\002\002\004\000\002\005" +
    "\007\000\002\005\002\000\002\004\004\000\002\004\002" +
    "\000\002\002\003\000\002\002\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\013\000\006\002\ufffe\012\ufffe\001\002\000\006\002" +
    "\001\012\007\001\002\000\004\002\006\001\002\000\004" +
    "\002\000\001\002\000\004\013\010\001\002\000\006\007" +
    "\ufffc\010\ufffc\001\002\000\006\007\012\010\013\001\002" +
    "\000\010\006\015\007\ufffb\010\ufffb\001\002\000\006\002" +
    "\uffff\012\uffff\001\002\000\006\007\ufffd\010\ufffd\001\002" +
    "\000\006\007\ufffa\010\ufffa\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\013\000\006\003\004\005\003\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\004\010\001\001\000\004\002\013\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser_Usuario$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser_Usuario$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser_Usuario$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




		

public void report_error(String message, Object info) {
    StringBuilder m = new StringBuilder("Error ");

       if (info instanceof java_cup.runtime.Symbol) {

       	 java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);

            String lexema = (String) s.value;
            String descripcion = "Se Esperaba: ";
            for(Integer token : expected_token_ids())
            	descripcion = descripcion + " \'"+sym.terminalNames[token]+"\'";	
   	   		
		System.out.println("Error: "+s.left+" , " +s.right+"\n"+lexema +" "+descripcion);
     
    }

    m.append(" : "+message);
   
   
    System.out.println(m);
  }
public void syntax_error(Symbol cur_token) {
            
            report_error( "Error Sintactico", cur_token) ;

        }
	

/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser_Usuario$actions {
  private final Parser_Usuario parser;

  /** Constructor */
  CUP$Parser_Usuario$actions(Parser_Usuario parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser_Usuario$do_action_part00000000(
    int                        CUP$Parser_Usuario$act_num,
    java_cup.runtime.lr_parser CUP$Parser_Usuario$parser,
    java.util.Stack            CUP$Parser_Usuario$stack,
    int                        CUP$Parser_Usuario$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser_Usuario$result;

      /* select the action based on the action number */
      switch (CUP$Parser_Usuario$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // inicio ::= instruccion 
            {
              List<UsrLoad> RESULT =null;
		int lstleft = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()).left;
		int lstright = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()).right;
		List<UsrLoad> lst = (List<UsrLoad>)((java_cup.runtime.Symbol) CUP$Parser_Usuario$stack.peek()).value;
		RESULT = lst; 
              CUP$Parser_Usuario$result = parser.getSymbolFactory().newSymbol("inicio",1, ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()), RESULT);
            }
          return CUP$Parser_Usuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).right;
		List<UsrLoad> start_val = (List<UsrLoad>)((java_cup.runtime.Symbol) CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).value;
		RESULT = start_val;
              CUP$Parser_Usuario$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)), ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser_Usuario$parser.done_parsing();
          return CUP$Parser_Usuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // instruccion ::= instruccion IDENTIFIER DOT descripcion SEMI 
            {
              List<UsrLoad> RESULT =null;
		int lstleft = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-4)).left;
		int lstright = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-4)).right;
		List<UsrLoad> lst = (List<UsrLoad>)((java_cup.runtime.Symbol) CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-4)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-3)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-3)).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-3)).value;
		int descleft = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).left;
		int descright = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).right;
		List<Integer> desc = (List<Integer>)((java_cup.runtime.Symbol) CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).value;
		
							UsrLoad usrLoad = new UsrLoad();
							usrLoad.setId((n));
							usrLoad.getLst().addAll(desc);
							lst.add(usrLoad);
							RESULT = lst;

						
              CUP$Parser_Usuario$result = parser.getSymbolFactory().newSymbol("instruccion",3, ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-4)), ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()), RESULT);
            }
          return CUP$Parser_Usuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // instruccion ::= 
            {
              List<UsrLoad> RESULT =null;
		RESULT = new ArrayList<>();
              CUP$Parser_Usuario$result = parser.getSymbolFactory().newSymbol("instruccion",3, ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()), RESULT);
            }
          return CUP$Parser_Usuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // descripcion ::= descripcion datos 
            {
              List<Integer> RESULT =null;
		int lstleft = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).left;
		int lstright = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).right;
		List<Integer> lst = (List<Integer>)((java_cup.runtime.Symbol) CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()).right;
		String d = (String)((java_cup.runtime.Symbol) CUP$Parser_Usuario$stack.peek()).value;
		
							lst.add(Integer.parseInt(d));
							RESULT = lst;
						
              CUP$Parser_Usuario$result = parser.getSymbolFactory().newSymbol("descripcion",2, ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)), ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()), RESULT);
            }
          return CUP$Parser_Usuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // descripcion ::= 
            {
              List<Integer> RESULT =null;
		
						RESULT = new ArrayList<>();
              CUP$Parser_Usuario$result = parser.getSymbolFactory().newSymbol("descripcion",2, ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()), RESULT);
            }
          return CUP$Parser_Usuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // datos ::= NUMBER 
            {
              String RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$Parser_Usuario$stack.peek()).value;
		RESULT = n;
              CUP$Parser_Usuario$result = parser.getSymbolFactory().newSymbol("datos",0, ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()), RESULT);
            }
          return CUP$Parser_Usuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // datos ::= NUMBER COLON 
            {
              String RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)).value;
		RESULT = n;
              CUP$Parser_Usuario$result = parser.getSymbolFactory().newSymbol("datos",0, ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.elementAt(CUP$Parser_Usuario$top-1)), ((java_cup.runtime.Symbol)CUP$Parser_Usuario$stack.peek()), RESULT);
            }
          return CUP$Parser_Usuario$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser_Usuario$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser_Usuario$do_action(
    int                        CUP$Parser_Usuario$act_num,
    java_cup.runtime.lr_parser CUP$Parser_Usuario$parser,
    java.util.Stack            CUP$Parser_Usuario$stack,
    int                        CUP$Parser_Usuario$top)
    throws java.lang.Exception
    {
              return CUP$Parser_Usuario$do_action_part00000000(
                               CUP$Parser_Usuario$act_num,
                               CUP$Parser_Usuario$parser,
                               CUP$Parser_Usuario$stack,
                               CUP$Parser_Usuario$top);
    }
}

}
