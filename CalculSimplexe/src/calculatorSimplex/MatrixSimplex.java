package calculatorSimplex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatrixSimplex implements Serializable {
	
	/**
	 * Version alpha
	 * December 2014;
	 */
	private static final long serialVersionUID = 5370224255246835399L;

	// Constructor
	public MatrixSimplex(List<Double> coefficiant, List<List<Double>> constraint) throws WrongMatrixSimplexException {
		_matrice = new ArrayList<ArrayList<Double>>();
		_n = coefficiant.size();
		_m = constraint.size();
		
		if (_n != constraint.get(0).size() - 1) {
			throw new WrongMatrixSimplexException();
		}
		int tmp = 0;
		for (int i = 0; i < _m; i++) {
			_matrice.add(new ArrayList<Double>());
			 for (int j = 0; j < _n; j++) {
				_matrice.get(i).add(new Double(constraint.get(i).get(j)));
			}
			for (int j = 0; j < _m; j++) {
				_matrice.get(i).add((tmp == j) ? 1. : 0.);
			}
			tmp++;
			_matrice.get(i).add(new Double(constraint.get(i).get(_n)));
		}
		_matrice.add(new ArrayList<Double>());
		for (int i = 0; i < coefficiant.size(); i++) {
			_matrice.get(_m).add(new Double(coefficiant.get(i)));
		}
		for (int i = 0; i < _m + 1; i++) {
			_matrice.get(_m).add(0.);
		}
	}
	
	private MatrixSimplex(MatrixSimplex src) {
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
		if (index < 0 && index >= _matrice.get(index).size()) {
			return null;
		}
		Double[] res = new Double[_matrice.get(index).size()];
		
		_matrice.get(index).toArray(res);
		return res;
	}
	
	public Double[] getLastLine() {
		return getLine(_matrice.get(0).size() - 1);
	}
	
	public Double[] getColumn(int index) {
		if (index < 0 && index >= _matrice.size()) {
			return null;
		}
		
		Double[] res = new Double[_matrice.size()];
		for (int i = 0; i < _matrice.size() - 1; i++) {
			for (int j = 0; j < res.length; j++) {
				res[j] = _matrice.get(i).get(index);
			}
		}
		return res;
	}
	
	public Double[] getLastColumn() {
		return getColumn(_matrice.size() - 1);
	}
	
	public Double[] getVarInBase() {
		Double[] res = new Double[_m + _n];
		
		for (int i = 0; i < _m + _n; i++) {
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
	public MatrixSimplex clone() {
		return new MatrixSimplex(this);
	}
	
	// Attribute
	private ArrayList<ArrayList<Double>> _matrice;
	private int _n; // Nombre de coefficiant
	private int _m; // Nombre de contraite
}
