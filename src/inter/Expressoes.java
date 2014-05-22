package inter;
import lexico.*;
import simbolos.*;

public class Expressoes extends Node {
	 public Token op;
	 public Tipo tipo;
	 Expressoes(Token tok, Tipo p){
		 op = tok;
		 tipo = p;
		 }
	 public Expressoes gen(){
		 return this;
	 }
	 public Expressoes reduce(){
		 return this;
	 }
	 public void jummping(int t, int f){
		 emitjumps(toString(), t, f);
	 }
	 public void emitjumps(String test,int t, int f){
		 if(t != 0 && f !=0){
			 
			 emit("if "+ test +"goto L" + t);
			 emit("goto L" + f);
		 }else if(t != 0){
			 emit("if" + test+ "goto L" + t);
		 }else if(f != 0){
			 emit("iffalse" + test+ "goto L" + f);
		 }else;
		 
		}
	 	public String toString(){
		 return op.toString();
	 	}
		 
	 }
