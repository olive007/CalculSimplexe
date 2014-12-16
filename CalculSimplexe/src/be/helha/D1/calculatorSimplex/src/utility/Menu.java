package be.helha.D1.calculatorSimplex.src.utility;

import be.helha.D1.calculatorSimplex.src.exception.WrongEntryException;


/**
 * 
 * Cette classe permet de construire les menus de l'application.
 * Un menu signifie un choix de l'utilistateur.
 * Menu est un spécialisation de Entry car une entré peut être un sous-menu.
 *
 * @see Entry
 * 
 * @author Olivier
 * 
 */
public class Menu extends Entry {
	
	// Constructor
	public Menu(String name, Entry ... entrys) throws WrongEntryException {
		this(0, name, entrys);
	}
	
	public Menu(int nb, String name, Entry ... entrys) throws WrongEntryException {
		setNb(nb);
		setName(name);
		_entrys = new Entry[entrys.length];
		if (entrys.length > 9) {
			throw new WrongEntryException();
		}
		
		int tmp = -1;
		for (int i = 0; i < entrys.length; i++) {
			if (i <= tmp) {
				throw new WrongEntryException();
			}
			_entrys[i] = entrys[i];
			if (_entrys[i].getNb() == 0) {
				_entrys[i].setNb(i);
			}
			tmp = i;
		}
	}
	
	// Getter
	public int getNbEntry() {
		return _entrys.length;
	}
	
	public Entry getEntry(int i) {
		if (i < 0 && i >= _entrys.length) {
			return null;
		}
		return _entrys[i];
	}
	
	// Method
	/**
	 * Cet methode affiche le nom de l'entrée.
	 * C'est une redéfinition de la fonction de la classe mere
	 */
	public void displayEntry() {
		Controller.out.writeEntry(this);
	}
	
	/**
	 * Cet methode affiche le menu. 
	 */
	public void display() {
		Controller.out.writeMenu(this);
	}
	
	/**
	 * Elle affiche le menu puis demande de choisir une entrée.
	 * Cet methode boucle juste l'un d'une des entrées renvoie 1.
	 */
	public int doAction() {
		int error = 0;
		boolean exit = false;
		
		do {
			display();
			int choise = Controller.in.readChoise();
			int i;
			
			for (i = 0; i < _entrys.length; i++) {
				if (_entrys[i] != null && _entrys[i].getNb() == choise) {
					if (_entrys[i].doAction() == 1) {
						exit = true;
					}
					break;
				}
			}
			if (i == _entrys.length) {
				Controller.out.writeError("Mauvais chriffre !!!");
			}
		} while (!exit);
		return error;
	}
	
	// Attribute
	private Entry[] _entrys;
}
