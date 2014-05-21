package lexico;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.io.*;

import simbolos.Tipo;
public class Lexer {

	
		private int numeroLinha = 1;

		private int linhaAtual;

		private int numCaracterLido = 0;

		private char caracterLido;

		private List<Token> lexemas = new ArrayList<Token>();

		private String condigoFonte;

		private char lookahead;

		Hashtable<String, Word> palavrasReservadas = new Hashtable<String, Word>();

		
		public  Lexer(String codF) {

			
			// Código fonte
			this.condigoFonte = codF;

			// Palavras reservadas
			this.reservarPalavras(new Word("IF", Tag.se));
			this.reservarPalavras(new Word("WHILE", Tag.enquanto));
			this.reservarPalavras(new Word("ELSE", Tag.seNao));
			this.reservarPalavras(new Word("BREAK", Tag.parar));
			this.reservarPalavras(new Word("CONTINUE", Tag.Continue));
			this.reservarPalavras(new Word("RETURN", Tag.retorno));

			this.reservarPalavras(Word.verdadeiro);
			this.reservarPalavras(Word.falso);
			this.reservarPalavras(Tipo.inteiro);
			this.reservarPalavras(Tipo.booleano);
			this.reservarPalavras(Word.vazio);

			this.reservarPalavras(Word.atribuicao);
			this.reservarPalavras(Word.diferente);
			this.reservarPalavras(Word.MaiorQuer);
			this.reservarPalavras(Word.MaiorIgual);
			this.reservarPalavras(Word.menorQuer);
			this.reservarPalavras(Word.Menorigual);

		}

		private char lerProximoCaracter() {

			caracterLido = condigoFonte.charAt(numCaracterLido);
			this.lerLookAhead();

			numCaracterLido++;

			return caracterLido;
		}

		private char lerLookAhead() {

			try {
				lookahead = condigoFonte.charAt(numCaracterLido + 1);
			} catch (Exception e) {
				lookahead = '$';
				return '$';
			}
			return lookahead;
		}

		/**
		 * Verifica se o carácter é maiúsculo.
		 * 
		 * @param c
		 *            - carácter a ser verificado.
		 * @return - true caso o carácter for maiusculo, false C.C..
		 */
		private boolean isMaiusculo(char c) {

			if (c >= 65 && c <= 90) {

				return true;

			} else {

				return false;
			}

		}

		/**
		 * Verifica se o carácter é minúsculo.
		 * 
		 * @param c
		 *            - carácter a ser verificado.
		 * @return - true caso o carácter for minusculo, false C.C..
		 */
		private boolean isMinusculo(char c) {

			if (c >= 97 && c <= 122) {

				return true;

			} else {

				return false;
			}
		}

		/**
		 * Verifica se o carácter é um número.
		 * 
		 * @param c
		 *            - carácter a ser verificado.
		 * @return - true caso o carácter for um número, false C.C..
		 */
		private boolean isNumero(char c) {

			if (c >= 48 && c <= 57) {

				return true;

			} else {

				return false;
			}
		}

		private void reservarPalavras(Word p) {

			palavrasReservadas.put(p.lexema, p);

		}

		public List<Token> scan() {

			while (numCaracterLido < condigoFonte.length()) {

				lerProximoCaracter();

				if (caracterLido == '\n') {

					numeroLinha++;

				} else if (caracterLido == '\t' || caracterLido == ' ') {

					// ...Fazer nada.

				} else if (isMaiusculo(caracterLido)) {// M

					// identificar palavras reservadas como tokens

					String palavraReservada = caracterLido + "";

					while (isMaiusculo(lookahead)) {

						palavraReservada = palavraReservada + lookahead;
						lerProximoCaracter();

					}

					if (isPalavraReservada(palavraReservada)) {

						// ----> tratar isso.
						Word p = palavrasReservadas.get(palavraReservada);
						lexemas.add(p);

					} else {
						// retorne erro.
					}

				} else if (isMinusculo(caracterLido)) {// m

					String id = caracterLido + "";

					while (isMaiusculo(lookahead) || isMinusculo(lookahead)
							|| isNumero(lookahead) || lookahead == '_') {

						id = id + lookahead;
						lerProximoCaracter();

					}

					lexemas.add(new Word(id, Tag.id));

				} else if (isNumero(caracterLido)) {// 1
					String numero = caracterLido + "";

					while (isNumero(lookahead)) {

						numero = numero + lookahead;
						lerProximoCaracter();

					}

					lexemas.add(new NumeroTag(Integer.parseInt(numero)));

				} else if (caracterLido == '{') {

					lexemas.add(new Token('{'));

				} else if (caracterLido == '}') {

					lexemas.add(new Token('}'));

				} else if (caracterLido == ')') {

					lexemas.add(new Token(')'));

				} else if (caracterLido == '(') {

					lexemas.add(new Token('('));

				} else if (caracterLido == ';') {

					lexemas.add(new Token(';'));

				} else if (caracterLido == '=') {

					if (lookahead == '=') {

						numCaracterLido++;
						lexemas.add(Word.Comparacao);

					} else {

						lexemas.add(Word.atribuicao);
					}

				} else if (caracterLido == '<') {

					if (lookahead == '=') {

						numCaracterLido++;
						lexemas.add(Word.Menorigual);

					} else {

						lexemas.add(Word.menorQuer);
					}

				} else if (caracterLido == '>') {

					if (lookahead == '=') {

						numCaracterLido++;
						lexemas.add(Word.MaiorIgual);

					} else {

						lexemas.add(Word.MaiorQuer);
					}

				} else if (caracterLido == '!') {

					if (lookahead == '=') {

						numCaracterLido++;
						lexemas.add(Word.diferente);

					} else {

						lexemas.add(new Token('!'));//pode da merda pois nao temos negação
					}

				}

			}

			return lexemas;
		}

