package packTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.Explorateur;

import calculatorSimplexe.AlgoSimplexe;
import calculatorSimplexe.MatriceSimplexe;

public class TestCalculSimplexe {
	
	private MatriceSimplexe mat;
	private List<List<Double>> matrice;
	private AlgoSimplexe algo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mat = new MatriceSimplexe();
		algo = new AlgoSimplexe();
		matrice =(List<List<Double>>)Explorateur.getField(mat, "matrice");
		
	}

	@After
	public void tearDown() throws Exception {
		mat = null;
		matrice = null;
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void TestRechercherColonnePivot(){
		//fail("Not yet implemented");
		int col;
		List<Double> ligne = new ArrayList<Double>(7);
		ligne.add(5.);ligne.add(6.);ligne.add(7.);ligne.add(0.);ligne.add(0.);ligne.add(0.);ligne.add(0.);
		col = algo.rechercherColonnePivot(ligne);
		assertTrue(col==2);
		
	}
	
	@Test
	public void TestRechercherLignePivot(){
		//fail("Not yet implemented");
		int ligne;
		
		List<List<Double>> tab2D = new ArrayList<>(4);
		List<Double> l1 = new ArrayList<>(7);
		List<Double> l2 = new ArrayList<>(7);
		List<Double> l3 = new ArrayList<>(7);
		List<Double> l4 = new ArrayList<>(7);
		
		l1.add(3.);l1.add(2.);l1.add(4.);l1.add(1.);l1.add(0.);l1.add(0.);l1.add(18.);
		l2.add(4.);l2.add(1.);l2.add(2.);l2.add(0.);l2.add(1.);l2.add(0.);l2.add(24.);
		l3.add(1.);l3.add(1.);l3.add(3.);l3.add(0.);l3.add(0.);l3.add(1.);l3.add(12.);
		l4.add(5.);l4.add(6.);l4.add(7.);l4.add(0.);l4.add(0.);l4.add(0.);l4.add(0.);
		
		tab2D.add(l1);tab2D.add(l2);tab2D.add(l3);tab2D.add(l4);
		
		ligne = algo.rechercherLignePivot(tab2D);
		assertTrue(ligne==2);
	}
	
	@Test
	public void TestCalculerPivot(){
		//fail("Not yet implemented");
			List<List<Double>> tab2D = new ArrayList<>(4);
			List<Double> l1 = new ArrayList<>(7);
			List<Double> l2 = new ArrayList<>(7);
			List<Double> l3 = new ArrayList<>(7);
			List<Double> l4 = new ArrayList<>(7);
				
			l1.add(3.);l1.add(2.);l1.add(4.);l1.add(1.);l1.add(0.);l1.add(0.);l1.add(18.);
			l2.add(4.);l2.add(1.);l2.add(2.);l2.add(0.);l2.add(1.);l2.add(0.);l2.add(24.);
			l3.add(1.);l3.add(1.);l3.add(3.);l3.add(0.);l3.add(0.);l3.add(1.);l3.add(12.);
			l4.add(5.);l4.add(6.);l4.add(7.);l4.add(0.);l4.add(0.);l4.add(0.);l4.add(0.);
				
			tab2D.add(l1);tab2D.add(l2);tab2D.add(l3);tab2D.add(l4);
			
			assertTrue(algo.calculPivot(tab2D)==3);
	}
	
	@Test
	public void TestRendrePivotUnitaire(){
		//fail("Not yet implemented");
		List<Double> lignePivot = new ArrayList<Double>(7);
		List<Double> lignePivotTrans = new ArrayList<Double>(7);
		
		lignePivot.add(1.);lignePivot.add(1.);lignePivot.add(3.);lignePivot.add(0.);lignePivot.add(0.);lignePivot.add(1.);lignePivot.add(12.);
		lignePivotTrans.add(1./3.);lignePivotTrans.add(1./3.);lignePivotTrans.add(1.);lignePivotTrans.add(0.);lignePivotTrans.add(0.);lignePivotTrans.add(1./3.);lignePivotTrans.add(12./3.);
		assertTrue(algo.rendrePivotUnitaire(lignePivot,3).containsAll(lignePivotTrans));
	}
	
	
	
	
	

}
