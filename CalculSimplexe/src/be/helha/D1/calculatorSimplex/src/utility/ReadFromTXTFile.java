package be.helha.D1.calculatorSimplex.src.utility;

/**
 * 
 * @author Olivier
 *
 * Cette classe permet de lire des données afin de faire les calculs.
 * les données sont les coefficiant et la liste des contraintes
 * 
 * Le format du fichier est TXT
 * 
 */
public class ReadFromTXTFile implements EntryInterface {
	
	public int action() {
		Controller.out.writeString("Lecture au format TXT\n");
		return 1;
	}

}
