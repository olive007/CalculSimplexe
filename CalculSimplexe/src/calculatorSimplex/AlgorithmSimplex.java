package calculatorSimplex;

import java.util.List;

public  abstract class AlgorithmSimplex {
	
	public static MatriceSimplex  calcul(MatriceSimplex src){
		MatriceSimplex objMat = src.clone();
		return objMat;
	}
	
	public static int rechercherColonnePivot(MatriceSimplex objMat){
		int indColPivot=0;
		
		for(int j=0;j<=objMat.getNbcolumn()-2;j++){
			if(indColPivot<objMat.getElement(objMat.getNbline()-1, j)) indColPivot=j;
		}
		
		return indColPivot;
	}
	
	public static int rechercherLignePivot(MatriceSimplex objMat){
		int indColPivot = rechercherColonnePivot(objMat);
		
		double[] 
		
	}
	
	
	

}
