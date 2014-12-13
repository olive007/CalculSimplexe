package be.helha.D1.calculatorSimplex.src.exception;

public class WrongEntryException extends Exception {

	/**
	 * Version alpha
	 * December 2014;
	 */
	private static final long serialVersionUID = 2587028073015549228L;	
	
	public WrongEntryException() {
		super("Mauvais parametre");
	}
	
}
