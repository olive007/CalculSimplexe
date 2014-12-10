package calculatorSimplex;

public class Entry{

	// Constructor
	protected Entry() {
		
	}
	
	public Entry(String name, EntryInterface action) throws WrongEntryException {
		setNb(0);
		setName(name);
		_interface = action;
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
		Controller.out.write("[" + _nb + "] " + _name + "\n");
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
