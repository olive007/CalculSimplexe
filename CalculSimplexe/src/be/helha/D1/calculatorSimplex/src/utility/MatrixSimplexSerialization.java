package be.helha.D1.calculatorSimplex.src.utility;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import be.helha.D1.calculatorSimplex.src.model.MatrixSimplex;

public abstract class MatrixSimplexSerialization {
	
	public static boolean writeTxtFile(String filename, MatrixSimplex matrix) {
		PrintWriter pw = null;
		
		try{
			pw = new PrintWriter(filename);
			pw.println(matrix.toString());
		}
		catch(FileNotFoundException e){
			Controller.out.writeError(e.getMessage());
		}
		finally{
			if (pw != null) {
				pw.close();
				return true;
			}
		}
		return false;
	}

}
