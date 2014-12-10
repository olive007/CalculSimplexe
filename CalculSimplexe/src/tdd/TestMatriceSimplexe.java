package tdd;

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

public class TestMatriceSimplexe {

	private MatriceSimplexe objMat;
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
		objMat = new MatriceSimplexe();
		matrice =(List<List<Double>>)Explorateur.getField(objMat, "matrice");
		int n = 3;
		int m = 3;
		
		List<List<Double>> liste = new ArrayList<List<Double>>(4);
		
		List<Double> l1 = new ArrayList<>(7);
		List<Double> l2 = new ArrayList<>(7);
		List<Double> l3 = new ArrayList<>(7);
		List<Double> l4 = new ArrayList<>(7);
		
		l1.add(3.);l1.add(2.);l1.add(4.);l1.add(1.);l1.add(0.);l1.add(0.);l1.add(18.);
		l2.add(4.);l2.add(1.);l2.add(2.);l2.add(0.);l2.add(1.);l2.add(0.);l2.add(24.);
		l3.add(1.);l3.add(1.);l3.add(3.);l3.add(0.);l3.add(0.);l3.add(1.);l3.add(12.);
		l4.add(5.);l4.add(6.);l4.add(7.);l4.add(0.);l4.add(0.);l4.add(0.);l4.add(0.);
		
		liste.add(l1);liste.add(l2);liste.add(l3);liste.add(l4);
		
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		objMat = null;
		matrice = null;
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testMatriceSimplexe
	
	@Test
	public void testInitialiserMatriceDepart(){
		
	}

}
