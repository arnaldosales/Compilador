package inter;

import lexico.*; import simbolos.*;

public class Arith extends Op {

   public Expressoes expr1, expr2;

   public Arith(Token tok, Expressoes x1, Expressoes x2)  {
      super(tok, null); expr1 = x1; expr2 = x2;
      tipo = Tipo.max(expr1.tipo, expr2.tipo);
      if (tipo == null ) error("type error");
   }

   public Expressoes gen() {
      return new Arith(op, expr1.reduce(), expr2.reduce());
   }

   public String toString() {
      return expr1.toString()+" "+op.toString()+" "+expr2.toString();
   }
}