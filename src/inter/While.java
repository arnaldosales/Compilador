package inter;
import simbolos.*;

public class While extends Stmt {

   Expressoes expr; Stmt stmt;

   public While() { expr = null; stmt = null; }

   public void init(Expressoes x, Stmt s) {
      expr = x;  stmt = s;
      if( expr.tipo != Tipo.booleano ) expr.error("boolean required in while");
   }
   public void gen(int b, int a) {
      after = a;                // save label a
      expr.jummping(0, a);
      int label = newlabel();   // label for stmt
      emitlabel(label); stmt.gen(label, b);
      emit("goto L" + b);
   }
}
