package be.helha.D1.calculatorSimplex.src.model;

import java.util.ArrayList;

import calculatorSimplex.MatriceSimplex;

public abstract class AlgorithmSimplex {
	
	// Macro
	static final public int PIVOT_NOT_FOUND = -1;
	
	
	// Method
	static public MatrixSimplex[] calcul(MatrixSimplex matrice) {
		ArrayList<MatrixSimplex> res = new ArrayList<MatrixSimplex>();
		
		searchPivotLine(matrice);
		res.add(matrice);
		
		return (MatrixSimplex[]) res.toArray();
	}
	
	static private int searchPivotColumn(MatrixSimplex matrice) {
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
	

	static private int searchPivotLine(MatrixSimplex matrice) {
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
	
	public static void setPivotUnit(MatriceSimplex objMat, int indLinePivot, int indColPivot){
		double pivot = calculPivot(objMat, indLinePivot, indColPivot);
		
		for(int j=0;j<=objMat.getNbcolumn()-1;j++){
			Double elem = objMat.getElement(indLinePivot, j);
			elem /= pivot;
			System.out.println(elem);
			objMat.setElement(indLinePivot, j, elem);
		}
	}
	
	public static void SubstTwoLine(MatriceSimplex objMat,int indLine, int indLinePivot, int indColPivot){
		double pivot = calculPivot(objMat, indLinePivot, indColPivot);
		double member2 = objMat.getElement(indLine, indColPivot) * objMat.getElement(indLinePivot, indColPivot);
		double newElem;
		
		for(int j=0; j<=objMat.getNbcolumn()-1; j++){
			objMat.setElement(indLine, j, objMat.getElement(indLine, j) - member2);
		}
	}
	
	public static double calculPivot(MatriceSimplex objMat,int indLinePivot,int indColPivot){
		return objMat.getElement(indLinePivot, indColPivot);
	}
}
