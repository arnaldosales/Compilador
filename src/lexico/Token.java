package lexico;

public class Token {

	/**
	 * @param args
	 */
	public final int tag;
	
	public Token(int tag){
		this.tag=tag;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + (char)this.tag;
	}

	
}
