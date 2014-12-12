package calculatorSimplexe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author christophe
 *
 */
public class MatriceSimplexe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<List<Double>> matrice;
	private double z;
	private List<Double> variables;
	private int n;
	private int m;
	
	public MatriceSimplexe(){
		matrice = new ArrayList<List<Double>>();
		z = 0;
		variables = new ArrayList<Double>();
		n = 0;
		m = 0;

	}
	
	@SuppressWarnings("unchecked")
	private MatriceSimplexe(List<List<Double>> matrice, double z, List<Double> variables, int n, int m){
		
		this.matrice = new ArrayList<List<Double>>();
		for(int i=0;i<=matrice.size()-1;i++){
		ArrayList<Double> liste = new ArrayList<Double>();
		liste.addAll(matrice.get(i));
		this.matrice.add((ArrayList<Double>) liste.clone());	
		}
		
		this.z = z;
		
		this.variables = new ArrayList<Double>();
		for(int i=0;i<=variables.size()-1;i++){
			ArrayList<Double> liste = new ArrayList<Double>();
			liste.addAll(variables);
			this.variables = (ArrayList<Double>) liste.clone();
			
		}
	
		this.n = n;
		this.m = m;
	}
	
	
	
	/**
	 * M�thode qui permet de cloner un objet matrice
	 * @param mat
	 * @return mat
	 */
	public MatriceSimplexe clone(){	
		return new MatriceSimplexe(matrice, z, variables, n, m);
	}
	
	public void InitialiserMatrice(){// Constructeur provisoire
		List<Double> l1 = new ArrayList<Double>();
		List<Double> l2 = new ArrayList<Double>();
		List<Double> l3 = new ArrayList<Double>();
		
		l1.add(new Double(1));
		l1.add(new Double(4));
		l1.add(new Double(1));
		l1.add(new Double(0));
		l1.add(new Double(12));
		
		l2.add(new Double(2));
		l2.add(new Double(4));
		l2.add(new Double(0));
		l2.add(new Double(1));
		l2.add(new Double(10));
		
		l3.add(new Double(3));
		l3.add(new Double(3));
		l3.add(new Double(0));
		l3.add(new Double(0));
		l3.add(new Double(0));
		
		this.matrice.add(l1);
		this.matrice.add(l2);
		this.matrice.add(l3);
		
		z = 0;
		
		n = 2;
		
		m = 2;
		

		
		variables.add(0.);
		variables.add(0.);
		variables.add(12.);
		variables.add(10.);
	}
	
	public boolean initialiserMatriceDepart(int n, int m, List<List<Double>> matrice){
		setN(n);
		setM(m);
		setMatrice(matrice);
		return true;
	}

	public List<List<Double>> getMatrice() {
		return Collections.unmodifiableList(matrice);
	}

	@SuppressWarnings("unchecked")
	public boolean setMatrice(List<List<Double>> matrice) {
		for(int i=0;i<=matrice.size()-1;i++){
			ArrayList<Double> liste = new ArrayList<Double>();
			liste.addAll(matrice.get(i));
			this.matrice.addAll((Collection<? extends List<Double>>) liste.clone());
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean modifierUneLigneMatrice(int i,List<Double> ligne){
		ArrayList<Double> liste = new ArrayList<Double>();
		liste.addAll(ligne);
		matrice.set(i,(List<Double>) liste.clone());
		return true;
	}
	
	

	public List<Double> getVariables() {
		return Collections.unmodifiableList(variables);
	}
	
	@SuppressWarnings("unchecked")
	public boolean setVariables(List<Double> listeVar){
		ArrayList<Double> liste = new ArrayList<Double>();
		liste.addAll(listeVar);
		variables.addAll((Collection<? extends Double>) liste.clone());
		return true;
	}
	
	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}
}



