package inter;
import lexico.*; import simbolos.*;

public class Logical extends Expressoes {

   public Expressoes expr1, expr2;

   Logical(Token tok, Expressoes x1, Expressoes x2) {
      super(tok, null);                      // null type to start
      expr1 = x1; expr2 = x2;
      tipo = check(expr1.tipo, expr2.tipo);
      if (tipo == null ) error("type error");
   }

   public Tipo check(Tipo p1, Tipo p2) {
      if ( p1 == Tipo.booleano && p2 == Tipo.booleano ) return Tipo.booleano;
      else return null;
   }

   public Expressoes gen() {
      int f = newlabel(); int a = newlabel();
      Temp temp = new Temp(tipo);
      this.jummping(0,f);
      emit(temp.toString() + " = true");
      emit("goto L" + a);
      emitlabel(f); emit(temp.toString() + " = false");
      emitlabel(a);
      return temp;
   }

   public String toString() {
      return expr1.toString()+" "+op.toString()+" "+expr2.toString();
   }
}
