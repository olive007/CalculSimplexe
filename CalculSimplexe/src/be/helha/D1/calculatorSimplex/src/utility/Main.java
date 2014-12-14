package be.helha.D1.calculatorSimplex.src.utility;


public class Main {

	public static void main(String[] args) {
		int error = 0;
		Controller controller = new Controller();
		
		if (controller.init()) {
			error = controller.loop();
		}
		controller.close();
		System.exit(error);
	}

}
