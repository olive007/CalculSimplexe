package be.helha.D1.calculatorSimplex.src.utility;

import java.util.List;

import be.helha.D1.calculatorSimplex.src.exception.WrongEntryException;
import be.helha.D1.calculatorSimplex.src.exception.WrongMatrixSimplexException;
import be.helha.D1.calculatorSimplex.src.model.AlgorithmSimplex;
import be.helha.D1.calculatorSimplex.src.model.MatrixSimplex;

public class CalculLive implements EntryInterface {

	public int action() {
		Controller.out.writeString("Effectuer un calcul\n");
		MatrixSimplex matrix = null;
		
		do {
			int nbCoefficiant = Controller.in.readNbCoefficiant();
			int nbConstraint = Controller.in.readNbConstraint();
			List<Double> coefficiant = Controller.in.readCoefficiant(nbCoefficiant);
			List<List<Double>> constraint = Controller.in.readConstraint(nbCoefficiant, nbConstraint);
			
			try {
				matrix = new MatrixSimplex(coefficiant, constraint);
			}
			catch (WrongMatrixSimplexException e) {
				System.err.println("Error: " + e.getMessage());
				matrix = null;
			}
		} while (matrix == null || !matrix.isValid());
		MatrixSimplex[] res = AlgorithmSimplex.calcul(matrix);
		
		for (int i = 0; i < res.length; i++) {
			Controller.out.writeMatrix(res[i]);
		}
		
		Menu menu = null;
		try {
			menu = new Menu("Voulez-vous sauvegarder les résultats ?", 
					new Entry("Non"),
					new Entry("Oui", new SaveResult(res)));
		}
		catch (WrongEntryException e) {
			e.printStackTrace();
			return 1;
		}
		return menu.doAction();
	}

}
