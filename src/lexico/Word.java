package lexico;

public class Word extends Token{

	/**
	 * @param args
	 */
	public String lexema="";
	
	public Word(String palavra, int Tag) {
		// TODO Auto-generated constructor stub
		
		super(Tag);
		lexema = palavra;
	}
	//pode ser necessario inserir os numeros e as letras
	public static final Word AbriChaves = new Word("{",Tag.abriChaves);
	public static final Word fecharChaves = new Word("}",Tag.fechaChaves);
	public static final Word PontoVirgula = new Word(";",Tag.pontoVirgula);
	public static final Word virgula = new Word(",",Tag.virgula);
	public static final Word diferente = new Word("!=",Tag.diferente);
	public static final Word abriParentes = new Word("(",Tag.abriParenteses);
	public static final Word fechaParenteses = new Word(")",Tag.fechaParentes);
	public static final Word mais = new Word("+",Tag.mais);
	public static final Word menos = new Word("-",Tag.menos);
	public static final Word multiplicacao = new Word("*",Tag.multiplicacao);
	public static final Word Divisao = new Word("/",Tag.divisao);
	public static final Word menorQuer = new Word("<",Tag.menorquer);
	public static final Word MaiorQuer = new Word(">",Tag.maiorquer);
	public static final Word MaiorIgual = new Word(">=",Tag.maiorIgual);
	public static final Word Menorigual = new Word("<=",Tag.menorIgual);
	public static final Word atribuicao = new Word("=",Tag.atribuicao);
	public static final Word seNao = new Word("ELSE",Tag.seNao);
	public static final Word se = new Word("IF",Tag.se);
	public static final Word parar = new Word("BREAK",Tag.parar);
	public static final Word Continue = new Word("CONTINUE",Tag.Continue);
	public static final Word retorna = new Word("RETURN",Tag.retorno);
	//foi apagado tipo boleano e inteiro
	public static final Word verdadeiro = new Word("TRUE",Tag.verdadeiro);
	public static final Word falso = new Word("FALSO",Tag.falso);
	public static final Word Comparacao = new Word("==",Tag.Comparacao);
	public static final Word tempo = new Word("temp",Tag.Temp);
	public static final Word minus = new Word("minus",Tag.Minu);
	public static final Word vazio = new Word("VOID",Tag.vazio);
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return lexema;
	}


























}
