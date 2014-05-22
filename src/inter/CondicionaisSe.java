package inter;
import simbolos.*;

public class CondicionaisSe extends Stmt {
Expressoes expressao;
Stmt stmt;
public CondicionaisSe (Expressoes x, Stmt s){
	expressao = x;
	stmt = s;
	if(expressao.tipo != Tipo.booleano){
		expressao.error("booleano requerido no if");
		}
}
public void gen(int b, int a){
	int label = newlabel();//rotulo do codigo para stmt
	expressao.jummping(0, a);//segue se fr true vai pra a se for false
	emitlabel(label);
	stmt.gen(label,a);
	
	}
	
}