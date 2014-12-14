package be.helha.D1.calculatorSimplex.src.utility;

import java.util.Scanner;

public class Reader {

	// Constructor
	public Reader() {
		_sc = new Scanner(System.in);
	}
	
	// Method
	public int readChoise() {
		int res = -1;

		do {
			System.out.print("Entrer un chrifre pour sélectioner l'action: ");
			if (_sc.hasNextInt()) {
				res = _sc.nextInt();
				if (res < 0 || res > 9) {
					System.err.println("Ceci n'est pas un chriffre");					
				}
			}
			else {
				System.err.println("Ceci n'est pas un chriffre");
				_sc.nextLine();
			}
		}
		while (res < 0 || res > 9);
		return res;
	}
	
	// Attribute
	private Scanner _sc;
}
