package be.helha.D1.calculatorSimplex.src.utility;

import be.helha.D1.calculatorSimplex.src.model.MatrixSimplex;


public class SaveResultXML extends SaveResult implements EntryInterface  {

	public SaveResultXML(MatrixSimplex[] resultat) {
		super(resultat);
	}

	public int action() {
		return 1;
	}

}

