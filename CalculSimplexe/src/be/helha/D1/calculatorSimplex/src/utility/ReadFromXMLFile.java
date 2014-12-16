package be.helha.D1.calculatorSimplex.src.utility;

/**
*
* Cette classe permet de lire des données afin de faire les calculs.
* Les données sont les coefficients et la liste des contraintes
* 
* Le format du fichier est XML
* 
* Non Fini
* 
* @see ReadFromTXTFile
* 
* @author Olivier
* 
*/
public class ReadFromXMLFile implements EntryInterface {
	
	public int action() {
		Controller.out.writeString("Affichage au format XML\n");
		return 1;
	}

}
