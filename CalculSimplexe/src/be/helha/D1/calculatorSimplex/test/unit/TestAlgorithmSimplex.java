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
	private List<Double> _coefficiants;
	private List<List<Double>> _contraintes;
	private	MatrixSimplex _objMat;
	
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
		
		_coefficiants.add(5.);
		_coefficiants.add(6.);
		_coefficiants.add(7.);
		
		for (int i = 0; i < 3; i++) {
			_contraintes.add(i, new ArrayList<Double>());
		}
		
		_contraintes.get(0).add(3.);
		_contraintes.get(0).add(2.);
		_contraintes.get(0).add(4.);
		_contraintes.get(0).add(18.);
		
		_contraintes.get(1).add(4.);
		_contraintes.get(1).add(1.);
		_contraintes.get(1).add(2.);
		_contraintes.get(1).add(24.);
		
		_contraintes.get(2).add(1.);
		_contraintes.get(2).add(1.);
		_contraintes.get(2).add(3.);
		_contraintes.get(2).add(12.);
	
		_objMat = new MatrixSimplex(_coefficiants, _contraintes);
	}

	@After
	public void tearDown() throws Exception {
		_coefficiants = null;
		_contraintes = null;
		_objMat = null;
	}

	@Ignore
	@Test
	public void testSearchPivotColumn() {
		try {
			Method method = AlgorithmSimplex.class.getDeclaredMethod("searchPivotColumn", MatrixSimplex.class);
			method.setAccessible(true);
			assertTrue((int)method.invoke(null, _objMat) == 2);
		}
		catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	@Ignore
	@Test
	public void testSearchPivotLine() {
		try {
			Method method = AlgorithmSimplex.class.getDeclaredMethod("searchPivotLine", MatrixSimplex.class);
			method.setAccessible(true);
			assertTrue((int)method.invoke(null, _objMat) == 2);
		}
		catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	@Ignore
	@Test
	public void testCalculPivot(){
		//fail("Not yet implemented");
		assertTrue(AlgorithmSimplex.calculPivot(_objMat,2,2)==3);
	}
	@Ignore
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
