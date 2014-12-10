package calculatorSimplexe;

import java.util.ArrayList;
import java.util.List;

public class AlgoSimplexe {
	
	public AlgoSimplexe(){
		
	}

	public void  calcul(){
	
	}
	
	public int rechercherColonnePivot(List<Double> ligne){
		int colPivot=0;
		
		for(int i=0;i<=ligne.size()-2;i++){
			if(colPivot<ligne.get(i)) colPivot=i;
		}
		
		return colPivot;
	}
	
	public int rechercherLignePivot(List<List<Double>> matrice){
		int lignePivot = 0;
		int colPivot = rechercherColonnePivot(matrice.get(matrice.size()-1));
		double[] elements = new double[matrice.size()-1];
		double elem = 999999999.;
		
		for (int i=0;i<=matrice.size()-2;i++){

			if(matrice.get(i).get(colPivot)!=0){  // Si l'élément de la colonne du pivot est égal à 0
														   // On entre pas car on aurra une division par 0.
				if(matrice.get(i).get(matrice.get(0).size()-1)!=0){  // Il faut vérifier que l'élément de la dernière colonne soit != de 0.
					elements[i] = matrice.get(i).get(matrice.get(0).size()-1)/matrice.get(i).get(colPivot); 
				}		// elements[i] contient le résultat de la division pour chaque ligne																						
			}			// (sauf la dernière) de l'élément de la dernière colonne par l'élément de la colonne du pivot.


			else if(matrice.get(i).get(matrice.get(0).size()-1)==0 && matrice.get(i).get(colPivot)>0){
				elements[i] = matrice.get(i).get(matrice.get(0).size()-1)/matrice.get(i).get(colPivot);
			}  // Si l'élément de la dernière colonne == 0, on vérifie que l'élément de la colonne du pivot est positif.
			   // Si c'est le cas, on peut effectuer une division comme faite plus haut.

			else{
				elements[i] = -1;
				// Si aucune des conditions n'est respectée, l'élément d'indice i obtient -1 comme valeur.
			}
		}
		
		for(int i=0;i<=elements.length-1;i++){
			if(elem>elements[i] && elements[i]>=0){ // Si la valeur de elements[i] est >=0 et < que la valeur de elem
				elem = elements[i]; // elem prend comme valeur elements[i]
				lignePivot = i;	// La valeur de la ligne du pivot correspond à i
			}
		}

		return lignePivot; 
	}


	public double calculPivot(List<List<Double>> matrice){
		int col = rechercherColonnePivot(matrice.get(matrice.size()-1));  // col contient la colonne du pivot
		int ligne = rechercherLignePivot(matrice);	// ligne contient la ligne du pivot
		double pivot = matrice.get(ligne).get(col);
		return pivot;
	}
	
	public List<Double> rendrePivotUnitaire(List<Double> lignePivot,double pivot){
		List<Double> ligneClone = new ArrayList<>();
		ligneClone.addAll(lignePivot);
	
		for(int i=0;i<=ligneClone.size()-1;i++){
			ligneClone.set(i, ligneClone.get(i)/pivot);
		}
		return ligneClone;
	}
	
	public List<Double> additionnerDeuxLigne(List<Double> ligne,List<Double> lignePivot,double pivot){
		List<Double> ligneClone = new ArrayList<>();
		ligneClone.addAll(ligne);
		
		for(int i=0;i<=ligneClone.size()-1;i++){
			ligneClone.set(i, ligneClone.get(i)/pivot);
		}
		
		
		
		return ligneClone;
		
	}
	
	
}