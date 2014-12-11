package calculatorSimplex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatriceSimplex implements Serializable {
	
	/**
	 * Version alpha
	 * December 2014;
	 */
	private static final long serialVersionUID = 5370224255246835399L;

	// Constructor
	public MatriceSimplex(List<Double> coefficiant, List<List<Double>> contrainte) {
		_n = coefficiant.size();
		_m = contrainte.size();
		_matrice = new ArrayList<List<Double>>();
		
		int tmp = 0;
		for (int i = 0; i < _m; i++) {
			_matrice.add(i, new ArrayList<Double>());
			for (int j = 0; j < _n; j++) {
				_matrice.get(i).add(j, contrainte.get(i).get(j));
			}
			for (int j = 0; j < _m ; j++) {
				_matrice.get(i).add(j + _n , (tmp == j ? 1. : 0.));
			}
			tmp++;
			_matrice.get(i).add(contrainte.get(i).get(contrainte.get(0).size()-1));
			
		}
		
		_matrice.add(_m, new ArrayList<Double>());
		
		for (int j = 0; j < coefficiant.size(); j++){
			_matrice.get(_m).add(coefficiant.get(j));
		}
		for(int j = coefficiant.size(); j< _matrice.get(0).size(); j++){
			_matrice.get(_m).add(0.);
		}
	}
	
	private MatriceSimplex(MatriceSimplex src) {
		for (int i = 0; i < _matrice.size(); i++) {
			_matrice.add(new ArrayList<Double>(src._matrice.get(i)));
		}
		_n = src._n;
		_m = src._m;
	}
	
	// Getter
	public int getN() {
		return _n;
	}
	
	public int getM() {
		return _m;
	}
	
	public Double getZ() {
		Double z = _matrice.get(_matrice.size() - 1).get(_matrice.get(0).size() - 1);
		
		return (z < 0) ? z * -1. : z;
	}
	
	//Christophe : J'ai rajouté un cast
	public Double[] getLine(int i) {
		Double[] res = (Double[]) _matrice.get(i).toArray();

		return res;
	}
	
	public Double[] getColumn(int j){
		Double[] res = new Double[_m + 1];
		
		for(int i = 0; i < _matrice.size() - 1; i++) {
			res[i] = getElement(i, j);
		}
		
		return res;
	}
	
	public Double[] getVarInBase() {
		Double[] res = new Double[_m + _n];
		
		for (int i = 0; i < _m + _n - 1; i++) {
			res[i] = 0.;
		}
		for (int i = 0; i < _matrice.size() - 1; i++) {
			for (int j = 0; j < _matrice.get(i).size() - 1; i++) {	
				_matrice.get(i).get(j);
			}
		}
		return res;
	}
	
	public int getNbcolumn() {
		return _matrice.get(0).size();
	}
	
	public int getNbline() {
		return _matrice.size();
	}
	
	public Double getElement(int x, int y) {
		return _matrice.get(x).get(y);
	}
	
	// Setter
	public void setElement(int x, int y, Double element) {
		_matrice.get(x).set(y, element);
	}
	
	//Equals
	public boolean equals(Object o){
		if(o instanceof MatriceSimplex){
			if(_m!=(((MatriceSimplex)o).getM()) || _n!=(((MatriceSimplex)o).getN()))return false;
			
			for(int i=0;i<=_matrice.size()-1;i++){
				if(!_matrice.get(i).contains(((MatriceSimplex)o).getLine(i)))return false;
			}
			
			return true;
		}
		return false;
	}
	
	// Method
	public MatriceSimplex clone() {
		return new MatriceSimplex(this);
	}
	
	// Attribute
	private List<List<Double>> _matrice;
	private int _n; // Nombre de coefficiant
	private int _m; // Nombre de contraite
	
}
