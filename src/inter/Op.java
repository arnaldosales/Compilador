package inter;


import lexico.*; 
import simbolos.*;

public class Op extends Expressoes {

   public Op(Token tok, Tipo p)  { super(tok, p); }

   public Expressoes reduce() {
      Expressoes x = gen();
      Temp t = new Temp(tipo);
      emit( t.toString() + " = " + x.toString() );
      return t;
   }
}