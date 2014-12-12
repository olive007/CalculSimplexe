package calculatorSimplex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {
	
	// Constructor
	public Writer() {
		
	}

	// Method display console
	public void writeString(String str) {
		System.out.print(str);
	}
	
	public void writeEntry(Entry entry) {
		System.out.println("[" + entry.getNb() + "] " + entry.getName());
	}
	
	public void writeEntry(Menu entry) {
		System.out.println("[" + entry.getNb() + "] Sous-Menu: " + entry.getName());
	}
	
	public void writeMenu(Menu menu) {
		System.out.println(menu.getName());
		for (int i = 0; i < menu.getNbEntry(); i++) {
			menu.getEntry(i).displayEntry();
		}
	}
	
	public void writeMatrice(MatrixSimplex matrice) {
		for (int i = 0; i < matrice.getNbline(); i++) {
			Double[] line = matrice.getLine(i);
			
			System.out.print("| ");
			for (int j = 0; j < line.length; j++) {
				if (j == matrice.getN() - 1 || j == matrice.getM() + matrice.getN() - 1) {
					System.out.printf("%11.4e | ", line[j]);
				}
				else if (j == line.length - 1) {
					System.out.printf("%11.4e", line[j]);
				}
				else {
					System.out.printf("%11.4e ", line[j]);
				}
			}
			System.out.println(" |");
			if (i == matrice.getNbline() - 2) {
				for (int j = 0; j < line.length; j++) {
					System.out.print("------------");
				}
				System.out.println("-------");
			}
		}
		Double[] sb = matrice.getVarInBase();
		
		System.out.println();
		System.out.print("Variable dans la base : (");
		for (int i = 0; i < sb.length; i++) {
			if (i == sb.length - 1) {  
				System.out.printf("%9.3e", sb[i]);
			}
			else {
				System.out.printf("%9.3e ", sb[i]);
			}
		}
		System.out.printf(") z=%9.3e", matrice.getZ());
		System.out.println();
	}

	public void writeError(String str) {
		System.err.println(str);
	}
	
	// Method write file
	public boolean writeTxtFile(String filename, MatrixSimplex matrice) {
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject("Matrice du Simplexe : ");
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if (out != null) {
				try {
					out.flush();
					out.close();
				}
				catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public boolean writeXmlFile() {
		return false;
	}
	
	// Attribute
}
