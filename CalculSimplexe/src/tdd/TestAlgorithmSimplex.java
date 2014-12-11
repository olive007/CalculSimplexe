package tdd;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.Explorateur;
import calculatorSimplex.AlgorithmSimplex;
import calculatorSimplex.MatriceSimplex;


public class TestAlgorithmSimplex {
	
	private static List<Double> _coefficiants;
	private static List<List<Double>> _contraintes;
	private MatriceSimplex _objMat;
	private ArrayList<ArrayList<Double>> _matrice;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		_coefficiants = new ArrayList<>();
		_contraintes = new ArrayList<List<Double>>();
		
		_coefficiants.add(5.);_coefficiants.add(6.);_coefficiants.add(7.);
		
		for(int i=0; i<=2; i++){
			_contraintes.add(i, new ArrayList<Double>());
		}
		
		_contraintes.get(0).add(3.);_contraintes.get(0).add(2.);_contraintes.get(0).add(4.);_contraintes.get(0).add(18.);
		_contraintes.get(1).add(4.);_contraintes.get(1).add(1.);_contraintes.get(1).add(2.);_contraintes.get(1).add(24.);
		_contraintes.get(2).add(1.);_contraintes.get(2).add(1.);_contraintes.get(2).add(3.);_contraintes.get(2).add(12.);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		_coefficiants = null;
		_contraintes = null;
	}

	@Before
	public void setUp() throws Exception {
	
		_objMat = new MatriceSimplex(_coefficiants, _contraintes);
		_matrice =(ArrayList<ArrayList<Double>>)Explorateur.getField(_objMat, "_matrice");
		
	}

	@After
	public void tearDown() throws Exception {
		_objMat = null;
		_matrice = null;
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void TestRechercherColonnePivot(){
		//fail("Not yet implemented");
		int colPivot;
		List<Double> lastLine = new ArrayList<Double>(7);
		lastLine.add(5.);lastLine.add(6.);lastLine.add(7.);lastLine.add(0.);lastLine.add(0.);lastLine.add(0.);lastLine.add(0.);
		colPivot = AlgorithmSimplex.rechercherColonnePivot(_objMat);
		assertTrue(colPivot==2);
		
	}
	
}