package calculatorSimplex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatriceSimplexe implements Serializable {
	
	/**
	 * Version alpha
	 * December 2014;
	 */
	private static final long serialVersionUID = 5370224255246835399L;

	// Constructor
	public MatriceSimplexe(List<Double> coefficiant, List<List<Double>> contrainte) {
		_n = coefficiant.size();
		_m = contrainte.size();
		
		int tmp = 0;
		for (int i = 0; i < _m; i++) {
			_matrice.add(i, new ArrayList<Double>());
			for (int j = 0; j < contrainte.get(i).size() - 2; j++) {
				_matrice.get(i).add(j, contrainte.get(i).get(j));
			}
			for (int j = 0; j < _m - 1; j++) {
				_matrice.get(i).add(j + _m - 1, tmp == j ? 1. : 0.);
			}
			tmp++;
			_matrice.get(i).add(contrainte.get(i).get(contrainte.get(i).size() - 1));
		}
	}
	
	private MatriceSimplexe(MatriceSimplexe src) {
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
	
	public Double[] getLine(int i) {
		Double[] res = _matrice.get(i).toArray();

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
	
	// Method
	public MatriceSimplexe clone() {
		return new MatriceSimplexe(this);
	}
	
	// Attribute
	private ArrayList<ArrayList<Double>> _matrice;
	private int _n; // Nombre de coefficiant
	private int _m; // Nombre de contraite
}
