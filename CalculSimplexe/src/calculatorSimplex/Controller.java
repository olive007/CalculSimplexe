package calculatorSimplex;

public class Controller {

	// Constructor
	public Controller() {
		in = new Reader();
		out = new Writer();
	}
	
	// Method
	public boolean init() {
		out.write("--- Calculator Symplexe ---\n");
		out.write("Démarrage...\n");
		try {
			_mainMenu = new Menu("Menu Principal",
					new Entry("Calculer", new CalculLive()),
					new Menu("Afficher les données",
							new Entry("TXT", new DisplayResultTXT()),
							new Entry("XML", new DisplayResultXML())));
		}
		catch (WrongEntryException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public int loop() {
		int error = 0;
		
		while (true) {
			_mainMenu.doAction();
			break;
		}
		return error;
	}
	
	public void close() {
		out.write("Fermeture du programme...\n");
	}
	
	// Attribute
	static protected Reader in;
	static protected Writer out;
	private Menu _mainMenu;
}
