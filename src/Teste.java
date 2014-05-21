import lexico.Lexer;


public class Teste {

	public static void main(String[] args) {
		Lexer lex = new Lexer("arnaldo== viado");
		System.out.println(lex.scan());
	}
}
