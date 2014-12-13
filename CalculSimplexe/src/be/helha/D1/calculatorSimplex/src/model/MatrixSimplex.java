package be.helha.D1.calculatorSimplex.src.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import be.helha.D1.calculatorSimplex.src.exception.WrongIndexMatrix;
import be.helha.D1.calculatorSimplex.src.exception.WrongMatrixSimplexException;

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
		_matrice = new ArrayList<ArrayList<Double>>();
		for (int i = 0; i < src.getNbLine(); i++) {
			_matrice.add(new ArrayList<Double>());
			for (int j = 0; j < src.getNbColumn(); j++) {
				_matrice.get(i).add(new Double(src.getElement(i, j)));
			}
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
		Double z = _matrice.get(getNbLine() - 1).get(getNbColumn() - 1);
		
		return (z < 0) ? z * -1. : z;
	}
	
	public Double[] getLine(int index) {
		if (index < 0 && index >= getNbLine()) {
			return null;
		}
		Double[] res = new Double[getNbColumn()];
		
		_matrice.get(index).toArray(res);
		return res;
	}
	
	public Double[] getLastLine() {
		return getLine(getNbLine() - 1);
	}
	
	public Double[] getColumn(int index) {
		if (index < 0 && index >= getNbColumn()) {
			return null;
		}
		
		Double[] res = new Double[getNbLine()];
		for (int i = 0; i < getNbLine(); i++) {
			res[i] = _matrice.get(i).get(index);
		}
		return res;
	}
	
	public Double[] getLastColumn() {
		return getColumn(getNbColumn() - 1);
	}
	
	public Double[] getVarInBase() {
		Double[] res = new Double[getNbColumn() - 1];
		Double[] lastColumn = getLastColumn();
		
		for (int i = 0; i < getNbColumn() - 1; i++) {
			res[i] = 0.;
			Double[] column = getColumn(i);
			int pos = 0;
			int nbZero = 0;
			int nbOne = 0;
			
			for (int j = 0; j < column.length - 1; j++) {
				if (column[j] == 0) {
					nbZero++;
				}
				else if (column[j] == 1) {
					nbOne++;
					pos = j;
				}
			}
			if (nbZero == column.length - 2 && nbOne == 1) {
				res[i] = lastColumn[pos];
			}
		}
		return res;
	}
	
	public int getNbLine() {
		return _matrice.size();
	}
	
	public int getNbColumn() {
		return _matrice.get(0).size();
	}
	
	public Double getElement(int line, int column) {
		if (line < 0 || line >= getNbLine() ||
				column < 0 || column >= getNbColumn()) {
			return null;
		}
		return _matrice.get(line).get(column);
	}
	
	// Setter
	public void setElement(int line, int column, Double element) throws WrongIndexMatrix {
		if (line < 0 || line >= getNbLine() ||
				column < 0 || column >= getNbColumn()) {
			throw new WrongIndexMatrix();
		}
		_matrice.get(line).set(column, element);
	}
	
	// Method
	public MatrixSimplex clone() {
		MatrixSimplex tmp = new MatrixSimplex(this);
		return tmp;
	}
	
	public boolean isValid() {
		int nb = 0;
		
		for (int i = 0; i < getNbColumn() - 1; i++) {
			Double[] column  = getColumn(i);
			int nbZero = 0;
			int nbOne = 0;
			
			for (int j = 0; j < column.length - 1; j++) {
				if (column[j] == 0.) {
					nbZero++;
				}
				else if (column[j] == 1.) {
					nbOne++;
				}
			}
			if (nbOne == 1 && nbZero == column.length - 2) {
				nb++;
			}
		}
		if (nb != _n) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		String res = "";
		
		for (int i = 0; i < getNbLine(); i++) {
			Double[] line = getLine(i);
			
			res += "| ";
			for (int j = 0; j < line.length; j++) {
				if (j == _n - 1 || j == _m + _n - 1) {
					res += String.format("%11.4e | ", line[j]);
				}
				else if (j == line.length - 1) {
					res += String.format("%11.4e", line[j]);
				}
				else {
					res += String.format("%11.4e ", line[j]);
				}
			}
			res += " |\r\n";
			if (i == getNbLine() - 2) {
				for (int j = 0; j < line.length; j++) {
					res += "------------";
				}
				res += "-------\r\n";
			}
		}
		Double[] sb = getVarInBase();
		
		res += "\r\nVariable dans la base : (";
		for (int i = 0; i < sb.length; i++) {
			if (i == sb.length - 1) {  
				res += String.format("%9.3e", sb[i]);
			}
			else {
				res += String.format("%9.3e ", sb[i]);
			}
		}
		res += String.format(") z=%9.3e\r\n", getZ());
		return res;
	}
	
	public boolean equals(Object o) {
		if (o.getClass()==MatrixSimplex.class) {
			MatrixSimplex tmp = (MatrixSimplex) o;
			if (_m != tmp._m || _n != tmp._n) {
				return false;
			}
			for (int i = 0; i < getNbLine(); i++) {
				for (int j = 0; j < getNbColumn(); j++) {
					if (getElement(i, j) != tmp.getElement(i, j)) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}


	// Attribute
	private ArrayList<ArrayList<Double>> _matrice;
	private int _n; // Nombre de coefficiant
	private int _m; // Nombre de contraite
}