package calculatorSimplex;

public class DisplayResultTXT implements EntryInterface {
	
	public int action() {
		Controller.out.writeString("Affichage au format TXT\n");
		return 1;
	}

}
