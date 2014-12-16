package be.helha.D1.calculatorSimplex.src.exception;

/**
 * 
 * Elle est lancée lorsqu'on tente d créer 
 * 
 * @see MatrixSimplex
 * 
 * @version 1.0 Décembre 2014
 * 
 */

public class WrongMatrixSimplexException extends Exception {

	private static final long serialVersionUID = -339581876617983895L;

	public WrongMatrixSimplexException() {
		super("La matrix est mauvaise");
	}
	
	public WrongMatrixSimplexException(String string) {
		super(string);
	}
	
}
