package simbolos;

import lexico.Tag;
import lexico.Word;

public class Tipo extends Word {

	/**
	 * @param args
	 */
	public int quantidade=0;
	
	public Tipo (String palavra, int tag, int quantidade){
		super(palavra, tag);
		this.quantidade=quantidade;
	}
	
	public static final Tipo inteiro= new Tipo("int", Tag.Basic, 1);
	public static final Tipo booleano= new Tipo("boolean", Tag.Basic, 2);
	
	public static boolean numeric(Tipo p){
		if(p== Tipo.inteiro){
			return true;
		}else{
			return false;
		}
	}
	public static Tipo max(Tipo p1, Tipo p2){
		if(!numeric(p1)|| !numeric(p2)){
			return null;
		}else{
			return Tipo.inteiro;
		}
	}
}
