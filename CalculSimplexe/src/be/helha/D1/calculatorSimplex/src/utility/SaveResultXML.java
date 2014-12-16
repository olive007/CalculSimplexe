package be.helha.D1.calculatorSimplex.src.utility;

import be.helha.D1.calculatorSimplex.src.model.MatrixSimplex;

/**
 * 
 * @author Olivier
 * 
 * Cette classe permet d'ecrire les différents resultats des calcul dans un fichier
 * 
 * Le format est xml
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

