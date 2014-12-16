package be.helha.D1.calculatorSimplex.test.unit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import test.Explorateur;
import be.helha.D1.calculatorSimplex.src.exception.WrongIndexMatrixException;
import be.helha.D1.calculatorSimplex.src.model.MatrixSimplex;

public class TestMatrixSimplex {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		_coefficiants = new ArrayList<>();
		_constraints = new ArrayList<List<Double>>();
		
		_coefficiants.add(5.);
		_coefficiants.add(6.);
		_coefficiants.add(7.);
		
		for (int i = 0; i < 3; i++) {
			_constraints.add(i, new ArrayList<Double>());
		}

		_constraints.get(0).add(3.);
		_constraints.get(0).add(2.);
		_constraints.get(0).add(4.);
		_constraints.get(0).add(18.);
		
		_constraints.get(1).add(4.);
		_constraints.get(1).add(1.);
		_constraints.get(1).add(2.);
		_constraints.get(1).add(24.);
		
		_constraints.get(2).add(1.);
		_constraints.get(2).add(1.);
		_constraints.get(2).add(3.);
		_constraints.get(2).add(12.);
	
		_obj = new MatrixSimplex(_coefficiants, _constraints);	
		_matrix = (ArrayList<ArrayList<Double>>) Explorateur.getField(_obj, "_matrix");
	}
	
	@After
	public void tearDown() throws Exception {
		_coefficiants = null;
		_constraints = null;
		_obj = null;
		_matrix = null;
	}
	
	@Test
	public void testGetN() {
		assertTrue(_obj.getN() == _coefficiants.size());
	}
	
	@Test
	public void testGetM() {
		assertTrue(_obj.getM() == _constraints.size());
	}
	
	@Test
	public void testGetZ() {
		assertTrue(_obj.getZ() >= 0);
	}
	
	@Test
	public void testGetLine() {
		final int LINE = 0;
		double[] oracle = new double[_constraints.get(LINE).size() + _constraints.size()];
		
		for (int i = 0; i < _constraints.get(LINE).size() - 1; i++) {
			oracle[i] = _constraints.get(LINE).get(i);
		}	
		for (int i = 0; i < _constraints.size(); i++) {
			oracle[i + _constraints.get(LINE).size() - 1] = (i == LINE) ? 1. : 0.;
		}
		oracle[_constraints.get(LINE).size() + _constraints.size() - 1] = _constraints.get(LINE).get(_constraints.get(LINE).size() - 1);
		assertArrayEquals(oracle, _obj.getLine(LINE), 0.00005);
	}
	
	@Test
	public void testGetColumn() {
		int size = _constraints.size();
		double[] oracle = new double[size + 1];
		
		for (int i = 0; i < size; i++) {
			oracle[i] = new Double(_constraints.get(i).get(0));
		}
		oracle[size] = new Double(_coefficiants.get(0));
		assertArrayEquals(oracle, _obj.getColumn(0), 0.00005);
	}
	
	@Test
	public void getVarInBase() {
		double[] oracle = new double[_constraints.size() + _coefficiants.size()];
		
		for (int i = 0; i < _coefficiants.size(); i++) {
			oracle[i] = 0.;
		}
		for (int i = 0; i < _constraints.size(); i++) {
			oracle[_coefficiants.size() + i] = _constraints.get(i).get(_constraints.get(i).size() - 1);
		}
		assertArrayEquals(oracle, _obj.getVarInBase(), 0.00005);
	}
	
	@Test
	public void testGetNbLine() {
		assertTrue(_constraints.size() + 1 == _obj.getNbLine());
	}
	
	@Test
	public void testGetNbColumn() {
		assertTrue(_constraints.size() + _coefficiants.size() + 1 == _obj.getNbColumn());
	}
	
	@Test
	public void testGetElement() {
		assertNull(_obj.getElement(1, -1));
	}
	
	@Test (expected=WrongIndexMatrixException.class)
	public void testSetElement() throws WrongIndexMatrixException {
		_obj.setElement(1, -1, 0.);
	}
	
	@Test
	public void testClone() {
		MatrixSimplex tmp = _obj.clone();
		
		assertEquals(tmp, _obj);
		assertNotSame(tmp, _obj);
	}
	
	@Test
	public void testIsValid() {
		assertTrue(_obj.isValid());
	}
	
	@Test
	public void testIsValid2() {
		_matrix.get(0).set(3, 999.);
		assertFalse(_obj.isValid());
	}
	
	@Test
	public void testEquals() {
		assertTrue(_obj.equals((Object) _obj));
	}
	
	@Ignore
	@Test
	public void testToString() {
		System.out.println(_obj.toString());
		assertTrue(false);
	}
	
	
	// Attribute
	private List<Double> _coefficiants;
	private List<List<Double>> _constraints;
	private MatrixSimplex _obj;
	private ArrayList<ArrayList<Double>> _matrix;

}
