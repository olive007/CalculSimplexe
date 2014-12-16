package be.helha.D1.calculatorSimplex.src.utility;

/**
 *
 * Cette classe permet de lire des données afin de faire les calculs.
 * Les données sont les coefficients et la liste des contraintes
 * 
 * Le format du fichier est TXT
 * 
 * Non Fini
 * 
 * @see ReadFromXMLFile
 * 
 * @author Olivier
 * 
 */
public class ReadFromTXTFile implements EntryInterface {
	
	public int action() {
		Controller.out.writeString("Lecture au format TXT\n");
		return 1;
	}

}
