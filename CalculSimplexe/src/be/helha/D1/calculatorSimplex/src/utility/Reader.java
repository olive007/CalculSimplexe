package be.helha.D1.calculatorSimplex.src.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Cette classe est une interface afin de récupérer les données depuis la console.
 * 
 * Vu que le projet doit être modifié afin d'utilisé avec une GUI, celle-ci sera complètement changé lors de la modification.
 * 
 * @author Olivier
 * 
 */
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
		if (_sc.hasNextLine()) {
			_sc.nextLine();
		}
		return res;
	}
	
	// Attribute
	private Scanner _sc;

	public int readNbCoefficiant() {
		int res = 0;
		
		do {
			System.out.print("Entrer le nombre de coefficiant: ");
			if (_sc.hasNextInt()) {
				res = _sc.nextInt();
			}
			else {
				System.err.println("Ceci n'est pas un nombre");
				_sc.nextLine();
			}
		}
		while (res <= 0);
		if (_sc.hasNextLine()) {
			_sc.nextLine();
		}
		return res;
	}
	
	public int readNbConstraint() {
		int res = 0;
		
		do {
			System.out.print("Entrer le nombre de contrainte: ");
			if (_sc.hasNextInt()) {
				res = _sc.nextInt();
			}
			else {
				System.err.println("Ceci n'est pas un nombre");
				_sc.nextLine();
			}
		}
		while (res <= 0);
		if (_sc.hasNextLine()) {
			_sc.nextLine();
		}
		return res;
	}

	public ArrayList<Double> readCoefficiant(int nbCoefficiant) {
		ArrayList<Double> res = new ArrayList<Double>();
		int i = 0;
		
		System.out.print("Entrer les coefficiants: ");
		while (i < nbCoefficiant) {
			if (_sc.hasNextDouble()) {
				double d = _sc.nextDouble();
				
				if (d >= 0) {
					res.add(d);
					i++;
				}
			}
			else {
				_sc.nextLine();
			}
		}
		if (_sc.hasNextLine()) {
			_sc.nextLine();
		}
		return res;
	}

	public List<List<Double>> readConstraint(int nbCoefficiant, int nbConstraint) {
		ArrayList<List<Double>> res = new ArrayList<List<Double>>();
		int i = 0;
		
		while (i < nbConstraint) {
			System.out.print("Entrer les contraintes " + (i + 1) + ": ");
			int j = 0;
			
			res.add(new ArrayList<Double>());
			while (j < nbCoefficiant + 1) {
				if (_sc.hasNextDouble()) {
					double d = _sc.nextDouble();
					
					if (d >= 0) {
						res.get(i).add(d);
						j++;
					}
				}
				else {
					_sc.next();
				}
			}
			i++;
		}
		if (_sc.hasNextLine()) {
			_sc.nextLine();
		}
		return res;
	}

	public String readFilename() {
		String res = "";
		
		do {
			System.out.print("Entrer un nom de fichier :");
			if (_sc.hasNextLine()) {
				res = _sc.nextLine();
				
			}
			else {
				System.err.println("Ceci n'est pas un nom");
				_sc.nextLine();
			}
		}
		while (res.equals(""));
		return res;
	}
	
}
