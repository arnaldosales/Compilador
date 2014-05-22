package inter;
import lexico.*; import simbolos.*;

public class Temp extends Expressoes {

   static int count = 0;
   int number = 0;

   public Temp(Tipo p) { super(Word.tempo, p); number = ++count; }

   public String toString() { return "t" + number; }
}
