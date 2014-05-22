package inter;

import simbolos.Tipo;

public class CondicionalSeNao extends Stmt {
Expressoes expressao;
Stmt stmt1,stmt2;
public CondicionalSeNao(Expressoes x, Stmt s1, Stmt s2){
	expressao = x;
	stmt1 = s1;
	stmt2 = s2;
	if(expressao.tipo != Tipo.booleano){
		expressao.error("booleano requerido no if");
		}
	
	}

public void gen (int b, int a){
	
	int label1 = newlabel();
	int label2 = newlabel();
	expressao.jummping(0, label2);;//segue para stmt1 se expr for true
	emitlabel(label1);
	stmt1.gen(label1,a);
	emit("goto L" + a);
	emitlabel(label2);
	stmt2.gen(label2,a);
	
}
}