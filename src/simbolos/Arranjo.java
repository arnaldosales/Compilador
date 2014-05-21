package simbolos;

import lexico.Tag;

public class Arranjo extends Tipo{

	public Tipo of;
	public int tamanho =1;
	
	public Arranjo (int tamanho, Tipo tipo){
		super("[]", Tag.Index, tamanho*tipo.quantidade);
		this.tamanho=tamanho;
		of=tipo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + tamanho + "]" + of.toString();
	}
}
