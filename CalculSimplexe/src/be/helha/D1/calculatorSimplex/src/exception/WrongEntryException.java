package be.helha.D1.calculatorSimplex.src.exception;

/**
 * 
 * Elle est lancé lorqu'on crée un mauvais menu ou une mauvais entry
 * 
 * @see Menu, Entry
 * 
 * @version 1.0 Décembre 2014
 * 
 */

public class WrongEntryException extends Exception {

	private static final long serialVersionUID = 2587028073015549228L;	
	
	public WrongEntryException() {
		super("Mauvais parametre a été donné dans la construction d'un menu");
	}
	
	public WrongEntryException(String str) {
		super(str);
	}
	
}
