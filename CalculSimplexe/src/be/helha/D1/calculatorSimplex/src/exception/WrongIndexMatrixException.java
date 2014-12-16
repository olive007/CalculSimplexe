package be.helha.D1.calculatorSimplex.src.exception;

/**
 * 
 * Elle est lancé lorsqu'on tente de modifier une variable hors de la matrice
 * 
 * @see MatrixSimplex
 * 
 * @version 1.0 Décembre 2014
 *
 */

public class WrongIndexMatrixException extends Exception {
	
	private static final long serialVersionUID = -796306736684644122L;

	public WrongIndexMatrixException() {
		super("L'index passé en parametre est mauvais");
	}
	
	public WrongIndexMatrixException(String str) {
		super(str);
	}
}
