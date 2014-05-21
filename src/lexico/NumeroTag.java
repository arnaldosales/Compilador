package lexico;

public class NumeroTag extends Token{

	/**
	 * @param args
	 */
	public final int valor;
	
	public NumeroTag(int valor) {
		// TODO Auto-generated constructor stub
		super(Tag.numeros);
		this.valor=valor;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + valor;
	}

}
