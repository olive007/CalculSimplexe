package be.helha.D1.calculatorSimplex.src.view;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import be.helha.D1.calculatorSimplex.src.model.MatrixSimplex;
import be.helha.D1.calculatorSimplex.src.utility.Entry;
import be.helha.D1.calculatorSimplex.src.utility.Menu;

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
		System.out.println(matrice.toString());
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
