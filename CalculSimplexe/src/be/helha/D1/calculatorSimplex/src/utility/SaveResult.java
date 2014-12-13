package be.helha.D1.calculatorSimplex.src.utility;

import be.helha.D1.calculatorSimplex.src.exception.WrongEntryException;

public class SaveResult implements EntryInterface {

	public int action() {
		Menu menu = null;
		
		try {
			menu = new Menu("Format",
					new Entry("XML", new SaveResultXML()),
					new Entry("TXT", new SaveResultTXT()));
		} catch (WrongEntryException e) {
			e.printStackTrace();
			return 1;
		}
		menu.doAction();
		return 1;
	}
	
}
