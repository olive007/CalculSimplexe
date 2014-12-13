package be.helha.D1.calculatorSimplex.src.utility;

import be.helha.D1.calculatorSimplex.src.exception.WrongEntryException;
import be.helha.D1.calculatorSimplex.src.view.Reader;
import be.helha.D1.calculatorSimplex.src.view.Writer;

public class Controller {

	// Constructor
	public Controller() {
		in = new Reader();
		out = new Writer();
	}
	
	// Method
	public boolean init() {
		out.writeString("--- Calculator Symplexe ---\n");
		out.writeString("Démarrage...\n");
		try {
			_mainMenu = new Menu("Menu Principal",
					new Entry("Effectuer un calcul", new CalculLive()),
					new Menu("Afficher les données",
							new Entry("TXT", new DisplayResultTXT()),
							new Entry("XML", new DisplayResultXML()),
							new Entry(9, "Retour")),
					new Entry(9, "Quiter"));
		}
		catch (WrongEntryException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public int loop() {
		int error = 0;
		
		error = _mainMenu.doAction();
		return error;
	}
	
	public void close() {
		out.writeString("Fermeture du programme...\n");
	}
	
	// Attribute
	static protected Reader in;
	static protected Writer out;
	private Menu _mainMenu;
}
