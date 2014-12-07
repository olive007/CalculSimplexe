package calculatorSimplex;

import java.util.Scanner;

public class Reader {

	// Constructor
	public Reader() {
	
	}
	
	// Method
	public String read() {
		String res = "";
		
		return res;
	}
	
	public int readChoise() {
		int res = -1;
		Scanner in = new Scanner(System.in);
		
		do {
			Controller.out.write("Entrer un chrifre pour sélectioner l'action: ");
			if (in.hasNextInt()) {
				res = in.nextInt();
				if (res < 0 || res > 9) {
					Controller.out.error("Ceci n'est pas un chriffre");					
				}
			}
			else {
				Controller.out.error("Ceci n'est pas un chriffre");
				in.nextLine();
			}
		}
		while (res < 0 || res > 9);
		return res;
	}
}
