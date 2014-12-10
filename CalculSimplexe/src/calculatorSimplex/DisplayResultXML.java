package calculatorSimplex;

public class DisplayResultXML implements EntryInterface {
	
	public int action() {
		Controller.out.writeString("Affichage au format XML\n");
		return 1;
	}

}
