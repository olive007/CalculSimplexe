package be.helha.D1.calculatorSimplex.src.model;

import java.util.ArrayList;

import be.helha.D1.calculatorSimplex.src.exception.WrongIndexMatrix;

public abstract class AlgorithmSimplex {
	
	// Macro
	static final private int PIVOT_NOT_FOUND = -1;
	
	// Method
	static public MatrixSimplex[] calcul(MatrixSimplex matrix) {
		ArrayList<MatrixSimplex> res = new ArrayList<MatrixSimplex>();
		int columnPivot;
		MatrixSimplex tmp = matrix;
		
		res.add(matrix);
		while ((columnPivot = searchPivotColumn(tmp)) != PIVOT_NOT_FOUND) {
			tmp = tmp.clone();
			doIteration(tmp, columnPivot);
			res.add(tmp);
		}
		MatrixSimplex[] tab = new MatrixSimplex[res.size()];
		
		return res.toArray(tab);
	}
	
	static private int searchPivotColumn(MatrixSimplex matrix) {
		int res = PIVOT_NOT_FOUND;
		double[] lastLine = matrix.getLastLine();
		
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
	
	static private MatrixSimplex doIteration(MatrixSimplex matrix, int columnPivot) {
		int linePivot = searchPivotLine(matrix, columnPivot);
		
		setUnitPivot(matrix, linePivot, columnPivot);
		for (int i = 0; i <= matrix.getNbLine() - 1; i++) {
			if (i != linePivot) {
				substractLine(matrix, i, linePivot, columnPivot);
			}
		}
		return matrix;
	}
	
	static private int searchPivotLine(MatrixSimplex matrix, int columnPivot) {
		double[] pivotColumn = matrix.getColumn(columnPivot);
		double[] lastColumn = matrix.getLastColumn();
		
		if (pivotColumn == null || lastColumn == null) {
			return PIVOT_NOT_FOUND;
		}
		int res = 0;
		double previous = 99999999999.;
		
		for (int i = 0; i < pivotColumn.length - 1; i++) {
			if (pivotColumn[i] > 0.) {
				double tmp =  lastColumn[i] / pivotColumn[i];
				
				if (tmp < previous) {
					previous = tmp;
					res = i;
				}
			}
		}
		return res;
	}
	
	static private void setUnitPivot(MatrixSimplex matrix, int linePivot, int columnPivot) {
		double pivot = matrix.getElement(linePivot, columnPivot);
		
		for(int j = 0; j <= matrix.getNbColumn() - 1; j++) {
			try {
				double res = matrix.getElement(linePivot, j);
				
				matrix.setElement(linePivot, j, res / pivot);
			}
			catch (WrongIndexMatrix e) {
				e.printStackTrace();
			}
		}
	}

	static private void substractLine(MatrixSimplex matrix, int indexLine, int linePivot, int columnPivot) {
		double multiplier = matrix.getElement(indexLine, columnPivot);
		
		for (int j = 0; j < matrix.getNbColumn(); j++) {
			try {
				double res = matrix.getElement(indexLine, j) - multiplier * matrix.getElement(linePivot, j);
				
				matrix.setElement(indexLine, j, res);
			}
			catch (WrongIndexMatrix e) {
				e.printStackTrace();
			}
		}
	}
	
}
