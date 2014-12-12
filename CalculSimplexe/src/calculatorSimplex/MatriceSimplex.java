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
		
		int tmp = 0;
		for (int i = 0; i < _m; i++) {
			_matrice.add(i, new ArrayList<Double>());
			for (int j = 0; j < contrainte.get(i).size() - 2; j++) {
				_matrice.get(i).add(j, contrainte.get(i).get(j));
			}
			for (int j = 0; j < _m - 1; j++) {
				_matrice.get(i).add(j + _m - 1, (tmp == j) ? 1. : 0.);
			}
			tmp++;
			_matrice.get(i).add(contrainte.get(i).get(contrainte.get(i).size() - 1));
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
	
	public Double[] getLine(int index) {
		if (index < 0 && index >= _matrice.size()) {
			return null;
		}
		return (Double[]) _matrice.get(index).toArray();
	}
	
	public Double[] getLastLine() {
		return getLine(_matrice.size() - 1);
	}
	
	public Double[] getColumn(int index) {
		if (index < 0 && index >= _matrice.get(0).size()) {
			return null;
		}
		
		Double[] res = new Double[_matrice.get(0).size()];
		for (int i = 0; i < _matrice.size() - 1; i++) {
			for (int j = 0; j < res.length; j++) {
				res[j] = _matrice.get(i).get(index);
			}
		}
		return res;
	}
	
	public Double[] getLastColumn() {
		return getColumn(_matrice.get(0).size() - 1);
	}
	
	public Double[] getVarInBase() {
		Double[] res = new Double[_m + _n];
		
		for (int i = 0; i < _m + _n - 1; i++) {
			res[i] = 0.;
			Double[] column = getColumn(i);
			
			int pos = -1;
			int nbZero = 0;
			for (int j = 0; j < column.length; j++) {
				if (column[j] == 1) {
					pos = j;
				} else if (column[j] == 0) {
					nbZero++;
				}
			}
			if (nbZero == column.length - 1 && pos != -1) {
				res[i] = column[pos];
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
	public MatriceSimplex clone() {
		return new MatriceSimplex(this);
	}
	
	// Attribute
	private ArrayList<ArrayList<Double>> _matrice;
	private int _n; // Nombre de coefficiant
	private int _m; // Nombre de contraite
}
