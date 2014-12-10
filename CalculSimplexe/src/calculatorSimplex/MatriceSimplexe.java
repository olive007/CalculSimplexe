package calculatorSimplex;

import java.io.Serializable;

public class MatriceSimplexe implements Serializable {
	
	/**
	 * Version alpha
	 * December 2014;
	 */
	private static final long serialVersionUID = 5370224255246835399L;

	public MatriceSimplexe() {
	
	}
	
	// Getter
	public int getNbBaseVar() {
		return 3;
	}
	
	public int getNbCondition() {
		return 3;
	}
	
	public int getMaximum() {
		return 100;
	}
	
	// Attribute
	
}
