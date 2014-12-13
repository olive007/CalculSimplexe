package be.helha.D1.calculatorSimplex.src.utility;


public class DisplayResultTXT implements EntryInterface {
	
	public int action() {
		Controller.out.writeString("Affichage au format TXT\n");
		return 1;
	}

}
