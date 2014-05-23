package lexico;

public class Teste {

	public static void main(String[] args) {
		Lexer lexer = new Lexer("INT arnaldo = 5;");
		System.out.println(lexer.scan());
	}
}
