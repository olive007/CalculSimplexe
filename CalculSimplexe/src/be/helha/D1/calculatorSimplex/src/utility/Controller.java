package be.helha.D1.calculatorSimplex.src.utility;

import be.helha.D1.calculatorSimplex.src.exception.WrongEntryException;

/**
 * 
 * @author Olivier
 *
 * Cette classe est le départ du programme elle est dois etre initialisé
 * afin de pouvoir demarré le programme
 *
 */

public class Controller {

	// Constructor
	/**
	 * Ce constructeur initialise les differentes relation entre les objets
	 * dont il depent
	 * 
	 */
	public Controller() {
		in = new Reader();
		out = new Writer();
		_inited = false;
	}
	
	// Method
	/**
	 * 
	 * Cette méthode est utilisé afin d'initialiser le programme.
	 * La différence entre la construction du Controller et cette methode est le fait
	 * que c'est methode charge tous les données nécessaire pour le démarrage.
	 * 
	 * @return Réusite ou pas
	 */
	public boolean init() {
		out.writeString("--- Calculator Symplexe ---\n");
		out.writeString("Démarrage...\n");
		try {
			_mainMenu = new Menu("Effectuer des calculs",
					new Entry("Entrer les données manuellement", new CalculLive()),
					new Menu("Récuperer les données depuis un fichier",
							new Entry("TXT", new ReadFromTXTFile()),
							new Entry("XML", new ReadFromXMLFile()),
							new Entry(9, "Retour")),
					new Entry(9, "Quiter"));
		}
		catch (WrongEntryException e) {
			e.printStackTrace();
			return false;
		}
		_inited = true;
		return true;
	}

	/**
	 * Cette methode est la boucle principale du programme.
	 * Tout commence et termine dans cette boucle.
	 * 
	 * @return une valeur si différente de 0 si une erreur c'est produite.
	 */
	public int loop() {
		if (!_inited) {
			return -1;
		}
		int error = 0;
		
		error = _mainMenu.doAction();
		return error;
	}
	
	/**
	 * Cette methode ferme le Controller
	 * 
	 */
	public void close() {
		out.writeString("Fermeture du programme...\n");
		in = null;
		out = null;
		_mainMenu = null;
		_inited = false;
	}
	
	// Attribute shared
	/**
	 * Les atributs "in" et "out" sont mis en protected afin d'être
	 * utilisé dans les classe du meme package.
	 * 
	 */
	static protected Reader in;
	static protected Writer out;
	
	// Attribute
	private Menu _mainMenu;
	private boolean _inited;
}
