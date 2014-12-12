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
	
	private  List<Double> _coefficiants;
	private  List<List<Double>> _contraintes;
	private MatriceSimplex _objMat;
	private ArrayList<ArrayList<Double>> _matrice;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
	
		_coefficiants = new ArrayList<>();
		_contraintes = new ArrayList<List<Double>>();
		
		_coefficiants.add(5.);_coefficiants.add(6.);_coefficiants.add(7.);
		
		for(int i=0; i<=2; i++){
			_contraintes.add(i, new ArrayList<Double>());
		}
		
		_contraintes.get(0).add(3.);_contraintes.get(0).add(2.);_contraintes.get(0).add(4.);_contraintes.get(0).add(18.);
		_contraintes.get(1).add(4.);_contraintes.get(1).add(1.);_contraintes.get(1).add(2.);_contraintes.get(1).add(24.);
		_contraintes.get(2).add(1.);_contraintes.get(2).add(1.);_contraintes.get(2).add(3.);_contraintes.get(2).add(12.);
	
		_objMat = new MatriceSimplex(_coefficiants, _contraintes);
		_matrice =(ArrayList<ArrayList<Double>>)Explorateur.getField(_objMat, "_matrice");
		
	}

	@After
	public void tearDown() throws Exception {
		_coefficiants = null;
		_contraintes = null;
		_objMat = null;
		_matrice = null;
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSearchColumnPivot(){
		//fail("Not yet implemented");
		assertTrue(AlgorithmSimplex.searchColumnPivot(_objMat)==2);
		
	}
	
	@Test
	public void testSearchLinePivot(){
		//fail("Not yet implemented");
		assertTrue(AlgorithmSimplex.searchLinePivot(_objMat,2)==2);
	}
	
	@Test
	public void testCalculPivot(){
		//fail("Not yet implemented");
		assertTrue(AlgorithmSimplex.calculPivot(_objMat,2,2)==3);
	}
	
	@Test
	public void testSetPivotUnit(){
		int indLinePivot = 2;
		int indColPivot = 2;
		List<Double> linePivot = new ArrayList<Double>();
		linePivot.add(1./3.);linePivot.add(1./3.);linePivot.add(1.);
		linePivot.add(0.);linePivot.add(0.);linePivot.add(1./3.);linePivot.add(4.);
		AlgorithmSimplex.setPivotUnit(_objMat, indLinePivot, indColPivot);
		assertTrue(_matrice.get(2).containsAll(linePivot));
	}
	
}