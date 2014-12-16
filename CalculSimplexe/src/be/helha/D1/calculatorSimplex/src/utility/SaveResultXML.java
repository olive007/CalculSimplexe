package be.helha.D1.calculatorSimplex.src.utility;

import be.helha.D1.calculatorSimplex.src.model.MatrixSimplex;

/**
 * 
 * Cette classe permet d'ecrire les différents résultats des calculs dans un fichier.
 * 
 * Le format est XML
 * 
 * @see SaveResult
 * @see SaveResultTXT
 * 
 * @author Olivier
 *
 */

public class SaveResultXML extends SaveResult implements EntryInterface  {

	public SaveResultXML(MatrixSimplex[] resultat) {
		super(resultat);
	}

	public int action() {
		return 1;
	}

}

