package be.helha.D1.calculatorSimplex.src.utility;

import be.helha.D1.calculatorSimplex.src.exception.WrongEntryException;

/**
 * 
 * Cette classe permet de construire les choix des différents menus de l'application.
 * Le choix est représenté par cet classe.
 * Une interface est passé en paramètre afin de savoir quoi faire
 * 
 * @see Menu
 * @see EntryInterface
 * 
 * @author Olivier
 * 
 */
public class Entry{

	// Constructor
	protected Entry() {
		
	}
	
	public Entry(String name) throws WrongEntryException {
		this(0, name, null);
	}
	
	public Entry(String name, EntryInterface action) throws WrongEntryException {
		this(0, name, action);
	}
	
	public Entry(int nb, String name) throws WrongEntryException {
		this(nb, name, null);
	}
	
	public Entry(int nb, String name, EntryInterface action) throws WrongEntryException {
		setNb(nb);
		setName(name);
		_interface = action;
	}

	// Getter
	public int getNb() {
		return _nb;
	}
	
	public String getName() {
		return _name;
	}
	
	// Setter
	public void setNb(int arg) throws WrongEntryException {
		if (arg < 0 && arg > 9) {
			throw new WrongEntryException();
		}
		_nb = arg;
	}
	
	public void setName(String arg) throws WrongEntryException {
		if (arg.isEmpty()) {
			throw new WrongEntryException();
		}
		_name = arg;
	}
	
	// Method
	public void displayEntry() {
		Controller.out.writeEntry(this);
	}
	
	public int doAction() {
		if (_interface == null) {
			return 1;
		}
		return _interface.action();
	}
	
	// Attribute
	private int _nb;
	private String _name;
	private EntryInterface _interface;
}
