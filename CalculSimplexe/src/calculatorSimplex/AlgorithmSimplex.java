package calculatorSimplex;

import java.util.ArrayList;
import java.util.List;

public abstract class AlgorithmSimplex {
	
	// Macro
	static final public int PIVOT_NOT_FOUND = -1;
	
	
	// Method
	static public MatriceSimplex[] calcul(MatriceSimplex matrice) {
		ArrayList<MatriceSimplex> res = new ArrayList<MatriceSimplex>();
		
		res.add(matrice);
		
		return (MatriceSimplex[]) res.toArray();
	}
	
	static private int searchPivotColumn(MatriceSimplex matrice) {
		int res = 0;
		Double[] lastColumn = matrice.getLastColumn();
		
		if (lastColumn == null) {
			return PIVOT_NOT_FOUND;
		}
		Double previus = lastColumn[0];
		
		for (int i = 0; i < lastColumn.length - 1; i++) {
			if (lastColumn[i] > previus) {
				res = i;
			}
		}
		return res;
	}
	

	static private int searchPivotLine(MatriceSimplex matrice) {
		Double[] pivotColumn = matrice.getColumn(searchPivotColumn(matrice));
		Double[] lastColumn = matrice.getLastColumn();
		
		if (pivotColumn == null || lastColumn == null) {
			return PIVOT_NOT_FOUND;
		}
		int res = 0;
		Double previus = 999999999.;
		
		for (int i = 0; i < pivotColumn.length - 1; i++) {
			if (pivotColumn[i] > 0) {
				Double tmp =  lastColumn[i] / pivotColumn[i];
				
				if (tmp < 0 && tmp < previus) {
					res = i;
				}
			}
		}
		return res;
	}
}
