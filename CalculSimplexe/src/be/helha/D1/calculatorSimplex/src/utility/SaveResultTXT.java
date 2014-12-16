package be.helha.D1.calculatorSimplex.src.utility;

import be.helha.D1.calculatorSimplex.src.model.MatrixSimplex;

/**
 * 
 * Cette classe permet d'ecrire les différents résultats des calculs dans un fichier.
 * 
 * Le format est TXT
 * 
 * @see SaveResult
 * @see SaveResultXML
 * 
 * @author Olivier
 *
 */
public class SaveResultTXT extends SaveResult implements EntryInterface  {

	public SaveResultTXT(MatrixSimplex[] resultat) {
		super(resultat);
	}

	public int action() {
		String filename = "";
		String extention = "";		
		
		do {
			filename = Controller.in.readFilename();
			if (filename.lastIndexOf('.') > 0) {
				extention = filename.substring(filename.lastIndexOf('.') + 1);
			}
			else if (filename.lastIndexOf('.') != 0){
				filename += ".txt";
				extention = "txt";
			}
			if (!extention.equals("txt")) {
				Controller.out.writeError("Mauvais nom de fichier");
				filename = "";
				extention = "";
			}
		} while (!extention.equals("txt"));
		for (int i = 0; i < _resultat.length; i++) {
			if (!MatrixSimplexSerialization.writeTxtFile(filename, _resultat[i])) {
				return 1;
			}
		}
		return 1;
	}

}
