package calculatorSimplex;

import java.util.List;

public  abstract class AlgorithmSimplex {
	
	public static MatriceSimplex  calcul(MatriceSimplex src){
		MatriceSimplex objMat = src.clone();
		return objMat;
	}
	
	public static int searchColumnPivot(MatriceSimplex objMat){
		int indColPivot=-1;
		
		for(int j=0;j<=objMat.getNbcolumn()-2;j++){
			if(indColPivot<objMat.getElement(objMat.getNbline()-1, j) && objMat.getElement(objMat.getNbline()-1, j)>=0) indColPivot=j;
		}
		
		return indColPivot;
	}
	
	public static int searchLinePivot(MatriceSimplex objMat, int indColPivot){
		int indLinePivot = 0;
		Double[] colPivot = objMat.getColumn(indColPivot);
		Double[] lastCol = objMat.getColumn(objMat.getNbcolumn()-1);
		Double[] ratio = new Double[objMat.getNbline()-1];
		double minRatio = 99999999.;
		
		for(int i=0;i<=objMat.getNbline()-2;i++){
			
			if(colPivot[i]!=0){
				
				if(lastCol[i]!=0 && colPivot[i]!=0){
					ratio[i] = lastCol[i]/colPivot[i];
				}
				
				else if(lastCol[i]==0 && colPivot[i]>0){
					ratio[i] = lastCol[i]/colPivot[i];
				}
			}
			
			else{
				ratio[i] = -1.;
			}
		}
			
		for(int i=0;i<=ratio.length-1;i++){
			
			if(minRatio>ratio[i] && ratio[i]>-1){
				minRatio = ratio[i];
				indLinePivot = i;
			}
				
		}
		
		return indLinePivot;
	}
	
	public static double calculPivot(MatriceSimplex objMat,int indLinePivot,int indColPivot){
		return objMat.getElement(indLinePivot, indColPivot);
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
	
	public static void SubstTwoLine(MatriceSimplex objMat, int indLinePivot, int indColPivot){
		double pivot = calculPivot(objMat, indLinePivot, indColPivot);
		
		for(int i=0; i<=objMat.getNbline()-1; i++){
			if(i != indLinePivot){
				
			}
		}
		
	}
	
	
	

}
