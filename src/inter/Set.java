package inter;
import lexico.*; import simbolos.*;

public class Set extends Stmt {

   public Id id; public Expressoes expr;

   public Set(Id i, Expressoes x) {
      id = i; expr = x;
      if ( check(id.tipo, expr.tipo) == null ) error("type error");
   }

   public Tipo check(Tipo p1, Tipo p2) {
      if ( Tipo.numeric(p1) && Tipo.numeric(p2) ) return p2;
      else if ( p1 == Tipo.booleano && p2 == Tipo.booleano ) return p2;
      else return null;
   }

   public void gen(int b, int a) {
      emit( id.toString() + " = " + expr.gen().toString() );
   }
}
