package inter;
import lexico.*; import simbolos.*;

public class Unary extends Op {

   public Expressoes expr;

   public Unary(Token tok, Expressoes x) {    // handles minus, for ! see Not
      super(tok, null);  expr = x;
      tipo = Tipo.max(Tipo.inteiro, expr.tipo);
      if (tipo == null ) error("type error");
   }

   public Expressoes gen() { return new Unary(op, expr.reduce()); }

   public String toString() { return op.toString()+" "+expr.toString(); }
}