package be.helha.D1.calculatorSimplex.test.unit;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import be.helha.D1.calculatorSimplex.src.model.AlgorithmSimplex;
import be.helha.D1.calculatorSimplex.src.model.MatrixSimplex;

public class TestAlgorithmSimplex {
	
	// Attribute
	private	MatrixSimplex _matrice;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		List<Double> coefficiants;
		List<List<Double>> contraintes;
		
		coefficiants = new ArrayList<>();
		contraintes = new ArrayList<List<Double>>();
		
		coefficiants.add(5.);
		coefficiants.add(6.);
		coefficiants.add(7.);
		
		for (int i = 0; i < 3; i++) {
			contraintes.add(i, new ArrayList<Double>());
		}
		
		contraintes.get(0).add(3.);
		contraintes.get(0).add(2.);
		contraintes.get(0).add(4.);
		contraintes.get(0).add(24.);
		
		contraintes.get(1).add(4.);
		contraintes.get(1).add(1.);
		contraintes.get(1).add(2.);
		contraintes.get(1).add(24.);
		
		contraintes.get(2).add(1.);
		contraintes.get(2).add(1.);
		contraintes.get(2).add(5.);
		contraintes.get(2).add(15.);
	
		_matrice = new MatrixSimplex(coefficiants, contraintes);
	}

	@After
	public void tearDown() throws Exception {
		_matrice = null;
	}

	@Test
	public void testCalcul() {
		
	}
	
	@Test
	public void testSearchPivotColumn() {
		try {
			Method method = AlgorithmSimplex.class.getDeclaredMethod("searchPivotColumn", MatrixSimplex.class);
			
			method.setAccessible(true);
			assertTrue((int)method.invoke(null, _matrice) == 2);
		}
		catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void testdoIteration() {
		try {
			MatrixSimplex oracle = _matrice.clone();
			
			oracle.setElement(0, 0, 11./5.);
			oracle.setElement(0, 1, 6./5.);
			oracle.setElement(0, 2, 0.);
			oracle.setElement(0, 3, 1.);
			oracle.setElement(0, 4, 0.);
			oracle.setElement(0, 5, -4./5.);
			oracle.setElement(0, 6, 12.);
			
			oracle.setElement(1, 0, 18./5.);
			oracle.setElement(1, 1, 3./5.);
			oracle.setElement(1, 2, 0.);
			oracle.setElement(1, 3, 0.);
			oracle.setElement(1, 4, 1.);
			oracle.setElement(1, 5, -2./5.);
			oracle.setElement(1, 6, 18.);
			
			oracle.setElement(2, 0, 1./5.);
			oracle.setElement(2, 1, 1./5.);
			oracle.setElement(2, 2, 1.);
			oracle.setElement(2, 3, 0.);
			oracle.setElement(2, 4, 0.);
			oracle.setElement(2, 5, 1./5.);
			oracle.setElement(2, 6, 3.);
			
			oracle.setElement(3, 0, 18./5.);
			oracle.setElement(3, 1, 23./5.);
			oracle.setElement(3, 2, 0.);
			oracle.setElement(3, 3, 0.);
			oracle.setElement(3, 4, 0.);
			oracle.setElement(3, 5, -7./5.);
			oracle.setElement(3, 6, -21.);
			
			MatrixSimplex testing;
			Method method = AlgorithmSimplex.class.getDeclaredMethod("doIteration", MatrixSimplex.class, int.class);
			
			method.setAccessible(true);
			testing = (MatrixSimplex) method.invoke(null, _matrice, 2);
			assertTrue(oracle.equals(testing));
		}
		catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void testSearchPivotLine() {
		try {
			Method method = AlgorithmSimplex.class.getDeclaredMethod("searchPivotLine", MatrixSimplex.class, int.class);
			
			method.setAccessible(true);
			assertTrue((int)method.invoke(null, _matrice, 2) == 2);
		}
		catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	@Test
	public void testSetPivotUnit(){
		try {
			double[] oracle = {1./5., 1./5., 1., 0., 0., 1./5., 3.};
			double[] testing;
			Method method = AlgorithmSimplex.class.getDeclaredMethod("setUnitPivot", MatrixSimplex.class, int.class, int.class);
	
			method.setAccessible(true);
			method.invoke(null, _matrice, 2, 2);
			testing = _matrice.getLine(2);
			assertArrayEquals(oracle, testing, 0.0005);
		}
		catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	@Test
	public void testSubstractLine() {
		try {
			double[] oracle = {11./5., 6./5., 0., 1., 0., -4./5., 12.};
			double[] testing;
			Method method = AlgorithmSimplex.class.getDeclaredMethod("setUnitPivot", MatrixSimplex.class, int.class, int.class);
			
			method.setAccessible(true);
			method.invoke(null, _matrice, 2, 2);
			method = AlgorithmSimplex.class.getDeclaredMethod("substractLine", MatrixSimplex.class, int.class, int.class, int.class);
			method.setAccessible(true);
			method.invoke(null, _matrice, 0, 2, 2);
			testing = _matrice.getLine(0);
			assertArrayEquals(oracle, testing, 0.0005);
		}
		catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
