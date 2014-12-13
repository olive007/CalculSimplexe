package be.helha.D1.calculatorSimplex.src.utility;

import java.util.ArrayList;
import java.util.List;

import be.helha.D1.calculatorSimplex.src.exception.WrongEntryException;
import be.helha.D1.calculatorSimplex.src.exception.WrongMatrixSimplexException;
import be.helha.D1.calculatorSimplex.src.model.MatrixSimplex;

public class CalculLive implements EntryInterface {

	public int action() {
		Controller.out.writeString("Calcul en direct\n");
		List<Double> coefficiant = new ArrayList<Double>();
		List<List<Double>> constraint = new ArrayList<List<Double>>();

		coefficiant.add(2.);
		coefficiant.add(3.);
		coefficiant.add(-888888884.);

		constraint.add(new ArrayList<Double>(coefficiant));
		constraint.add(new ArrayList<Double>(coefficiant));
		constraint.add(new ArrayList<Double>(coefficiant));
		constraint.add(new ArrayList<Double>(coefficiant));
		constraint.add(new ArrayList<Double>(coefficiant));
		
		coefficiant.remove(0);
		
		MatrixSimplex matrice = null;
		try {
			matrice = new MatrixSimplex(coefficiant, constraint);
			Controller.out.writeMatrice(matrice);
		}
		catch (WrongMatrixSimplexException e) {
			e.printStackTrace();
		}
		
		Menu menu = null;
		try {
			menu = new Menu("Voulez-vous sauvegarder les résultats ?", 
					new Entry("Non"),
					new Entry("Oui", new SaveResult()));
		}
		catch (WrongEntryException e) {
			e.printStackTrace();
			return 1;
		}
		return menu.doAction();
	}

}