		private boolean isPalavraReservada(String p) {

			boolean r = palavrasReservadas.containsKey(p);

			return r;
		}
	
	
	
	/*public static int linhas=1;
	private int linhaAtual;
	private int numCaracterLido = 0;
	private char caracterLido;
	private char proxChar= ' ';
	private String codFonte;
	private char lookahead;
	private List<Token> listaLexemas = new ArrayList<Token>();
	Hashtable<String, Word> word = new Hashtable<String, Word>();
	private void reserve(Word w){
		word.put(w.lexema, w);
	}
	
	public Lexer(String codigoFonte){
		
		reserve(new Word("if", Tag.se));
		reserve(new Word("else", Tag.seNao));
		reserve(new Word("while", Tag.enquanto));
		reserve(new Word("break", Tag.parar));
		reserve(new Word("continue", Tag.Continue));
		reserve(new Word("return", Tag.retorno));
		
		
		reserve(Word.verdadeiro);
		reserve(Word.falso);
		reserve(Tipo.booleano);
		reserve(Tipo.inteiro);
	}
	
	private char lerLookAhead() {

		try {
			lookahead = codFonte.charAt(numCaracterLido + 1);
		} catch (Exception e) {
			lookahead = '$';
			return '$';
		}
		return lookahead;
	}
	
	
	private char lerProximoCaracter() {

		caracterLido = codFonte.charAt(numCaracterLido);
		this.lerLookAhead();

		numCaracterLido++;

		return caracterLido;
	}
	
	private boolean isNumero(char c) {

		if (c >= 48 && c <= 57) {

			return true;

		} else {

			return false;
		}
	}

	
	
	public Token scan() throws IOException{
		while(numCaracterLido < codFonte.length()){
			lerProximoCaracter();
			if(proxChar== ' '|| proxChar == '\t'){
				continue;
			}else if(proxChar =='\n'){
				linhas++;
			}else{
				break;
			}
		}
		
		switch (caracterLido) {
		
		case '=':
			if(lerProximoCaracter()==('=')) return Word.Comparacao;
			else return Word.atribuicao;
		
		case '!':
				if(lerProximoCaracter()==('=')) return Word.diferente;
				else return new Token('!');//diferente nos nao aceitamos
		
		case '<':
			if(lerProximoCaracter()==('=')) return Word.Menorigual;
			else return Word.menorQuer;
		
		case '>':
			if(lerProximoCaracter()==('=')) return Word.MaiorIgual;
			else return Word.MaiorQuer;
		case '{':
			return Word.AbriChaves;
		case '}':
			return Word.fecharChaves;
		case ';':
			return Word.PontoVirgula;
		case ',':
			return Word.virgula;
		case '(':
			return Word.abriParentes;
		case ')':
			return Word.fechaParenteses;
		case '+':
			return Word.mais;
		case '-':
			return Word.menos;
		case '*':
			return Word.multiplicacao;
		case '/':
			return Word.Divisao;
		default:
			break;
	}
	
	if(Character.isDigit(caracterLido)){
		int v = 0;
		do{
			v = 10*v + Character.digit(caracterLido, 10);
			lerProximoCaracter();
		}while(Character.isDigit(caracterLido));
		return new NumeroTag(v);//esse chamada no livro eh para classe real, usamos a numero pois nao temos reasl
	}
	
	if(Character.isLetter(caracterLido)){
		StringBuffer b = new StringBuffer();
		do{
			b.append(caracterLido);
			lerProximoCaracter();
		}while(Character.isLetterOrDigit(caracterLido));
		
		String s = b.toString();
		Word w = (Word)word.get(s);
		//SySSSSstem.out.println("WORD:" + w.tag);
		
		if(w != null) return w;
		w = new Word(s, Tag.id);
		word.put(s, w);
//		System.out.println("ID:" + w.tag);
		return w;
	}
	
	Token tok = new Token(caracterLido);
	caracterLido = ' ';
	return tok;
	
}


public Hashtable getWords(){
	return this.word;
}*/
}


