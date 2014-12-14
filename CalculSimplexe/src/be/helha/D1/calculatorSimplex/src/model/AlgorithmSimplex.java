package be.helha.D1.calculatorSimplex.src.model;

import java.util.ArrayList;

import be.helha.D1.calculatorSimplex.src.exception.WrongIndexMatrix;

public abstract class AlgorithmSimplex {
	
	// Macro
	static final public int PIVOT_NOT_FOUND = -1;
	
	
	// Method
	static public MatrixSimplex[] calcul(MatrixSimplex matrice) {
		ArrayList<MatrixSimplex> res = new ArrayList<MatrixSimplex>();
		
		res.add(matrice);
		int columnPivot;
		MatrixSimplex tmp = matrice;
		
		while ((columnPivot = searchPivotColumn(tmp)) == PIVOT_NOT_FOUND) {
			tmp = doIteration(tmp, columnPivot);
			res.add(tmp);
		}
		
		MatrixSimplex[] tab = new MatrixSimplex[res.size()];
		return res.toArray(tab);
	}
	
	static private int searchPivotColumn(MatrixSimplex matrice) {
		int res = 0;
		double[] lastLine = matrice.getLastLine();
		
		if (lastLine == null) {
			return PIVOT_NOT_FOUND;
		}
		double previous = 0.;
		
		for (int i = 0; i < lastLine.length - 1; i++) {
			if (lastLine[i] > previous) {
				previous = lastLine[i];
				res = i;
			}
		}
		return res;
	}
	
	static private MatrixSimplex doIteration(MatrixSimplex matrice, int columnPivot) {
		int linePivot = searchPivotLine(matrice, columnPivot);
		MatrixSimplex tmp = matrice.clone();
		
		setUnitPivot(tmp, columnPivot, linePivot);
		for (int i = 0; i <= tmp.getNbLine() - 1; i++) {
			if (i != linePivot) {
				substractLine(tmp, i, columnPivot, linePivot);
			}
		}
		return tmp;
	}
	
	static private int searchPivotLine(MatrixSimplex matrice, int columnPivot) {
		double[] pivotColumn = matrice.getColumn(columnPivot);
		double[] lastColumn = matrice.getLastColumn();
		
		if (pivotColumn == null || lastColumn == null) {
			return PIVOT_NOT_FOUND;
		}
		int res = 0;
		double previous = 99999999999.;
		
		for (int i = 0; i < pivotColumn.length - 1; i++) {
			if (pivotColumn[i] > 0) {
				double tmp =  lastColumn[i] / pivotColumn[i];
				
				if (tmp < previous) {
					previous = tmp;
					res = i;
				}
			}
		}
		return res;
	}
	
	static private void setUnitPivot(MatrixSimplex matrice, int linePivot, int columnPivot) {
		double pivot = matrice.getElement(linePivot, columnPivot);
		
		for(int j = 0; j <= matrice.getNbColumn() - 1; j++) {
			try {
				matrice.setElement(linePivot, j, matrice.getElement(linePivot, j) / pivot);
			}
			catch (WrongIndexMatrix e) {
				e.printStackTrace();
			}
		}
	}

	static private void substractLine(MatrixSimplex matrice, int indexLine, int linePivot, int columnPivot) {
		double multiplier = matrice.getElement(indexLine, columnPivot);
		
		for (int j = 0; j < matrice.getNbColumn(); j++) {
			try {
				double res = matrice.getElement(indexLine, j) - multiplier * matrice.getElement(linePivot, j);
				matrice.setElement(indexLine, j, res);
			}
			catch (WrongIndexMatrix e) {
				e.printStackTrace();
			}
		}
	}
	
}
