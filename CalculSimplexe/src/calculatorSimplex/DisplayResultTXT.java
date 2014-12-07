package calculatorSimplex;

public class DisplayResultTXT implements EntryInterface {
	
	public int action() {
		Controller.out.write("Affichage au format TXT\n");
		return 1;
	}

}
