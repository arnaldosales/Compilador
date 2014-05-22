package inter;

import lexico.*;
import simbolos.*;

public class Id extends Expressoes {
public int offset;
public Id(Word id, Tipo p, int b ){
	super(id,p);
	offset = b;
	}
}