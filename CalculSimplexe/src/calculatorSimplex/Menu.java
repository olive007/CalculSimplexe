package calculatorSimplex;

public class Menu extends Entry {
	
	// Constructor
	public Menu(String name, Entry ... entrys) throws WrongEntryException {
		setNb(0);
		setName(name);
		_entrys = new Entry[entrys.length + 1];
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
		_entrys[entrys.length] = new Entry(9, "Retour", null);
	}
	
	public Menu(int nb, String name, Entry ... entrys) throws WrongEntryException {
		this(name, entrys);
		setNb(nb);
	}
	
	// Getter
	public int getNbEntry() {
		return _entrys.length;
	}
	
	// Method
	public void displayEntry() {
		Controller.out.write("[" + getNb() + "] Sous-Menu: " + getName() + "\n");
	}
	
	public void display() {
		Controller.out.write(getName() + "\n");
		for (int i = 0; i < _entrys.length; i++) {
			_entrys[i].displayEntry();
		}
	}
	
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
				Controller.out.error("Mauvais chriffre !!!");
			}
		} while (!exit);
		return error;
	}
	
	// Attribute
	private Entry[] _entrys;
}
