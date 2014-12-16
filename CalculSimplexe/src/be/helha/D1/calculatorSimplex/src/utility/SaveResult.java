package be.helha.D1.calculatorSimplex.src.utility;

import be.helha.D1.calculatorSimplex.src.exception.WrongEntryException;
import be.helha.D1.calculatorSimplex.src.model.MatrixSimplex;

/**
 * 
 * Cette classe permet de choisir dans quel format de fichier il faut écrire le fichier.
 * 
 * C'est aussi une généralisation car l'atribute "_resultat" est identique aux classe appelé depuis ce menu.
 * 
 * Elle renvoie toujours 1 car même si le fichier n'a pas pu être enregistré le programme doit continuer.
 *
 * @see SaveResultTXT
 * @see SaveResultXML
 * 
 * @author Olivier
 * 
 */

public class SaveResult implements EntryInterface {

	public SaveResult(MatrixSimplex[] resultat) {
		_resultat = resultat;
	}
	
	public int action() {
		Menu menu = null;
		
		try {
			menu = new Menu("Format",
					new Entry("TXT", new SaveResultTXT(_resultat)),
					new Entry("XML", new SaveResultXML(_resultat)));
		} catch (WrongEntryException e) {
			e.printStackTrace();
			return 1;
		}
		menu.doAction();
		return 1;
	}
	
	// Attribute
	protected MatrixSimplex[] _resultat;
	
}
